package com.som.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.som.bean.Employee;
import com.som.factory.EmployeeServiceFactory;
import com.som.service.EmployeeService;

public class Test {

	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("1. Add record ");
				System.out.println("2. Search record ");
				System.out.println("3. Update record ");
				System.out.println("4. Delete record ");
				System.out.println("5.  Exit");
				System.out.println("Enter your choice(1,2,3,4,5) : ");
				int option=Integer.parseInt(br.readLine());
				int empno;
				String ename;
				int sal;
				String status;
				Employee emp=null;
				EmployeeService empService=EmployeeServiceFactory.getEmployeService();
				switch (option) {
				case  1:
					System.out.print("Employee no :");
					empno=Integer.parseInt(br.readLine());
					System.out.print("Employee Name :");
					ename=br.readLine();
					System.out.print("Employee salary :");
				    sal=Integer.parseInt(br.readLine());
					emp=new Employee();
					emp.setEmpno(empno);
					emp.setEname(ename);
					emp.setSal(sal);
					status=empService.addEmployee(emp);
					System.out.println("satus :"+status);
					
					
					break;
				case 2:
					System.out.print("Employee no :");
					empno=Integer.parseInt(br.readLine());
					emp=empService.searchEmployee(empno);
					if(emp==null) {
						System.out.print("Record does not exits:");
					}
					else{
						System.out.println("Employees Information :");
						System.out.println("---------------------------");
						System.out.println("Employee no:"+emp.getEmpno());
						System.out.println("Employee name:"+emp.getEname());
						System.out.println("Employee Salary:"+emp.getSal());
						System.out.println("---------------------------");
					}
					
					break;
				case 3:
					System.out.print("Employee no :");
					empno=Integer.parseInt(br.readLine());
					emp=empService.searchEmployee(empno);
					if(emp==null) {
						System.out.print("Record does not exits:");
					}
					else {
						System.out.print("New Employee no :");
						empno=Integer.parseInt(br.readLine());
						System.out.print("New Employee Name :");
						ename=br.readLine();
						System.out.print("New Employee salary :");
					    sal=Integer.parseInt(br.readLine());
						emp=new Employee();
						emp.setEmpno(empno);
						emp.setEname(ename);
						emp.setSal(sal);
						status=empService.updateEmployee(emp);
						System.out.println("satus :"+status);
					}
					break;
				case 4:
					System.out.print("Employee no :");
					empno=Integer.parseInt(br.readLine());
					status=empService.deleteEmployee(empno);
					System.out.println("satus :"+status);
					break;
				case 5:
					System.out.println("Thanks for using Employee application");
					System.exit(0);

					break;
				default:
					System.out.println("Enter choice between (1,2,3,4,5)");
					break;
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
