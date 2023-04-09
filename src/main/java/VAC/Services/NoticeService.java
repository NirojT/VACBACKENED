package VAC.Services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import VAC.Dto.NoticeDto;
import VAC.Entity.Notice;

public interface NoticeService {

	//create notice
	Notice createNotice(Notice notice);
	
	//dto way of creating
	Boolean createNotice(NoticeDto noticeDto) throws IOException; 
	
	
	
	
	
	//update notice
	Boolean updateNotice(NoticeDto noticeDto ,Integer id) throws IOException;
	
	
	
	//update Notice is Active
	Boolean updateNoticeIsActive( Integer id);
	
	//get all notice
	 List<Notice> getAllNotice();
	
	

	
	// get notice by id
	
	 Optional<Notice> getNoticeById(Integer id);
	
	
	//delete notice
	 Boolean deleteNotice(Integer id);
	
	
	
	
	
	
	
	
	
}