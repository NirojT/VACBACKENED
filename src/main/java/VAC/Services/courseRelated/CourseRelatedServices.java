package VAC.Services.courseRelated;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import VAC.Dto.CoursesDto;
import VAC.Entity.CourseRelated.Courses;

public interface CourseRelatedServices {
	
	
	Boolean createCourseRelated(CoursesDto coursesDto);
	Boolean updateCourseRelated(CoursesDto coursesDto,int id);
	Boolean deleteCourseRelated(int id);
	List<CoursesDto> getAllCourseRelated();
	HashMap<String, Object> getAllCourseRelatedByIdYear(int id);
	


}
