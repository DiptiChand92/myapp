package com.som.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.som.bean.Employee;
import com.som.factory.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	Employee emp =new Employee();
	//private Employee emp;
	String status="";

	
	@Override
	public String add(Employee emp) {
		
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from emp where empno="+emp.getEmpno());
			boolean b=rs.next();
			if(b==true) {
				status="Employee already exist";
			}
			else {
				int rowcount=st.executeUpdate("insert into emp values("+emp.getEmpno()+",'"+emp.getEname()+"',"+emp.getSal()+")");
				if(rowcount==1) {
					status="Employee record inserted sucessful";
				}
				else {
					status="insertation failed";
				}
			}
		}
		catch(Exception e) {
			status="insertation failed";
			e.printStackTrace();
		}
	
		return status;
	}

	@Override
	public Employee search(int empno) {
		
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from emp where empno="+empno);
			boolean b=rs.next();
			if(b==true) {
				
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("Ename"));
			emp.setSal(rs.getInt("sal"));
			}
			else {
				System.out.print("Record not found:");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String update(Employee emp) {
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from emp where empno="+emp.getEmpno());
			boolean b=rs.next();
			if(b==true) {
				status="Employee already exist";
			}
			else {
				int rowcount=st.executeUpdate("insert into emp values("+emp.getEmpno()+",'"+emp.getEname()+"',"+emp.getSal()+")");
				if(rowcount==1) {
					status="Employee record inserted sucessful";
				}
				else {
					status="insertation failed";
				}
			}
		}
		catch(Exception e) {
			status="insertation failed";
			e.printStackTrace();
		}
	
		return status;
		
	
	}

	@Override
	public String delete(int empno) {
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from emp where empno="+emp.getEmpno());
			boolean d=rs.next();
			if(d==true) {
				int rowcount1=st.executeUpdate("delete from emp where empno="+empno);
				if(rowcount1==1) {
					status="Employee record deleted sucessful";
			
			}
			}

				else {
					status="Deletation  failed";
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
