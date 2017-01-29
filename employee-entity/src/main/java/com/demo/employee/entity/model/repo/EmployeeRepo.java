package com.demo.employee.entity.model.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.employee.entity.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	Employee findByEmployeeId(int employee_id);
}
