package edu.rit.auth.service.Impl;

import edu.rit.auth.dao.UserRepository;
import edu.rit.auth.dao.CourseRepository;
import edu.rit.auth.service.CourseService;
import edu.rit.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CourseServiceImplementation implements CourseService {

    private static final Logger LOG = LoggerFactory.getLogger(edu.rit.auth.service.Impl.CourseServiceImplementation.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String getCoursePage(Model model){
        LOG.debug("Returning courses template");
        model.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }


}
