package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class1CurriculumDto;

public interface Class1CurriculumService {
	Boolean createClass1Curriculum(Class1CurriculumDto class1CurriculumDto, Integer levelId);

	Boolean updateClass1Curriculum(Class1CurriculumDto class1CurriculumDto, int id);

	Boolean deleteClass1Curriculum(int id);

	List<Class1CurriculumDto> getAllClass1Curriculum();

	Class1CurriculumDto getAllClass1Curriculum(int id);
}
