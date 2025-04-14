package jsp.SupplyChainManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jsp.SupplyChainManagementSystem.DTO.ResponseStructure;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception){
    	ResponseStructure<String> structure=new ResponseStructure<String>();
    	structure.setData(exception.getMessage());
    	structure.setStatusCode(HttpStatus.NOT_FOUND.value());
    	structure.setMessage("Not Found");
    	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
    }
}
