package edu.rit.auth.service.Impl;

import edu.rit.auth.dao.CourseRepository;
import edu.rit.auth.service.courseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CourseServiceImplementation implements courseService {
    private static final Logger LOG = LoggerFactory.getLogger(CourseServiceImplementation.class);

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public String getCoursePage(Model model) {
        LOG.debug("Returning Course template");
        model.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }
}
