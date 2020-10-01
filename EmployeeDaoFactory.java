package com.som.factory;


import com.som.Dao.EmployeeDao;
import com.som.Dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
private static EmployeeDao empDao;
 static {
	 empDao=new EmployeeDaoImpl();
 }
 public static EmployeeDao getEmployeeDao() {
	return empDao;
	 
 }
}
