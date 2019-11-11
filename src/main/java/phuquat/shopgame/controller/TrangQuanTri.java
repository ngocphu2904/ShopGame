package phuquat.shopgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import phuquat.shopgame.dao.TaiKhoanDAO;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.TaiKhoanModel;
import phuquat.shopgame.service.TaiKhoanService;


@Controller
//Cho Hibernate Transaction.
@Transactional
//Su dung RedirectAttributes
@EnableWebMvc
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
    
    @RequestMapping(value="/taikhoan", method = RequestMethod.GET)
    public String taiKhoan(Model model) {
    	TaiKhoanModel taiKhoanModel = new TaiKhoanModel();
    	model.addAttribute("taikhoan", taiKhoanModel);
    	return "taikhoan";
    }
    
    @PostMapping("/luuTaiKhoan")
	public String luuTaiKhoan( @Validated @ModelAttribute("taikhoan") TaiKhoan taiKhoan,
			BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "taikhoan";
		}
		taiKhoanService.luuTaiKhoan(taiKhoan);
		return "taikhoan";
	}
}
