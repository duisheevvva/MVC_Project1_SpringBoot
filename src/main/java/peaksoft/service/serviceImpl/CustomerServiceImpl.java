package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.exception.MyException;
import peaksoft.repository.AgencyRepository;
import peaksoft.repository.CustomerRepository;
import peaksoft.service.CustomerService;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AgencyRepository agencyRepository;
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        try {
            return customerRepository.findById(id).orElseThrow(() -> new MyException("not found!"));
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateCustomerById(Long id, Customer customer) {
        try {
            Customer customer1 = customerRepository.findById(id).orElseThrow(() -> new MyException("not found!"));
            customer1.setName(customer.getName());
            customer1.setSurname(customer.getSurname());
            customer1.setPhoneNumber(customer.getPhoneNumber());
            customerRepository.save(customer1);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deletedCustomerById(Long id) {
        try{
            boolean exists = customerRepository.existsById(id);
            if(!exists){
                throw new MyException("Customer with id: " + id + " is not found");
            }customerRepository.deleteById(id);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {
        try{
            Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new MyException("not found!"));
            Agency agency = agencyRepository.findById(agencyId).orElseThrow(() -> new MyException("not found!"));
            customer.getAgencies().add(agency);
            agency.getCustomers().add(customer);
            customerRepository.save(customer);


        }catch (MyException e){
            System.out.println(e.getMessage());
        }


    }


}
