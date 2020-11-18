package edu.rit.auth.service.Impl;

import edu.rit.auth.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

@Service
public class HomeServiceImplementation implements HomeService {
    private static final Logger LOG = LoggerFactory.getLogger(HomeServiceImplementation.class);
    private static int authrty = 0;

    @Override
    public String getHomePage(Model model, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        LOG.debug("Returning home template");
        if (session.getAttribute("name") == null && authrty ==2) {


            HttpSession httpSession = session;
            httpSession.invalidate();
            return "redirect:/";

        }
        session.setAttribute("name", auth.getName());
        authrty++;
        System.out.println(authrty + " @@");


        //Message
        String content = "Welcome: " + auth.getName() + " - " + auth.getAuthorities();
        model.addAttribute("message", content);

        ArrayList<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
        listAuthorities.addAll(auth.getAuthorities());
        String role = listAuthorities.remove(0).toString();

        model.addAttribute(role, role);

        return "index";
    }

    @Override
    public String get403(){
        LOG.debug("Returning 403 template");
        return "403";
    }
}
