package phuquat.shopgame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

<<<<<<< HEAD
=======
import phuquat.shopgame.entity.HinhAnh;
>>>>>>> 33e8c449df019bcc52a0e6da4d3b50519f9aa3a3
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
	public int demtaikhoan() {
		
		Session session = sessionFactory.getCurrentSession();//
		String sql = "SELECT COUNT(*) FROM "+TaiKhoan.class.getName();
		Query countquery = session.createQuery(sql);
		int count = ((Long)countquery.list().get(0)).intValue();
		return count;
	}

	public int demtaikhoanmua() {

		Session session = sessionFactory.getCurrentSession();//
		String sql = "SELECT COUNT(*) FROM " + TaiKhoan.class.getName()+" where mua = 1";
		Query countquery = session.createQuery(sql);
		int countmua = ((Long) countquery.list().get(0)).intValue();
		return countmua;
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
	
	public List<TaiKhoanModel> chiTietTaiKhoan(String ma){
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.ma = h.taiKhoan.ma and t.ma = " +ma;
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