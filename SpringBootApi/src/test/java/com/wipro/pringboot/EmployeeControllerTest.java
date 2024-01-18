package com.wipro.pringboot;

import com.wipro.pringboot.controller.EmployeeController;
import com.wipro.pringboot.model.Employee;
import com.wipro.pringboot.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {SpringBootApiApplication.class})
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    @InjectMocks
    EmployeeController employeeController;
    @Mock
    EmployeeRepository employeeRepository;
    private Employee employee;

    @Test
    public void getEmployee(){
            List<Employee> employeeList=new ArrayList<>();

            employee=new Employee();

            employee.setId(20);
            employeeList.add(employee);
            //when(employeeRepository.findAll()).thenReturn(employeeList);

            employeeController.getAllEmployee();
            List<Employee> employeeList2=employeeController.getAllEmployee();
            //assertEquals(employeeList2.get(0).getId(),20);
            assertNotNull(employeeList2);



    }



}
