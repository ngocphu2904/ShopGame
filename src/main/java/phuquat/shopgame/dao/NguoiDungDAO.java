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
        crit.add(Restrictions.eq("tendangnhap", tendangnhap));
        return (NguoiDung) crit.uniqueResult();
    }
    
    public NguoiDungModel getThongTinNguoiDung(String tendangnhap) {
        NguoiDung nguoidung = this.timNguoiDung(tendangnhap);
        if (nguoidung == null) {
            return null;
        }
        return new NguoiDungModel(nguoidung.getTendangnhap(), nguoidung.getMatkhau(), //
        		nguoidung.isKichhoat(), nguoidung.getKieunguoidung(), nguoidung.getTennguoidung(), //
        	  nguoidung.getTien(), nguoidung.getEmail(), nguoidung.getSodienthoai());
    }
}
