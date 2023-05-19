package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.Year1Dto;
import VAC.Dto.Year2Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year1;
import VAC.Entity.CourseRelated.Year2;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year1Repo;
import VAC.Reposiotery.courseRelated.Year2Repo;
import VAC.Services.courseRelated.Year2Service;


@Service
public class Year2ServiceImpl implements Year2Service {
	
	@Autowired
	private Year2Repo year2Repo;
	
	@Autowired
	private CourseRelatedRepo courseRelatedRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean createYear2(Year2Dto year2Dto,Integer CourseId) {
	Courses courses = this.courseRelatedRepo.findById(CourseId).orElseThrow(()-> new ResourceNotFound("Course", "Course id", CourseId));
		
	Year2 year2 = this.mapper.map(year2Dto, Year2.class);
		year2.setCourses(courses);
		
		this.year2Repo.save(year2);
		
		return true;
	}

	

	@Override
	public Boolean updateYear2(Year2Dto year2Dto, int id) {
		Year2 year2Update = this.year2Repo.findById(id).orElseThrow(()-> new ResourceNotFound("year2", "Year id", id));
		year2Update.setSubject(year2Dto.getSubject());
		this.year2Repo.save(year2Update);
		
		if (year2Update instanceof Year2) {
			return true;
			
		}
		return false;
	}

	@Override
	public Boolean deleteYear2(int id) {
		Year2 year2delete = this.year2Repo.findById(id).orElseThrow(()-> new ResourceNotFound("year2", "Year id", id));
		this.year2Repo.delete(year2delete);
		Optional<Year2> year2deletes = this.year2Repo.findById(id);
		if (year2deletes.isPresent()) {
			return false;
			
		}
		return true;
		
	}

	@Override
	public List<Year2Dto> getAllYear2() {
		List<Year2> AllYear2 = this.year2Repo.findAll();
		List<Year2Dto> year2DtoList = AllYear2.stream().map(year2 -> this.mapper.map(year2, Year2Dto.class)).collect(Collectors.toList());
		
		return year2DtoList;
	}

	
	

}