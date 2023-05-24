package VAC.Dto.SchoolLevels;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolLevelsDto {

	private int id;

	private String levels;

	private String tagline;

	private String description;

	private String duration;

	private List<PreCurriculumDto> preCurriculumDto;

	private List<NurseryCurriculumDto> nurseryCurriculumDto;

	private List<LkgCurriculumDto> lkgCurriculumDto;

	private List<UkgCurriculumDto> ukgCurriculumDto;

	private List<Class1CurriculumDto> class1CurriculumDto;

	private List<Class2CurriculumDto> class2CurriculumDto;

	private List<Class3CurriculumDto> class3CurriculumDto;

	private List<Class4CurriculumDto> class4CurriculumDto;

	private List<Class5CurriculumDto> class5CurriculumDto;

	private List<Class6CurriculumDto> class6CurriculumDto;

	private List<Class7CurriculumDto> class7CurriculumDto;

	private List<Class8CurriculumDto> class8CurriculumDto;

	private List<Class9CurriculumDto> class9CurriculumDto;

	private List<Class10CurriculumDto> class10CurriculumDto;

}
