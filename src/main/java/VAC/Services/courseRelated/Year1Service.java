package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year1Dto;
import VAC.Entity.CourseRelated.Year1;

public interface Year1Service  {
	
	
	Boolean createYear1(Year1Dto year1Dto,Integer CourseId);
	Boolean updateYear1(Year1Dto year1Dto,int id);
	Boolean deleteYear1(int id);
	List<Year1Dto> getAllYear1();
	Year1Dto getAllYear1ById(int id);
	

}
