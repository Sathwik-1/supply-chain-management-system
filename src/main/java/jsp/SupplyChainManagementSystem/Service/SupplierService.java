package jsp.SupplyChainManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.SupplyChainManagementSystem.DAO.SupplierDao;
import jsp.SupplyChainManagementSystem.DTO.ResponseStructure;
import jsp.SupplyChainManagementSystem.Entity.Supplier;
import jsp.SupplyChainManagementSystem.Exception.IdNotFoundException;

@Service
public class SupplierService {
   @Autowired
   private SupplierDao supplierdao;
   
   // saving record
   public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier){
	      Supplier getSupplier=  supplierdao.saveSupplier(supplier);
	      ResponseStructure<Supplier> responseStructure=new ResponseStructure<Supplier>();
	      responseStructure.setStatusCode(HttpStatus.CREATED.value());
	      responseStructure.setMessage("Successfully Supplier Record Is Inserted");
	      responseStructure.setData(getSupplier);
	      return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.CREATED);
	      
   }
   
   //fetching record by id
   public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(int id){
	   
	      Optional<Supplier> supplierByid=  supplierdao.getSupplierById(id);
	      
	      if(supplierByid.isPresent()) {
	      ResponseStructure<Supplier> responseStructure=new ResponseStructure<Supplier>();
	      responseStructure.setStatusCode(HttpStatus.FOUND.value());
	      responseStructure.setMessage("Successfully Fetched");
	      responseStructure.setData(supplierByid.get());
	      return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.FOUND);
	      }
	      else {
	    	  throw new IdNotFoundException();
	      }
	      
  }
   
   //fetching All records
   public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers(){
	  List<Supplier> list= supplierdao.getAllSuppliers();
	  ResponseStructure<List<Supplier>> responseStructure=new ResponseStructure<List<Supplier>>();
	  responseStructure.setData(list);
	  responseStructure.setMessage("Successfully Fetched All The Records");
	  responseStructure.setStatusCode(HttpStatus.OK.value());
	  return new ResponseEntity<ResponseStructure<List<Supplier>>>(responseStructure, HttpStatus.OK);
   }
   
   //update Supplier 
    public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier){
    	 Supplier getsupplier=  supplierdao.updateSupplier(supplier);
    	 ResponseStructure<Supplier> responseStructure=new ResponseStructure<Supplier>();
    	 responseStructure.setData(getsupplier);
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
    	 responseStructure.setMessage("Succeessfully Updated");
    	 return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure,HttpStatus.OK);
    }
    
    //Delete Supplier By id
    public ResponseEntity<ResponseStructure<Supplier>> deleteSupplierById(int id){
    	 Optional<Supplier> getSupplier=supplierdao.getSupplierById(id);
    	 if(getSupplier.isPresent()) {
    		 ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
    		 structure.setData(getSupplier.get());
    		 structure.setMessage("Successfully Deleted Supplier By Id "+id);
    		 structure.setStatusCode(HttpStatus.FOUND.value());
    		 supplierdao.deleteSupplierById(getSupplier.get());// it will delete the record in db
    		 return new ResponseEntity<ResponseStructure<Supplier>>(structure, HttpStatus.FOUND);
    	 }
    	 else {
    		 throw new IdNotFoundException();
    	 }
    }
}
