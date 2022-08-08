package com.classroomservices.ClassRoomSvcs.controller;

import com.classroomservices.ClassRoomSvcs.repository.CustomerRepository;
import com.classroomservices.ClassRoomSvcs.util.AppConfig;
import com.classroomservices.ClassRoomSvcs.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping(path="/customer")
public class CustomerController {
    @Autowired
    AppConfig appConfig;
    @Autowired
    private CustomerRepository customerRepository;// = new CustomerRepository();
    @GetMapping(path="/")
    public @ResponseBody String defaultResponse(){

        System.out.println("appConfig="+ appConfig.toString());
        System.out.println("ver"+ SpringVersion.getVersion());
        return "Hello world Spring Ver = " + SpringVersion.getVersion() ;

    }
    @GetMapping(path="/public-api")
    public @ResponseBody String callPublicApi() {
        String url = appConfig.getAppTwo().get("url");
        String port = appConfig.getAppTwo().get("port");

        String endpoint = "https://api.publicapis.org/entries"; //url+":"+port;
        System.out.println("endpoint" + endpoint);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);

        return response.toString();
    }

    @GetMapping(path="/call-app-classrmsvc")
    public @ResponseBody String callAppTwo() {
        String url = appConfig.getAppTwo().get("url");
        String port = appConfig.getAppTwo().get("port");

        String endpoint = url+":"+port;
        System.out.println("endpoint" + endpoint);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);

        return response.toString();
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
