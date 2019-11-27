package phuquat.shopgame.controller;

import java.io.IOException;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import phuquat.shopgame.entity.DonMua;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.DonMuaModel;
import phuquat.shopgame.model.TaiKhoanModel;
import phuquat.shopgame.service.DonMuaService;
import phuquat.shopgame.service.HinhAnhService;
import phuquat.shopgame.service.NguoiDungService;
import phuquat.shopgame.service.TaiKhoanService;


@Controller
public class TrangQuanTri {

	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private HinhAnhService hinhAnhService;
	
	@Autowired
	private DonMuaService donMuaService;
	
    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
 
        if (target.getClass() == TaiKhoan.class) {
        	// Su dung cho upload Image.
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
    
    @RequestMapping(value = {"/themtaikhoan"}, method = RequestMethod.GET)
    public String luuTaiKhoan(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
    	resp.setContentType("text/html;charset=UTF-8");
    	req.setCharacterEncoding("utf-8");
    	
    	model.addAttribute("formTaiKhoan", new TaiKhoan());
    	return "taikhoan";
    }
    
    
    @RequestMapping(value = {"/themtaikhoan"}, method = RequestMethod.POST)
	public String luuTaiKhoan(@ModelAttribute("formTaiKhoan") TaiKhoan taiKhoan,
			@RequestParam(value = "files") MultipartFile[] files, HttpServletRequest req, HttpServletResponse resp) throws IOException {
 
    	resp.setContentType("text/html;charset=UTF-8");
    	req.setCharacterEncoding("utf-8");
    	
		taiKhoanService.luuTaiKhoan(taiKhoan);

		
		hinhAnhService.luuHinhAnh(taiKhoan,files);
		
		return "redirect:/danhsachtaikhoan";
    }
    
    @RequestMapping(value = {"/suataikhoan"}, method = RequestMethod.GET)
    public String suaTaiKhoan(Model model, @RequestParam(value="ma") String ma) {
    	
    	TaiKhoan taiKhoan;
    	
    	taiKhoan = taiKhoanService.timTaiKhoan(ma);
    	
    	model.addAttribute("formTaiKhoan", taiKhoan);
    	
    	return "taikhoan";
    }
    
    @RequestMapping(value = {"/suataikhoan"}, method = RequestMethod.POST)
    public String suaTaiKhoan(@ModelAttribute("formTaiKhoan") TaiKhoan taiKhoan,
    		@RequestParam(value = "files") MultipartFile[] files) {
  
    	taiKhoanService.suaTaiKhoan(taiKhoan);
    	
    	hinhAnhService.luuHinhAnh(taiKhoan, files);
    	
    	return "redirect:/danhsachtaikhoan";
    	
    }
    
    @RequestMapping(value= {"/xoataikhoan"})
    public String xoaTaiKhoan(@RequestParam(value="ma") String ma) {
    	
    	taiKhoanService.xoaTaiKhoan(ma);

    	return "redirect:/danhsachtaikhoan";
    	
    }
    
    @RequestMapping(value = {"/danhsachmua"}, method = RequestMethod.GET)
    public String danhSachMua(Model model) {
    	List<DonMuaModel> ds = donMuaService.thongTinMuaHang();
    	model.addAttribute("ds", ds);
    	int tongTienDaBan = donMuaService.tongTiendaBan();
    	model.addAttribute("TongTienDaBan", tongTienDaBan);
    	return "danhsachmua";
    }
    
	@RequestMapping("guitaikhoan")
	public String thongKe(Model model) {
		List<NguoiDung> dsnguoidung = nguoiDungService.xemnguoidung();
		model.addAttribute("dsnguoidung",dsnguoidung);
		List<TaiKhoan> dstaikhoan = taiKhoanService.xemtaikhoan();
		model.addAttribute("dstaikhoan", dstaikhoan);
		return "guitaikhoan";
	}
	
	@RequestMapping(value= {"guitaikhoan"}, method = RequestMethod.POST)
	public String xuLyThongKe(HttpServletRequest req, Model model) {
		String tenDangNhap =req.getParameter("tendangnhap");
		String maTaiKhoan = req.getParameter("mataikhoan");
		
		donMuaService.luuDonMua(maTaiKhoan, tenDangNhap);
		taiKhoanService.capNhatTaiKhoanDaMua(maTaiKhoan);
		
		List<NguoiDung> dsnguoidung = nguoiDungService.xemnguoidung();
		model.addAttribute("dsnguoidung",dsnguoidung);
		List<TaiKhoan> dstaikhoan = taiKhoanService.xemtaikhoan();
		model.addAttribute("dstaikhoan", dstaikhoan);
		
		model.addAttribute("kq", "Đã gửi tài khoản có mã: "+maTaiKhoan+" cho người dùng có tên tài khoản: "+tenDangNhap);
				
		return "guitaikhoan";
	}
    
}
