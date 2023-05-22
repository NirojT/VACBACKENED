package VAC.Services.CoursePlusTwo;

import java.util.List;

import VAC.Dto.PlusTwo.Year2PlusTwoDto;

public interface Year2PlusTwoServicec {
	// iam doing it later

	Boolean createYear2PlusTwo(Year2PlusTwoDto year2PlusTwoDto, Integer CoursePlusTwoId);

	Boolean updateYear2PlusTwo(Year2PlusTwoDto year2PlusTwoDto, int id);

	Boolean deleteYear2PlusTwo(int id);

	List<Year2PlusTwoDto> getAllYear1PlusTwo();

	Year2PlusTwoDto getAllYear2PlusTwoById(int id);

}
