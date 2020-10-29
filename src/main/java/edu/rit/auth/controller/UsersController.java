package edu.rit.auth.controller;

import edu.rit.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
    private static final Logger LOG = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String home(Model model) {
        LOG.debug("Getting users page");
        return userService.getUserPage(model);
    }
}
