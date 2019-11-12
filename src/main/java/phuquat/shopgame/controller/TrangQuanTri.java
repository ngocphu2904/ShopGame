package phuquat.shopgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.service.HinhAnhService;
import phuquat.shopgame.service.TaiKhoanService;


@Controller
public class TrangQuanTri {

	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@Autowired
	private HinhAnhService hinhAnhService;
	
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
    
    @RequestMapping(value= {"/themtaikhoan"}, method = RequestMethod.GET)
    public String taiKhoan(Model model) {
    	
    	model.addAttribute("formTaiKhoan", new TaiKhoan());
    	return "taikhoan";
    }
    
    @RequestMapping(value= {"/themtaikhoan"}, method = RequestMethod.POST)
	public String luuTaiKhoan(Model model, @ModelAttribute("formTaiKhoan") TaiKhoan taiKhoan,
			@RequestParam(value = "files") MultipartFile[] files,
			BindingResult theBindingResult) {
		
    	if(theBindingResult.hasErrors()) {
			return "taikhoan";
		}

		taiKhoanService.luuTaiKhoan(taiKhoan);
		hinhAnhService.luuHinhAnh(taiKhoan,files);
		
		model.addAttribute("formTaiKhoan", taiKhoan);
		return "taikhoan";

    }
}
