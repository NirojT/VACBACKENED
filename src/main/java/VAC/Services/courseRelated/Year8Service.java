package VAC.Services.courseRelated;

import java.util.List;

import VAC.Entity.CourseRelated.Year8;

public interface Year8Service {

	
	Boolean createYear8(Year8 year8);
	Boolean updateYear8(Year8 year8,int id);
	Boolean deleteYear8(int id);
	List<Year8> getAllYear8();
	Year8 getAllYear8ById(int id);
}
