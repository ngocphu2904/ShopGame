package phuquat.shopgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.TaiKhoanModel;
import phuquat.shopgame.service.TaiKhoanService;


@Controller
public class TrangQuanTri {

	@Autowired
	private TaiKhoanService taiKhoanService;
	
    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
 
        if (target.getClass() == TaiKhoanModel.class) {
        	// Su dung cho upload Image.
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
    
    @RequestMapping(value= {"/themtaikhoan"}, method = RequestMethod.GET)
    public String taiKhoan(Model model) {
    	
    	model.addAttribute("formTaiKhoan", new TaiKhoanModel());
    	return "taikhoan";
    }
    
    @RequestMapping(value= {"/themtaikhoan"}, method = RequestMethod.POST)
	public String luuTaiKhoan(Model model, @ModelAttribute("formTaiKhoan") TaiKhoan taiKhoan,
			BindingResult theBindingResult) {
		
    	if(theBindingResult.hasErrors()) {
			return "taikhoan";
		}

		taiKhoanService.luuTaiKhoan(taiKhoan);
		
		model.addAttribute("formTaiKhoan", taiKhoan);
		return "taikhoan";

    }
}
