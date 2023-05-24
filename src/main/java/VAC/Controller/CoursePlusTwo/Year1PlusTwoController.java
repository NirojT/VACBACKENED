package VAC.Controller.CoursePlusTwo;

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

import VAC.Dto.PlusTwo.Year1PlusTwoDto;
import VAC.Entity.coursesPlusTwo.Year1PlusTwo;
import VAC.Services.CoursePlusTwo.Year1PlusTwoService;

@RestController
@RequestMapping("/api/Year1PlusTwo")
public class Year1PlusTwoController {
	
	@Autowired
	private Year1PlusTwoService year1PlusTwoService;
	
	HashMap< String, Object> response=new HashMap<>();
	
	@PostMapping("/create/{courseId}")
	public ResponseEntity<?> createYear1PlusTwo(@RequestBody Year1PlusTwoDto year1PlusTwoDto,
		@PathVariable int courseId ){
	Boolean createYear1PlusTwo=	this.year1PlusTwoService.createYear1PlusTwo(year1PlusTwoDto, courseId);
		if (createYear1PlusTwo) {
			response.put("message", "Year1PlusTwo subject successfully created");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
			
		}
		response.put("message", "Year1PlusTwo subject not created");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateYear1PlusTwo(@RequestBody Year1PlusTwoDto year1PlusTwoDto,
			@PathVariable int id ){
		Boolean updateYear1PlusTwo = this.year1PlusTwoService.updateYear1PlusTwo(year1PlusTwoDto, id);
		
		if (updateYear1PlusTwo) {
			response.put("message", "Year1PlusTwo updated successfully ");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
			
		}
		response.put("message", "Year1PlusTwo  not updated");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear1PlusTwo(@PathVariable int id ){
		Boolean deleteYear1PlusTwoSubject = this.year1PlusTwoService.deleteYear1PlusTwo(id);
		if (deleteYear1PlusTwoSubject) {
			
			response.put("message", "Year1PlusTwo  subject deleted successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}
		response.put("message", "Year1PlusTwo is not deleted...");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}
	
	@GetMapping("get-all")
	public ResponseEntity<?> getYear1PlusTwoAllSubject( ){
	List<Year1PlusTwoDto> allYear1PlusTwo = this.year1PlusTwoService.getAllYear1PlusTwo();
	if (allYear1PlusTwo!=null) {
		
		
		response.put("AllYear1PlusTwoSubject", allYear1PlusTwo);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	}
	
	response.put("message", "Year1PlusTwoSubjects are not found...");
	response.put("status", 400);
	return ResponseEntity.status(200).body(response);	
		
		
	}
	@GetMapping("get/year1Sub/{id}")
	public ResponseEntity<?> getYear1PlusTwoSubjectById(@PathVariable int id){
		
		Year1PlusTwoDto allYear1PlusTwoById = this.year1PlusTwoService.getAllYear1PlusTwoById(id);
		if (allYear1PlusTwoById!=null) {
			
			
			response.put("Year1PlusTwoSubjectById", allYear1PlusTwoById);
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}
		
		response.put("message", "Year1PlusTwoSubjects is not found...");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);	
			
			
		}
	
	
	
	
	
	
	
	

}
