package springbootquickstart.topic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	//Marks that this needs dependency injections
	//It takes in the dependency from the TopicService instance that was already created when the application run
	//Link up to the service
	//Takes in the named class in the service class
	@Autowired
	private TopicService topicService;
	
	//Setting the return type of the method to a list
	//The instance of TopicService is available for this method, taken from the above private method
	@RequestMapping("/topics")
	public List <Topic> getAllTopics() 
	{
		//goes to the instance and get the method in the TopicService class
		return topicService.getAllTopics();
	}
	
	//returns one topic
	//accepts an id only
	//@PathVariable tells the method that it is passing a variable argument in the path "/topics/${id}"
	//get the value from "foo" in the path and pass it into the String argument (not recommended because it is an extra step)
	//if the variable is ${id}, there is no need to pass in the argument in the @PathVariable as it is the same as the String argument
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
		
	}
	
	//map this request to any methods that is a post on "/topics"
	//get the requestbody and convert it to a topic instance then pass it to the addTopic
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		
	}

}
