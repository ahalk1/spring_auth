package edu.rit.auth.service.Impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ArrayList<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
        listAuthorities.addAll(auth.getAuthorities());
        String role = listAuthorities.remove(0).toString();
        
        model.addAttribute(role, role);
        model.addAttribute("students", userRepository.findByType(UserType.STUDENT));
        return "students";
    }
    
}
