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
import VAC.Dto.Year2Dto;
import VAC.Services.courseRelated.Year1Service;
import VAC.Services.courseRelated.Year2Service;

@RestController
@RequestMapping("/api/year2")
public class Year2Controller {
	
	@Autowired
	private Year2Service year2Service;
	
	
	
	@PostMapping("create/{courseId}")
	public ResponseEntity<?> createYear2(@RequestBody Year2Dto year1Dto,@PathVariable Integer courseId ){
		Boolean createYear2 = this.year2Service.createYear2(year1Dto,courseId);
		if(createYear2) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year2 created successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year2 didnot created ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
		
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateYear2(@RequestBody Year2Dto year2Dto,@PathVariable Integer id){
		
		Boolean updateYear1 = this.year2Service.updateYear2(year2Dto, id);
		
		if(updateYear1) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year2 updated successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year2 didnot updated ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
			
		}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear2(@PathVariable Integer id){
		Boolean deleteYear2 = this.year2Service.deleteYear2(id);
		if(deleteYear2) {
			
				HashMap<String, Object> response = new HashMap<>();
				response.put("year1", "year2 deleted successfully...");
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
		List<Year2Dto> allYear2Dto = this.year2Service.getAllYear2();
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYear2Dto);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	}

	
	
	
	
	
	
	}
		
		
	
	


