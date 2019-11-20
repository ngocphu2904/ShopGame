package phuquat.shopgame.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.dao.NguoiDungDAO;
import phuquat.shopgame.entity.NguoiDung;

@Transactional
public class NguoiDungService {

	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	
	public NguoiDung timNguoiDung(String tenDangNhap) {
		return nguoiDungDAO.timNguoiDung(tenDangNhap);
	}
	public List<NguoiDung> xemnguoidung(){
		return nguoiDungDAO.xemnguoidung();
	}
	public void luuNguoiDung(NguoiDung nguoidung) {
		nguoiDungDAO.luuNguoiDung(nguoidung);
	}
	public boolean checkUser(NguoiDung nguoidung) {
		boolean kq = nguoiDungDAO.checkUser(nguoidung);
		if(kq==true) return true;
		return false;
	}
	public boolean checkUserDoiMatKhau(String matkhau) {
		boolean kq = nguoiDungDAO.checkUserDoiMatKhau(matkhau);
		if(kq==true) return true;
		return false;
	}
	public void doiMatKhau(String pass,String userName) {
		nguoiDungDAO.doiMatKhau(pass, userName);
	}
	public void capNhatTienSauMua(String maTK, String tenDN) {
		nguoiDungDAO.capNhatTienSauMua(maTK, tenDN);
	}
}
