package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Entity.CourseRelated.Courses;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Services.courseRelated.CourseRelatedServices;

@Service
public class CourseRelatedServiceImpl implements CourseRelatedServices{

	@Autowired
	private CourseRelatedRepo courseRelatedRepo;
	
	
	//creating courses..........
	@Override
	public Boolean createCourseRelated(Courses courses) {
		
		Courses courses2=new Courses();
		courses2.setTitle(courses.getTitle());
		courses2.setCriteria(courses.getCriteria());
		courses2.setDescription(courses.getDescription());
		courses2.setDuration(courses.getDuration());
		courses2.setTagline(courses.getTagline());
		
		
		
		Courses saveingCourse = courseRelatedRepo.save(courses2);
		
		if (saveingCourse instanceof Courses) {
			return true;
			
		}
		
		return false;
	}

	//updating course
	@Override
	public Boolean updateCourseRelated(Courses courses,int id) {
		
		Courses courseById = this.courseRelatedRepo.findById(id).orElseThrow(()-> new ResourceNotFound("Course", "Courses id", id));
		
		
		courseById.setTitle(courses.getTitle());
		courseById.setCriteria(courses.getCriteria());
		courseById.setDescription(courses.getDescription());
		courseById.setDuration(courses.getDuration());
		courseById.setTagline(courses.getTagline());
		
		
		Courses updatedCourse = this.courseRelatedRepo.save(courseById);
		
		if (updatedCourse instanceof Courses) {
			return true;
			
		}
		
		return false;
	}

	//deleting courses
	@Override
	public Boolean deleteCourseRelated(int id) {
		
		Courses courseById = this.courseRelatedRepo.findById(id).orElseThrow(()-> new ResourceNotFound("Course", "Courses id", id));
		
		this.courseRelatedRepo.delete(courseById);
		Optional<Courses> deletedCourse = this.courseRelatedRepo.findById(id);
		
		if(deletedCourse.isPresent()) {
			return false;
		}
		
		
		
		return true;
	}

	// getting all courses
	
	@Override
	public List<Courses> getAllCourseRelated() {
		List<Courses> allCourses = this.courseRelatedRepo.findAll();
		return allCourses;
	}

	// getting all course by id
	@Override
	public Optional<Courses> getAllCourseRelatedById(int id) {
		try {

			return this.courseRelatedRepo.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
