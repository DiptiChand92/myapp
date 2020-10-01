package com.som.service;

import com.som.Dao.EmployeeDao;
import com.som.bean.Employee;
import com.som.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements EmployeeService {
	String status=null;
	@Override
	public String addEmployee(Employee emp) {
		EmployeeDao empDao=EmployeeDaoFactory.getEmployeeDao();
		status=empDao.add(emp);
		return status;
	}

	@Override
	public Employee searchEmployee(int empno) {
		EmployeeDao empDao=EmployeeDaoFactory.getEmployeeDao();
		Employee emp=empDao.search(empno);
		
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		EmployeeDao empDao=EmployeeDaoFactory.getEmployeeDao();
		 status=empDao.update(emp);
		return status;
		
	}

	@Override
	public String deleteEmployee(int empno) {
		EmployeeDao empDao=EmployeeDaoFactory.getEmployeeDao();
		status=empDao.delete(empno);
		return status;
	}

}
