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

import VAC.Dto.PlusTwo.Year2PlusTwoDto;
import VAC.Services.CoursePlusTwo.Year2PlusTwoServicec;

@RestController
@RequestMapping("/api/Year2PlusTwo")
public class Year2PlusTwoController {
	
	@Autowired
	private Year2PlusTwoServicec year2PlusTwoService;
	
	HashMap< String, Object> response=new HashMap<>();
	
	@PostMapping("/create/{courseId}")
	public ResponseEntity<?> createYear2PlusTwo(@RequestBody Year2PlusTwoDto year2PlusTwoDto,
		@PathVariable int courseId ){
	Boolean createYear2PlusTwo=	this.year2PlusTwoService.createYear2PlusTwo(year2PlusTwoDto, courseId);
		if (createYear2PlusTwo) {
			response.put("message", "Year2PlusTwo subject successfully created");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
			
		}
		response.put("message", "Year2PlusTwo subject not created");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}
	
	
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateYear2PlusTwo(@RequestBody Year2PlusTwoDto year2PlusTwoDto,
			@PathVariable int id ){
		Boolean updateYear2PlusTwo = this.year2PlusTwoService.updateYear2PlusTwo(year2PlusTwoDto, id);
		
		if (updateYear2PlusTwo) {
			response.put("message", "Year2PlusTwo updated successfully ");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
			
		}
		response.put("message", "Year2PlusTwo  not updated");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteYear2PlusTwo(@PathVariable int id ){
		Boolean deleteYear2PlusTwoSubject = this.year2PlusTwoService.deleteYear2PlusTwo(id);
		if (deleteYear2PlusTwoSubject) {
			
			response.put("message", "Year2PlusTwo  subject deleted successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}
		response.put("message", "Year2PlusTwo is not deleted...");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
	}
	
	
	@GetMapping("get-all")
	public ResponseEntity<?> getYear2PlusTwoAllSubject(){
	List<Year2PlusTwoDto> allYear2PlusTwo = this.year2PlusTwoService.getAllYear2PlusTwo();
	
	if (allYear2PlusTwo!=null) {
		
		
		response.put("AllYear2PlusTwoSubject", allYear2PlusTwo);
		response.put("status", 200);
		return ResponseEntity.status(200).body(response);
	}
	
	response.put("message", "Year2PlusTwoSubjects are not found...");
	response.put("status", 400);
	return ResponseEntity.status(200).body(response);	
		
		
	}
	@GetMapping("get/year2Sub/{id}")
	public ResponseEntity<?> getYear1PlusTwoSubjectById(@PathVariable int id){
		
		Year2PlusTwoDto allYear2PlusTwoById = this.year2PlusTwoService.getAllYear2PlusTwoById(id);
		if (allYear2PlusTwoById!=null) {
			
			
			response.put("Year1PlusTwoSubjectById", allYear2PlusTwoById);
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}
		
		response.put("message", "Year2PlusTwoSubjects is not found...");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);	
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
