package jsp.SupplyChainManagementSystem.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.SupplyChainManagementSystem.Entity.Orders;
import jsp.SupplyChainManagementSystem.Repository.OrderRepository;

@Repository
public class OrderDao {
  @Autowired
  private OrderRepository orderRepository;
   
  public Orders creatOrder(Orders orders) {
	  return orderRepository.save(orders);
  }
  
  public Optional<Orders> getOrderById(int id){
	  return orderRepository.findById(id);
  }
  
  public Optional<Orders> getOrderByTrackingNumber(String trackingNumber){
	  return orderRepository.findByTrackingNumber(trackingNumber);
  }
  
  public List<Orders> getAllOrders(){
	  return orderRepository.findAll();
  }
  
  public List<Orders> getOrdersByCustomerId(int customerId){
	  return orderRepository.getOrdersByCustomerId(customerId);
  }
  
  public void deleteOrder(Orders orders) {
	  orderRepository.delete(orders);
  }
}
