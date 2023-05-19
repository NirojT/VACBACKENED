package VAC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import VAC.Entity.MainUser;
import VAC.Entity.CourseRelated.Courses;
import VAC.Entity.CourseRelated.Year1;
import VAC.Entity.CourseRelated.Year2;
import VAC.Entity.CourseRelated.Year3;
import VAC.Entity.CourseRelated.Year4;
import VAC.Entity.CourseRelated.Year5;
import VAC.Entity.CourseRelated.Year6;
import VAC.Entity.CourseRelated.Year7;
import VAC.Entity.CourseRelated.Year8;
import VAC.Services.MainUserService;
import VAC.Services.courseRelated.CourseRelatedServices;
import VAC.Services.courseRelated.Year1Service;
import VAC.Services.courseRelated.Year2Service;
import VAC.Services.courseRelated.Year3Service;
import VAC.Services.courseRelated.Year4Service;
import VAC.Services.courseRelated.Year5Service;
import VAC.Services.courseRelated.Year6Service;
import VAC.Services.courseRelated.Year7Service;
import VAC.Services.courseRelated.Year8Service;
import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class VacBackenedApplication implements CommandLineRunner {
	
	/*
	 * @Autowired private CourseRelatedServices courseRelatedServices;
	 * 
	 * 
	 * @Autowired private Year8Service year4Service;
	 * 
	 * @Autowired private MainUserService mainUserService;
	 * 
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(VacBackenedApplication.class, args);

		String dateString = "2021-10-01";
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = dateFormat.parse(dateString);

		System.out.println(dateString);
//		System.out.println(d.compareTo(a));

	}

	@Override
	public void run(String... args) throws Exception {

//		MainUser user = new  MainUser();
//		user.setName("admin");
//		user.setPassword(passwordEncoder.encode("admin"));
//		user.setEmail("admin@gmail.com");
//		user.setRole("Admin");
//		
//		
//		
//		this.mainUserService.createMainUser(user);

		// seeding

		try {
			Courses courses = new Courses();
			courses.setId(1);

			Year8 year4 = new Year8();
			year4.setCourses(courses);
			year4.setSubject("Mobile Programming (CACS 351)");
			year4.setSubject("Distributed System (CACS 352)");
			year4.setSubject("Applided Ecomomics (CAEC 353)");
			year4.setSubject("Advance Java Programming (CACS 354)"); //
			year4.setSubject("Network Programming (CACS 355)");
			year4.setSubject("Project II (CAPJ 356)");
////    

			// this.year4Service.createYear8(year4);

		} catch (Exception e) {

			e.printStackTrace(); // TODO: handle exception }

		}

		/*
		 * try { // seeding means iam inserting value by myself Courses courses = new
		 * Courses(); courses.setTitle("Bachelors in Computer Application");
		 * courses.setTitle("Bachelors in Business Study");
		 * courses.setTitle("Master's in Business StudyMBS");
		 * 
		 * courses.
		 * setTagline("Bachelor of Computer Application (BCA) Is A 8-Semester Program Of Tribhuvan"
		 * + " University (TU) Suitable For" +
		 * " Students Interested In The Field Of Computer Application And Software Development."
		 * ); courses.setTagline("Bachelor's Of Business Studies (BBS) Is A Four-Year" +
		 * " Program Under Tribhuwan University (TU) Aiming To Prepare Competent," +
		 * " Skilled, Self-Assured, And Socially Responsible Professionals.");
		 * courses.setTagline("Master's In Business Studies (MBS) Is A Four-Semester " +
		 * "Program Under Tribhuwan University (TU) Preparing Graduates Who Can Support "
		 * + "Managerial And Leadership Roles In\n" + "\n" + "Different Organizations");
		 * 
		 * courses.
		 * setDescription("Bachelor in Computer Application (BCA) program is one of the most sought-after"
		 * +
		 * " programs among students who want to pursue a career in the IT (Information Technology). The course has an eight-semester length and a four-year duration."
		 * +
		 * " It includes topics like databases, networking, data structures, and fundamental programming languages like \"C\" and \"java.\" Students who are interested in computers, especially to those "
		 * +
		 * "who want become programmers or software developers will find that this course offers a lot of opportunities."
		 * );
		 * 
		 * courses.setDescription(
		 * "Bachelors in Business Studies (BBS) combines academic knowledge of business and related fields,"
		 * +
		 * " such as marketing, economics, accountancy, and finance, with real-world work experience.Given the significant"
		 * + " demand for BBS courses in the business sector, this course has" +
		 * " emerged as one of the top choices for undergraduate students.");
		 * courses.setDescription(
		 * "Master’s in Business Studies (MBS) combines academic knowledge of business and related fields,"
		 * +
		 * " such as marketing, economics, accountancy, and finance, with real-world work experience. Given the significant demand for MBS courses in the business sector,"
		 * +
		 * " this course has emerged as one of the top choices for graduate students.");
		 * 
		 * courses.setDuration("8 Semester"); courses.setDuration("4 Years");
		 * courses.setDuration("4 Semester");
		 * 
		 * courses.setCriteria(
		 * " Students aspiring for course must have passed 10+2 or equivalent with minimum grade of 2.0 GPA from a recognized board. "
		 * + "They must also qualify in the entrance exam conducted by TU.");
		 * courses.setCriteria(
		 * "Students aspiring for course must have passed 10+2 or equivalent with minimum grade of D+ in all subjects (1.6 GPA) from a recognized board."
		 * + " They must also qualify in the entrance exam conducted by TU.");
		 * courses.setCriteria(
		 * " Good academic record at any bachelor degree course recognized by Tribhuvan University and must pass CMAT examination conducted by TU."
		 * );
		 * 
		 * this.courseRelatedServices.createCourseRelated(courses);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		// System.out.println(courseRelatedServices);

	}

}
