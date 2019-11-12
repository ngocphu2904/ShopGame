package phuquat.shopgame.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.dao.NguoiDungDAO;
import phuquat.shopgame.entity.NguoiDung;

@Transactional
public class NguoiDungService {

	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	
	public NguoiDung timNguoiDung(String tenDangNhap) {
		return nguoiDungDAO.timNguoiDung(tenDangNhap);
	}
}
