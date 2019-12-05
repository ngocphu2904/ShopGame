package phuquat.shopgame.model;

import java.util.Date;

public class DonMuaModel {

	/* Khai bao cac truong cua TaiKhoan */
    private String ma;
    private String loai;
    private double gia;
    private int vip;
    private String thongTin;
    private String tenTaiKhoan;
	private String matKhauTaiKhoan;
    private String cauHoiBaoMat;
    private String cauTraLoiBaoMat;
    private String emailTaiKhoan;
    private String CMND;
    
	/* Khai bao cac truong cua NguoiDung */
    private String tenDangNhap;
    private String tenNguoiDung;
    private double tien;
    private String email;
	private String soDienThoai;
    
	//donmua
	private Date ngayMua;
	
			
	private double tienConLai;
	
	public DonMuaModel() {}
     
	public DonMuaModel(double gia, double tien) 
	{	
		this.gia = gia;
		this.tien = tien;	
	}
	
	public DonMuaModel(String tenDangNhap,String tenNguoiDung, String email, String soDienThoai, String ma, String loai, 
			int vip, String thongTin, String tenTaiKhoan, String matKhauTaiKhoan, double gia, 
			Date ngayMua, String cauHoiBaoMat, String cauTraLoiBaoMat, String emailTaiKhoan, String CMND) {
		this.tenDangNhap = tenDangNhap;
		this.tenNguoiDung = tenNguoiDung;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.ma = ma;
		this.loai = loai;
		this.vip = vip;
		this.thongTin = thongTin;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhauTaiKhoan = matKhauTaiKhoan;
		this.gia = gia;
		this.ngayMua= ngayMua;
		this.cauHoiBaoMat = cauHoiBaoMat;
		this.cauTraLoiBaoMat = cauTraLoiBaoMat;
		this.emailTaiKhoan = emailTaiKhoan;
		this.CMND = CMND;
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


	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}


	public double getTienConLai() {
		return tienConLai;
	}
	public void setTienConLai(double tienConLai) {
		this.tienConLai = tienConLai;
	}
	
	
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public String getThongTin() {
		return thongTin;
	}
	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public double getTien() {
		return tien;
	}
	public void setTien(double tien) {
		this.tien = tien;
	}

	public String getCauHoiBaoMat() {
		return cauHoiBaoMat;
	}

	public void setCauHoiBaoMat(String cauHoiBaoMat) {
		this.cauHoiBaoMat = cauHoiBaoMat;
	}

	public String getCauTraLoiBaoMat() {
		return cauTraLoiBaoMat;
	}

	public void setCauTraLoiBaoMat(String cauTraLoiBaoMat) {
		this.cauTraLoiBaoMat = cauTraLoiBaoMat;
	}

	public String getEmailTaiKhoan() {
		return emailTaiKhoan;
	}

	public void setEmailTaiKhoan(String emailTaiKhoan) {
		this.emailTaiKhoan = emailTaiKhoan;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
    
    
}
