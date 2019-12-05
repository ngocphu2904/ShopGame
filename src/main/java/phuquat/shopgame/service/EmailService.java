package phuquat.shopgame.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.dao.EmailDao;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;

@Transactional
public class EmailService {

		@Autowired
		EmailDao emailDao;
		
		public void guiEmail( NguoiDung nguoiDung ,TaiKhoan taiKhoan ) {
			emailDao.guiEmail(nguoiDung, taiKhoan);
		} 
}
