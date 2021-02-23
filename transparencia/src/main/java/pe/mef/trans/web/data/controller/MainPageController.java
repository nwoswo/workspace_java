package pe.mef.trans.web.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
public class MainPageController {

    //@ResponseStatus(HttpStatus.OK)
    @RequestMapping({ "/" })
    public String forward() {
    	System.out.println("fowrdware");
    	
        return "forward:/index.html";
    }
}