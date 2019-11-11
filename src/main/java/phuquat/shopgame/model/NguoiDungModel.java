package phuquat.shopgame.model;

public class NguoiDungModel {

    private String tendangnhap;
    private String matkhau;
    private boolean kichhoat;
    private String kieunguoidung;
    private String tennguoidung;
    private double tien;
    private String email;
    private String sodienthoai;
    
	public NguoiDungModel(String tendangnhap, String matkhau, boolean kichhoat, String kieunguoidung,
			String tennguoidung, double tien, String email, String sodienthoai) {
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.kichhoat = kichhoat;
		this.kieunguoidung = kieunguoidung;
		this.tennguoidung = tennguoidung;
		this.tien = tien;
		this.email = email;
		this.sodienthoai = sodienthoai;
	}

	public NguoiDungModel(String tendangnhap, String matkhau) {
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
	}

	public NguoiDungModel(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public boolean isKichhoat() {
		return kichhoat;
	}

	public void setKichhoat(boolean kichhoat) {
		this.kichhoat = kichhoat;
	}

	public String getKieunguoidung() {
		return kieunguoidung;
	}

	public void setKieunguoidung(String kieunguoidung) {
		this.kieunguoidung = kieunguoidung;
	}

	public String getTennguoidung() {
		return tennguoidung;
	}

	public void setTennguoidung(String tennguoidung) {
		this.tennguoidung = tennguoidung;
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

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
    
}
