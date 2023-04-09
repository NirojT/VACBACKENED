package VAC.Dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import VAC.Entity.MainUser;
import VAC.Entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDto {
	
	 private String title;

	    private String description;

	    private MultipartFile file;
	    
	    
	    private String noticeDate;
}
