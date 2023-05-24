package VAC.ServicesImpl.CoursePlusTwo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.PlusTwo.Year1PlusTwoDto;
import VAC.Entity.coursesPlusTwo.CoursePlusTwo;
import VAC.Entity.coursesPlusTwo.Year1PlusTwo;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.CoursePlusTwo.CoursePlusTwoRepo;
import VAC.Reposiotery.CoursePlusTwo.Year1PlusTwoRepo;
import VAC.Services.CoursePlusTwo.Year1PlusTwoService;

@Service
public class Year1PlusTwoServiceImpl implements Year1PlusTwoService {

	
	@Autowired
	private CoursePlusTwoRepo coursePlusTwoRepo;

	
	@Autowired
	private Year1PlusTwoRepo year1PlusTwoRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Boolean createYear1PlusTwo(Year1PlusTwoDto year1PlusTwoDto, Integer CourseId) {
		
	CoursePlusTwo coursePlusTwoID=	this.coursePlusTwoRepo.findById(CourseId).orElseThrow(()->new ResourceNotFound("CoursePlussTwo","CoursePlussTwo id" , CourseId));
	Year1PlusTwo year1PlusTwo=	this.mapper.map(year1PlusTwoDto, Year1PlusTwo.class);
	year1PlusTwo.setCoursePlusTwo(coursePlusTwoID);
	Year1PlusTwo savedYear1PlusTwo = this.year1PlusTwoRepo.save(year1PlusTwo);
	if (savedYear1PlusTwo instanceof Year1PlusTwo) {
		return true;
	}
		return false;
	}

	@Override
	public Boolean updateYear1PlusTwo(Year1PlusTwoDto year1PlusTwoDto, int id) {
		Year1PlusTwo year1PlusTwoId = this.year1PlusTwoRepo.findById(id).orElseThrow(()->new ResourceNotFound("Year1PlusTwo","Year1PlusTwo id" , id));
		year1PlusTwoId.setSubject(year1PlusTwoDto.getSubject());
		
		Year1PlusTwo updatedYear1PlusTwo = this.year1PlusTwoRepo.save(year1PlusTwoId);
		if (updatedYear1PlusTwo instanceof Year1PlusTwo) {
			return true;
		}
			return false;
		}

	@Override
	public Boolean deleteYear1PlusTwo(int id) {
		Year1PlusTwo year1PlusTwoId = this.year1PlusTwoRepo.findById(id).orElseThrow(()->new ResourceNotFound("Year1PlusTwo","Year1PlusTwo id" , id));
		this.year1PlusTwoRepo.delete(year1PlusTwoId);
		
		Optional<Year1PlusTwo> CheckingAgainYear1 = this.year1PlusTwoRepo.findById(id);
		if (CheckingAgainYear1.isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public List<Year1PlusTwoDto> getAllYear1PlusTwo() {
	List<Year1PlusTwo> AllYear1PlusTwo = this.year1PlusTwoRepo.findAll();
	
	List<Year1PlusTwoDto> allYear1PlusTwoDtos = AllYear1PlusTwo.stream().map(year1PlusTwo ->this.mapper.map(year1PlusTwo, Year1PlusTwoDto.class)).collect(Collectors.toList());
		return allYear1PlusTwoDtos;
	}

	@Override
	public Year1PlusTwoDto getAllYear1PlusTwoById(int id) {
		Year1PlusTwo year1PlusTwoId = this.year1PlusTwoRepo.findById(id).orElseThrow(()->new ResourceNotFound("Year1PlusTwo","Year1PlusTwo id" , id));
		Year1PlusTwoDto year1PlusTwoDto = this.mapper.map(year1PlusTwoId, Year1PlusTwoDto.class);
		
		return year1PlusTwoDto;
	}

}
