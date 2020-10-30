package edu.rit.auth.service;

import org.springframework.ui.Model;

public interface EnrollService {
    public abstract String getEnrollPageTeacher(Model model, String sid);
    public abstract String getEnrollPageAdmin(Model model, String sid);
    public abstract String getEnrollFinishPage(Model model, String sid, String cid);
}
