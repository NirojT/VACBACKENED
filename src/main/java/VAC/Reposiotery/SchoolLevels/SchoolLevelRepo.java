package VAC.Reposiotery.SchoolLevels;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import VAC.Dto.SchoolLevels.SchoolLevelsDto;
import VAC.Entity.SchoolLevels.Class1Curriculum;
import VAC.Entity.SchoolLevels.SchoolLevels;

public interface SchoolLevelRepo extends JpaRepository<SchoolLevels, Integer> {
	
}
