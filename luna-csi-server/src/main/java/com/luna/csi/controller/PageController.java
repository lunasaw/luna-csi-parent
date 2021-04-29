package com.luna.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luna@mac
 * 2021年04月29日 09:13
 */
@Controller
public class PageController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
