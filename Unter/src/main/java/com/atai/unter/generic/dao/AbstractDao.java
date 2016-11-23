package com.atai.unter.generic.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
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
		//Query query = getSession().createQuery(hql);
		
		Field[] fields = persistentClass.getDeclaredFields();
		for (Field field : fields) {
			try {
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
		Type t;
		if (field.getType().equals(Integer.TYPE))
		{
			fieldName = field.getName();
			criteria.add(Restrictions.eq(fieldName, field.getInt(entity)));
		}
		else if (field.getType().equals(String.class))
		{
			fieldName = field.getName();
			criteria.add(Restrictions.eq(fieldName, field.get(entity)));
		}
		
		/*  Search query section ends */
	}
}
