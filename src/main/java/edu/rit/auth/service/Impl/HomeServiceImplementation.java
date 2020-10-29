package edu.rit.auth.service.Impl;

import edu.rit.auth.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImplementation implements HomeService {
    private static final Logger LOG = LoggerFactory.getLogger(HomeServiceImplementation.class);

    @Override
    public String getHomePage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        LOG.debug("Returning home template");

        //Message
        String content = "Welcome: " + auth.getName() + " - " + auth.getAuthorities();
        model.addAttribute("message", content);

        ArrayList<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
        listAuthorities.addAll(auth.getAuthorities());
        String role = listAuthorities.remove(0).toString();

        model.addAttribute(role, role);
        return "index";
    }


}
