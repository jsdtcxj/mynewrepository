package com.chs.springHibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import com.chs.springHibernate.entity.EmployeeDtl;

public class MyTransformer implements ResultTransformer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6956706854630723562L;

	@Override
	public Object transformTuple(Object[] tuple, String[] aliases) {
		EmployeeDtl employeeDtl = new EmployeeDtl();
		employeeDtl.setId((Integer)tuple[0]);
		employeeDtl.setEmail((String)tuple[1]);
		employeeDtl.setDepName((String)tuple[2]);
		
		return employeeDtl;
	}

	@Override
	public List transformList(List collection) {
		List<EmployeeDtl> employees = new ArrayList<>();
		for(int i = 0; i < collection.size(); i++) {
			employees.add((EmployeeDtl)collection.get(i));
		}
		return employees;
	}

}
