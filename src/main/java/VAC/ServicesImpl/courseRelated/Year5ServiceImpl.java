package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.Year5Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year4;
import VAC.Entity.CourseRelated.Year5;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year5Repo;
import VAC.Services.courseRelated.Year5Service;

@Service
public class Year5ServiceImpl implements Year5Service {

	@Autowired
	private Year5Repo year5Repo;

	@Autowired
	private CourseRelatedRepo courseRelatedRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean createYear5(Year5Dto year5Dto, Integer CourseId) {
		Courses courses = this.courseRelatedRepo.findById(CourseId)
				.orElseThrow(() -> new ResourceNotFound("course", "course id", CourseId));
		Year5 year5Create = this.mapper.map(year5Dto, Year5.class);
		year5Create.setCourses(courses);
		this.year5Repo.save(year5Create);

		return true;

	}

	@Override
	public Boolean updateYear5(Year5Dto year5Dto, int id) {
		Year5 year5Update = this.year5Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year5", "Year id", id));
		year5Update.setSubject(year5Dto.getSubject());
		Year5 updatedYear5 = this.year5Repo.save(year5Update);

		if (updatedYear5 instanceof Year5) {

			return true;

		}
		return false;
	}

	@Override
	public Boolean deleteYear5(int id) {
		Year5 year5Update = this.year5Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year5", "Year id", id));

		this.year5Repo.delete(year5Update);
		Optional<Year5> year5UpdateChecking = this.year5Repo.findById(id);
		if (year5UpdateChecking.isPresent()) {
			return false;
		}

		return true;

	}

	@Override
	public List<Year5Dto> getAllYear5() {
		List<Year5> allYear5 = this.year5Repo.findAll();
		List<Year5Dto> allYear5Dto = allYear5.stream().map(year5 -> mapper.map(year5, Year5Dto.class))
				.collect(Collectors.toList());
		return allYear5Dto;
	}

}
