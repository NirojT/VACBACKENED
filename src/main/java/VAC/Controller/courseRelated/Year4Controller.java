package VAC.Controller.courseRelated;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VAC.Dto.Year3Dto;
import VAC.Dto.Year4Dto;
import VAC.Services.courseRelated.Year3Service;
import VAC.Services.courseRelated.Year4Service;

@RestController
@RequestMapping("api/year4")
public class Year4Controller {

	
	
	@Autowired
	public Year4Service year4Service;
	@PostMapping("create/{courseId}")
	public ResponseEntity<?> createYear4(@RequestBody Year4Dto year4Dto,@PathVariable Integer courseId){
		Boolean createYear4 = this.year4Service.createYear4(year4Dto, courseId);
		if (createYear4) {
			HashMap< String, Object> response=new HashMap<>();
			response.put("message","year 4 created succesfully");
			response.put("status",200);
			return ResponseEntity.status(200).body(response);
			
		}
		HashMap< String, Object> response=new HashMap<>();
		response.put("message","year 4 didnot created");
		response.put("status",400);
		return ResponseEntity.status(200).body(response);
		
		
	}
	@PostMapping("update/{yearId}")
	public ResponseEntity<?> updateYear4(@RequestBody Year4Dto year4Dto,@PathVariable Integer yearId){
		Boolean updateYear4 = this.year4Service.updateYear4(year4Dto, yearId);
		if (updateYear4) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year4 updated successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year4 didnot updated ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
			
	
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear4(@PathVariable Integer id){
		Boolean deleteYear4 = this.year4Service.deleteYear4(id);
		if (deleteYear4) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year4 updated successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year4 didnot updated ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
			
			
		
	}

	
	@GetMapping("get-all")
	public ResponseEntity<?> getAllYear4(){
		List<Year4Dto> allYear4Dto = this.year4Service.getAllYear4();
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYear4Dto);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
