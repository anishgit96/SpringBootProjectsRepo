package com.example2.RestSpringBoot.RestSpringBoot2;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {

}