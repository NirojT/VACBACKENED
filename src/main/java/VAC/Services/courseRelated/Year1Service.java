package VAC.Services.courseRelated;

import java.util.List;

import VAC.Entity.CourseRelated.Year1;

public interface Year1Service  {
	
	
	Boolean createYear1(Year1 year1);
	Boolean updateYear1(Year1 year1,int id);
	Boolean deleteYear1(int id);
	List<Year1> getAllYear1();
	Year1 getAllYear1ById(int id);
	

}
