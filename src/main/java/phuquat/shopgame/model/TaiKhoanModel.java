package phuquat.shopgame.model;

public class TaiKhoanModel {
	
	/* Khai bao cac truong cua TaiKhoan */
    private String ma;
    private String loai;
    private double gia;
    private int vip;
    private String thongTin;
    private String tenTaiKhoan;
    private String mkTaiKhoan;
    
    
    
    /* Khai bao cac truong cua HinhAnh */
    private String maHinhAnh;
    
    /*Khai bao cac truong nguoidung*/
    private String soDienThoai;
    private String tenDangNhap;
    private String Email;
    
    public TaiKhoanModel(String ma, String loai, double gia, String thongTin, int vip, String maHinhAnh) {
		this.ma = ma;
		this.loai = loai;
		this.gia = gia;
		this.vip = vip;
		this.thongTin = thongTin;
		this.maHinhAnh = maHinhAnh;
	}
    
   
	
	public String getMa() {
		return ma;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMkTaiKhoan() {
		return mkTaiKhoan;
	}

	public void setMkTaiKhoan(String mkTaiKhoan) {
		this.mkTaiKhoan = mkTaiKhoan;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public TaiKhoanModel(double gia, String tenTaiKhoan, String mkTaiKhoan, String soDienThoai, String tenDangNhap,
			String email) {
		super();
		this.gia = gia;
		this.tenTaiKhoan = tenTaiKhoan;
		this.mkTaiKhoan = mkTaiKhoan;
		this.soDienThoai = soDienThoai;
		this.tenDangNhap = tenDangNhap;
		Email = email;
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

	public String getMaHinhAnh() {
		return maHinhAnh;
	}

	public void setMaHinhAnh(String maHinhAnh) {
		this.maHinhAnh = maHinhAnh;
	}
	
}
