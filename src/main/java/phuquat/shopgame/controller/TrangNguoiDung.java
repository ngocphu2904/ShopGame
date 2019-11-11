package phuquat.shopgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import phuquat.shopgame.dao.NguoiDungDAO;
import phuquat.shopgame.model.NguoiDungModel;

@Controller
//Cho Hibernate Transaction.
@Transactional
//Su dung RedirectAttributes
@EnableWebMvc
public class TrangNguoiDung {
	
	@Autowired
    private NguoiDungDAO nguoiDungDAO;
	
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
        
        NguoiDungModel thongtin = null;
        if (nguoiDung.getUsername() != null) {
        	thongtin = nguoiDungDAO.getThongTinNguoiDung(nguoiDung.getUsername());
        }
        if (thongtin == null) {
            return "redirect:/login";
        }
 
        model.addAttribute("thongtin", thongtin);
 
        return "thongtin";
    }
}
