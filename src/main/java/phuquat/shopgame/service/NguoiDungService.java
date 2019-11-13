package phuquat.shopgame.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.dao.NguoiDungDAO;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.model.NguoiDungModel;

@Transactional
public class NguoiDungService {

	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	
	public NguoiDung timNguoiDung(String tenDangNhap) {
		return nguoiDungDAO.timNguoiDung(tenDangNhap);
	}
	public void luunguoidung(NguoiDung nguoidung) {
		nguoiDungDAO.luuNguoiDung(nguoidung);
	}
	public boolean checkuser(NguoiDung nguoidung) {
		boolean kq=nguoiDungDAO.checkuser(nguoidung);
		if(kq==true)return true;
		return false;
	}
	public boolean checkuserdoimatkhau(String matkhau) {
		boolean kq=nguoiDungDAO.checkuserdoimatkhau(matkhau);
		if(kq==true)return true;
		return false;
	}
	public boolean doimatkhau(String pass,String userName) {
		boolean kq=nguoiDungDAO.doimatkhau(pass, userName);
		if(kq==true)return true;
		return false;
	}
}
