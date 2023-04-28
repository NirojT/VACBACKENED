package VAC.Services.courseRelated;

import java.util.List;

import VAC.Entity.CourseRelated.Year7;

public interface Year7Service {

	Boolean createYear7(Year7 year7);
	Boolean updateYear7(Year7 year7,int id);
	Boolean deleteYear7(int id);
	List<Year7> getAllYear7();
	Year7 getAllYear7ById(int id);
}
