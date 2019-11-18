package phuquat.shopgame.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Donmua")
public class DonMua implements Serializable{
	
	private static final long serialVersionUID = -4810692978410751832L;
	
	private String maDonMua;
	private TaiKhoan taiKhoan;
	private NguoiDung nguoiDung;
	private String ngayMua;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Madonmua", length = 50, nullable = false)
	public String getMaDonMua() {
		return maDonMua;
	}
	public void setMaDonMua(String maDonMua) {
		this.maDonMua = maDonMua;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Mataikhoan", nullable = false, //
    foreignKey = @ForeignKey(name = "DONMUA_TAK_FK") )
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Manguoidung", nullable = false, //
    foreignKey = @ForeignKey(name = "DONMUA_NGD_FK") )
	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	
	 @Column(name = "Ngaymua")
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}

	
	
	

	
}
