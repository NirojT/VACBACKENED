package VAC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUS {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "User_Name")
	private String name;
	private String email;
    private String message;
	public ContactUS(String name, String email, String message) {
	
		this.name = name;
		this.email = email;
		this.message = message;
	}
    
    
    
    
    

}
