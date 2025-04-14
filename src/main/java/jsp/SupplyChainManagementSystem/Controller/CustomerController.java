package jsp.SupplyChainManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.SupplyChainManagementSystem.DTO.ResponseStructure;
import jsp.SupplyChainManagementSystem.Entity.Customer;
import jsp.SupplyChainManagementSystem.Service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    //1
    @PostMapping
    public ResponseEntity<ResponseStructure<Customer>> addCustomer(@RequestBody Customer customer){
    	return customerService.addCustomer(customer);
    }
    //2
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer(){
    	return customerService.getAllCustomer();
    }
	//3
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable int id){
    	return customerService.getCustomerById(id);
    }
	//4
   @PutMapping
   public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer){
	    	return customerService.updateCustomer(customer);
	   }
   //5
   @DeleteMapping("{id}")
   public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@PathVariable int id){
   	return customerService.deleteCustomerById(id);
   }
}
