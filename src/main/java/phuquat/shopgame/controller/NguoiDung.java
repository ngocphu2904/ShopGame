package phuquat.shopgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NguoiDung {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
