package jsp.SupplyChainManagementSystem.Controller;


import java.util.List;
import java.util.Optional;

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
import jsp.SupplyChainManagementSystem.Entity.Supplier;
import jsp.SupplyChainManagementSystem.Service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	@Autowired
	SupplierService supplierService;
	
	
   @PostMapping
   public ResponseEntity<ResponseStructure<jsp.SupplyChainManagementSystem.Entity.Supplier>> saveSupplier(@RequestBody Supplier supplier){
	   return supplierService.saveSupplier(supplier);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(@PathVariable int id)
   {
	return supplierService.getSupplierById(id);
	   
   }
   
   @GetMapping
   public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSupplier()
   {
	return supplierService.getAllSuppliers();
	   
   }
   
   @PutMapping
   public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(@RequestBody Supplier supplier){
	  return supplierService.updateSupplier(supplier);
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<ResponseStructure<Supplier>> deleteSupplierById(@PathVariable int id)
   {
	return supplierService.deleteSupplierById(id);
	   
   }
   
}
