package edu.rit.auth.service.Impl;

import edu.rit.auth.dao.UserRepository;
import edu.rit.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserServiceImplementation implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImplementation.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getUserPage(Model model){
        LOG.debug("Returning users template");
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
}
