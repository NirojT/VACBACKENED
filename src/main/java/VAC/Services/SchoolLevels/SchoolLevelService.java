package VAC.Services.SchoolLevels;

import java.util.HashMap;
import java.util.List;

import VAC.Dto.SchoolLevels.SchoolLevelsDto;

public interface SchoolLevelService {
	
	Boolean createSchoolLevel(SchoolLevelsDto schoolLevelsDto);

	Boolean updateSchoolLevel(SchoolLevelsDto schoolLevelsDto, int id);

	Boolean deleteSchoolLevel(int id);

	List<SchoolLevelsDto> getAllSchoolLevels();

	HashMap<String, Object> getSchoolLevelsById(int id);
}
