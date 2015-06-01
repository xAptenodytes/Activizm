package ru.xaptenodytes.activizm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("login");
		return view;
	}
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView view = new ModelAndView("logout");
		return view;
	}
}
