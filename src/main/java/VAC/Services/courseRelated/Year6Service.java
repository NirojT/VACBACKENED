package VAC.Services.courseRelated;

import java.util.List;

import VAC.Entity.CourseRelated.Year5;
import VAC.Entity.CourseRelated.Year6;

public interface Year6Service {

	
	
	Boolean createYear6(Year6 year6);
	Boolean updateYear6(Year6 year6,int id);
	Boolean deleteYear6(int id);
	List<Year6> getAllYear6();
	Year6 getAllYear6ById(int id);
}
