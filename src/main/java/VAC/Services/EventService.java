package VAC.Services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import VAC.Dto.EventDto;
import VAC.Dto.NoticeDto;
import VAC.Entity.Event;
import VAC.Entity.Notice;

public interface EventService {
	
	
	
	
	//dto way of creating event
	Boolean createEvent(EventDto eventDto) throws IOException; 
	
	
	
	
	
	//update notice
	Boolean updateEvent(EventDto eventDto ,Integer id) throws IOException;
	
	
	
	//update event is Active
	Boolean updateEventIsActive( Integer id);
	
	//get all notice
	List<Event> getAllEvent();
	
	

	
	// get Event by id
	
	 Optional<Event> getEventById(Integer id);
	
	
	//delete event
	 Boolean deleteEvent(Integer id);



}
