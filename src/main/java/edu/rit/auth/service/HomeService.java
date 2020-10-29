package edu.rit.auth.service;

import org.springframework.ui.Model;

public interface HomeService {
    String getHomePage(Model model);
    String get403();
}
