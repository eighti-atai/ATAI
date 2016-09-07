package com.atai.unter.generic.interfaces;

import java.util.List;

public interface DataAcccessObject<T> {

	public void addData(T p);
	public void updateData(T p);
	public List<T> listData();
} 

