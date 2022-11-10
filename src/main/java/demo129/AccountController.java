package demo129;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sb")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
		
		
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addAccount(@RequestBody AccountModel accountModel) {
		accountRepository.save(accountModel);
		return "Account added successfully";
	}
	
	 @GetMapping("/findAllAccounts")
	    public List<AccountModel> getBooks() {
	        
	        return accountRepository.findAll();
	    }
	 
	 @DeleteMapping("/delete/{accNo}")
	    public String deleteBook(@PathVariable int accNo){
		 accountRepository.deleteById(accNo);
	        
	        return "Deleted Successfully";
	    }
	 
	
}
