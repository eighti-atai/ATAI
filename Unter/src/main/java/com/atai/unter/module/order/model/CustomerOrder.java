package com.atai.unter.module.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.atai.unter.generic.interfaces.Model;
import com.atai.unter.module.enterprise.model.Customer;
import com.atai.unter.module.enterprise.model.User;

@Entity
@Table(name = "customer_order_tab")
public class CustomerOrder implements Model<String>{

	@Id
	@Column(name = "customer_order_id")
	private String customerOrderId;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "status")
	private String status;
	@Column(name = "note")
	private String note;
	@Column(name = "payment_no")
	private int paymentNo;
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "user_id")
	private int userId;
	private String objid;
	
	@OneToMany(mappedBy = "customerOrder")
	private List<CustomerOrderLine> customerOrderLine;
	//private CustomerOrderLine customerOrderLine;
	
	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private Customer customer;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
//	private User user;
	
	public String getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getId() {
		return getCustomerOrderId();
	}

	public void setId(String id) {
		setCustomerOrderId(id);
	}

}
