package phuquat.shopgame.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.entity.DonMua;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.DonMuaModel;

public class DonMuaDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	NguoiDungDAO nguoiDungDAO;
	
	@Autowired
	TaiKhoanDAO taiKhoanDAO;
	
	public List<DonMuaModel> kiemTraTien(String maTK, String tenDN) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String hql = "SELECT NEW " + DonMuaModel.class.getName()
                + "( t.ma, t.loai, t.gia, t.thongTin, t.vip, n.tenDangNhap, n.tien)"
                + " FROM " + TaiKhoan.class.getName() + " t, " + NguoiDung.class.getName() + " n "
                + " WHERE t.ma = "+maTK+" and n.tenDangNhap like '"+tenDN+"'";
		
		Query<DonMuaModel> query = session.createQuery(hql);
		
		return query.getResultList();
	}
	
	public void luuDonMua(String maTK, String tenDN)  {
		NguoiDung nguoiDung = nguoiDungDAO.timNguoiDung(tenDN);
		TaiKhoan taiKhoan = taiKhoanDAO.timTaiKhoan(maTK);
		
		DonMua donMua = new DonMua();
		donMua.setNguoiDung(nguoiDung);
		donMua.setTaiKhoan(taiKhoan);
		donMua.setNgayMua(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(donMua);
	}
}
