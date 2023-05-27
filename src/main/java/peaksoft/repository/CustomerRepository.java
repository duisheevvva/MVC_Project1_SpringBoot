package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

//    void assignCustomerToAgency(Long customerId,List<Long> agencyId);

}
