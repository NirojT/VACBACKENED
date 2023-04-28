package VAC.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VAC.Entity.ContactUS;
import VAC.Reposiotery.ContactUSRepo;


@RestController
@RequestMapping("api/contact")
public class ContactUsController {
	
	@Autowired
	public ContactUSRepo contactUSRepo;
	
	
	@PostMapping("/contact")
	public ResponseEntity<ContactUS> contact(@RequestParam String name,
			@RequestParam String email,
			@RequestParam String message
		){
		ContactUS contactUS= new ContactUS(name,email,message);
		
		ContactUS savedContact = this.contactUSRepo.save(contactUS);
		
		return new  ResponseEntity<ContactUS>(savedContact, HttpStatus.OK);
				
		
	
		
		
		
	}
	
	
	@GetMapping("all-contact")
	public ResponseEntity<List<ContactUS>> getAllContacts(){
		
		List<ContactUS> allContacts = this.contactUSRepo.findAll();
		
		return new ResponseEntity<List<ContactUS>>(allContacts, HttpStatus.OK);
	}
	
	@GetMapping("contact/{id}")
	public ResponseEntity<ContactUS> getContactById(@PathVariable Integer id){
		Optional<ContactUS> contactId = this.contactUSRepo.findById(id);
		
		return new ResponseEntity<ContactUS>(HttpStatus.OK);
		
		
		
		
		
	}
	
	
	
	
	
	

}
