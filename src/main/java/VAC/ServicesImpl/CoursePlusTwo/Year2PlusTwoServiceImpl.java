package VAC.ServicesImpl.CoursePlusTwo;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.PlusTwo.Year2PlusTwoDto;
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
	public Boolean createYear2PlusTwo(Year2PlusTwoDto year2PlusTwoDto, Integer CoursePlusTwoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateYear2PlusTwo(Year2PlusTwoDto year2PlusTwoDto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteYear2PlusTwo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Year2PlusTwoDto> getAllYear1PlusTwo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Year2PlusTwoDto getAllYear2PlusTwoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
