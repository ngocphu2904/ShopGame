package phuquat.shopgame.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import phuquat.shopgame.entity.TaiKhoan;

@Entity
@Table(name="Hinhanh")
public class HinhAnh implements Serializable{
	
	private static final long serialVersionUID = -8376159244471210711L;
	
	private TaiKhoan taiKhoan;
    private String maHinhAnh;
    private byte[] hinhAnh;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Mahinhanh", length = 50, nullable = false)
	public String getMaHinhAnh() {
		return maHinhAnh;
	}
	public void setMaHinhAnh(String maHinhAnh) {
		this.maHinhAnh = maHinhAnh;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Mataikhoan", nullable = false, //
    foreignKey = @ForeignKey(name = "HINHANH_TAK_FK") )
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	
	@Lob
    @Column(name = "Hinhanh", length = Integer.MAX_VALUE, nullable = true)
	public byte[] getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
}
