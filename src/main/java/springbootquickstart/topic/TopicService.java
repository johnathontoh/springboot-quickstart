package springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//spring business service
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	//Return the array as a list
	//position 0 is name
	//position 1 is id
	//position 2 is description
	//It will produce a JSON file with a key and value on the "/topic" URL
	//static initialization block that initializes the topic to be this list
	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
					//calling the constructor on the topic class to create new topic objects
					new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "Core Java", "Core Java Description"),
					new Topic("javascript", "JavaScript", "JavaScript Description")
					
					));*/
	
	public List<Topic> getAllTopics(){
		//return topics;
		
		//initialise a new array list
		List<Topic> topics = new ArrayList<>();
		//connect to the database
		//run a query to get the topics
		//convert each of those rows into topic instances
		//and get it back
		//for each of the elements in the iterable, calling the add method in the "topics" and passing that element
		//method reference
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	//stream the list of items
	//filter by the topic
	//comparing the id of that topic to the id that is passed in
	//get the first topic element 
	//get the topic
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		
		//save topic to the database
		topicRepository.save(topic);
		
	}

	//loop through the list of topics
	//get the id which is the same as the input id
	//update the topic list
	//comparing the URL id with the List id
	public void updateTopic(String id, Topic topic) {
		/*for (int i=0; i < topics.size(); i++) {
			//for each topic in the list
			Topic t = topics.get(i);
			//compare the id in the list with the input
			//if it matches, at that location, it will send the updated topic and set it to the list
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		//the repository knows if there is already a row in the table for that particular id
		//if the row does not exist, it will do an insert
		//if the row exist, it knows to do an update
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		
		topicRepository.deleteById(id);;
	}

	
	
	
	
	
	
	
	
}
