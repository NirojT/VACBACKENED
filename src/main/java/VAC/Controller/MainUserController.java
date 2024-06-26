package VAC.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VAC.AllJwt.AuthRequest;
import VAC.AllJwt.JwtService;
import VAC.Entity.MainUser;
import VAC.Services.MainUserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://127.0.0.1:5173/", "http://localhost:5173/"}, allowCredentials = "true")
public class MainUserController {

	@Autowired
	public MainUserService mainUserService;
	
	
	  @Autowired 
	  public JwtService jwtService;
	 
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	
	@PostMapping("/create")
	public ResponseEntity<MainUser> createUser(@RequestBody MainUser mainUser){
		
		
		MainUser createdUser = this.mainUserService.createMainUser(mainUser);
		
		return new ResponseEntity<MainUser>(createdUser,HttpStatus.CREATED);
	
	}
	
	
	/*
	 * @PostMapping("/login") public String authenticateAndGetToken(@RequestBody
	 * AuthRequest authRequest) { System.out.println("inside if"); Authentication
	 * authenticate = this.authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.
	 * getPassword())); System.out.println("inside if");
	 * if(authenticate.isAuthenticated()) { System.out.println("inside if"); return
	 * this.jwtService.generateToken(authRequest.getUsername()); }
	 * 
	 * else { throw new UsernameNotFoundException("invalid user request! "); } }
	 */
	
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		System.out.println("inside if");
		Authentication authenticate = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())); 
		System.out.println("inside if");
		if(authenticate.isAuthenticated()) {
			System.out.println("inside if");
			 String generateToken = this.jwtService.generateToken(authRequest.getUsername());
			 
			 //creating key value pair using hashmap
			 HashMap<String, Object> response= new HashMap<>();
			 response.put("token", generateToken);
			 response.put("message", "login success");
			 response.put("status", 200);
			 //sending custom response with status and message
			 return  ResponseEntity.status(200).body(response);
		}
		
		else {
			throw new UsernameNotFoundException("invalid user request! ");
		}
	}

	
}
