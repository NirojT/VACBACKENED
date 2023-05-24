package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class1CurriculumDto;
import VAC.Dto.SchoolLevels.Class5CurriculumDto;

public interface Class5CurriculumService {
	Boolean createClass5Curriculum(Class5CurriculumDto class5CurriculumDto, Integer levelId);

	Boolean updateClass5Curriculum(Class5CurriculumDto class5CurriculumDto, int id);

	Boolean deleteClass5Curriculum(int id);

	List<Class5CurriculumDto> getAllClass5Curriculum();

	Class5CurriculumDto getAllClass5Curriculum(int id);
}
