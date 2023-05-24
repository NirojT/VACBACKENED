package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class1CurriculumDto;
import VAC.Dto.SchoolLevels.Class6CurriculumDto;

public interface Class6CurriculumService {
	Boolean createClass6Curriculum(Class6CurriculumDto class6CurriculumDto, Integer levelId);

	Boolean updateClass6Curriculum(Class6CurriculumDto class6CurriculumDto, int id);

	Boolean deleteClass6Curriculum(int id);

	List<Class6CurriculumDto> getAllClass6Curriculum();

	Class6CurriculumDto getAllClass6Curriculum(int id);
}
