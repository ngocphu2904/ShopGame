package phuquat.shopgame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;

public class NguoiDungDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private TaiKhoanDAO taiKhoanDAO;
	

	public NguoiDung timNguoiDung(String tenDangNhap) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(NguoiDung.class, tenDangNhap);
	}
	
	public List<NguoiDung> xemnguoidung(){
		
		Session session = this.sessionFactory.getCurrentSession();
		String hql = " from "+NguoiDung.class.getName()+" n where n.kieuNguoiDung like 'NGUOI_DUNG'";
		Query<NguoiDung> query = session.createQuery(hql);
		
		return query.getResultList();
	}
	
	public void luuNguoiDung(NguoiDung nguoiDung) {
		
		nguoiDung.setKichHoat(true);
		nguoiDung.setKieuNguoiDung("NGUOI_DUNG");
		nguoiDung.setTien(20000000);
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
	
	public void doiMatKhau(String pass, String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		NguoiDung nguoiDung = this.timNguoiDung(userName);
		nguoiDung.setMatKhau(pass);
		session.update(nguoiDung);
	}
	
	public void capNhatTienSauMua(String maTK, String tenDN) {
		Session session = this.sessionFactory.getCurrentSession();
		
		TaiKhoan taiKhoan = taiKhoanDAO.timTaiKhoan(maTK);
		NguoiDung nguoiDung = this.timNguoiDung(tenDN);
		
		double gia = taiKhoan.getGia();
		double tien = nguoiDung.getTien();
		double tienConLai = tien - gia;
		
		nguoiDung.setTien(tienConLai);
		session.update(nguoiDung);
	}
}
