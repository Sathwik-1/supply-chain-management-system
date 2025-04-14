package jsp.SupplyChainManagementSystem.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.SupplyChainManagementSystem.Entity.Product;
import jsp.SupplyChainManagementSystem.Repository.ProductRepository;

@Repository
public class ProductDao {
  @Autowired
  private ProductRepository productRepository;
  
  public Product addProduct(Product product) {
	  return productRepository.save(product);
  }
  
  public Optional<Product> getProductById(int id) {
	  return productRepository.findById(id);
  }
  
  public List<Product> getAllProduct() {
	  return productRepository.findAll();
  }
  
 public List<Product> getProductBySupplierId(int supplierId){
	 return productRepository.getProductBySupplierId(supplierId);
 }
 
 public void deleteProductById(Product product) {
	 productRepository.delete(product);
 }
}
