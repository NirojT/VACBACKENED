package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year5Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year4;
import VAC.Entity.CourseRelated.Year5;

public interface Year5Service {

	
	

	Boolean createYear5(Year5Dto year5Dto,Integer CourseId);
	Boolean updateYear5(Year5Dto year5Dto,int id);
	Boolean deleteYear5(int id);
	List<Year5Dto> getAllYear5();
	
}
