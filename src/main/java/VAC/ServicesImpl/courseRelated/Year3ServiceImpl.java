package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.Year3Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year2;
import VAC.Entity.CourseRelated.Year3;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year2Repo;
import VAC.Reposiotery.courseRelated.Year3Repo;
import VAC.Services.courseRelated.Year3Service;

@Service
public class Year3ServiceImpl implements Year3Service {

	
	@Autowired
	private Year3Repo year3Repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CourseRelatedRepo courseRelatedRepo;

	@Override
	public Boolean createYear3(Year3Dto year3Dto, Integer CourseId) {
		
		Courses courses = this.courseRelatedRepo.findById(CourseId).orElseThrow(()-> new ResourceNotFound("Course", "Course id", CourseId));
		
		
		
		Year3 year3Create = this.mapper.map(year3Dto, Year3.class);
		
		year3Create.setCourses(courses);
		
		this.year3Repo.save(year3Create);
		
		return true;
	}

	@Override
	public Boolean updateYear3(Year3Dto year3Dto, int id) {
		Year3 year3Update = this.year3Repo.findById(id).orElseThrow(()-> new ResourceNotFound("year2", "Year id", id));
		
		year3Update.setSubject(year3Dto.getSubject());
		
		Year3 updatedYear3 = this.year3Repo.save(year3Update);
		
		if(updatedYear3 instanceof Year3) {
			return true;
		}
		
		
		
		return false;
	}

	@Override
	public Boolean deleteYear3(int id) {
		Year3 deleteYear3 = this.year3Repo.findById(id).orElseThrow(()-> new ResourceNotFound("Year3", "Year3 id", id));
		this.year3Repo.delete(deleteYear3);
	Optional<Year3> deleteYear3Checking = this.year3Repo.findById(id);
		if(deleteYear3Checking.isPresent()) {
			return false;
		}
		
		
		return true;
	}

	@Override
	public List<Year3Dto> getAllYear3() {
		List<Year3> Allyear3 = this.year3Repo.findAll();
		List<Year3Dto> Allyear3Dto = Allyear3.stream().map(year3 -> mapper.map(year3, Year3Dto.class)).collect(Collectors.toList());
		return Allyear3Dto;
	}
	


}
