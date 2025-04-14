package jsp.SupplyChainManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.SupplyChainManagementSystem.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
