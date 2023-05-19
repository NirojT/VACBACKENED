package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year7Dto;
import VAC.Entity.CourseRelated.Year7;

public interface Year7Service {

	Boolean createYear7(Year7Dto year7Dto,Integer CourseId);
	Boolean updateYear7(Year7Dto year7Dto,int id);
	Boolean deleteYear7(int id);
	List<Year7Dto> getAllYear7();

}
