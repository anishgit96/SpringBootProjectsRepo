package com.example2.RestSpringBoot.RestSpringBoot2;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {   //Request body will attach all coming data to our variables
    return repository.save(newEmployee);     
  }

  @GetMapping("/employees/{id}")
  EntityModel<Employee> one(@PathVariable Long id) {             

    Employee employee = repository.findById(id) //
        .orElseThrow(() -> new EmployeeNotFoundException(id));

    return EntityModel.of(employee,                                                            //everything will be done by Hateos dependency
    		                                                                                   //This will show the links in the response..
            linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),   
            linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
}
}