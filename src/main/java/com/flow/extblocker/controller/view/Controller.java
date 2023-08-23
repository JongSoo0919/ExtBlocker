package com.flow.extblocker.controller.view;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@Slf4j
public class Controller {
    @GetMapping("/")
    public String index(
            HttpServletRequest request,
            Model model
    ){
        log.info("[View] index Controller 진입");
        model.addAttribute("message", "Hello Thymeleaf");
        return "index";
    }
}
