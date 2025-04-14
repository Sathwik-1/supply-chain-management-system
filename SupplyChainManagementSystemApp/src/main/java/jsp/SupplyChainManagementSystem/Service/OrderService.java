package jsp.SupplyChainManagementSystem.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.SupplyChainManagementSystem.DAO.CustomerDao;
import jsp.SupplyChainManagementSystem.DAO.OrderDao;
import jsp.SupplyChainManagementSystem.DAO.ProductDao;
import jsp.SupplyChainManagementSystem.DTO.ResponseStructure;
import jsp.SupplyChainManagementSystem.Entity.Customer;
import jsp.SupplyChainManagementSystem.Entity.Orders;
import jsp.SupplyChainManagementSystem.Entity.Product;
import jsp.SupplyChainManagementSystem.Exception.IdNotFoundException;


@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ProductDao productDao;
	
	//Create Order 
	public ResponseEntity<ResponseStructure<Orders>> createOrder(Orders orders)
	{
	 Optional<Customer>  checkCustomer=customerDao.getCustomerById(orders.getCustomer().getId());
	 if(checkCustomer.isEmpty()) {  // checking wethere the customer is present or not
		 throw new IdNotFoundException();
	 }
	 
	 List<Product> checkProductList =orders.getProductList();
	 List<Product> productList =new ArrayList<Product>();
	 
	  for(Product product:checkProductList) {//checking whethere the product is there or not 
		Optional<Product> checkProduct=productDao.getProductById(product.getId());
		
		if(checkProduct.isPresent()) {
			productList.add(checkProduct.get());
		}
		else {
			throw new IdNotFoundException();
		}
	  }
	  
	  orders.setCustomer(checkCustomer.get());
	  orders.setProductList(productList);
	  orderDao.creatOrder(orders);
		ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
		responseStructure.setData(orders);
		responseStructure.setMessage("Successfully Order Placed");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.CREATED);
	}
	
	//get order by id
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(int id){
		  Optional<Orders> checkOrder=orderDao.getOrderById(id);
		  if(checkOrder.isPresent()) {
			  ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
			  responseStructure.setData(checkOrder.get());
			  responseStructure.setMessage("Successfull");
			  responseStructure.setStatusCode(HttpStatus.FOUND.value());
			  return new ResponseEntity<ResponseStructure<Orders>>(responseStructure,HttpStatus.FOUND);
		  }
		  else {
			  throw new IdNotFoundException();
		  }
	}
	
	//get order by trackingnumber
	public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(String trackingNumber){
		  Optional<Orders> checkOrder=orderDao.getOrderByTrackingNumber(trackingNumber);
		  if(checkOrder.isPresent()) {
			  ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
			  responseStructure.setData(checkOrder.get());
			  responseStructure.setMessage("Successfull");
			  responseStructure.setStatusCode(HttpStatus.FOUND.value());
			  return new ResponseEntity<ResponseStructure<Orders>>(responseStructure,HttpStatus.FOUND);
		  }
		  else {
			  throw new IdNotFoundException();
		  }
	}
	//get all orders
	public ResponseEntity<ResponseStructure<List<Orders>>>  getAllOrders(){
		List<Orders> ordersList=orderDao.getAllOrders();
		ResponseStructure<List<Orders>>responseStructure=new ResponseStructure<List<Orders>>();
		responseStructure.setData(ordersList);
		responseStructure.setMessage("Successfull");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Orders>>>(responseStructure,HttpStatus.OK);
	}
    //get product by customerid
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrderByCustomerId(int customerId){
           List<Orders> OrderList =orderDao.getOrdersByCustomerId(customerId);
           
     if(!OrderList.isEmpty()) {
    	 ResponseStructure<List<Orders>> responseStructure=new ResponseStructure<List<Orders>>();
			  responseStructure.setData(OrderList);
			  responseStructure.setMessage("Successfull");
			  responseStructure.setStatusCode(HttpStatus.FOUND.value());
			  return new ResponseEntity<ResponseStructure<List<Orders>>>(responseStructure,HttpStatus.FOUND);
		  }
		  else {
			  throw new IdNotFoundException();
		  }
	}
	
	//delete order
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(int id){
		  Optional<Orders> checkOrder=orderDao.getOrderById(id);
		  if(checkOrder.isPresent()) {
			  orderDao.deleteOrder(checkOrder.get());
			  ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
			  responseStructure.setData(checkOrder.get());
			  responseStructure.setMessage("Successfull");
			  responseStructure.setStatusCode(HttpStatus.FOUND.value());
			  return new ResponseEntity<ResponseStructure<Orders>>(responseStructure,HttpStatus.FOUND);
		  }
		  else {
			  throw new IdNotFoundException();
		  }
	}
	//update order

		public ResponseEntity<ResponseStructure<Orders>> updateOrder(Orders orders)
		{
		 Optional<Customer>  checkCustomer=customerDao.getCustomerById(orders.getCustomer().getId());
		 if(checkCustomer.isEmpty()) {  // checking wethere the customer is present or not
			 throw new IdNotFoundException();
		 }
		 
		 List<Product> checkProductList =orders.getProductList();
		 List<Product> productList =new ArrayList<Product>();
		 
		  for(Product product:checkProductList) {//checking whethere the product is there or not 
			Optional<Product> checkProduct=productDao.getProductById(product.getId());
			
			if(checkProduct.isPresent()) {
				productList.add(checkProduct.get());
			}
			else {
				throw new IdNotFoundException();
			}
		  }
		  
		  orders.setCustomer(checkCustomer.get());
		  orders.setProductList(productList);
		  orderDao.creatOrder(orders);
			ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
			responseStructure.setData(orders);
			responseStructure.setMessage("Successfully Order Placed");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.CREATED);
		}
}
