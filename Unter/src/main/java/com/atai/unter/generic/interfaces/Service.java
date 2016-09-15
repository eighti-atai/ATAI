package com.atai.unter.generic.interfaces;

import java.util.List;


public interface Service<T> {

	public void addData(T p);
	public void updateData(T p);
	public List<T> listData();
}
