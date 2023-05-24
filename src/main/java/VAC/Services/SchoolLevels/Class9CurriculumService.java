package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class1CurriculumDto;
import VAC.Dto.SchoolLevels.Class9CurriculumDto;

public interface Class9CurriculumService {
	Boolean createClass9Curriculum(Class9CurriculumDto class9CurriculumDto, Integer levelId);

	Boolean updateClass9Curriculum(Class9CurriculumDto class9CurriculumDto, int id);

	Boolean deleteClass9Curriculum(int id);

	List<Class9CurriculumDto> getAllClass9Curriculum();

	Class9CurriculumDto getAllClass9Curriculum(int id);
}
