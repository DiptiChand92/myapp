package com.som.factory;

import com.som.service.EmployeeService;
import com.som.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
private static EmployeeService empService;
static {
	empService=new EmployeeServiceImpl();
}
public static EmployeeService getEmployeService() {
	return empService;
	}
}
