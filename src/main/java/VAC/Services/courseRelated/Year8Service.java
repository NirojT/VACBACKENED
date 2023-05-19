package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year8Dto;
import VAC.Entity.CourseRelated.Year8;

public interface Year8Service {

	
	Boolean createYear8(Year8Dto year8Dto,Integer CourseId);
	Boolean updateYear8(Year8Dto year8,int id);
	Boolean deleteYear8(int id);
	List<Year8Dto> getAllYear8();
	
}
