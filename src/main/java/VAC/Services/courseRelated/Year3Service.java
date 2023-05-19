package VAC.Services.courseRelated;

import java.util.List;

import VAC.Dto.Year3Dto;

public interface Year3Service {

	
	Boolean createYear3(Year3Dto year3Dto,Integer CourseId);
	Boolean updateYear3(Year3Dto year3Dto,int id);
	Boolean deleteYear3(int id);
	List<Year3Dto> getAllYear3();
	
}
