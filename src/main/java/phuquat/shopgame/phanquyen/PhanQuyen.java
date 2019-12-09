package phuquat.shopgame.phanquyen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.service.NguoiDungService;

@Service
public class PhanQuyen implements UserDetailsService{
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	//Tham số truyền vào chỉ gồm có username của người dùng. Ta sẽ tìm kiếm trong CSDL, record thỏa mãn username.
	//Nếu không tìm thấy, ta sẽ ném ra ngoại lệ UsernameNotFoundException.
	@Override
    public UserDetails loadUserByUsername(String tendangnhap) throws UsernameNotFoundException {
        NguoiDung nguoiDung = nguoiDungService.timNguoiDung(tendangnhap);
        
        // QUAN_TRI, NGUOI_DUNG
        String quyen = nguoiDung.getKieuNguoiDung();
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
 
        // ROLE_QUAN_TRI, ROLE_NGUOI_DUNG
        //Một GrantedAuthority là một quyền được ban cho principal. Các quyền đều có tiền tố là ROLE_
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + quyen);
        
        grantList.add(authority);
 
        boolean enabled = nguoiDung.isKichHoat();//tra ve true neu nguoi dung da duoc kich hoat
        boolean accountNonExpired = true;//tra ve true neu nguoi dung chua het han
        boolean credentialsNonExpired = true;// tra ve true neu chung thuc (mat khau) nguoi dung chua het han
        boolean accountNonLocked = true;//tra ve true neu nguoi dung chua bi khoa
 
        UserDetails thongTin = (UserDetails) new User(nguoiDung.getTenDangNhap() //so sanh voi param username trang login
                , nguoiDung.getMatKhau() //so sanh vs param password trang login
                , enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);
 
        return thongTin;
    }
}
