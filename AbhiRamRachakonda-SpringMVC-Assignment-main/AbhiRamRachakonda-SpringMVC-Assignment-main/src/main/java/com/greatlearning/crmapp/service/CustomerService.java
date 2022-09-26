package com.greatlearning.crmapp.service;

import com.greatlearning.crmapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer thecustomer);

	public void deleteById(int theId);
}
