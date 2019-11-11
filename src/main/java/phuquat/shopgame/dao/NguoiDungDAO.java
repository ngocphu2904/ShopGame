package phuquat.shopgame.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.model.NguoiDungModel;

//Transactional cho Hibernate
@Transactional
public class NguoiDungDAO {
	
    @Autowired
    private SessionFactory sessionFactory;

    public NguoiDung timNguoiDung(String tendangnhap ) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(NguoiDung.class);
        crit.add(Restrictions.eq("tenDangNhap", tendangnhap));
        return (NguoiDung) crit.uniqueResult();
    }
    
    public NguoiDungModel getThongTinNguoiDung(String tendangnhap) {
        NguoiDung nguoidung = this.timNguoiDung(tendangnhap);
        if (nguoidung == null) {
            return null;
        }
        return new NguoiDungModel(nguoidung.getTenDangNhap(), nguoidung.getMatKhau(), //
        		nguoidung.isKichHoat(), nguoidung.getKieuNguoiDung(), nguoidung.getTenNguoiDung(), //
        	  nguoidung.getTien(), nguoidung.getEmail(), nguoidung.getSoDienThoai());
    }
}
