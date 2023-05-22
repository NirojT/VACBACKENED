package VAC.ServicesImpl.CoursePlusTwo;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VAC.Dto.Year1Dto;
import VAC.Dto.PlusTwo.CoursesPlusTwoDto;
import VAC.Dto.PlusTwo.Year1PlusTwoDto;
import VAC.Dto.PlusTwo.Year2PlusTwoDto;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.coursesPlusTwo.CoursePlusTwo;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.CoursePlusTwo.CoursePlusTwoRepo;
import VAC.Services.CoursePlusTwo.CoursePlusTwoService;
import net.bytebuddy.asm.Advice.This;

@Service
public class CoursePlusTwoServiceImpl implements CoursePlusTwoService {

	@Autowired
	private CoursePlusTwoRepo coursePlusTwoRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean createCourseRelated(CoursesPlusTwoDto coursesDto) {
		CoursePlusTwo coursePlusTwo = this.mapper.map(coursesDto, CoursePlusTwo.class);
		CoursePlusTwo savedCoursePlusTwo = this.coursePlusTwoRepo.save(coursePlusTwo);
		if (savedCoursePlusTwo instanceof CoursePlusTwo) {
			return true;

		}

		return false;
	}

	@Override
	public Boolean updateCourseRelated(CoursesPlusTwoDto coursesDto, int id) {
		CoursePlusTwo coursesPlusTwoId = this.coursePlusTwoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("CoursesPlusTwo", "CoursesPlusTwo id", id));
		coursesPlusTwoId.setTitle(coursesDto.getTitle());
		coursesPlusTwoId.setTagline(coursesDto.getTagline());

		coursesPlusTwoId.setDescription(coursesDto.getDescription());
		coursesPlusTwoId.setDuration(coursesDto.getDuration());
		coursesPlusTwoId.setCriteria(coursesDto.getCriteria());

		CoursePlusTwo updatedCoursePlusTwo = this.coursePlusTwoRepo.save(coursesPlusTwoId);

		if (updatedCoursePlusTwo instanceof CoursePlusTwo) {
			return true;

		}
		return false;
	}

	@Override
	public Boolean deleteCourseRelated(int id) {
		CoursePlusTwo coursesPlusTwodelete = this.coursePlusTwoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("CoursesPlusTwo", "CoursesPlusTwo id", id));

		this.coursePlusTwoRepo.delete(coursesPlusTwodelete);
		Optional<CoursePlusTwo> coursesPlusTwoRechecking = this.coursePlusTwoRepo.findById(id);
		if (coursesPlusTwoRechecking.isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public List<CoursesPlusTwoDto> getAllCoursesPlusTwoDto() {
		List<CoursePlusTwo> allPlusTwoCourses = this.coursePlusTwoRepo.findAll();
		List<CoursesPlusTwoDto> coursesPlusTwoDto = allPlusTwoCourses.stream()
				.map(coursePlusTwo -> this.mapper.map(coursePlusTwo, CoursesPlusTwoDto.class))
				.collect(Collectors.toList());
		
		return coursesPlusTwoDto;
	}

	@Override
	public HashMap<String, Object> getAllCoursesPlusTwoDtoById(int id) {
		CoursePlusTwo coursesPlusTwoId = this.coursePlusTwoRepo.findById(id).orElseThrow(()-> new ResourceNotFound("CoursesPlusTwo", "CoursesPlusTwo id", id));
		
		if (coursesPlusTwoId !=null) {
			CoursesPlusTwoDto coursesPlusTwoDto = this.mapper.map(coursesPlusTwoId,CoursesPlusTwoDto.class);
			
		
			coursesPlusTwoDto.setYear1PlusTwoDtos(coursesPlusTwoId.getYear1PlusTwo().stream()
					.map(year1PlusTwo ->this.mapper.map(year1PlusTwo, Year1PlusTwoDto.class))
					.collect(Collectors.toList())); 
			
			coursesPlusTwoDto.setYear2PlusTwoDtos(coursesPlusTwoId.getYear2PlusTwo().stream().map(year2PlusTwo -> this.mapper
					.map(year2PlusTwo, Year2PlusTwoDto.class)).collect(Collectors.toList()));
			

			HashMap<String, Object> coursesPlusTwoData = new HashMap<>();
			coursesPlusTwoData.put("id", coursesPlusTwoDto.getId());
			coursesPlusTwoData.put("title", coursesPlusTwoDto.getTitle());
			coursesPlusTwoData.put("tagline", coursesPlusTwoDto.getTagline());
			coursesPlusTwoData.put("description", coursesPlusTwoDto.getDescription());
			coursesPlusTwoData.put("duration", coursesPlusTwoDto.getDuration());
			coursesPlusTwoData.put("criteria", coursesPlusTwoDto.getCriteria());
			
			HashMap<String, Object> data = new HashMap<>();
			if (coursesPlusTwoDto.getYear1PlusTwoDtos() .size() > 0) {
				data.put("YearOne", coursesPlusTwoDto.getYear1PlusTwoDtos());
			}
			
			if (coursesPlusTwoDto.getYear2PlusTwoDtos() .size() > 0 ) {
				data.put("YearTwo", coursesPlusTwoDto.getYear2PlusTwoDtos());
			}
		
			data.put("coursesPlusTwo", coursesPlusTwoData);
			return data;
		}
		return null;
	}

}
