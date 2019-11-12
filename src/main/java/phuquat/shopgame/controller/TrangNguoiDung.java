package phuquat.shopgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.service.NguoiDungService;

@Controller
public class TrangNguoiDung {
	
	@Autowired
    private NguoiDungService nguoiDungService;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = {"/dangnhap"} , method = RequestMethod.GET)
	public String dangNhap(Model model) {
		return "dangnhap";
	}
	
	@RequestMapping(value = {"/thongtin"}, method = RequestMethod.GET)
    public String thongTin(Model model) {
 
        UserDetails nguoiDung = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        NguoiDung thongtin = null;
        if (nguoiDung.getUsername() != null) {
        	thongtin = nguoiDungService.timNguoiDung(nguoiDung.getUsername());
        }
        if (thongtin == null) {
            return "redirect:/login";
        }
 
        model.addAttribute("thongtin", thongtin);
 
        return "thongtin";
    }
}
