package VAC.Entity.CourseRelated;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Course")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
  

    @Column(name = "title", unique = true, columnDefinition = "VARCHAR(1000)")
    private String title = "name";

    @Column(unique = true, columnDefinition = "VARCHAR(1000)")
    private String tagline;

    @Column(unique = true, columnDefinition = "VARCHAR(1000)")
    private String description;

    @Column(unique = true, columnDefinition = "VARCHAR(1000)")
    private String duration;

    @Column(unique = true, columnDefinition = "VARCHAR(1000)")
    private String criteria;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.EAGER)
	private List<Year1> year1=new ArrayList<>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.LAZY)
	private List<Year2 > year2=new ArrayList<>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.LAZY)
	private List<Year3> year3=new ArrayList<>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.LAZY)
	private List<Year4> year4=new ArrayList<>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.LAZY)
	private List<Year5> year5=new ArrayList<>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.LAZY)
	private List<Year6> year6=new ArrayList<>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.LAZY)
	private List<Year7> year7=new ArrayList<>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "courses",fetch = FetchType.LAZY)
	private List<Year8> year8=new ArrayList<>() ;
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
}
