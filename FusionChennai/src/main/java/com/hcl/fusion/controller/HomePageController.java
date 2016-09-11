package com.hcl.fusion.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.hcl.fusion.bean.BeanClass;


@Controller
public class HomePageController {

	static Logger log = Logger.getLogger(HomePageController.class.getName());
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String homePage(){
		System.out.println("home page controller homePage()");
		log.info("this is home page controller[]");
		return "reg";
	}

	@RequestMapping(value = "/home")
	//public String Login(@ModelAttribute(value="beanClass") BeanClass beanClass,ModelMap model){
	public String Login(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "passWord") String passWord,Model model){
		
		
		BeanClass user = new BeanClass();
		System.out.println(user+"thisis the user class bean class");
		System.out.println(userName+"this is user name"+passWord);
		ModelAndView mv = new ModelAndView();
		//List<UsersDTO> userList = new ArrayList<UsersDTO>();
		BCryptPasswordEncoder encrypt=new BCryptPasswordEncoder();
		user.setUserName(userName);
		System.out.println(encrypt+"this the object of crpto class");
		String hascode=encrypt.encode(passWord+"this is the encrypted passwword");
		System.out.println(hascode);
		user.setPassWord(hascode);
		//ServiceClass abc=new ServiceClass();
		//loginDao.getUser(user.getUserName(), user.getPassWord());
		//loginDao.getAllUsers();
		System.out.println(model+"this i s model atribute value");
		System.out.println("this is home page controller login value getting class");
		//user = LoginDao.getUser(user.getUserName(), user.getPassWord()); 
		if (user == null) 
		{ 

			return "index";
		} 
		else 
		{
			return "index"; 
		}
	}
}


