package phuquat.shopgame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.entity.HinhAnh;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.TaiKhoanModel;

public class TaiKhoanDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void luuTaiKhoan(TaiKhoan taiKhoan) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(taiKhoan);
	}
	
	public void suaTaiKhoan(TaiKhoan taiKhoan) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(taiKhoan);
	}
	
	public TaiKhoan timTaiKhoan(String ma){
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(TaiKhoan.class, ma);
	}
	
	public List<TaiKhoanModel> dsTaiKhoan(){
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT NEW " + TaiKhoanModel.class.getName()
                + "( t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
                + " FROM " + TaiKhoan.class.getName() + " t "
                + ", " + HinhAnh.class.getName() + " h "
                + " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma GROUP BY t.ma ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public void xoaTaiKhoan(String ma) {
		Session session = this.sessionFactory.getCurrentSession();	
		String sql = "DELETE " + TaiKhoan.class.getName() + " t WHERE t.ma = :ma";
		Query<?> query = session.createQuery(sql);
		query.setParameter("ma", ma);
		query.executeUpdate();
	}
}
