package edu.rit.auth.dao;

import edu.rit.auth.data.Course;
import edu.rit.auth.data.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    Course findByCourseId(String courseId);


}