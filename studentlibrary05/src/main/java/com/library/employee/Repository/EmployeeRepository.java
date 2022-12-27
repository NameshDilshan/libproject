package com.library.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
