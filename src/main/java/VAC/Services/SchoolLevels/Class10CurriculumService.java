package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class10CurriculumDto;

public interface Class10CurriculumService {
	Boolean createClass10Curriculum(Class10CurriculumDto class10CurriculumDto, Integer levelId);

	Boolean updateClass10Curriculum(Class10CurriculumDto class10CurriculumDto, int id);

	Boolean deleteClass10Curriculum(int id);

	List<Class10CurriculumDto> getAllClass10Curriculum();

	Class10CurriculumDto getAllClass10Curriculum(int id);
}
