package jsp.SupplyChainManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.SupplyChainManagementSystem.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.supplier.id=?1")
    List<Product> getProductBySupplierId(int supplierId);
}
