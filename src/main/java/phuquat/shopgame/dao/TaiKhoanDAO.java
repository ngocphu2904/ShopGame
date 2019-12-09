package phuquat.shopgame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.entity.HinhAnh;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.TaiKhoanModel;

public class TaiKhoanDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	
	public void luuTaiKhoan(TaiKhoan taiKhoan) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(taiKhoan);
	}
	public List<TaiKhoan> xemTaiKhoanChuaMua(){
		Session session = sessionFactory.getCurrentSession();//
		String sql = "FROM "+TaiKhoan.class.getName()+" t where t.mua = 0 ";
		Query<TaiKhoan> query = session.createQuery(sql);
		return query.getResultList();
	}
	public int demTaiKhoan() {
		
		Session session = sessionFactory.getCurrentSession();//
		String sql = "SELECT COUNT(*) FROM "+TaiKhoan.class.getName();
		Query<?> countquery = session.createQuery(sql);
		int count = ((Long)countquery.list().get(0)).intValue();
		return count;
	}

	public int demTaiKhoanMua() {

		Session session = sessionFactory.getCurrentSession();//
		String sql = "SELECT COUNT(*) FROM " + TaiKhoan.class.getName()+" where mua = 1";
		Query<?> countquery = session.createQuery(sql);
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
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma and t.ma = " +ma;
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

	public void capNhatTaiKhoanDaMua(String maTK) {
		Session session = this.sessionFactory.getCurrentSession();
		
		TaiKhoan taiKhoan = this.timTaiKhoan(maTK);
		
		taiKhoan.setMua(true);
		session.update(taiKhoan);
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMa(String ma){
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma and t.ma = " +ma + " group by h.taiKhoan.ma ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoLoai(String loai){
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma and t.loai like '" +loai + "' group by h.taiKhoan.ma ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoGia(String gia){
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma";
		switch (gia) {
		case "duoi-1-trieu":
			sql += " and t.gia < 1000000 group by h.taiKhoan.ma";
			break;
		
		case "tu-1-2-trieu":
			sql +=" and t.gia >= 1000000 and t.gia <= 2000000 group by h.taiKhoan.ma";
			break;
			
		default:
			 sql += " and t.gia > 2000000 group by h.taiKhoan.ma";
			break;
		}
		sql+= " ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMaLoai(String ma, String loai){
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma and t.ma = '"+ma+"' and t.loai like '" +loai + "' group by h.taiKhoan.ma ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMaGia(String ma, String gia){
		Session session = this.sessionFactory.getCurrentSession();
		String sql =  "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma and t.ma = " +ma;
		switch (gia) {
		case "duoi-1-trieu":
			sql +=" and t.gia < 1000000 group by h.taiKhoan.ma";
			break;
		
		case "tu-1-2-trieu":
			sql += " and t.gia > 1000000 and t.gia < 2000000 group by h.taiKhoan.ma";
			break;
			
		default:
			 sql += " and t.gia > 2000000 group by h.taiKhoan.ma";
			break;
		}
		sql+= " ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoGiaLoai(String gia, String loai){
		Session session = this.sessionFactory.getCurrentSession();
		String sql =  "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma ";
		switch (gia) {
		case "duoi-1-trieu":
			sql +=" and t.gia < 1000000 and t.loai like '"+loai+"' group by h.taiKhoan.ma";
			break;
		
		case "tu-1-2-trieu":
			sql += " and t.gia > 1000000 and t.gia < 2000000 and t.loai like '"+loai+"' group by h.taiKhoan.ma";
			break;
			
		default:
			 sql += " and t.gia > 2000000 and t.loai like '"+loai+"' group by h.taiKhoan.ma";
			break;
		}
		sql+= " ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public List<TaiKhoanModel> tkTaiKhoanTheoMaGiaLoai(String ma, String gia, String loai){
		Session session = this.sessionFactory.getCurrentSession();
		String sql =  "SELECT NEW " + TaiKhoanModel.class.getName()
				+ " (t.ma, t.loai, t.gia, t.thongTin, t.vip, h.maHinhAnh) "
				+ " FROM " + TaiKhoan.class.getName() + " t, "
				+ HinhAnh.class.getName() + " h "
				+ " WHERE t.mua = 0 and t.ma = h.taiKhoan.ma and t.ma = " +ma;
		switch (gia) {
		case "duoi-1-trieu":
			sql +=" and t.gia < 1000000 and t.loai like '"+loai+"' group by h.taiKhoan.ma";
			break;
		
		case "tu-1-2-trieu":
			sql += " and t.gia > 1000000 and t.gia < 2000000 and t.loai like '"+loai+"' group by h.taiKhoan.ma";
			break;
			
		default:
			 sql += " and t.gia > 2000000 and t.loai like '"+loai+"' group by h.taiKhoan.ma";
			break;
		}
		sql+= " ORDER BY t.gia DESC";
		Query<TaiKhoanModel> query = session.createQuery(sql);
		return query.getResultList();
	}
}
