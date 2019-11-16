package phuquat.shopgame.model;

public class DonMuaModel {

	/* Khai bao cac truong cua TaiKhoan */
    private String ma;
    private String loai;
    private double gia;
    private int vip;
    private String thongTin;

    
	/* Khai bao cac truong cua NguoiDung */
    private String tenDangNhap;
    private double tien;
    
    private double tienConLai;
    
	public DonMuaModel(String ma, String loai, double gia, String thongTin, int vip,
			String tenDangNhap, double tien) 
	{
		this.ma= ma;
		this.loai = loai;
		this.gia = gia;
		this.thongTin = thongTin;
		this.vip = vip;
		this.tien = tien;
		this.tenDangNhap = tenDangNhap;
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
    
    
}
