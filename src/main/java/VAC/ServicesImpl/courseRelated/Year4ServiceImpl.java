package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.Year4Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year3;
import VAC.Entity.CourseRelated.Year4;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year4Repo;
import VAC.Services.courseRelated.Year4Service;

@Service
public class Year4ServiceImpl implements Year4Service {

	@Autowired
	private Year4Repo year4Repo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CourseRelatedRepo courseRelatedRepo;

	@Override
	public Boolean createYear4(Year4Dto year4Dto, Integer CourseId) {
		
		Courses courses = this.courseRelatedRepo.findById(CourseId)
				.orElseThrow(() -> new ResourceNotFound("course", "course id", CourseId));
		Year4 year4Create = this.mapper.map(year4Dto, Year4.class);
		year4Create.setCourses(courses);
		this.year4Repo.save(year4Create);
		
		return true;
	}

	@Override
	public Boolean updateYear4(Year4Dto year4Dto, int id) {
		Year4 year4Update = this.year4Repo.findById(id).orElseThrow(()-> new ResourceNotFound("year4", "Year id", id));
		year4Update.setSubject(year4Dto.getSubject());
		Year4 updatedYear4 = this.year4Repo.save(year4Update);
		
		if (updatedYear4 instanceof Year4) {
			
			return true;
			
			
		}
		return false;
	}

	@Override
	public Boolean deleteYear4(int id) {
		Year4 year4Update = this.year4Repo.findById(id).orElseThrow(()-> new ResourceNotFound("year2", "Year id", id));
		
		this.year4Repo.delete(year4Update);
	Optional<Year4> year4UpdateChecking = this.year4Repo.findById(id);
		if (year4UpdateChecking.isPresent()) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<Year4Dto> getAllYear4() {
		List<Year4> allYear4 = this.year4Repo.findAll();
		List<Year4Dto> allYear4Dto = allYear4.stream().map(year4 -> mapper.map(year4, Year4Dto.class)).collect(Collectors.toList());
		return allYear4Dto;
	}

}
