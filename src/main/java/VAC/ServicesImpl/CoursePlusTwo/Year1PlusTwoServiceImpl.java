package VAC.ServicesImpl.CoursePlusTwo;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.PlusTwo.Year1PlusTwoDto;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateYear1PlusTwo(Year1PlusTwoDto year1PlusTwoDto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteYear1PlusTwo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Year1PlusTwoDto> getAllYear1PlusTwo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Year1PlusTwoDto getAllYear1PlusTwoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
