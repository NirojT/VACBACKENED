package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year3Dto;
import VAC.Dto.Year4Dto;
import VAC.Entity.CourseRelated.Year4;

public interface Year4Service {

	
	Boolean createYear4(Year4Dto year4Dto,Integer CourseId);
	Boolean updateYear4(Year4Dto year4,int id);
	Boolean deleteYear4(int id);
	List<Year4Dto> getAllYear4();
	
	

	
}
