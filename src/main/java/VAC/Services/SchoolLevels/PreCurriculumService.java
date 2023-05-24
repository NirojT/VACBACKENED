package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.PreCurriculumDto;

public interface PreCurriculumService {
	Boolean createPreCurriculum(PreCurriculumDto preCurriculumDto, Integer levelId);

	Boolean updatePreCurriculum(PreCurriculumDto preCurriculumDto, int id);

	Boolean deletePreCurriculum(int id);

	List<PreCurriculumDto> getAllPreCurriculum();

	PreCurriculumDto getAllPreCurriculum(int id);
}
