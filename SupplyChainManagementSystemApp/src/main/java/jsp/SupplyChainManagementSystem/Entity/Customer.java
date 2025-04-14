package jsp.SupplyChainManagementSystem.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Customer {
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int id;
  private String name;
  private long phone_no;
  private String email;
  private String address;
  
  @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Orders> orderList;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public long getPhone_no() {
	return phone_no;
}

public void setPhone_no(long phone_no) {
	this.phone_no = phone_no;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public List<Orders> getOrderList() {
	return orderList;
}

public void setOrderList(List<Orders> orderList) {
	this.orderList = orderList;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", phone_no=" + phone_no + ", email=" + email + ", address="
			+ address + ", orderList=" + orderList + "]";
}
   
}
