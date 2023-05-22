package VAC.Controller.CoursePlusTwo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VAC.Dto.PlusTwo.CoursesPlusTwoDto;
import VAC.Services.CoursePlusTwo.CoursePlusTwoService;

@RestController
@RequestMapping("/api/CoursePlusTwo/")
public class CoursePlusTwoController {
	@Autowired
	private CoursePlusTwoService coursePlusTwoService;
	HashMap<String, Object> response = new HashMap<>();
	
	@PostMapping("create")
	public ResponseEntity<?> createCoursePlusTwo(@RequestBody CoursesPlusTwoDto coursesPlusTwoDto){
		Boolean createCourseRelated = this.coursePlusTwoService.createCourseRelated(coursesPlusTwoDto);
		
		if(createCourseRelated) {
			response.put("status", 200);
			response.put("message", "Plus Two course created Successfully..");
			return ResponseEntity.status(200).body(response);
		}
		response.put("status", 400);
		response.put("message", "Plus Two course is not created..");
		return ResponseEntity.status(200).body(response);
	}

	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateCoursePlusTwo(@RequestBody CoursesPlusTwoDto coursesPlusTwoDto , @PathVariable Integer id){
	
	Boolean updateCourseRelated = this.coursePlusTwoService.updateCourseRelated(coursesPlusTwoDto, id);
	if(updateCourseRelated) {
		response.put("status", 200);
		response.put("message", "Plus Two course updated Successfully..");
		return ResponseEntity.status(200).body(response);
	}
	
	response.put("status", 400);
	response.put("message", "Plus Two course is not updated..");
	return ResponseEntity.status(200).body(response);
}
	
	@GetMapping("get-all")
	public ResponseEntity<?> getAllCoursePlusTwo(){
	List<CoursesPlusTwoDto> allCoursesPlusTwoDto = this.coursePlusTwoService.getAllCoursesPlusTwoDto();
	
	response.put("status", 200);
	response.put("PlusTwoCourses", allCoursesPlusTwoDto);
	return ResponseEntity.status(200).body(response);
	
	
	}
	@GetMapping("get/year/{id}")
	public ResponseEntity<?> getCoursePlusTwoById( @PathVariable Integer id){
		HashMap<String,Object> allCoursesPlusTwoDtoById = this.coursePlusTwoService.getAllCoursesPlusTwoDtoById(id);
		if(allCoursesPlusTwoDtoById !=null) {
			response.put("status", 200);
			response.put("PlusTwoCourses",allCoursesPlusTwoDtoById );
			return ResponseEntity.status(200).body(response);
		}
		response.put("status", 400);
		response.put("message", "Plus Two course is not found..");
		return ResponseEntity.status(200).body(response);
		
		
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deletePlusTwoCourse(@PathVariable Integer id){
		Boolean deleteCourseRelated = this.coursePlusTwoService.deleteCourseRelated(id);
		if(deleteCourseRelated) {
			response.put("message", "Plus Two course deleted successfully...");
			response.put("status", 200);
			return ResponseEntity.status(200).body(response);
		}
		response.put("message", "course is not deleted...");
		response.put("status", 400);
		return ResponseEntity.status(200).body(response);
		
	}
	
	
}
