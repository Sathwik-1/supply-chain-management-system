package jsp.SupplyChainManagementSystem.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.SupplyChainManagementSystem.Entity.Customer;
import jsp.SupplyChainManagementSystem.Repository.CustomerRepository;

@Repository
public class CustomerDao {
  @Autowired
  CustomerRepository customerRepository;
  
  public Customer addcustomer(Customer customer) {
	  return customerRepository.save(customer);
  }
  
  public List<Customer> getAllCustomer(){
	  return customerRepository.findAll();
  }
  public Optional<Customer> getCustomerById(int id) {
	  return customerRepository.findById(id);
  }
  
  public void deleteCustomer(Customer customer) {
	  customerRepository.delete(customer);
  }
}
