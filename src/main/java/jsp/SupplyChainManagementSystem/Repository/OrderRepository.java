package jsp.SupplyChainManagementSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.SupplyChainManagementSystem.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
  Optional<Orders> findByTrackingNumber(String trakingNumber);
  
  @Query("select o from Orders o where o.customer.id=?1")
  List<Orders> getOrdersByCustomerId(int customerId);
}
