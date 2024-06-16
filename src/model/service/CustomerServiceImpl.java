package model.service;

import mapper.Mapper;
import model.dao.CustomerDao;
import model.dao.CustomerDaoImpl;
import model.dto.CustomerDto;
import model.dto.ProductDto;
import model.entity.Customer;
import model.entity.Product;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public List<CustomerDto> queryAllCustomer() {
        return customerDao.queryAllCustomers()
                .stream()
                .map(Mapper::fromCustomerDtoToCustomerDto)
                .toList();
    }

    @Override
    public Customer updateCustomerById(Integer id) {
        Customer existingCustomer = customerDao.searchCustomerById(id);
        if (existingCustomer != null) {
            customerDao.updateCustomerById(existingCustomer.getId());
            return existingCustomer;
        } else {
            System.out.println("[!] Customer not found");
            return null;
        }
    }

    @Override
    public Customer deleteCustomerById(Integer id) {
        Customer existingCustomer = customerDao.searchCustomerById(id);
        if (existingCustomer != null) {
            customerDao.deletedCustomerById(id);
            return existingCustomer;
        } else {
            System.out.println("[!] Customer not found");
            return null;
        }
    }

    @Override
    public void addNewCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .id(customerDto.id())
                .name(customerDto.name())
                .email(customerDto.email())
                .build();
        customerDao.addNewCustomer(customer);
    }

    @Override
    public CustomerDto searchProductById(Integer id) {
        Customer customer = customerDao.searchCustomerById(id);
        if (customer != null) {
            CustomerDto customerDto = Mapper.fromCustomerDtoToCustomerDto(customer);
            System.out.println("Customer ID: " +customerDto.id());
            System.out.println("Customer Name: " + customerDto.name());
            System.out.println("Customer Email: " + customerDto.email());
            return customerDto;
        } else {
            System.out.println("[!] Customer not found");
            return null;
        }
    }
}