package org.springframework.social.skplanetx.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.social.skplanetx.api.Skplanetx;
import org.springframework.social.skplanetx.api.user.dto.SkplanetxUserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/11/14
 */
@EnableAutoConfiguration
@ComponentScan
@Controller
public class SkplanetxBootSampleApplication {

    @Autowired
    private Skplanetx skplanetx;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap map) {
        SkplanetxUserProfile profile = skplanetx.getUser().getProfile();
        map.addAttribute("profile", profile);
        return "home";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SkplanetxBootSampleApplication.class, args);
    }
}
