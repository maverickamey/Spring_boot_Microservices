package com.jbdl58.learningspringbootdemo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScoreFetchingController {
//    private static final Logger log_obj = LoggerFactory.getLogger(ScoreFetchingController.class);
    /*
    We need a server and port just like 127.0.0.1:8080
    /getScore?sport = FOOTBALL&match= NEPvsPAK
    after question is request params
    // so stores the sport in sport and match here
    */
    @RequestMapping("/getScore")
    public String getScore(@RequestParam("sport") String sport, @RequestParam("match") String match){
//        log_obj.info("Serving the request of some user");
        return "Hello Amey, I am not aware of score of match" + match ;
    }
}
