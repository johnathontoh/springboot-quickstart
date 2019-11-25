package springbootquickstart.topic;

import org.springframework.data.repository.CrudRepository;

//Data Service
//Structure is the same
//Build standard methods
//Spring data jpa will provide the class
//Use the interface that uses the implementation that comes with spring data jpa
//CrudRepository contains the logic for any entity class --> an interface that spring data jpa has

//Topic is the entity class
//Object type for the id defined in Topic.java
//CrudRepository is a generic type
//Can get all the methods because it is a generic type
public interface TopicRepository extends CrudRepository<Topic, String>{

}
