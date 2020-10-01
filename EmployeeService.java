package com.som.service;

import com.som.bean.Employee;

public interface EmployeeService {
 public String addEmployee(Employee emp);
 public Employee searchEmployee(int empno);
 public String updateEmployee(Employee emp);
 public String deleteEmployee(int empno);
}
