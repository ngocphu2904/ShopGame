package phuquat.shopgame.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nguoidung")
public class NguoiDung implements Serializable{
	
	private static final long serialVersionUID = -6781126844516303480L;
	
	public static final String ROLE_QUAN_TRI = "QUAN_TRI";
    public static final String ROLE_NGUOI_DUNG = "NGUOI_DUNG";
    
    private String tenDangNhap;
    private String matKhau;
    private boolean kichHoat;
    private String kieuNguoiDung;
    private String tenNguoiDung;
    private double tien;
    private String email;
    private String soDienThoai;
    
    @Id
    @Column(name = "Tendangnhap", length = 50, nullable = false)
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	
	@Column(name = "Matkhau", length = 50, nullable = false)
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	 @Column(name = "Kichhoat", length = 1, nullable = false)
	public boolean isKichHoat() {
		return kichHoat;
	}
	public void setKichHoat(boolean kichHoat) {
		this.kichHoat = kichHoat;
	}
	
	@Column(name = "Kieunguoidung", length = 50, nullable = false)
	public String getKieuNguoiDung() {
		return kieuNguoiDung;
	}
	public void setKieuNguoiDung(String kieuNguoiDung) {
		this.kieuNguoiDung = kieuNguoiDung;
	}
	
	@Column(name = "Tennguoidung", length = 255, nullable = false)
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	
	@Column(name = "Tien", nullable = false)
	public double getTien() {
		return tien;
	}
	public void setTien(double tien) {
		this.tien = tien;
	}
	
	@Column(name = "Email", length = 50, nullable = false)	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "Sodienthoai", length = 50, nullable = false)
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
}