package edu.rit.auth.service.Impl;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.ui.Model;

import edu.rit.auth.service.LoginService;

public class LoginServiceImplementation implements LoginService {

    @Override
    public String getLoginPage(Model model, HttpSession session) {
        setSessionAttributes(session);
        model.addAttribute("timeout", "none");
        model.addAttribute("error", "hidden");
        return "login";
    }

    @Override
    public String getLoginPageTimeout(Model model, HttpSession session) {
        setSessionAttributes(session);
        model.addAttribute("timeout", "block");
        model.addAttribute("error", "hidden");
        return "login";
    }

    @Override
    public String getLoginPageError(Model model, HttpSession session) {
        setSessionAttributes(session);
        model.addAttribute("timeout", "none");
        model.addAttribute("error", "");
        return "login";
    }

    public void setSessionAttributes(HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
        session.setAttribute("name", auth.getName());
        session.setAttribute("ip", details.getRemoteAddress());
    }

    

    
    
}
