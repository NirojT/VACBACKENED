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

import VAC.Dto.Year5Dto;
import VAC.Services.courseRelated.Year5Service;

@RestController
@RequestMapping("/api/year5")
public class Year5Controller {

	@Autowired
	private Year5Service year5Service;
	
	
	@PostMapping("create/{courseId}")
	public ResponseEntity<?> createYear5(@RequestBody Year5Dto year5Dto,@PathVariable Integer courseId ){
		Boolean createYear5 = this.year5Service.createYear5(year5Dto,courseId);
		if(createYear5) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year5 created successfully...");
		
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year5 didnot created ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
		
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateYear5(@RequestBody Year5Dto year5Dto,@PathVariable Integer id){
		
		Boolean updateYear5 = this.year5Service.updateYear5(year5Dto, id);
		
		if(updateYear5) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year5 updated successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year5 didnot updated ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
			
		}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear5(@PathVariable Integer id){
		Boolean deleteYear5 = this.year5Service.deleteYear5(id);
		if(deleteYear5) {
			
				HashMap<String, Object> response = new HashMap<>();
				response.put("year5", "year5 deleted successfully...");
				response.put("status", 200);
				return ResponseEntity.status(200).body(response);

			}
			HashMap<String, Object> response = new HashMap<>();
			response.put("year5", "year5 didnot deleted");
			response.put("status", 400);
			return ResponseEntity.status(200).body(response);

		}
		
	
	@GetMapping("/get-all")
	public  ResponseEntity<?> getAllYear(){
		List<Year5Dto> allYearDto = this.year5Service.getAllYear5();
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYearDto);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
