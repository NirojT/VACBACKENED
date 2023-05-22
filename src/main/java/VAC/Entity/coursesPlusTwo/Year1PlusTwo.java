package VAC.Entity.coursesPlusTwo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.Data;

@Entity
@Data
public class Year1PlusTwo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	private String subject;
	
	@ManyToOne
	private CoursePlusTwo coursePlusTwo;
}
