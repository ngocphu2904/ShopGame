package phuquat.shopgame.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.dao.HinhAnhDAO;
import phuquat.shopgame.dao.TaiKhoanDAO;
import phuquat.shopgame.entity.HinhAnh;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.TaiKhoanModel;

@Transactional
public class TaiKhoanService {

	@Autowired
	private TaiKhoanDAO taiKhoanDAO;
	
	@Autowired
	private HinhAnhDAO hinhAnhDAO;
	
	public void luuTaiKhoan(TaiKhoan taiKhoan) {
		taiKhoanDAO.luuTaiKhoan(taiKhoan);
	}
	
	public void suaTaiKhoan(TaiKhoan taiKhoan) {
		hinhAnhDAO.xoaHinhAnhTheoTaiKhoan(taiKhoan);
		taiKhoanDAO.suaTaiKhoan(taiKhoan);
	}
	
	public TaiKhoan timTaiKhoan(String ma){
		return taiKhoanDAO.timTaiKhoan(ma);
	}
	
	public List<TaiKhoanModel> dsTaiKhoan(){
		return taiKhoanDAO.dsTaiKhoan();
	}
	
	public List<TaiKhoanModel> chiTietTaiKhoan(String ma){
		return taiKhoanDAO.chiTietTaiKhoan(ma);
	}
	
	public void xoaTaiKhoan(String ma) {
		taiKhoanDAO.xoaTaiKhoan(ma);
	}
}
