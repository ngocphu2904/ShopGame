package phuquat.shopgame.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import phuquat.shopgame.dao.HinhAnhDAO;
import phuquat.shopgame.entity.HinhAnh;
import phuquat.shopgame.entity.TaiKhoan;

@Transactional
public class HinhAnhService {
	
	@Autowired
	private HinhAnhDAO hinhAnhDAO;
	
	public void luuHinhAnh(TaiKhoan taiKhoan, MultipartFile[] files) {
		hinhAnhDAO.luuHinhAnh(taiKhoan, files);
	}
	
	public HinhAnh layHinhAnhTheoMa(String maHinhAnh) {
		return hinhAnhDAO.layHinhAnhTheoMa(maHinhAnh);
	}

}
