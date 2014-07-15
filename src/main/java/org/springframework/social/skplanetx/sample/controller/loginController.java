package org.springframework.social.skplanetx.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/14/14
 */
@Controller
public class loginController {
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "signin";
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public RedirectView signout() {
        return new RedirectView("/signin");
    }
}
