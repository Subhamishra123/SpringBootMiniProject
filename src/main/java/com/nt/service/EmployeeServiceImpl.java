package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.BO.EmployeeBO;
import com.nt.DTO.EmployeeDTO;
import com.nt.dao.IEmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public List<EmployeeDTO> fetchEmployeeByDesgs(String[] desgs) throws Exception {
		String condn=null;
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
		StringBuffer sb=new StringBuffer("(");
		for(int i=0;i<desgs.length;i++)
		{
			if(i==desgs.length-1) {
				sb.append("'"+desgs[i]+"')");
			}
			else {
				sb.append("'"+desgs[i]+"',");
			}
		}
		condn=sb.toString();
		List<EmployeeBO> employeeBOs = dao.getEmployeeByDesgs(condn);
		
		employeeBOs.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
