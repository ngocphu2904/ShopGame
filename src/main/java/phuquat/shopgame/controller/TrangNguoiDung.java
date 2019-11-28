package phuquat.shopgame.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import javassist.expr.NewArray;
import phuquat.shopgame.entity.HinhAnh;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.DonMuaModel;
import phuquat.shopgame.model.TaiKhoanModel;
import phuquat.shopgame.service.DonMuaService;
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
	
	@Autowired
	private DonMuaService donMuaService;

	@RequestMapping("/403")
	public String truyCapBiTuChoi() {
		return "/403";
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		
		int demtaikhoan = taiKhoanService.demTaiKhoan();
		model.addAttribute("sotaikhoan", demtaikhoan);
		int mua = taiKhoanService.demTaiKhoanMua();
		model.addAttribute("mua", mua);
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
			nguoiDungService.doiMatKhau(nguoiDung.getMatKhau(), userName);
			req.setAttribute("checkuser", "Đổi mật khẩu thành công");
		}
		return "doimatkhau";
	}
	
	@RequestMapping(value= {"/danhsachtaikhoan"}, method = RequestMethod.GET)
	public String dsTaiKhoan(Model model, HttpServletRequest req) {
		
			List<TaiKhoanModel> ds = taiKhoanService.dsTaiKhoan();
			model.addAttribute("ds", ds);
		return "danhsachtaikhoan";
	}
	
	@RequestMapping(value= {"/timkiem"}, method = RequestMethod.GET)
	public String timkiem(Model model, HttpServletRequest req) {
		
		String ma =req.getParameter("id");
		String chuyen = req.getParameter("chuyen");
		String gia = req.getParameter("gia");
		List<TaiKhoanModel> ds = null;
		
		if(ma.isEmpty() == false && chuyen.isEmpty() == false && gia.isEmpty() == false) 
		{
			ds = taiKhoanService.tkTaiKhoanTheoMaGiaLoai(ma, gia, chuyen);
			model.addAttribute("ds", ds);
		}
		else if(ma.isEmpty() == false && chuyen.isEmpty() == false) 
			 {
				ds = taiKhoanService.tkTaiKhoanTheoMaLoai(ma, chuyen);
				model.addAttribute("ds", ds);
			 }
			 else if(ma.isEmpty() == false && gia.isEmpty() == false) 
				  {
			 		  ds = taiKhoanService.tkTaiKhoanTheoMaGia(ma, gia);
					  model.addAttribute("ds", ds);
				  }
				  else if(gia.isEmpty() == false && chuyen.isEmpty() == false)
					   {
						   ds = taiKhoanService.tkTaiKhoanTheoGiaLoai(gia, chuyen);
						   model.addAttribute("ds", ds);
					   }
					   else if(ma.isEmpty() == false)
				  		    {
						  		ds = taiKhoanService.tkTaiKhoanTheoMa(ma);
								model.addAttribute("ds", ds);
					        }
						    else if(gia.isEmpty() == false)
				   		    	 {
									ds = taiKhoanService.tkTaiKhoanTheoGia(gia);
									model.addAttribute("ds", ds);
								 }
								 else if(chuyen.isEmpty() == false)
									  {
										  ds = taiKhoanService.tkTaiKhoanTheoLoai(chuyen);
										  model.addAttribute("ds", ds);
									  }
									  else 
									  {
										  model.addAttribute("kq","Không tìm thấy tài khoản.");
										  return "danhsachtaikhoan";
									  }
	
		if(ds.isEmpty() == true)
			model.addAttribute("kq","Không tìm thấy tài khoản.");

		return "danhsachtaikhoan";
	}
	
	@RequestMapping(value = {"/chitiettaikhoan"}, method = RequestMethod.GET)
	public String chiTietTaiKhoan(Model model, @RequestParam("ma") String ma) {
		
		List<TaiKhoanModel> chitiet = taiKhoanService.chiTietTaiKhoan(ma);
		
		model.addAttribute("chitiettaikhoan", chitiet);
		
		return "chitiettaikhoan";
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
	
	@RequestMapping(value={"/muataikhoan"}, method = RequestMethod.GET)
	public String muaTaiKhoan(Model model, @RequestParam("ma") String maTK,
			@RequestParam("tdn") String tenDN) {
		
		List<DonMuaModel> donMuaModel = donMuaService.kiemTraTien(maTK, tenDN);
		model.addAttribute("muataikhoan", donMuaModel);
		return "muataikhoan";
	}
	
	@RequestMapping(value={"/muataikhoan"}, method = RequestMethod.POST)
	public String xacNhanMuaTaiKhoan(Model model, @RequestParam("ma") String maTK,
			@RequestParam("tdn") String tenDN) {
		
		donMuaService.luuDonMua(maTK, tenDN);
		taiKhoanService.capNhatTaiKhoanDaMua(maTK);
		nguoiDungService.capNhatTienSauMua(maTK, tenDN);
		
		return "redirect:/taikhoandamua?ten="+tenDN;
	}
	
	@RequestMapping(value = {"/taikhoandamua"})
	public String taiKhoanDaMua(Model model, @RequestParam("ten") String ten) {
		
		List<DonMuaModel> ds = donMuaService.taiKhoanDaMua(ten);
    	model.addAttribute("ds", ds);
    	int tongTienDaMua = donMuaService.tongTienDaMua(ten);
    	model.addAttribute("TongTienDaMua", tongTienDaMua);
    		
		return "taikhoandamua";

	}
	
}
