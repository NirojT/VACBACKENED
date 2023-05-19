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

import VAC.Dto.Year1Dto;
import VAC.Services.courseRelated.Year1Service;

@RestController
@RequestMapping("api/year")
public class Year1Controller {
	
	@Autowired
	private Year1Service year1Service;
	
	
	@PostMapping("create/{courseId}")
	public ResponseEntity<?> createYear1(@RequestBody Year1Dto year1Dto,@PathVariable Integer courseId ){
		Boolean createYear1 = this.year1Service.createYear1(year1Dto,courseId);
		if(createYear1) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year1 created successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year1 didnot created ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
		
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateYear1(@RequestBody Year1Dto year1Dto,@PathVariable Integer id){
		
		Boolean updateYear1 = this.year1Service.updateYear1(year1Dto, id);
		
		if(updateYear1) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year1 updated successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year1 didnot updated ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
			
		}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear1(@PathVariable Integer id){
		Boolean deleteYear1 = this.year1Service.deleteYear1(id);
		if(deleteYear1) {
			
				HashMap<String, Object> response = new HashMap<>();
				response.put("year1", "year1 deleted successfully...");
				response.put("status", 200);
				return ResponseEntity.status(200).body(response);

			}
			HashMap<String, Object> response = new HashMap<>();
			response.put("year1", "year1 didnot deleted");
			response.put("status", 400);
			return ResponseEntity.status(200).body(response);

		}
		
	
	@GetMapping("/get-all")
	public  ResponseEntity<?> getAllYear1(){
		List<Year1Dto> allYear1Dto = this.year1Service.getAllYear1();
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYear1Dto);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	}

	
	
	
	
	
	
	}
		
		
	
	


