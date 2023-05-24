package VAC.Services.SchoolLevels;

import java.util.List;

import VAC.Dto.SchoolLevels.NurseryCurriculumDto;

public interface NurseryCurriculumService {
	Boolean createNurseryCurriculum(NurseryCurriculumDto nurseryCurriculumDto, Integer levelId);

	Boolean updateNurseryCurriculum(NurseryCurriculumDto nurseryCurriculumDto, int id);

	Boolean deleteNurseryCurriculum(int id);

	List<NurseryCurriculumDto> getAllNurseryCurriculum();

	NurseryCurriculumDto getAllNurseryCurriculum(int id);
}
