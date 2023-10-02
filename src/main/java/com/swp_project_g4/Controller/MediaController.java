package com.swp_project_g4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author TTNhan
 */
@Controller
@RequestMapping("/media")
public class MediaController {
    @GetMapping("")
    @ResponseBody
    public String login(ModelMap model) {
//        model.addAttribute("title", "Index!");
        return "admin/login";
    }
}
