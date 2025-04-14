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
public class Supplier {
	   @Id 
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private  int id;
	  private String name;
	  private long contact_no;
	  private String email;
	  private String companyname;
	  
	  @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
	  @JsonIgnore
	  private  List<Product> productList;

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

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", contact_no=" + contact_no + ", email=" + email
				+ ", companyname=" + companyname + ", productList=" + productList + "]";
	}
	  
}
