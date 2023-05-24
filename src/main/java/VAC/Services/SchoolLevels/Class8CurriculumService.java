package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class8CurriculumDto;

public interface Class8CurriculumService {
	Boolean createClass8Curriculum(Class8CurriculumDto class8CurriculumDto, Integer levelId);

	Boolean updateClass8Curriculum(Class8CurriculumDto class8CurriculumDto, int id);

	Boolean deleteClass8Curriculum(int id);

	List<Class8CurriculumDto> getAllClass8Curriculum();

	Class8CurriculumDto getAllClass8Curriculum(int id);
}
