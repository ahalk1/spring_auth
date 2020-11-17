package edu.rit.auth.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rit.auth.service.LoginService;
import edu.rit.auth.service.Impl.LoginServiceImplementation;

@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    
    private LoginService loginService = new LoginServiceImplementation();

    @GetMapping(value = "/login")
    public String login(Model model, HttpSession session){
        LOG.debug("Getting loging page");
        return loginService.getLoginPage(model, session);
    }

    @GetMapping(value = "/login", params = "timeout")
    public String timeout(Model model, HttpSession session ){
        LOG.debug("Session timed out");
        return loginService.getLoginPageTimeout(model, session);
    }

    @GetMapping(value = "/login", params = "error")
    public String error(Model model, HttpSession session ){
        LOG.debug("Session timed out");
        return loginService.getLoginPageError(model, session);
    }
}
