package com.caru.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 07. 12.
 */
@Repository
public class EmployeeRepository {
	private List<Employee> employees = new ArrayList<>();

	public Employee add(Employee employee) {
		employee.setId((long)(employees.size() + 1));
		employees.add(employee);
		return employee;
	}

	public Employee findById(Long id) {
		Optional<Employee> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}

	public List<Employee> findAll() {
		return employees;
	}

	public List<Employee> findByDepartment(Long departmentId) {
		return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
	}

	public List<Employee> findByOrganization(Long organizationId) {
		return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
	}

}
