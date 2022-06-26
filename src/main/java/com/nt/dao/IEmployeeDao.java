package com.nt.dao;

import java.util.List;

import com.nt.BO.EmployeeBO;


public interface IEmployeeDao {
	
	public List<EmployeeBO> getEmployeeByDesgs(String condn)throws Exception;

}
