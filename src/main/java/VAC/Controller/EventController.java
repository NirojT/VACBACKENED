package VAC.Controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VAC.Dto.EventDto;
import VAC.Entity.Event;
import VAC.Services.EventService;

@RestController
@RequestMapping("api/event")
@CrossOrigin(origins = "http://127.0.0.1:5173/", allowCredentials = "true")
public class EventController {

	@Autowired
	public EventService eventService;

	@PostMapping("/create")
	public ResponseEntity<?> createEvent(@ModelAttribute EventDto eventDto) throws IOException {
		try {
			System.out.println(eventDto.getTitle());
			System.out.println(eventDto.getEventDate());
			Boolean createEvent = this.eventService.createEvent(eventDto);
			if (createEvent) {
				HashMap<String, Object> response = new HashMap<>();
				response.put("message", "Event created successfully");
				response.put("status", 200);
				return ResponseEntity.status(200).body(response);
			}

			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Event is not created ");
			response.put("status", 400);
			return ResponseEntity.status(200).body(response);

		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> response = new HashMap<>();
			response.put("message", "Event not created");
			response.put("status", 400);
			return ResponseEntity.status(400).body(response);

			// TODO: handle exception
		}

	}
	
	
	@PutMapping("/update/{eid}")
	public ResponseEntity<?> updateEvent( @ModelAttribute EventDto eventDto, @PathVariable Integer eid  ) throws IOException{
		
		Boolean updateEvent = this.eventService.updateEvent(eventDto, eid);
		
		if(updateEvent) {
			
			HashMap<String, Object> response=new HashMap<>();
			response.put("message", "Event updated successfully");
			response.put("status", 200);
			
			return ResponseEntity.status(400).body(response);
		}
		HashMap<String, Object> response=new HashMap<>();
		response.put("message", "Event not updated successfully");
		response.put("status", 200);
		
		return ResponseEntity.status(400).body(response);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
