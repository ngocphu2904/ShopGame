package phuquat.shopgame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import phuquat.shopgame.entity.HinhAnh;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.TaiKhoanModel;
import phuquat.shopgame.service.HinhAnhService;
import phuquat.shopgame.service.NguoiDungService;
import phuquat.shopgame.service.TaiKhoanService;

@Controller
public class TrangNguoiDung {

	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@Autowired
	private HinhAnhService hinhAnhService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = { "/dangnhap" }, method = RequestMethod.GET)
	public String dangNhap(Model model) {
		return "dangnhap";
	}

	@RequestMapping(value = { "/dangky" }, method = RequestMethod.GET)
	public String dangky(Model model) {
		model.addAttribute("formnguoidung", new NguoiDung());
		return "dangky";
	}

	@RequestMapping(value = { "/doimatkhau" }, method = RequestMethod.GET)
	public String doimatkhau(Model model) {
		model.addAttribute("formdoimatkhau", new NguoiDung());
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
		
		if (theBindingResult.hasErrors()) 
		{
			model.addAttribute("checkuser", "Đăng ký không thành công");
		}

		boolean kq = nguoiDungService.checkUser(nguoidung);
		if (kq == true) 
		{
			model.addAttribute("checkuser", "Tên đăng nhập đã tồn tại");
		} 
		else if (nguoidung.getMatKhau().equals(confirm_password) == false) 
		{
			model.addAttribute("checkuser", "Nhập lại mật khẩu không đúng");
		} 
		else 
		{
			nguoiDungService.luuNguoiDung(nguoidung);

			model.addAttribute("checkuser", "Đăng ký thành công");
			model.addAttribute("formnguoidung", nguoidung);
		}
		return "dangky";
	}

	@RequestMapping(value = { "/doimatkhau" }, method = RequestMethod.POST)
	public String doimatkhau(Model model, @ModelAttribute("formdoimatkhau") NguoiDung nguoiDung,
			BindingResult theBindingResult, HttpServletRequest req,
			@RequestParam(value = "userName", defaultValue = "") String userName) {
		
		String mkc = req.getParameter("matKhauHienTai");
		String mkm_nl = req.getParameter("nhapLaiMatKhauMoi");

		boolean kq = nguoiDungService.checkUserDoiMatKhau(mkc);
		if (kq == false) 
		{
			req.setAttribute("checkuser", "Mật khẩu hiện tại không đúng");
		} 
		else if (nguoiDung.getMatKhau().equals(mkm_nl) == false) 
		{
			req.setAttribute("checkuser", "Mật khẩu nhập lại không trùng với mật khẩu mới");
		} 
		else 
		{
			boolean doimatkhau = nguoiDungService.doiMatKhau(nguoiDung.getMatKhau(), userName);
			
			if (doimatkhau == true)
				req.setAttribute("checkuser", "Đổi mật khẩu thành công");
			else 
			{
				req.setAttribute("checkuser", "Đổi mật khẩu thất bại");
			}
		}
		return "doimatkhau";
	}
	
	@RequestMapping(value= {"/danhsachtaikhoan"}, method = RequestMethod.GET)
	public String dsTaiKhoan(Model model) {
		
		List<TaiKhoanModel> ds = taiKhoanService.dsTaiKhoan();
		
		model.addAttribute("ds", ds);
		
		return "danhsachtaikhoan";
	}
	
	@RequestMapping(value= {"/hinhAnhTaiKhoan"}, method = RequestMethod.GET)
	public void hinhAnhTaiKhoan(@RequestParam("maHinhAnh") String maHinhAnh,
			HttpServletResponse res) throws IOException{
		
		HinhAnh hinhAnh;
		hinhAnh = hinhAnhService.layHinhAnhTheoMa(maHinhAnh);

		if(hinhAnh.getHinhAnh() != null)
		{
			res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			res.getOutputStream().write(hinhAnh.getHinhAnh());
		}
		res.getOutputStream().close();
	}
}
