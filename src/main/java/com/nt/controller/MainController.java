package com.nt.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.DTO.EmployeeDTO;
import com.nt.VO.EmployeeVO;
import com.nt.service.IEmployeeService;

@Controller("employeeController")
public class MainController {
	
	@Autowired
	private IEmployeeService service;
	
	public List<EmployeeVO> showEmployeeByDesgs(String[] desgs) throws Exception
	{
		List<EmployeeVO> listVO=new ArrayList<EmployeeVO>();
		List<EmployeeDTO> employeeDTOs = service.fetchEmployeeByDesgs(desgs);
		employeeDTOs.forEach(dto->{
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setMgr(String.valueOf(dto.getMgr()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			listVO.add(vo);
		});
		return listVO;
	}
	
}
