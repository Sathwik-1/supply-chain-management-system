package jsp.SupplyChainManagementSystem.Exception;

public class IdNotFoundException extends RuntimeException {
 @Override
public String getMessage() {
	return "ID is not found in DB";
}
}
