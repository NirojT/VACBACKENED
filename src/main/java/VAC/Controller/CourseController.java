package VAC.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VAC.Entity.CourseRelated.Courses;
import VAC.Services.courseRelated.CourseRelatedServices;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = {"http://127.0.0.1:5173/","http://192.168.0.102:5173/"}, allowCredentials = "true")
public class CourseController {
	
	
	@Autowired
	private CourseRelatedServices courseRelatedServices;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createCourses(@RequestBody Courses courses){
		
		
		
		Boolean createCourseRelated = this.courseRelatedServices.createCourseRelated(courses);
		
		if(createCourseRelated) {
			HashMap<String, Object> response= new HashMap<>();
			response.put("message","Course created successfully...");
			response.put("status",200);
			return ResponseEntity.status(200).body(response);
		}
		
		HashMap<String, Object> response= new HashMap<>();
		response.put("message","Course didnot created ...");
		response.put("status",400);
		
		return ResponseEntity.status(400).body(response);
		
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateCourses(@RequestBody Courses courses,@PathVariable int id){
		
		
		
		Boolean updateCourseRelated = this.courseRelatedServices.updateCourseRelated(courses, id);		
		if(updateCourseRelated) {
			HashMap<String, Object> response= new HashMap<>();
			response.put("message","Course updated successfully...");
			response.put("status",200);
			return ResponseEntity.status(200).body(response);
		}
		
		HashMap<String, Object> response= new HashMap<>();
		response.put("message","Course didnot updated ...");
		response.put("status",400);
		
		return ResponseEntity.status(400).body(response);
		
	}

}
