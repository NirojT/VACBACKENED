package VAC.ServicesImpl.courseRelated;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year1;
import VAC.Reposiotery.courseRelated.Year1Repo;
import VAC.Services.courseRelated.Year1Service;

@Service
public class Year1ServiceImpl implements Year1Service {
	
	@Autowired
	public Year1Repo year1Repo;

	@Override
	public Boolean createYear1(Year1 year1) {
		this.year1Repo.save(year1);
		return true;
	}

	@Override
	public Boolean updateYear1(Year1 year1, int id) {
	
		return null;
	}

	@Override
	public Boolean deleteYear1(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Year1> getAllYear1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Year1 getAllYear1ById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
