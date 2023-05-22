package VAC.Dto.PlusTwo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoursesPlusTwoDto {

	  private int id;
		 
	    private String title;

	   
	    private String tagline;

	   
	    private String description;

	    
	    private String duration;

	  
	    private String criteria;

	    private List<Year1PlusTwoDto> year1PlusTwoDtos;
	    private List<Year2PlusTwoDto> year2PlusTwoDtos;
}
