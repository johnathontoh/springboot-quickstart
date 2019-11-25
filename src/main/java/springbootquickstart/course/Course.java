package springbootquickstart.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import springbootquickstart.topic.Topic;

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
public class Course {
	
	//field level annotation
	//Mark it as a primary key using "@Id"
	@Id
	private String id;
	private String name;
	private String description;
	
	//Tie the course to a particular topic
	//Many courses to 1 topic
	//Maps to the topic table
	@ManyToOne
	private Topic topic;
	
	
	//No argument constructor
	public Course() {
		
	}
	
	//constructor
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//get the id, name and description
		this.topic = new Topic(topicId, "", "");
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	
	


	

}
