package edu.rit.auth.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.rit.auth.dao.UserRepository;
import edu.rit.auth.data.UserType;
import edu.rit.auth.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentServiceImplementation.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getStudentPage(Model model) {
        LOG.debug("Returning students template");
        model.addAttribute("students", userRepository.findByType(UserType.STUDENT));
        return "students";
    }
    
}
