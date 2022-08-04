package com.classroomservices.ClassRoomSvcs.controller;

import com.classroomservices.ClassRoomSvcs.repository.CustomerRepository;
import com.classroomservices.ClassRoomSvcs.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path="/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;// = new CustomerRepository();
    @GetMapping(path="/")
    public @ResponseBody String defaultResponse(){
        return "Hello world";
    }
    @GetMapping(path="/health")
    public @ResponseBody String healthCheck(){
        return "Ok";
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCustomer(@RequestBody Map<String, String> customerDTO) {

        // <validation logic here>
        // todo: generalise validation logic

        // <retrieve data from request body>
        System.out.println("customerMap= " +customerDTO);
        String firstName = customerDTO.get("firstName");
        String lastName = customerDTO.get("lastName");
        // create DTO
        Customer customer = new Customer(firstName, lastName);

        // dao layer: save object to db
        customerRepository.save(customer);

        // todo: better logging
        // todo: generalise response message
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Customer> getAllCustomers (){

        return customerRepository.findAll();
    }

}
