package phuquat.shopgame.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.NguoiDungModel;
import phuquat.shopgame.model.TaiKhoanModel;
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
	@RequestMapping(value = {"/dangky"} , method = RequestMethod.GET)
	public String dangky(Model model) {
		model.addAttribute("formnguoidung", new NguoiDungModel());
		return "dangky";
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
	@RequestMapping(value = {"/dangky"} , method = RequestMethod.POST)
	public String luunguoidung(Model model, @ModelAttribute("formnguoidung") NguoiDung nguoidung,
			BindingResult theBindingResult,HttpServletRequest req) {
		String confirm_password = req.getParameter("confirm_password");
		if(theBindingResult.hasErrors()) {
			model.addAttribute("checkuser", "Đăng ký không thành công");
		}
		
		boolean kq = nguoiDungService.checkuser(nguoidung);
		if(kq==true) {
			model.addAttribute("checkuser","Tên đăng nhập đã tồn tại");
		}
		else if(nguoidung.getMatKhau().equals(confirm_password)==false) {
			model.addAttribute("checkuser", "Mật khẩu không trùng");
		}
		else {
		nguoiDungService.luunguoidung(nguoidung);
		
		model.addAttribute("checkuser", "Đăng ký thành công");
		model.addAttribute("formnguoidung", nguoidung);
		}
		return "dangky";
	}
}
