package VAC.ServicesImpl;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import VAC.Dto.NoticeDto;
import VAC.Entity.Notice;
import VAC.ErrorHandler.ResourceNotFound;
import VAC.Reposiotery.NoticeRepo;
import VAC.Services.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepo noticeRepo;

	// create Notice
	@Override
	public Notice createNotice(Notice notice) {

		Notice createdUser = this.noticeRepo.save(notice);

		return createdUser;
	}

	// creating notice using dto
	@Override
	public Boolean createNotice(NoticeDto noticeDto) throws IOException {
		String imageName = noticeDto.getFile().getOriginalFilename();


		try {
		    // Save the file to the server file system
		    String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static";
		    Path uploadPath = Paths.get(uploadDirectory);
		    if (!Files.exists(uploadPath)) {
		        Files.createDirectories(uploadPath);
		    }

		    // Copy the uploaded file to the final location
		    Path imagePath = uploadPath.resolve(imageName);
		    Files.copy(noticeDto.getFile().getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
		    noticeDto.getFile().getInputStream().close(); // close the input stream

		    // Save the Notice in the database
		    Notice notice = new Notice();
		    notice.setTitle(noticeDto.getTitle());
		    notice.setDescription(noticeDto.getDescription());
		    notice.setImageName("http://localhost:9191/" + imageName);
		    notice.setNoticeDate(noticeDto.getNoticeDate());
		    notice.setIsActive(false);
		    Notice createdNotice = this.noticeRepo.save(notice);

		    if (createdNotice instanceof Notice) {
		        return true;
		    }
		    return false;
		} catch (IOException e) {
		    e.printStackTrace();
		    return false;
		} catch (UncheckedIOException e) {
		    // Handle the exception that occurs when deleting the temporary file
		    System.err.println("Error deleting temporary file: " + e.getMessage());
		    return true;
		}
	}


	// updating notice using dto

	public Boolean updateNotice(String title, String description, String imageName, String noticeDate,
			MultipartFile file, Integer id) {
		
		if(file!=null) {
		
		String filename = file.getOriginalFilename();

		// Save the file to the server file system
		String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static";
		Path uploadPath = Paths.get(uploadDirectory);
		try {
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
				System.out.println("inside try");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Path imagePath = uploadPath.resolve(filename);
			Files.copy(file.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
			file.getInputStream().close(); // close the input stream
			// Save the Notice in the database
		
				Notice updateNotice = this.noticeRepo.findById(id)
						.orElseThrow(() -> new ResourceNotFound("Notice", "Notice id", id));

				updateNotice.setTitle(title);
				updateNotice.setNoticeDate(noticeDate);

				updateNotice.setDescription(description);
				updateNotice.setImageName("http://localhost:9191/" + filename);
				updateNotice.setIsActive(false);

				Notice notice = this.noticeRepo.save(updateNotice);
				if (notice instanceof Notice) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}else {
			try {
			Notice updateNotice = this.noticeRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFound("Notice", "Notice id", id));

			updateNotice.setTitle(title);
			updateNotice.setNoticeDate(noticeDate);

			updateNotice.setDescription(description);
			updateNotice.setImageName(imageName);
			updateNotice.setIsActive(false);

			Notice notice = this.noticeRepo.save(updateNotice);
			if (notice instanceof Notice) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		}
		
		

	}
	

	// use the isActive
	public Boolean updateNoticeIsActive(Integer id) {
		try {
			Notice updateNotice = this.noticeRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFound("Notice", "Notice id", id));

			updateNotice.setIsActive(!updateNotice.getIsActive());

			Notice savedNotice = this.noticeRepo.save(updateNotice);

			if (savedNotice instanceof Notice) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	// get all notice
	@Override
	public List<Notice> getAllNotice() {

		List<Notice> allNotice = this.noticeRepo.findAll();

		return allNotice;

	}

	// get specific notice
	@Override
	public Optional<Notice> getNoticeById(Integer id) {

		try {

			return this.noticeRepo.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// delete notice..
	@Override
	public Boolean deleteNotice(Integer id) {

		Notice deleteNotice = this.noticeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Notice", "Notice id", id));

		this.noticeRepo.delete(deleteNotice);
		Optional<Notice> deletedNotice = this.noticeRepo.findById(id);

		if (deletedNotice.isPresent()) {
			return false;
		}

		return true;
	}

	

}
