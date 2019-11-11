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
    
    private String tendangnhap;
    private String matkhau;
    private boolean kichhoat;
    private String kieunguoidung;
    private String tennguoidung;
    private double tien;
    private String email;
    private String sodienthoai;

    @Id
    @Column(name = "Tendangnhap", length = 50, nullable = false)
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	
	@Column(name = "Matkhau", length = 50, nullable = false)
		public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

    @Column(name = "Kichhoat", length = 1, nullable = false)
	public boolean isKichhoat() {
		return kichhoat;
	}
	public void setKichhoat(boolean kichhoat) {
		this.kichhoat = kichhoat;
	}
	
    @Column(name = "Kieunguoidung", length = 50, nullable = false)
		public String getKieunguoidung() {
		return kieunguoidung;
	}
	public void setKieunguoidung(String kieunguoidung) {
		this.kieunguoidung = kieunguoidung;
	}

	@Column(name = "Tennguoidung", length = 255, nullable = false)
	public String getTennguoidung() {
		return tennguoidung;
	}
	public void setTennguoidung(String tennguoidung) {
		this.tennguoidung = tennguoidung;
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
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	
    @Override
    public String toString()  {
        return "["+ this.tendangnhap+","+ this.matkhau+","+ this.kieunguoidung+"]";
    }
}