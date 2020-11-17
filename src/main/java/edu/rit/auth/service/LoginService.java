package edu.rit.auth.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface LoginService {
    public abstract String getLoginPage(Model model, HttpSession session);
    public abstract String getLoginPageTimeout(Model model, HttpSession session);
    public abstract String getLoginPageError(Model model, HttpSession session);
}
