package springbootquickstart.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

//ENTITY MAPPING

//Entity class
//Needs to tell JPA to save this to the database
//Needs to map this object of the topic class to the relational database table
//member variables go as columns in the table
//each instance of the topic class go as rows in the table
//tells JPA this is an entity class
//The table will consist of Topic with 3 test columns
//Needs to have a primary key
@Entity
public class Topic {
	
	//field level annotation
	//Mark it as a primary key using "@Id"
	@Id
	private String id;
	private String name;
	private String description;
	
	
	//No argument constructor
	public Topic() {
		
	}
	
	//constructor
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	//getter
	public String getId() {
		return id;
	}
	//setter
	public void setId(String id) {
		this.id = id;
	}
	
	//getter
	public String getName() {
		return name;
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	//getter
	public String getDescription() {
		return description;
	}
	//setter
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	


	

}
