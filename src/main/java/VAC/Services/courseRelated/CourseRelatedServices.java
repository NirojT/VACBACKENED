package VAC.Services.courseRelated;

import java.util.List;
import java.util.Optional;

import VAC.Entity.CourseRelated.Courses;

public interface CourseRelatedServices {
	
	
	Boolean createCourseRelated(Courses courses);
	Boolean updateCourseRelated(Courses courses,int id);
	Boolean deleteCourseRelated(int id);
	List<Courses> getAllCourseRelated();
	Optional<Courses> getAllCourseRelatedById(int id);
	


}
