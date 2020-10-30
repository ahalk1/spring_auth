package edu.rit.auth.dao;

import edu.rit.auth.data.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    Course findByCourseId(String courseId);
    List<Course> findByTeacher(String teacher);
}