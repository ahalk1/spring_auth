package edu.rit.auth.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface HomeService {
    String getHomePage(Model model, HttpSession session);
    String get403();
}
