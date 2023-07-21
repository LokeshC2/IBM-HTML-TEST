package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.CustomerAppException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @GetMapping
  public String getCustomers(Model model) {

    List<String> errors = new ArrayList<String>();
    List<Customer> customers = new ArrayList<Customer>();
    try{
      customers = customerService.listAllCustomers();
    } catch (Exception e) {
      errors.add(e.getMessage());
    }
    model.addAttribute("errors", errors);
    model.addAttribute("customers", customers);
    return "listCustomer";
  }

  @GetMapping("/add")
  public String addCustomer(Model model) {
    Customer c = customerService.createCustomer();
    model.addAttribute("customer", c);
    return "addCustomer";
  }

  @GetMapping("/update")
  public String updateCustomer(Model model, @RequestBody Integer id) {
    Customer c;
    List<String> errors = new ArrayList<String>();
    try {
      c = customerService.getCustomerById(id);
    } catch (CustomerAppException e) {
      errors.add(e.getMessage());
      c = customerService.createCustomer();
    }
    model.addAttribute("errors", errors);
    model.addAttribute("customer", c);
    return "updateCustomer";
  }

  @PostMapping("/add")
  public String addCustomer(@ModelAttribute Customer customer, Model model) {
    List<String> errors = new ArrayList<String>();
    try{
      customerService.saveCustomer(customer);
      return "redirect:/customers";
    } catch (Exception e) {
      errors.add(e.getMessage());
    }
    model.addAttribute("errors", errors);
    return "addCustomer";
  }

  @PostMapping("/update")
  public String updateCustomer(@ModelAttribute Customer customer, Model model) {
    List<String> errors = new ArrayList<String>();
    try{
      customerService.updateCustomer(customer);
      return "redirect:/customers";
    } catch (Exception e) {
      errors.add(e.getMessage());
    }
    model.addAttribute("errors", errors);
    return "updateCustomer";
  }

  @GetMapping("/delete")
  @PostMapping("/delete")
  public String deleteCustomer(Model model, @RequestBody Integer id) {
    List<String> errors = new ArrayList<String>();
    try {
      Customer c = customerService.getCustomerById(id);
      customerService.deleteCustomer(c);
    } catch (CustomerAppException e) {
      errors.add(e.getMessage());
    }
    model.addAttribute("errors", errors);
    return "redirect:/customers";
  }

}
