package phuquat.shopgame.model;

import java.util.Date;

public class ThongTinMuaHangModel {
	//nguoi dung
	private String tenDangNhap;
	private String email;
	private String soDienThoai;
	
	//tai khoan
	private String tenTaiKhoan;
	private String matKhauTaiKhoan;
	private double gia;
	
	//donmua
	private Date ngayMua;
	
	public ThongTinMuaHangModel(String tenDangNhap, String email, String soDienThoai, String tenTaiKhoan,
			String matKhauTaiKhoan, double gia, Date ngayMua) {
		this.tenDangNhap = tenDangNhap;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhauTaiKhoan = matKhauTaiKhoan;
		this.gia = gia;
		this.ngayMua= ngayMua;
	}
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhauTaiKhoan() {
		return matKhauTaiKhoan;
	}
	public void setMatKhauTaiKhoan(String matKhauTaiKhoan) {
		this.matKhauTaiKhoan = matKhauTaiKhoan;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	
}
