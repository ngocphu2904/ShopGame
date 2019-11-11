package phuquat.shopgame.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Taikhoan")
public class TaiKhoan implements Serializable{

	private static final long serialVersionUID = 7286302134459922806L;
	
    private String ma;
    private String loai;
    private double gia;
    private int vip;
    private String thongTin; 
    private boolean mua;
    private String tenTaiKhoan;
    private String matKhauTaiKhoan;
    
    public TaiKhoan() {}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma", length = 50, nullable = false)
	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}
	
    @Column(name = "Loai", length = 255, nullable = false)
	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

    @Column(name = "Gia", nullable = false)
	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

    @Column(name = "Vip", length = 20, nullable = false)
	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

    @Column(name = "Thongtin", length = 255, nullable = false)
	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

    @Column(name = "Mua", length = 255, nullable = true)
	public boolean isMua() {
		return mua;
	}

	public void setMua(boolean mua) {
		this.mua = mua;
	}

    @Column(name = "Tentaikhoan", length = 255, nullable = true)
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

    @Column(name = "Matkhautaikhoan", length = 255, nullable = true)
	public String getMatKhauTaiKhoan() {
		return matKhauTaiKhoan;
	}

	public void setMatKhauTaiKhoan(String matKhauTaiKhoan) {
		this.matKhauTaiKhoan = matKhauTaiKhoan;
	}
    
}
