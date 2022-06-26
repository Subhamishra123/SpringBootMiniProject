package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.BO.EmployeeBO;
@Repository("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	
	private static final String SQL_QUERY="select empno,ename,job,mgr,sal,deptNo from emp where job in";
	@Autowired
	private DataSource datasource;
	
	@Override
	public List<EmployeeBO> getEmployeeByDesgs(String condn) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeBO> listBO=new ArrayList<EmployeeBO>();
		
		try(
			Connection con=datasource.getConnection();
			Statement st=con.createStatement();
			)
		{
			ResultSet rs=st.executeQuery(SQL_QUERY+condn+" order by job");
			EmployeeBO bo=null;
			while(rs.next())
			{
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setMgr(rs.getInt(4));
				bo.setSal(rs.getDouble(5));
				bo.setDeptNo(rs.getInt(6));
				listBO.add(bo);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			throw se;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}
	
}
