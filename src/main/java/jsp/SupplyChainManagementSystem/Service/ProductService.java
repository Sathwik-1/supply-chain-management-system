package jsp.SupplyChainManagementSystem.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.SupplyChainManagementSystem.DAO.ProductDao;
import jsp.SupplyChainManagementSystem.DTO.ResponseStructure;
import jsp.SupplyChainManagementSystem.Entity.Product;
import jsp.SupplyChainManagementSystem.Entity.Supplier;
import jsp.SupplyChainManagementSystem.Exception.IdNotFoundException;
import jsp.SupplyChainManagementSystem.Repository.SupplierRepository;

@Service
public class ProductService {
   @Autowired
   private ProductDao productDao;
   @Autowired
   private  SupplierRepository supplierRepository;
   
   //add Product
   public ResponseEntity<ResponseStructure<Product>> addProduct(Product product) {
	   Optional<Supplier>  getSupplier=supplierRepository.findById(product.getSupplier().getId());
	   if(getSupplier.isEmpty()) {
		   throw new IdNotFoundException();
	   }
	    
	   product.setSupplier(getSupplier.get());
	   Product getproduct= productDao.addProduct(product);
	   ResponseStructure<Product> structure=new ResponseStructure<Product>();
	   structure.setData(getproduct);
	   structure.setMessage("Successfull");
	   structure.setStatusCode(HttpStatus.CREATED.value());
	   return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
	   
		   
   }
   
   //get product by id
   public ResponseEntity<ResponseStructure<Product>> getProductById(int id){
	      Optional<Product> getProduct= productDao.getProductById(id);
	      if(getProduct.isPresent()) {
	    	  ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
	    	  responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	  responseStructure.setMessage("Successfully Fetched");
	    	  responseStructure.setData(getProduct.get());
	    	  return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
	      }
	      else {
	    	  throw new IdNotFoundException();
	      }
   }
   //get All products
   public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
	      List<Product> list= productDao.getAllProduct();
	      ResponseStructure<List<Product>> responseStructure=new ResponseStructure<List<Product>>();
	      if(!list.isEmpty()) {
	    	  responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	  responseStructure.setMessage("Successfully Fetched");
	    	  responseStructure.setData(list);
	    	  return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);
	      }
	      else {
	     	  responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	  responseStructure.setMessage(" There Is No Data In The DB  Please Add Data To Fetch");
	    	  responseStructure.setData(null);
	    	  return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);	      }
   }
   
   //get products by supplier id
     public ResponseEntity<ResponseStructure<List<Product>>> getProductsBySupplierId(int supplierId){
    	       Optional<Supplier> checkSupplier=supplierRepository.findById(supplierId);
    	      if(checkSupplier.isPresent()) {
    	      List<Product> productList=productDao.getProductBySupplierId(supplierId);
    	      ResponseStructure<List<Product>> responseStructure=new ResponseStructure<List<Product>>();
    	       responseStructure.setData(productList);
    	       responseStructure.setMessage("Successfull");
    	       responseStructure.setStatusCode(HttpStatus.FOUND.value());
    	       return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);
    	      }
    	      else {
    	    	  throw new IdNotFoundException();
    	      }
     }
  
     //update product
     public ResponseEntity<ResponseStructure<Product>> upadteProduct(Product product){
    	   Optional<Supplier> checkSupplier=supplierRepository.findById(product.getSupplier().getId());
    	   if(checkSupplier.isEmpty()) {
    		   throw new IdNotFoundException();
    	   }
    	   product.setSupplier(checkSupplier.get());
    	   Product getproduct= productDao.addProduct(product);
    	   ResponseStructure<Product> structure=new ResponseStructure<Product>();
    	   structure.setData(getproduct);
    	   structure.setMessage("Successfull");
    	   structure.setStatusCode(HttpStatus.OK.value());
    	   return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
     }
     
     //Delete Product
     public ResponseEntity<ResponseStructure<Product>> deleteProductById(int id){
    	 Optional<Product> getProduct=productDao.getProductById(id);
         if(getProduct.isPresent()) {
        	 productDao.deleteProductById(getProduct.get());
        	 ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
        	 responseStructure.setData(getProduct.get());
        	 responseStructure.setMessage("Succssfully Deleted Product By ID :"+id);
        	 responseStructure.setStatusCode(HttpStatus.OK.value());
        	 return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
         }
         else {
        	 throw new IdNotFoundException();
         }
     }
     
}