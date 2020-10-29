package edu.rit.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.rit.auth.dao.CourseRepository;
import edu.rit.auth.dao.UserRepository;
import edu.rit.auth.data.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.rit.auth.data.Users;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DataBootstrap {
    private static final String COURSES_LOCATION = "/static/courses.json";
    private static final String USERS_LOCATION = "/static/users.json";

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
       insertCourses();
       insertUsers();
    }

    private void insertCourses(){
        InputStream inputStream = this.getClass().getResourceAsStream(COURSES_LOCATION);

        Course[] courses = null;

        try {
            courses = objectMapper.readValue(inputStream, Course[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Course course : courses) {
            courseRepository.insert(course);
        }
    }

    private void insertUsers(){
        InputStream inputStream = this.getClass().getResourceAsStream(USERS_LOCATION);
        Users[] users = null;
        try {
            users = objectMapper.readValue(inputStream, Users[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Users user : users) {
            System.out.println(user.getUserId());
            userRepository.insert(user);
        }
    }
}