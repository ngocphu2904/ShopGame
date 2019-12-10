package phuquat.shopgame.dao;

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
                + "( t.gia, n.tien)"
                + " FROM " + TaiKhoan.class.getName() + " t, " + NguoiDung.class.getName() + " n "
                + " WHERE t.ma = "+maTK+" and t.mua = 0 and n.tenDangNhap like '"+tenDN+"'";
		
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
	
	public List<DonMuaModel> thongTinMuaHang(){
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "SELECT NEW "+ DonMuaModel.class.getName()
					+"( n.tenDangNhap,n.tenNguoiDung, n.email, n.soDienThoai, t.ma, t.loai, t.vip, t.thongTin,"
					+ " t.tenTaiKhoan, t.matKhauTaiKhoan, t.gia, d.ngayMua, t.cauHoiBaoMat, "
					+ " t.cauTraLoiBaoMat, t.emailTaiKhoan, t.CMND)"
					+" FROM "+NguoiDung.class.getName()+" n, " 
					+TaiKhoan.class.getName()+" t, "
					+DonMua.class.getName()+" d "
					+"where d.taiKhoan.ma=t.ma and d.nguoiDung.tenDangNhap=n.tenDangNhap order by d.ngayMua desc";
		
		Query<DonMuaModel> query = session.createQuery(hql);
		return query.getResultList();
	}
	
	public List<DonMuaModel> taiKhoanDaMua(String ten){
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "SELECT NEW "+ DonMuaModel.class.getName()
					+"( n.tenDangNhap,n.tenNguoiDung, n.email, n.soDienThoai, t.ma, t.loai, t.vip, t.thongTin, "
					+ " t.tenTaiKhoan, t.matKhauTaiKhoan, t.gia, d.ngayMua, t.cauHoiBaoMat, "
					+ " t.cauTraLoiBaoMat, t.emailTaiKhoan, t.CMND)"
					+" FROM "+NguoiDung.class.getName()+" n, " 
					+TaiKhoan.class.getName()+" t, "
					+DonMua.class.getName()+" d "
					+"where d.taiKhoan.ma=t.ma and d.nguoiDung.tenDangNhap=n.tenDangNhap "
					+ "and n.tenDangNhap like '"+ten+"' order by d.ngayMua desc";
		
		Query<DonMuaModel> query = session.createQuery(hql);
		return query.getResultList();
	}
	
	public int tongTienDaBan() {
		Session session = sessionFactory.getCurrentSession();//
		String sql = "SELECT ( case when sum(t.gia) is null then 0 else sum(t.gia) end)"
					+" FROM "+DonMua.class.getName()+" d"
					+" , "+TaiKhoan.class.getName()+" t"
					+" where t.ma = d.taiKhoan.ma";
		Query countquery = session.createQuery(sql);
		int count = ((Integer) countquery.list().get(0)).intValue();
		if(count != 0) {
			return count;
		}else
		return 0;
	}
	
	public int tongTienDaMua(String name) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT ( case when sum(t.gia) is null then 0 else sum(t.gia) end) "
					+" FROM "+DonMua.class.getName()+" d"
					+" , "+TaiKhoan.class.getName()+" t"
					+" where t.ma = d.taiKhoan.ma and d.nguoiDung.tenDangNhap like '"+name+"'";
		Query countquery = session.createQuery(sql);
		int count = ((Integer) countquery.list().get(0)).intValue();
		if(count != 0) {
			return count;
		}else
		return 0;
	}
	
}
