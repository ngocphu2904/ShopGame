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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.NguoiDungModel;
import phuquat.shopgame.model.TaiKhoanModel;
import phuquat.shopgame.service.NguoiDungService;
import phuquat.shopgame.service.TaiKhoanService;

@Controller
public class TrangNguoiDung {

	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private TaiKhoanService taikhoanservice;

	@RequestMapping("/")
	public String home(Model model) {
		
		int demtaikhoan = taikhoanservice.demtaikhoan();
		model.addAttribute("sotaikhoan", demtaikhoan);
		int mua = taikhoanservice.demtaikhoanmua();
		model.addAttribute("mua", mua);
		return "index";
	}

	@RequestMapping(value = { "/dangnhap" }, method = RequestMethod.GET)
	public String dangNhap(Model model) {
		return "dangnhap";
	}

	@RequestMapping(value = { "/dangky" }, method = RequestMethod.GET)
	public String dangky(Model model) {
		model.addAttribute("formnguoidung", new NguoiDungModel());
		return "dangky";
	}

	@RequestMapping(value = { "/doimatkhau" }, method = RequestMethod.GET)
	public String doimatkhau(Model model,@RequestParam(value = "userName", defaultValue = "") String tenDangNhap) {
		NguoiDung nguoidung = nguoiDungService.timNguoiDung(tenDangNhap);
		model.addAttribute("formdoimatkhau", nguoidung);
		return "doimatkhau";
	}

	@RequestMapping(value = { "/thongtin" }, method = RequestMethod.GET)
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

	@RequestMapping(value = { "/dangky" }, method = RequestMethod.POST)
	public String luunguoidung(Model model, @ModelAttribute("formnguoidung") NguoiDung nguoidung,
			BindingResult theBindingResult, HttpServletRequest req) {
		String confirm_password = req.getParameter("confirm_password");
		if (theBindingResult.hasErrors()) {
			model.addAttribute("checkuser", "Đăng ký không thành công");
		}

		boolean kq = nguoiDungService.checkuser(nguoidung);
		if (kq == true) {
			model.addAttribute("checkuser", "Tên đăng nhập đã tồn tại");
		} else if (nguoidung.getMatKhau().equals(confirm_password) == false) {
			model.addAttribute("checkuser", "Mật khẩu không trùng");
		} else {
			nguoiDungService.luunguoidung(nguoidung);

			model.addAttribute("checkuser", "Đăng ký thành công");
			model.addAttribute("formnguoidung", nguoidung);
		}
		return "dangky";
	}

	@RequestMapping(value = { "/doimatkhau" }, method = RequestMethod.POST)
	public String doimatkhau(Model model, @ModelAttribute("formdoimatkhau") NguoiDung nguoidung,
			BindingResult theBindingResult, HttpServletRequest req,
			@RequestParam(value = "userName", defaultValue = "") String userName) {
		String mkc = req.getParameter("matKhauhientai");
		String mkm_nl = req.getParameter("nhaplaimatkhaumoi");

		boolean kq = nguoiDungService.checkuserdoimatkhau(mkc);
		if (kq == false) {
			req.setAttribute("checkuser", "Mật khẫu hiện tại không đúng");
		} else if (nguoidung.getMatKhau().equals(mkm_nl) == false) {
			req.setAttribute("checkuser", "Mật khẫu nhập lại không trùng với mật khẩu mới");
		} else {
			boolean doimatkhau = nguoiDungService.doimatkhau(nguoidung.getMatKhau(), userName);
			if (doimatkhau == true)
				req.setAttribute("checkuser", "Đổi mật khẩu thành công");
			else {
				req.setAttribute("checkuser", "Đổi mật khẩu thất bại");
			}
//			nguoiDungService.doimatkhau1(nguoidung);
//			req.setAttribute("checkuser", "Đổi mật khẩu thành công");
		}
		return "doimatkhau";
	}
}
