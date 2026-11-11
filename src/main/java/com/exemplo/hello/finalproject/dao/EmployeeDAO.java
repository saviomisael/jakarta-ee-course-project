package com.exemplo.hello.finalproject.dao;

import com.exemplo.hello.finalproject.beans.Employee;

import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee) throws Exception;
    boolean updateEmployee(Employee employee) throws Exception;
    boolean deleteEmployee(int employeeId) throws Exception;
    List<Employee> getAll() throws Exception;
    Employee getEmployee(int employeeId) throws Exception;
}
