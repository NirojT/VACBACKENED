package VAC.Services.courseRelated;

import java.util.List;

import VAC.Entity.CourseRelated.Year2;
import VAC.Entity.CourseRelated.Year3;

public interface Year3Service {

	
	Boolean createYear3(Year3 year3);
	Boolean updateYear3(Year3 year3,int id);
	Boolean deleteYear3(int id);
	List<Year3> getAllYear3();
	Year3 getAllYear3ById(int id);
	
}
