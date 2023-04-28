package VAC.Services.courseRelated;

import java.util.List;

import VAC.Entity.CourseRelated.Year4;

public interface Year4Service {

	
	Boolean createYear4(Year4 year4);
	Boolean updateYear4(Year4 year4,int id);
	Boolean deleteYear4(int id);
	List<Year4> getAllYear4();
	Year4 getAllYear4ById(int id);
	
	
}
