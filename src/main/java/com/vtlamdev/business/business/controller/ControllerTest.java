package com.vtlamdev.business.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {
    @GetMapping("/_layout")
    public String layout()
    {
        return "_layout";
    }
}
