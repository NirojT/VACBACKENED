package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year2Dto;
import VAC.Entity.CourseRelated.Year2;

public interface Year2Service  {
	
	
	Boolean createYear2(Year2Dto year2Dto,Integer CourseId);
	Boolean updateYear2(Year2Dto year2Dto,int id);
	Boolean deleteYear2(int id);
	List<Year2Dto> getAllYear2();
	
	

}
