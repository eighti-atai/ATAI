package com.atai.unter.generic.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
    
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
     

	protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

	// Following code section is for search queries, under developement Kanchana
	public List<T> executeSelectQuery(T entity)
	{
		Criteria criteria = getSession().createCriteria(persistentClass);
		createCriteria(entity, criteria);
		List<T> results = criteria.list();
		return results;
	}
	
	private void createCriteria(T entity, Criteria criteria)
	{
		Field[] fields = persistentClass.getDeclaredFields();
		for (Field field : fields) {
			try {
				if (field.getName()!="objid")
					setValue(entity, criteria, field);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
	}
	
	private void setValue(T entity, Criteria criteria, Field field) throws Exception
	{
		String fieldName;
		String fieldValue;
		field.setAccessible(true);
		if (!checkIfNull(entity, field))
		{
			fieldName = field.getName();
			fieldValue = field.get(entity).toString();
			System.out.println("field value is ----------------------"+fieldValue);
			if(fieldValue.contains("%"))
			{
				criteria.add(Restrictions.ilike(fieldName, field.get(entity)));
			}
			else
			{
				criteria.add(Restrictions.eq(fieldName, field.get(entity)));
			}
		}
		
	}
	
	
	private boolean checkIfNull(T entity, Field field) throws Exception
	{
		boolean isNull = true;
		if (field.getType().equals(Integer.TYPE))
		{
			if (field.getInt(entity) != 0)
				return false;
		}
		else if (field.getType().equals(String.class))
		{
			if ((field.get(entity) !=null) && (field.get(entity) != ""))
				return false;
		}
		else if (field.getType().equals(Byte.TYPE))
		{
			if(field.getByte(entity) != 0)
				return false;
		}
		else if(field.getType().equals(Short.TYPE))
		{
			if (field.getShort(entity)!= 0)
				return false;
		}
		else if(field.getType().equals(Long.TYPE))
		{
			if (field.getLong(entity)!= 0L)
				return false;
		}
		else if(field.getType().equals(Float.TYPE))
		{
			if(field.getFloat(entity)!= 0.0F)
				return false;
		}
		else if(field.getType().equals(Double.TYPE))
		{
			if(field.getDouble(entity)!=0.0d)
				return false;
		}
		else if (field.getType().equals(Character.TYPE))
		{
			if(field.getChar(entity)!='\u0000')
				return false;
		}
		else
		{
			if (field.get(entity) != null)
				return false;
		}
		return true;
	}
	
}
