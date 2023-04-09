package VAC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import VAC.Entity.MainUser;
import VAC.Services.MainUserService;

@SpringBootApplication
public class VacBackenedApplication {



	public static void main(String[] args) throws ParseException {
		SpringApplication.run(VacBackenedApplication.class, args);
		
		String dateString = "2021-10-01";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateString);
		
		/*
		 * Date d= new Date(); Date a = "2023/02/12";
		 */
		System.out.println(date);
//		System.out.println(d.compareTo(a));
		
		/*
		 * try {
		 * 
		 * MainUser mainUser=new MainUser(); mainUser.setName("durgesh");
		 * mainUser.setEmail("durgesh@gmail.com"); mainUser.setPassword("code");
		 * 
		 * 
		 * 
		 * }catch (Exception e) { e.printStackTrace(); }
		
		 *
		 */
		
		
		
	}
	

	
}
