package com.caru.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigServerTestDynamicService
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 07. 10.
 */
@RestController
public class RestMainController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestMainController.class);

	@Autowired
	EmployeeRepository repository;

	@PostMapping
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add: {}", employee);
		return repository.add(employee);
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Long id) {
		LOGGER.info("Employee find: id={}", id);
		return repository.findById(id);
	}

	@GetMapping
	public List findAll() {
		LOGGER.info("Employee find");
		return repository.findAll();
	}

	@GetMapping("/department/{departmentId}")
	public List findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Employee find: departmentId={}", departmentId);
		return repository.findByDepartment(departmentId);
	}

	@GetMapping("/organization/{organizationId}")
	public List findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Employee find: organizationId={}", organizationId);
		return repository.findByOrganization(organizationId);
	}
}
