package jsp.SupplyChainManagementSystem.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.SupplyChainManagementSystem.Entity.Supplier;
import jsp.SupplyChainManagementSystem.Repository.SupplierRepository;

@Repository
public class SupplierDao {
  @Autowired
  private SupplierRepository supplierRepository;
  
  public Supplier saveSupplier(Supplier supplier) {
	  return supplierRepository.save(supplier);
  }
  
  public Optional<Supplier> getSupplierById(int id) {
	 return supplierRepository.findById(id);
  }
  public List<Supplier> getAllSuppliers(){
	  return supplierRepository.findAll();
  }
  
  public Supplier updateSupplier(Supplier supplier) {
	  return supplierRepository.save(supplier);
  }
  public void deleteSupplierById(Supplier supplier) {
	 supplierRepository.delete(supplier);
  }
}
