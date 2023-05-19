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
import VAC.Reposiotery.courseRelated.Year3Repo;
import VAC.Services.courseRelated.Year3Service;

@RestController
@RequestMapping("api/year3")
public class Year3Controller {
	@Autowired
	public Year3Service year3Service;
	@PostMapping("create/{courseId}")
	public ResponseEntity<?> createYear3(@RequestBody Year3Dto year3Dto,@PathVariable Integer courseId){
		Boolean createYear3 = this.year3Service.createYear3(year3Dto, courseId);
		if (createYear3) {
			HashMap< String, Object> response=new HashMap<>();
			response.put("message","year 3 created succesfully");
			response.put("status",200);
			return ResponseEntity.status(200).body(response);
			
		}
		HashMap< String, Object> response=new HashMap<>();
		response.put("message","year 3 didnot created");
		response.put("status",400);
		return ResponseEntity.status(200).body(response);
		
		
	}
	@PostMapping("update/{yearId}")
	public ResponseEntity<?> updateYear3(@RequestBody Year3Dto year3Dto,@PathVariable Integer yearId){
		Boolean updateYear3 = this.year3Service.updateYear3(year3Dto, yearId);
		if (updateYear3) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "year3 updated successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("message", "Year3 didnot updated ...");
		response.put("status", 400);

		return ResponseEntity.status(200).body(response);
			
	
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear3(@PathVariable Integer id){
		Boolean deleteYear3 = this.year3Service.deleteYear3(id);
		if (deleteYear3) {
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

	
	@GetMapping("get-all")
	public ResponseEntity<?> getAllYear3(){
		List<Year3Dto> allYear3Dto = this.year3Service.getAllYear3();
		HashMap<String, Object> response = new HashMap<>();
		response.put("coursesRelated", allYear3Dto);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	}
}
