package edu.rit.auth.controller;

import edu.rit.auth.service.HomeService;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeService homeService;

   @GetMapping("/")
    public String home(Model model, HttpSession session) {
       LOG.debug("Getting home page");
       System.out.println();
       return homeService.getHomePage(model, session);
    }

    @GetMapping("/403")
    public String page403(Model model) {
        LOG.debug("Getting 403 page");
        return homeService.get403();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String Submit(@RequestParam("name") String name, Model model, HttpSession session) {
        HttpSession httpSession = session;
                httpSession.invalidate();
                return "redirect:/";
    }
}
