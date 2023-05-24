package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.UkgCurriculumDto;

public interface UkgCurriculumService {
	
	Boolean createUkgCurriculum(UkgCurriculumDto ukgCurriculumDto, Integer levelId);

	Boolean updateUkgCurriculum(UkgCurriculumDto ukgCurriculumDto, int id);

	Boolean deleteUkgCurriculum(int id);

	List<UkgCurriculumDto> getAllUkgCurriculum();

	UkgCurriculumDto getAllUkgCurriculum(int id);
}
