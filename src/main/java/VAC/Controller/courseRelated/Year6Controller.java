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

import VAC.Dto.Year6Dto;
import VAC.Entity.CourseRelated.Year6;
import VAC.Services.courseRelated.Year6Service;

@RestController
@RequestMapping("/api/year6")
public class Year6Controller {
	@Autowired
	private Year6Service year6Service;

	@PostMapping("/create/{courseId}")
	public ResponseEntity<?> createYear6(@RequestBody Year6Dto year6Dto, @PathVariable Integer courseId) {
		Boolean createYear6 = this.year6Service.createYear6(year6Dto, courseId);

		if (createYear6) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 6 successfully created");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 6 is not created");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<?> updatyear6(@RequestBody Year6Dto year6Dto, @PathVariable Integer id) {

		Boolean updateYear6 = this.year6Service.updateYear6(year6Dto, id);
		if (updateYear6) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 6 successfully updated");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 6 is not updatedd");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear6(@PathVariable Integer id) {

		Boolean deleteYear6 = this.year6Service.deleteYear6(id);
		if (deleteYear6) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Year 6 successfully deleted");
			response.put("status", 200);

			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "year 6 is not deleted");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);

	}
	@GetMapping("get-all")
	public ResponseEntity<?> getAllYear6(){
		List<Year6Dto> allYear6 = this.year6Service.getAllYear6();
		
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYear6);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
		
	}
}
