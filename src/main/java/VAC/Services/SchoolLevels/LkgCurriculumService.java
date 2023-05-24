package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.Class1CurriculumDto;
import VAC.Dto.SchoolLevels.LkgCurriculumDto;

public interface LkgCurriculumService {
	Boolean createLkgCurriculum(LkgCurriculumDto lkgCurriculumDto, Integer levelId);

	Boolean updateLkgCurriculum(LkgCurriculumDto lkgCurriculumDto, int id);

	Boolean deleteLkgCurriculum(int id);

	List<LkgCurriculumDto> getAllLkgCurriculum();

	LkgCurriculumDto getAllLkgCurriculum(int id);
}
