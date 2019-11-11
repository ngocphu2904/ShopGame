package phuquat.shopgame.model;

import org.springframework.web.multipart.MultipartFile;

import phuquat.shopgame.entity.TaiKhoan;

public class TaiKhoanModel {
	
    private String ma;
    private String loai;
    private double gia;
    private int vip;
    private String thongTin;
    private boolean mua;
    private String tenTaiKhoan;
    private String matKhauTaiKhoan;
    private String maHinhAnh;
    private MultipartFile duLieuHinhAnh;
    
    private boolean taoMoiTaiKhoan = false;

    public TaiKhoanModel() {}
    
    public TaiKhoanModel(TaiKhoan taiKhoan) {
    	this.ma = taiKhoan.getMa();
    	this.loai = taiKhoan.getLoai();
    	this.gia = taiKhoan.getGia();
    	this.thongTin = taiKhoan.getThongTin();
    	this.vip = taiKhoan.getVip();
    	this.tenTaiKhoan = taiKhoan.getTenTaiKhoan();
    	this.matKhauTaiKhoan = taiKhoan.getMatKhauTaiKhoan();
    }

	public TaiKhoanModel(String maHinhAnh, String ma, String loai, double gia, int vip, String thongTin,
			boolean mua, String tenTaiKhoan, String matKhauTaiKhoan) {
		this.maHinhAnh = maHinhAnh;
		this.ma = ma;
		this.loai = loai;
		this.gia = gia;
		this.vip = vip;
		this.thongTin = thongTin;
		this.mua = mua;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhauTaiKhoan = matKhauTaiKhoan;
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

	public boolean isMua() {
		return mua;
	}

	public void setMua(boolean mua) {
		this.mua = mua;
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

	public String getMaHinhAnh() {
		return maHinhAnh;
	}

	public void setMaHinhAnh(String maHinhAnh) {
		this.maHinhAnh = maHinhAnh;
	}

	public MultipartFile getDuLieuHinhAnh() {
		return duLieuHinhAnh;
	}

	public void setDuLieuHinhAnh(MultipartFile duLieuHinhAnh) {
		this.duLieuHinhAnh = duLieuHinhAnh;
	}

	public boolean isTaoMoiTaiKhoan() {
		return taoMoiTaiKhoan;
	}

	public void setTaoMoiTaiKhoan(boolean taoMoiTaiKhoan) {
		this.taoMoiTaiKhoan = taoMoiTaiKhoan;
	}
    
    
}
