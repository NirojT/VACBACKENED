package VAC.Controller.courseRelated;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VAC.Dto.Year7Dto;
import VAC.Services.courseRelated.Year7Service;

@RestController
@RequestMapping("/api/year7")
public class Year7Controller {
	@Autowired
	private Year7Service year7Service;

	@PostMapping("/create/{courseId}")
	public ResponseEntity<?> createYear7(@RequestBody Year7Dto year7Dto, @PathVariable Integer courseId) {
		Boolean createYear7 = this.year7Service.createYear7(year7Dto, courseId);

		if (createYear7) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 7 successfully created");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 7 is not created");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updatyear7(@RequestBody Year7Dto year7Dto, @PathVariable Integer id) {

		Boolean updateYear7 = this.year7Service.updateYear7(year7Dto, id);
		if (updateYear7) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 7 successfully updated");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 7 is not updatedd");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear7(@PathVariable Integer id) {

		Boolean deleteYear7 = this.year7Service.deleteYear7(id);
		if (deleteYear7) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 7 successfully deleted");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 7 is not deleted");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);

	}
	@GetMapping("get-all")
	public ResponseEntity<?> getAllYear7(){
		List<Year7Dto> allYear7 = this.year7Service.getAllYear7();
		
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYear7);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
