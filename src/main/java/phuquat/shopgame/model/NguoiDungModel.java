package phuquat.shopgame.model;

public class NguoiDungModel {

    private String tenDangNhap;
    private String matKhau;
    private boolean kichHoat;
    private String kieuNguoiDung;
    private String tenNguoiDung;
    private double tien;
    private String email;
    private String soDienThoai;
    
	public NguoiDungModel(String tenDangNhap, String matKhau, boolean kichHoat, String kieuNguoiDung,
			String tenNguoiDung, double tien, String email, String soDienThoai) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.kichHoat = kichHoat;
		this.kieuNguoiDung = kieuNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.tien = tien;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public NguoiDungModel(String tenDangNhap, String matKhau) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	public NguoiDungModel(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isKichHoat() {
		return kichHoat;
	}

	public void setKichHoat(boolean kichHoat) {
		this.kichHoat = kichHoat;
	}

	public String getKieuNguoiDung() {
		return kieuNguoiDung;
	}

	public void setKieuNguoiDung(String kieuNguoiDung) {
		this.kieuNguoiDung = kieuNguoiDung;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public double getTien() {
		return tien;
	}

	public void setTien(double tien) {
		this.tien = tien;
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
    
}
