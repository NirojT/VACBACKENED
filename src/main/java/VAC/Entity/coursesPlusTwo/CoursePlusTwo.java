package VAC.Entity.coursesPlusTwo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursePlusTwo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name = "title", unique = true, columnDefinition = "VARCHAR(1000)")
	private String title;

	@Column(unique = true, columnDefinition = "VARCHAR(1000)")
	private String description;

	@Column(unique = true, columnDefinition = "VARCHAR(1000)")
	private String tagline;

	@Column(unique = true, columnDefinition = "VARCHAR(1000)")
	private String duration;

	@Column(unique = true, columnDefinition = "VARCHAR(1000)")
	private String criteria;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "coursePlusTwo",fetch = FetchType.LAZY)
	private List<Year1PlusTwo> year1PlusTwo;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "coursePlusTwo",fetch = FetchType.LAZY)
	private List<Year2PlusTwo> year2PlusTwo;
	

}
