package phuquat.shopgame.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.dao.DonMuaDAO;

import phuquat.shopgame.model.DonMuaModel;

@Transactional
public class DonMuaService {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	DonMuaDAO donMuaDAO;
	
	@Autowired
	NguoiDungService nguoiDungService;
	
	@Autowired
	TaiKhoanService taiKhoanService;
	
	
	public List<DonMuaModel> kiemTraTien(String maTK, String tenDN) {
		return donMuaDAO.kiemTraTien(maTK, tenDN);
	}
	
	public void luuDonMua(String maTK, String tenDN) {
		donMuaDAO.luuDonMua(maTK, tenDN);
	}
	public List<DonMuaModel> thongTinMuaHang(){
		return donMuaDAO.thongTinMuaHang();
	}
	public List<DonMuaModel> taiKhoanDaMua(String ten){
		return donMuaDAO.taiKhoanDaMua(ten);
	}
	public int tongTienDaBan() {
		return donMuaDAO.tongTienDaBan();
	}
	public int tongTienDaMua(String name) {
		return donMuaDAO.tongTienDaMua(name);
	}

}
