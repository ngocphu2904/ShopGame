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
	
	@Override
    public UserDetails loadUserByUsername(String tendangnhap) throws UsernameNotFoundException {
        NguoiDung nguoiDung = nguoiDungService.timNguoiDung(tendangnhap);
        
        // QUAN_TRI, NGUOI_DUNG
        String quyen = nguoiDung.getKieuNguoiDung();
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
 
        // ROLE_QUAN_TRI, ROLE_NGUOI_DUNG
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + quyen);
        
        grantList.add(authority);
 
        boolean enabled = nguoiDung.isKichHoat();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        UserDetails thongtin = (UserDetails) new User(nguoiDung.getTenDangNhap(), //
                nguoiDung.getMatKhau(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);
 
        return thongtin;
    }
}
