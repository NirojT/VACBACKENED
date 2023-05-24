package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class3CurriculumDto;

public interface Class3CurriculumService {
	
	Boolean createClass3Curriculum(Class3CurriculumDto class3CurriculumDto, Integer levelId);

	Boolean updateClass3Curriculum(Class3CurriculumDto class3CurriculumDto, int id);

	Boolean deleteClass3Curriculum(int id);

	List<Class3CurriculumDto> getAllClass3Curriculum();

	Class3CurriculumDto getAllClass3Curriculum(int id);
}
