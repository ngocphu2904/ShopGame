package phuquat.shopgame.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phuquat.shopgame.dao.TaiKhoanDAO;
import phuquat.shopgame.entity.TaiKhoan;

@Service
public class TaiKhoanService {

	@Autowired
	private TaiKhoanDAO taiKhoanDAO;
	
	@Transactional
	public void luuTaiKhoan(TaiKhoan taiKhoan) {
		taiKhoanDAO.luuTaiKhoan(taiKhoan);
	}
}
