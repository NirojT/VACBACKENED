package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class1CurriculumDto;
import VAC.Dto.SchoolLevels.Class7CurriculumDto;

public interface Class7CurriculumService {

	Boolean createClass7Curriculum(Class7CurriculumDto class7CurriculumDto, Integer levelId);

	Boolean updateClass7Curriculum(Class7CurriculumDto class7CurriculumDto, int id);

	Boolean deleteClass7Curriculum(int id);

	List<Class7CurriculumDto> getAllClass7Curriculum();

	Class7CurriculumDto getAllClass7Curriculum(int id);
}
