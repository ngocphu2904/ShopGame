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
	public List<TaiKhoan> xemtaikhoan(){
		return taiKhoanDAO.xemTaiKhoanChuaMua();
	}
	public int demTaiKhoan() {
		int count = taiKhoanDAO.demTaiKhoan();
		return count;
	}
	public int demTaiKhoanMua() {
		int countmua = taiKhoanDAO.demTaiKhoanMua();
		return countmua;
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
	
	public void capNhatTaiKhoanDaMua(String maTK) {
		taiKhoanDAO.capNhatTaiKhoanDaMua(maTK);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMa(String ma){
		return taiKhoanDAO.tkTaiKhoanTheoMa(ma);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoLoai(String loai){
		return taiKhoanDAO.tkTaiKhoanTheoLoai(loai);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoGia(String gia){
		return taiKhoanDAO.tkTaiKhoanTheoGia(gia);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMaGia(String ma, String gia){
		return taiKhoanDAO.tkTaiKhoanTheoMaGia(ma, gia);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMaLoai(String ma, String loai){
		return taiKhoanDAO.tkTaiKhoanTheoMaLoai(ma, loai);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoGiaLoai(String gia, String loai){
		return taiKhoanDAO.tkTaiKhoanTheoGiaLoai(gia, loai);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMaGiaLoai(String ma, String gia, String loai){
		return taiKhoanDAO.tkTaiKhoanTheoMaGiaLoai(ma, gia, loai);
	}
}
