package com.pitsik.spring.spring_boot_data_jpa.spring_boot_data_jpa.service;


import com.pitsik.spring.spring_boot_data_jpa.spring_boot_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> findAllByName(String name);
}
