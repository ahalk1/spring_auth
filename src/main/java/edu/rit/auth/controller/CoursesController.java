package edu.rit.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import edu.rit.auth.service.courseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
class CoursesController {
    private static final Logger LOG = LoggerFactory.getLogger(CoursesController.class);

    @Autowired
    private courseService courseService;

    @GetMapping("/courses")
    public String home(Model model) {
        LOG.debug("Getting course page");

        return courseService.getCoursePage(model);
    }
}
