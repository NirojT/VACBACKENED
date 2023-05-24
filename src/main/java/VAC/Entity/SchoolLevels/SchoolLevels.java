package VAC.Entity.SchoolLevels;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import VAC.Entity.coursesPlusTwo.Year1PlusTwo;
import VAC.Entity.coursesPlusTwo.Year2PlusTwo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolLevels {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name = "level", unique = true)
	private String levels;
	
	@Column(unique = true, columnDefinition = "VARCHAR(1000)")
	private String tagline;

	@Column(unique = true, columnDefinition = "VARCHAR(1000)")
	private String description;

	@Column(unique = true, columnDefinition = "VARCHAR(100)")
	private String duration;
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<PreCurriculum> preCurriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<NurseryCurriculum> nurseryCurriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<LkgCurriculum> lkgCurriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<UkgCurriculum> ukgCurriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class1Curriculum> class1Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class2Curriculum> class2Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class3Curriculum> class3Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class4Curriculum> class4Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class5Curriculum> class5Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class6Curriculum> class6Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class7Curriculum> class7Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class8Curriculum> class8Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class9Curriculum> class9Curriculum;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "schoolLevel",fetch = FetchType.LAZY)
	private List<Class10Curriculum> class10Curriculum;
	
	
	
	
	
	
	
	
}
