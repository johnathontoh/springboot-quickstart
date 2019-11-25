package springbootquickstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//spring business service
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	/*public List<Course> getAllCourses(String id){

		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}*/
	
	public List<Course> getAllCourses(String topicId){

		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	
	public Course getCourse(String id) {
		//courseRepository.findByName("--");
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {

		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
	
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {

		courseRepository.deleteById(id);;
	}

	
	
	
	
	
	
	
	
}
