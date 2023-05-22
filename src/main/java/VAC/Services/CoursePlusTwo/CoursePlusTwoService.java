package VAC.Services.CoursePlusTwo;

import java.util.HashMap;
import java.util.List;

import VAC.Dto.PlusTwo.CoursesPlusTwoDto;

public interface CoursePlusTwoService {
//iam using it later

	Boolean createCourseRelated(CoursesPlusTwoDto coursesDto);

	Boolean updateCourseRelated(CoursesPlusTwoDto coursesDto, int id);

	Boolean deleteCourseRelated(int id);

	List<CoursesPlusTwoDto> getAllCoursesPlusTwoDto();

	HashMap<String, Object> getAllCoursesPlusTwoDtoById(int id);

}
