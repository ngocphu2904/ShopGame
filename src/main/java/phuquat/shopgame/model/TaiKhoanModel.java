package phuquat.shopgame.model;

public class TaiKhoanModel {
	
    private String ma;
    private String loai;
    private double gia;
    private int vip;
    private String thongTin;
    private String maHinhAnh;
    
	public TaiKhoanModel(String ma, String loai, double gia, String thongTin, int vip,  String maHinhAnh) {
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
