package phuquat.shopgame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;

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
	
}
