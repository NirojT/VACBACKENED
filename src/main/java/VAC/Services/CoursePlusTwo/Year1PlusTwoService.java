package VAC.Services.CoursePlusTwo;

import java.util.List;

import VAC.Dto.Year1Dto;
import VAC.Dto.PlusTwo.Year1PlusTwoDto;
import VAC.Entity.coursesPlusTwo.Year1PlusTwo;

public interface Year1PlusTwoService {

	Boolean createYear1PlusTwo(Year1PlusTwoDto year1PlusTwoDto, Integer CourseId);

	Boolean updateYear1PlusTwo(Year1PlusTwoDto year1PlusTwoDto, int id);

	Boolean deleteYear1PlusTwo(int id);

	List<Year1PlusTwoDto> getAllYear1PlusTwo();

	Year1PlusTwoDto getAllYear1PlusTwoById(int id);

}
