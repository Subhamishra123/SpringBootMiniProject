package com.nt.service;

import java.util.List;

import com.nt.DTO.EmployeeDTO;

public interface IEmployeeService {
	
	public List<EmployeeDTO> fetchEmployeeByDesgs(String[] desgs)throws Exception;

}
