package VAC.ServicesImpl.courseRelated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.Year7Dto;
import VAC.Dto.Year8Dto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year7;
import VAC.Entity.CourseRelated.Year8;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.courseRelated.CourseRelatedRepo;
import VAC.Reposiotery.courseRelated.Year8Repo;
import VAC.Services.courseRelated.Year8Service;

@Service
public class Year8ServiceImpl implements Year8Service {

	@Autowired
	private Year8Repo year8Repo;

	@Autowired
	private CourseRelatedRepo courseRelatedRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean createYear8(Year8Dto year8Dto, Integer CourseId) {
		Courses coursesById = this.courseRelatedRepo.findById(CourseId)
				.orElseThrow(() -> new ResourceNotFound("courses", "course id", CourseId));

		Year8 year8Created = this.mapper.map(year8Dto, Year8.class);
		year8Created.setCourses(coursesById);
		this.year8Repo.save(year8Created);

		return true;
	}

	@Override
	public Boolean updateYear8(Year8Dto year8Dto, int id) {
		Year8 year8ById = this.year8Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year 8 ", "year id", id));

		year8ById.setSubject(year8Dto.getSubject());
		Year8 updatedYear8 = this.year8Repo.save(year8ById);
		if (updatedYear8 instanceof Year8) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean deleteYear8(int id) {
		Year8 year8ById = this.year8Repo.findById(id).orElseThrow(() -> new ResourceNotFound("year 8 ", "year id", id));
		this.year8Repo.delete(year8ById);

		Optional<Year8> year8Checking = this.year8Repo.findById(id);
		if (year8Checking.isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public List<Year8Dto> getAllYear8() {
		List<Year8> allYear8 = this.year8Repo.findAll();
		List<Year8Dto> year8Dto = allYear8.stream().map(year8-> mapper.map(year8, Year8Dto.class)).collect(Collectors.toList());
		return year8Dto;
	}

}
