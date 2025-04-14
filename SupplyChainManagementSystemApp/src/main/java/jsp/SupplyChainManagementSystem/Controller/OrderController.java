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
import jsp.SupplyChainManagementSystem.Entity.Orders;
import jsp.SupplyChainManagementSystem.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;
  
  @PostMapping
  public ResponseEntity<ResponseStructure<Orders>> createOrder(@RequestBody Orders orders){
	  return orderService.createOrder(orders);
  }
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(@PathVariable int id){
		  return orderService.getOrderById(id);
	  }
	@GetMapping("/trackingnumber/{trackingNumber}")
	public ResponseEntity<ResponseStructure<Orders>> getOrderBytrackingNumber(@PathVariable String trackingNumber){
		  return orderService.getOrderByTrackingNumber(trackingNumber);
	  }
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(){
		  return orderService.getAllOrders();
	  }
	@GetMapping("/customerid/{id}")
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrderByCustomerId(@PathVariable int id){
		  return orderService.getOrderByCustomerId(id);
	  }
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(@PathVariable int id){
		  return orderService.deleteOrderById(id);
	  }
	@PutMapping
	 public ResponseEntity<ResponseStructure<Orders>> updateOrder(@RequestBody Orders orders){
		  return orderService.updateOrder(orders);
	  }
}
