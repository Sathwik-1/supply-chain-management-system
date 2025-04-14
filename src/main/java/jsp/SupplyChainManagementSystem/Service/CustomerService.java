package jsp.SupplyChainManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.SupplyChainManagementSystem.DAO.CustomerDao;
import jsp.SupplyChainManagementSystem.DTO.ResponseStructure;
import jsp.SupplyChainManagementSystem.Entity.Customer;
import jsp.SupplyChainManagementSystem.Exception.IdNotFoundException;

@Service
public class CustomerService {
   
  @Autowired
  private CustomerDao customerDao;
  
  //add Customer
  public ResponseEntity<ResponseStructure<Customer>> addCustomer(Customer customer)
  {
	  customerDao.addcustomer(customer);
	  ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
	  responseStructure.setData(customer);
	  responseStructure.setMessage("Successfull");
	  responseStructure.setStatusCode(HttpStatus.CREATED.value());
	  return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
  }
  //get All customters
  public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer(){
	   List<Customer> customerList=customerDao.getAllCustomer();
	   ResponseStructure<List<Customer>> responseStructure=new ResponseStructure<List<Customer>>();
	   responseStructure.setData(customerList);
	   responseStructure.setMessage("Successfully fetched All records of customer");
	   responseStructure.setStatusCode(HttpStatus.OK.value());
	   return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure, HttpStatus.OK);
  }
  //get customters by id
  public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id){
	    Optional<Customer> getCustomer=customerDao.getCustomerById(id);
	    if(getCustomer.isPresent()) {
	   ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
	   responseStructure.setData(getCustomer.get());
	   responseStructure.setMessage("Successfully");
	   responseStructure.setStatusCode(HttpStatus.FOUND.value());
	   return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
	    }
	    else {
	    	throw new IdNotFoundException();
	    }
 }
  
  //update customer 
  public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer){
	  customerDao.addcustomer(customer);
	  ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
	  responseStructure.setData(customer);
	  responseStructure.setMessage("Successfull Updatd");
	  responseStructure.setStatusCode(HttpStatus.CREATED.value());
	  return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
  }
  
  //delete Customer
  public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int id){
	   Optional<Customer> getCustomer=customerDao.getCustomerById(id);
	   if(getCustomer.isPresent())
	   {
		   customerDao.deleteCustomer(getCustomer.get());
		   ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
			  responseStructure.setData(getCustomer.get());
			  responseStructure.setMessage("Successfull deleted");
			  responseStructure.setStatusCode(HttpStatus.OK.value());
			  return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
	   }
	   else {
		   throw new IdNotFoundException();
	   }
  }
}
