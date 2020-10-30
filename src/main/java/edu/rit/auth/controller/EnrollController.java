package edu.rit.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.rit.auth.service.EnrollService;

@Controller
public class EnrollController {
    private static final Logger LOG = LoggerFactory.getLogger(EnrollController.class);

    @Autowired
    private EnrollService enrollService;

    @GetMapping("/enrollteacher")
    public String enrollTeacher(Model model, String sid) {
        LOG.debug("Getting enrollTeacher page");
        return enrollService.getEnrollPageTeacher(model, sid);
    }

    @GetMapping("/enrolladmin")
    public String enrollAdmin(Model model, String sid) {
        LOG.debug("Getting enrollTeacher page");
        return enrollService.getEnrollPageAdmin(model, sid);
    }

    @GetMapping("/enrollfinish")
    public String finish(Model model, String sid, String cid) {
        LOG.debug("Getting enrollFinish page");
        return enrollService.getEnrollFinishPage(model, sid, cid);
    }
}
