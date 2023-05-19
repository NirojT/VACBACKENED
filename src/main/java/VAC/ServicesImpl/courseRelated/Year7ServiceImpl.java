package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.CoursesDto;
import VAC.Dto.Year7Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year6;
import VAC.Entity.CourseRelated.Year7;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year7Repo;
import VAC.Services.courseRelated.Year7Service;
import net.bytebuddy.asm.Advice.This;

@Service
public class Year7ServiceImpl implements Year7Service {
	
	@Autowired
	private Year7Repo year7Repo;
	
	@Autowired
	private CourseRelatedRepo courseRelatedRepo;

	@Autowired
	private ModelMapper mapper;


	@Override
	public Boolean createYear7(Year7Dto year7Dto,Integer CourseId) {
		
	Courses coursesById =	this.courseRelatedRepo.findById(CourseId).orElseThrow(()->new ResourceNotFound("courses", "course id", CourseId));
		
		Year7 year7Created = this.mapper.map(year7Dto, Year7.class);
		year7Created.setCourses(coursesById);
		this.year7Repo.save(year7Created);
		
		return true;
	}

	@Override
	public Boolean updateYear7(Year7Dto year7Dto, int id) {
	
		Year7 year7ById = this.year7Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year 7 ", "year id", id));

		year7ById.setSubject(year7Dto.getSubject());
		Year7 updatedYear7 = this.year7Repo.save(year7ById);
		if (updatedYear7 instanceof Year7) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean deleteYear7(int id) {
		Year7 year7ById = this.year7Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year 6 ", "year id", id));
		this.year7Repo.delete(year7ById);

		Optional<Year7> year7Checking = this.year7Repo.findById(id);
		if (year7Checking .isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public List<Year7Dto> getAllYear7() {
		List<Year7> allYear7 = this.year7Repo.findAll();
		List<Year7Dto> year7Dto = allYear7.stream().map(year7-> mapper.map(year7, Year7Dto.class)).collect(Collectors.toList());
		return year7Dto;
	}


}
