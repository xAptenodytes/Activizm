package ru.xaptenodytes.activizm.webcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.xaptenodytes.activizm.model.Activist;
import ru.xaptenodytes.activizm.service.ActivistService;

@Controller
public class ActivistController {
	
	@Autowired
	private ActivistService activistService;
	
	@RequestMapping("/index")
	public String listActivists(Map<String, Object> map) {
		map.put("activist", new Activist());
        map.put("activistList", activistService.listActivist());

        return "contact";
	}
	
	@RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addActivist(@ModelAttribute("activist") Activist activist,
            BindingResult result) {

    	activistService.addActivist(activist);

        return "redirect:/index";
    }
    
    @RequestMapping("/suspend/{activistId}")
    public String suspendActivist(@PathVariable("activistId") Integer activistId) {

    	activistService.suspendActivist(activistId);

        return "redirect:/index";
    }
}
