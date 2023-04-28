package VAC.Services.courseRelated;

import java.util.List;


import VAC.Entity.CourseRelated.Year2;

public interface Year2Service  {
	
	
	Boolean createYear2(Year2 year2);
	Boolean updateYear2(Year2 year2,int id);
	Boolean deleteYear2(int id);
	List<Year2> getAllYear2();
	Year2 getAllYear2ById(int id);
	

}
