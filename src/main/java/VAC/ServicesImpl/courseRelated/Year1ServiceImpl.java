package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.Year1Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year1;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year1Repo;
import VAC.Services.courseRelated.Year1Service;

@Service
public class Year1ServiceImpl implements Year1Service {
	
	@Autowired
	private Year1Repo year1Repo;
	
	@Autowired
	private CourseRelatedRepo courseRelatedRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean createYear1(Year1Dto year1Dto,Integer CourseId) {
		
		Courses courses = this.courseRelatedRepo.findById(CourseId).orElseThrow(()-> new ResourceNotFound("Course", "Course id", CourseId));
		
		
		Year1 year1 = this.mapper.map(year1Dto, Year1.class);
		year1.setCourses(courses);
		
		
		this.year1Repo.save(year1);
		return true;
	}

	@Override
	public Boolean updateYear1(Year1Dto year1Dto, int id) {
	
		Year1 year1Update = this.year1Repo.findById(id).orElseThrow(()-> new ResourceNotFound("year", "Year id", id));
	
		year1Update.setSubject(year1Dto.getSubject());
		
		Year1 updateYear1 = this.year1Repo.save(year1Update);
		
		
		
		if (updateYear1 instanceof Year1) {
			return true;
			
		}
		
		
		return false;
	}

	@Override
	public Boolean deleteYear1(int id) {
		Year1 year1Id = this.year1Repo.findById(id).orElseThrow(()->new ResourceNotFound("Year1", "year id", id));
		this.year1Repo.delete(year1Id);
		
		
	 Optional<Year1> year1 = this.year1Repo.findById(id);
	 
	 
		if (year1.isPresent()) {
			return false;
			
		}
		
		return true;
	}

	@Override
	public List<Year1Dto> getAllYear1() {
	List<Year1> AllYear1 = this.year1Repo.findAll();
	
	
		List<Year1Dto> year1DtoList = AllYear1.stream().map(year1-> this.mapper.map(year1, Year1Dto.class)).collect(Collectors.toList());
	
		return year1DtoList;
	}

	@Override
	public Year1Dto getAllYear1ById(int id) {
		Year1 year1ById = this.year1Repo.findById(id).orElseThrow(()->new ResourceNotFound("year1", "Year1 id", id));
		Year1Dto year1DtoByid = this.mapper.map(year1ById, Year1Dto.class);
		
		return year1DtoByid;
	}

}
