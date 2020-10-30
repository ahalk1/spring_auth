package edu.rit.auth.service.Impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.rit.auth.dao.CourseRepository;
import edu.rit.auth.data.Course;
import edu.rit.auth.service.EnrollService;

@Service
public class EnrollServiceImplementation implements EnrollService {

    private static final Logger LOG = LoggerFactory.getLogger(EnrollServiceImplementation.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String getEnrollPageTeacher(Model model, String sid) {
        LOG.debug("Returning enroll template");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails details = (UserDetails) auth.getPrincipal();
        String username = details.getUsername();

        model.addAttribute("courses", courseRepository.findByTeacher(username));
        model.addAttribute("sid", sid);
        return "enroll";
    }

    @Override
    public String getEnrollPageAdmin(Model model, String sid) {
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("sid", sid);
        return "enroll";
    }

    @Override
    public String getEnrollFinishPage(Model model, String sid, String cid) {
        String message;
        Course course = courseRepository.findByCourseId(cid);
        String[] studList = course.getStudents();
        boolean inClass = false;

        for(String s : studList){
            if(sid.equals(s)){
                inClass = true;
            }
        }

        if(!inClass){
            String[] newStudList = Arrays.copyOf(studList, studList.length+1);
            newStudList[newStudList.length-1] = sid;
            course.setStudents(newStudList);
            courseRepository.save(course);
            message = "Student was successfully Enrolled";
        }else{
            message = "Student is already Enrolled in this course";
        }
        model.addAttribute("message", message);
        return "enrollfinish";
    }
    
}
