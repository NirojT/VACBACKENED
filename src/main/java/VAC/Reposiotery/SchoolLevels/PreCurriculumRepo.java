package VAC.Reposiotery.SchoolLevels;

import org.springframework.data.jpa.repository.JpaRepository;

import VAC.Entity.SchoolLevels.Class1Curriculum;
import VAC.Entity.SchoolLevels.PreCurriculum;

public interface PreCurriculumRepo extends JpaRepository<PreCurriculum, Integer> {

}
