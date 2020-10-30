package edu.rit.auth.controller;

import edu.rit.auth.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentsController {
    private static final Logger LOG = LoggerFactory.getLogger(StudentsController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String home(Model model) {
        LOG.debug("Getting students page");
        return studentService.getStudentPage(model);
    }
}
