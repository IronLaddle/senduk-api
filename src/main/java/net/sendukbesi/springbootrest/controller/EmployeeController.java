package net.sendukbesi.springbootrest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sendukbesi.springbootrest.exception.ResourceNotFoundException;
import net.sendukbesi.springbootrest.model.Employee;
import net.sendukbesi.springbootrest.repository.EmployeeRepository;
import net.sendukbesi.springbootrest.util.BaseController;
import net.sendukbesi.springbootrest.util.BaseUtil;
import net.sendukbesi.springbootrest.util.MessageResponse;
import net.sendukbesi.springbootrest.util.SendukErrorCodeEnum;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController extends BaseController {
	
    @Autowired
    private EmployeeRepository employeeRepository;

   // @GetMapping(value = PageConstant.ALL_EMPLOYEES)
   // public List < Employee > getAllEmployees() {
    //    return employeeRepository.findAll();
    //}
    
    @GetMapping("/employees")
    public MessageResponse getAllEmployees() {
    	List <Employee> employess = employeeRepository.findAll();
    	System.err.println(BaseUtil.getListSize(employess));
        //return !BaseUtil.isObjNull(employess) ? employess : "NoData";
    	if(!BaseUtil.isObjNull(employess)) {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK001, employess);
    	} else {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK005, null);
    	}
    }

    @GetMapping("/employees/{id}")
    public MessageResponse getEmployeeById(@PathVariable("id") Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, employee);
    }

    @PostMapping("/employees")
    public MessageResponse createEmployee(Employee employee) {
    	for (Employee existEmp : employeeRepository.findAll()) {
    		if(existEmp.getEmailId().equalsIgnoreCase(employee.getEmailId())) {
    			return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "Duplicate Employee.Please use new email");
    		}
    	}
        employeeRepository.save(employee);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "create success");
    }

    @PutMapping("/employees/{id}")
    public MessageResponse updateEmployee(@PathVariable(value = "id") Long employeeId,
        @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "update success");
    }

    @DeleteMapping("/employees/{id}")
    public MessageResponse deleteEmployee(@PathVariable(value = "id") Long employeeId)
    throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "delete success");
    }
}