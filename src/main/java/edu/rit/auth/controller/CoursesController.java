package edu.rit.auth.controller;

import edu.rit.auth.service.CourseService;
import edu.rit.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesController {

    private static final Logger LOG = LoggerFactory.getLogger(CoursesController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public String CoursePage(Model model) {
        LOG.debug("Getting courses page");
        return courseService.getCoursePage(model);
    }




}
