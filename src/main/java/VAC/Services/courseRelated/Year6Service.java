package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year6Dto;
import VAC.Entity.CourseRelated.Year5;
import VAC.Entity.CourseRelated.Year6;

public interface Year6Service {

	
	
	Boolean createYear6(Year6Dto year6Dto,Integer CourseId);
	Boolean updateYear6(Year6Dto year6Dto,int id);
	Boolean deleteYear6(int id);
	List<Year6Dto> getAllYear6();
	
}
