package peaksoft.service;

import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);

    List<Customer> getAllCustomer();
    Customer getCustomerById(Long id);
    void updateCustomerById(Long id,Customer customer);
    void deletedCustomerById(Long id);
    void assignCustomerToAgency(Long customerId,Long agencyId);
}
