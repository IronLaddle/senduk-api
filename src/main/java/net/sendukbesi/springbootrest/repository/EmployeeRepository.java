package net.sendukbesi.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sendukbesi.springbootrest.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}