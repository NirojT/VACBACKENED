package VAC.ServicesImpl.CoursePlusTwo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.PlusTwo.Year1PlusTwoDto;
import VAC.Dto.PlusTwo.Year2PlusTwoDto;
import VAC.Entity.coursesPlusTwo.CoursePlusTwo;
import VAC.Entity.coursesPlusTwo.Year1PlusTwo;
import VAC.Entity.coursesPlusTwo.Year2PlusTwo;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.CoursePlusTwo.CoursePlusTwoRepo;
import VAC.Reposiotery.CoursePlusTwo.Year2PlusTwoRepo;
import VAC.Services.CoursePlusTwo.Year2PlusTwoServicec;

@Service
public class Year2PlusTwoServiceImpl implements Year2PlusTwoServicec {
	@Autowired
	private CoursePlusTwoRepo coursePlusTwoRepo;
	
	@Autowired
	private Year2PlusTwoRepo year2PlusTwoRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Boolean createYear2PlusTwo(Year2PlusTwoDto year2PlusTwoDto, Integer CourseId) {
		CoursePlusTwo coursePlusTwoID=	this.coursePlusTwoRepo.findById(CourseId).orElseThrow(()->new ResourceNotFound("CoursePlussTwo","CoursePlussTwo id" , CourseId));
		Year2PlusTwo year2PlusTwo=	this.mapper.map(year2PlusTwoDto, Year2PlusTwo.class);
		year2PlusTwo.setCoursePlusTwo(coursePlusTwoID);
		Year2PlusTwo savedYear2PlusTwo = this.year2PlusTwoRepo.save(year2PlusTwo);
		if (savedYear2PlusTwo instanceof Year2PlusTwo) {
			return true;
		}
			return false;
		}
	

	@Override
	public Boolean updateYear2PlusTwo(Year2PlusTwoDto year2PlusTwoDto, int id) {
		Year2PlusTwo year2PlusTwoId = this.year2PlusTwoRepo.findById(id).orElseThrow(()->new ResourceNotFound("Year2PlusTwo","Year2PlusTwo id" , id));
		year2PlusTwoId.setSubject(year2PlusTwoDto.getSubject());
		
		Year2PlusTwo updatedYear2PlusTwo = this.year2PlusTwoRepo.save(year2PlusTwoId);
		if (updatedYear2PlusTwo instanceof Year2PlusTwo) {
			return true;
		}
			return false;
		}
	@Override
	public Boolean deleteYear2PlusTwo(int id) {
		Year2PlusTwo year2PlusTwoId = this.year2PlusTwoRepo.findById(id).orElseThrow(()->new ResourceNotFound("Year2PlusTwo","Year2PlusTwo id" , id));
		this.year2PlusTwoRepo.delete(year2PlusTwoId);
		
		Optional<Year2PlusTwo> CheckingAgainYear2 = this.year2PlusTwoRepo.findById(id);
		if (CheckingAgainYear2.isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public List<Year2PlusTwoDto> getAllYear2PlusTwo() {
		List<Year2PlusTwo> Allyear2Sub = this.year2PlusTwoRepo.findAll();
		List<Year2PlusTwoDto> Allyear2PlusTwoDto=	Allyear2Sub.stream().map(year2PlusTwo ->mapper.map(year2PlusTwo, Year2PlusTwoDto.class)).collect(Collectors.toList());
		return Allyear2PlusTwoDto;
	}

	@Override
	public Year2PlusTwoDto getAllYear2PlusTwoById(int id) {
		Year2PlusTwo year2PlusTwoId = this.year2PlusTwoRepo.findById(id).orElseThrow(()->new ResourceNotFound("Year2PlusTwo","Year2PlusTwo id" , id));
		Year2PlusTwoDto year2PlusTwoDto = this.mapper.map(year2PlusTwoId, Year2PlusTwoDto.class);
		
		return year2PlusTwoDto;
	}

}
