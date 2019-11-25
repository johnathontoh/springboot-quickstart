package springbootquickstart.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springbootquickstart.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	

	@RequestMapping("/topics/{topicId}/courses")
	public List <Course> getAllCourses(@PathVariable String topicId) 
	{
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		//whatever is sent as the request body for the course, set a new topic
		//to get the mapping right for the topicId
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		
	}
	
	//Need to map to topicId to get it from the Topic.java from the Course.java and also because it it not a string
	//Need to POST then PUT so there is no need to map the "id" as it will already exist so only a comparison will be made (to add or update)
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
		
	}

}
