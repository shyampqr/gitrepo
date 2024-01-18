package com.wipro.pringboot.controller;
import com.wipro.pringboot.model.Employee;
import com.wipro.pringboot.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployee(){

        System.out.println("Adding sysout im coroller");

        System.out.println("Shyam 2 branch commit");

        return employeeRepository.findAll();
    }
    //find employee by id
    @GetMapping(value = "/employees/{id}")
    private Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }
   //adding employees
    @PostMapping(value = "/employees")
    private Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
         }

    //Updating Employee

    //@RequestMapping(value = "/employees/{id}",method = RequestMethod.PUT)
    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
        try{
            return new ResponseEntity<Employee>(employee,HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

        }}
    //deleting employees deleting easiest way
    @DeleteMapping(value ="/employees1/{id}")
    private void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

    //deleting employees by advanced way
    @DeleteMapping(value ="/employees/{id}")
    private ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String id){
        try{
            this.employeeRepository.deleteById(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }}


    }
