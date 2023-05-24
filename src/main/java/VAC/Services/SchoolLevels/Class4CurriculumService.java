package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class1CurriculumDto;
import VAC.Dto.SchoolLevels.Class4CurriculumDto;

public interface Class4CurriculumService {
	Boolean createClass4Curriculum(Class4CurriculumDto class4CurriculumDto, Integer levelId);

	Boolean updateClass4Curriculum(Class4CurriculumDto class4CurriculumDto, int id);

	Boolean deleteClass4Curriculum(int id);

	List<Class4CurriculumDto> getAllClass4Curriculum();

	Class4CurriculumDto getAllClass4Curriculum(int id);
}
