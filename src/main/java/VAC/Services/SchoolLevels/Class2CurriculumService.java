package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class2CurriculumDto;

public interface Class2CurriculumService {
	Boolean createClass2Curriculum(Class2CurriculumDto class2CurriculumDto, Integer levelId);

	Boolean updateClass2Curriculum(Class2CurriculumDto class2CurriculumDto, int id);

	Boolean deleteClass2Curriculum(int id);

	List<Class2CurriculumDto> getAllClass2Curriculum();

	Class2CurriculumDto getAllClass2Curriculum(int id);
}
