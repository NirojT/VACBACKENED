package VAC.Services.courseRelated;

import java.util.List;

import VAC.Entity.CourseRelated.Year4;
import VAC.Entity.CourseRelated.Year5;

public interface Year5Service {

	
	

	Boolean createYear5(Year5 year5);
	Boolean updateYear5(Year5 year5,int id);
	Boolean deleteYear5(int id);
	List<Year5> getAllYear5();
	Year5 getAllYear5ById(int id);
}
