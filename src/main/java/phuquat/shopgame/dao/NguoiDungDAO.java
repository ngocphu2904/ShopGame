package phuquat.shopgame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.entity.NguoiDung;

public class NguoiDungDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public NguoiDung timNguoiDung(String tenDangNhap) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(NguoiDung.class, tenDangNhap);
	}
	
	public void luuNguoiDung(NguoiDung nguoiDung) {
		
		nguoiDung.setKichHoat(true);
		nguoiDung.setKieuNguoiDung("NGUOI_DUNG");
		nguoiDung.setTien(0);
		Session session = this.sessionFactory.getCurrentSession();
		session.save(nguoiDung);
	}
	public boolean checkUser (NguoiDung nguoiDung) {
		
		Session session = this.sessionFactory.getCurrentSession();//
		String sql = "FROM "+NguoiDung.class.getName()+" E WHERE E.tenDangNhap = :tendangnhap";
		
		Query<?> query = session.createQuery(sql);
		query.setParameter("tendangnhap", nguoiDung.getTenDangNhap());
		if(query.list().size() >= 1)
		return true;
		return false;
	}

	public boolean checkUserDoiMatKhau(String matKhau) {

		Session session = this.sessionFactory.getCurrentSession();//
		String sql = "FROM " + NguoiDung.class.getName() + " E WHERE E.matKhau = :matKhau";

		Query<?> query = session.createQuery(sql);
		query.setParameter("matKhau", matKhau);
		if (query.list().size() >= 1)
			return true;
		return false;
	}
	
	public boolean doiMatKhau(String pass, String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "UPDATE "+NguoiDung.class.getName()+ " e set e.matKhau = :matKhau where e.tenDangNhap = :tendangnhap";
		Query<?> query = session.createQuery(hql);
		query.setParameter("matKhau", pass);
		query.setParameter("tendangnhap", userName);
		int result = query.executeUpdate();
		if (result >=1) {
			return true;
		}
		return false;
	}
	/*public void doimatkhau1(NguoiDung nguoidung) {
		Session session = sessionFactory.getCurrentSession();
		session.update(nguoidung);
	}*/
}
