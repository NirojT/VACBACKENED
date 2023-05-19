package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.CoursesDto;
import VAC.Dto.Year5Dto;
import VAC.Dto.Year6Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year5;
import VAC.Entity.CourseRelated.Year6;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year6Repo;
import VAC.Services.courseRelated.Year6Service;

@Service
public class Year6ServiceImpl implements Year6Service {

	@Autowired
	private Year6Repo year6Repo;

	@Autowired
	private CourseRelatedRepo courseRelatedRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean createYear6(Year6Dto year6Dto, Integer CourseId) {
		Courses courses = this.courseRelatedRepo.findById(CourseId)
				.orElseThrow(() -> new ResourceNotFound("course", "course id", CourseId));

		Year6 year6Create = this.mapper.map(year6Dto, Year6.class);
		year6Create.setCourses(courses);
		this.year6Repo.save(year6Create);
		return true;
	}

	@Override
	public Boolean updateYear6(Year6Dto year6Dto, int id) {

		Year6 year6ById = this.year6Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year 6 ", "year id", id));

		year6ById.setSubject(year6Dto.getSubject());
		Year6 updatedYear6 = this.year6Repo.save(year6ById);
		if (updatedYear6 instanceof Year6) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean deleteYear6(int id) {
		Year6 year6ById = this.year6Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year 6 ", "year id", id));
		this.year6Repo.delete(year6ById);

		Optional<Year6> year6Checking = this.year6Repo.findById(id);
		if (year6Checking .isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public List<Year6Dto> getAllYear6() {
		List<Year6> AllYear6 = this.year6Repo.findAll();
		List<Year6Dto> Allyear6Dto = AllYear6.stream().map(year6->this.mapper.map(year6, Year6Dto.class)).collect(Collectors.toList());
				
		
          return Allyear6Dto;
	}

}
