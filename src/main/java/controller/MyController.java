package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @RequestMapping(value = {"/hello"}, method = {RequestMethod.GET})
    public String hello(Model model) {
        model.addAttribute("msg", "Hello");
        return "hello";
    }

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String world(Model model) {
        model.addAttribute("msg", "World!");
        return "world";
    }

    @RequestMapping(value = "/forward", method = RequestMethod.GET)
    public String myForm(Model model) {
        return "forward";
    }

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String postForm(Model model) {
        return "receive";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

}
