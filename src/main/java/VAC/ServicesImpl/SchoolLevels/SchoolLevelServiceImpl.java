package VAC.ServicesImpl.SchoolLevels;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.PlusTwo.Year1PlusTwoDto;
import VAC.Dto.SchoolLevels.LkgCurriculumDto;
import VAC.Dto.SchoolLevels.NurseryCurriculumDto;
import VAC.Dto.SchoolLevels.PreCurriculumDto;
import VAC.Dto.SchoolLevels.SchoolLevelsDto;
import VAC.Entity.SchoolLevels.SchoolLevels;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.SchoolLevels.SchoolLevelRepo;
import VAC.Services.SchoolLevels.SchoolLevelService;
import net.bytebuddy.asm.Advice.This;

@Service
public class SchoolLevelServiceImpl implements SchoolLevelService {

	@Autowired
	private SchoolLevelRepo schoolLevelRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Boolean createSchoolLevel(SchoolLevelsDto schoolLevelsDto) {
		SchoolLevels createSchoolLevels = this.mapper.map(schoolLevelsDto, SchoolLevels.class);
		
		SchoolLevels savedSchoolLevels = this.schoolLevelRepo.save(createSchoolLevels);
		if (savedSchoolLevels instanceof SchoolLevels) {
			return true;			
		}
		return false;
	}

	@Override
	public Boolean updateSchoolLevel(SchoolLevelsDto schoolLevelsDto, int id) {
		SchoolLevels schoolLevelsId = this.schoolLevelRepo.findById(id).orElseThrow(()->new ResourceNotFound("SchoolLevel", "SchoolLevel Id", id));
		schoolLevelsId.setLevels(schoolLevelsDto.getLevels());
		schoolLevelsId.setTagline(schoolLevelsDto.getTagline());
		schoolLevelsId.setDescription(schoolLevelsDto.getDescription());
		schoolLevelsId.setDuration(schoolLevelsDto.getDuration());
		
		SchoolLevels updatedSchoolLevels = this.schoolLevelRepo.save(schoolLevelsId);
		
		if (updatedSchoolLevels instanceof SchoolLevels) {
			return true;			
		}
		return false;
	}
	

	@Override
	public Boolean deleteSchoolLevel(int id) {
		SchoolLevels schoolLevelsId = this.schoolLevelRepo.findById(id).orElseThrow(()->new ResourceNotFound("SchoolLevel", "SchoolLevel Id", id));
		this.schoolLevelRepo.delete(schoolLevelsId);
		Optional<SchoolLevels> checkingAgain = this.schoolLevelRepo.findById(id);
		if (checkingAgain.isPresent()) {
			return false;
			
		}
		return true;
	}

	@Override
	public List<SchoolLevelsDto> getAllSchoolLevels() {
		List<SchoolLevels> allSchoolLevels = this.schoolLevelRepo.findAll();
		List<SchoolLevelsDto> schoolLevelsDto = allSchoolLevels.stream().map(schoolLevel -> mapper.map(schoolLevel, SchoolLevelsDto.class)).collect(Collectors.toList());
		
		if (schoolLevelsDto!=null) {
			return schoolLevelsDto;
			
		}
		return null;
	}

	@Override
	public HashMap<String, Object> getSchoolLevelsById(int id) {
		SchoolLevels schoolLevelsId = this.schoolLevelRepo.findById(id).orElseThrow(()->new ResourceNotFound("SchoolLevel", "SchoolLevel Id", id));
		
		if (schoolLevelsId!=null) {
			SchoolLevelsDto schoolLevelsDto = this.mapper.map(schoolLevelsId, SchoolLevelsDto.class);
			
			
			
			
			schoolLevelsDto.setPreCurriculumDto(schoolLevelsId.getPreCurriculum().stream().map(
					preCurriculum ->mapper.map(preCurriculum,PreCurriculumDto.class)
					).collect(Collectors.toList()));
			
			schoolLevelsDto.setNurseryCurriculumDto(schoolLevelsId.getNurseryCurriculum().stream().map(nursery
					->mapper.map(nursery, NurseryCurriculumDto.class)).collect(Collectors.toList()));
			
			schoolLevelsDto.setLkgCurriculumDto(schoolLevelsId.getLkgCurriculum().stream()
					.map(lkg->mapper.map(lkg, LkgCurriculumDto.class)).collect(Collectors.toList()));
			
		}
		return null;
	}
	
	
}
