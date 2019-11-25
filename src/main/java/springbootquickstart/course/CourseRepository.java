package springbootquickstart.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Data Service
//Structure is the same
//Build standard methods
//Spring data jpa will provide the class
//Use the interface that uses the implementation that comes with spring data jpa
//CrudRepository contains the logic for any entity class --> an interface that spring data jpa has

//Course is the entity class
//Object type for the id defined in Course.java
//CrudRepository is a generic type
//Can get all the methods because it is a generic type

//method declarations
//jpa framework will look at the method name and figure out what's the implementation that you need based on that
public interface CourseRepository extends CrudRepository<Course, String>{
	
	//needs a method take takes in the topicId and returns a list of courses
	//Find the property in the entity (example, name, id, description)
	//start with "find" for a find method
	//this method will get all the courses based on the name
	//it takes in the name in the arbitrary string
	//it will search the database in the course table for all the courses that has the "name" property as what we are passing in
	
	//public List<Course> findByName(String name);
	
	//public List<Course> findByDescription(String description);
	
	//specify the property of the class of "Id"
	//this method refers to a property which is not a string but an object 
	//looking in the field of the object in that class --> need to specify the field name "TopicId"
	//"TopicId" --> "Topic" property in the course, looking at the "Id" property of the topic property 
	public List<Course> findByTopicId(String topicId);
	
	
	
}
