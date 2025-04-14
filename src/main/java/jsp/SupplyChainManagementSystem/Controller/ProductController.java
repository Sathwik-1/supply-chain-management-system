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
import jsp.SupplyChainManagementSystem.Entity.Product;
import jsp.SupplyChainManagementSystem.Service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
   @PostMapping
   public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product){
	  return  productService.addProduct(product);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id){
	  return  productService.getProductById(id);
   }
   
   @GetMapping
   public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
	  return  productService.getAllProduct();
   }
   
   @GetMapping("/supplier/{id}")
   public ResponseEntity<ResponseStructure<List<Product>>> getProductsBySupplierId(@PathVariable int id){
	   return productService.getProductsBySupplierId(id);
   }
   
   @PutMapping
   public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product){
	  return  productService.upadteProduct(product);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<ResponseStructure<Product>> deleteProductById(@PathVariable int id){
	   return productService.deleteProductById(id);
   }
}
