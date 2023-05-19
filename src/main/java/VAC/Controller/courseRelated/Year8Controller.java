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
import VAC.Dto.Year8Dto;
import VAC.Services.courseRelated.Year7Service;
import VAC.Services.courseRelated.Year8Service;
@RestController
@RequestMapping("/api/year8")
public class Year8Controller {
	@Autowired
	private Year8Service year8Service;

	@PostMapping("/create/{courseId}")
	public ResponseEntity<?> createYear8(@RequestBody Year8Dto year8Dto, @PathVariable Integer courseId) {
		Boolean createYear8 = this.year8Service.createYear8(year8Dto, courseId);

		if (createYear8) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 8 successfully created");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 8 is not created");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updatyear8(@RequestBody Year8Dto year8Dto, @PathVariable Integer id) {

		Boolean updateYear8 = this.year8Service.updateYear8(year8Dto, id);
		if (updateYear8) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 8 successfully updated");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		else {
		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 8 is not updatedd");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
		}
		
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear8(@PathVariable Integer id) {

		Boolean deleteYear8 = this.year8Service.deleteYear8(id);
		if (deleteYear8) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 8 successfully deleted");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 8 is not deleted");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);

	}
	@GetMapping("get-all")
	public ResponseEntity<?> getAllYear8(){
		List<Year8Dto> allYear8 = this.year8Service.getAllYear8();
		
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYear8);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	
	}
	
	
	
}
