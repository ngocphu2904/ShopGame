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

import phuquat.shopgame.dao.NguoiDungDAO;
import phuquat.shopgame.entity.NguoiDung;

@Service
public class PhanQuyen implements UserDetailsService{
	
	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	
	@Override
    public UserDetails loadUserByUsername(String tendangnhap) throws UsernameNotFoundException {
        NguoiDung nguoiDung = nguoiDungDAO.timNguoiDung(tendangnhap);
        
        // QUAN_TRI, NGUOI_DUNG
        String quyen = nguoiDung.getKieunguoidung();
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
 
        // ROLE_QUAN_TRI, ROLE_NGUOI_DUNG
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + quyen);
        
        grantList.add(authority);
 
        boolean enabled = nguoiDung.isKichhoat();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        UserDetails thongtin = (UserDetails) new User(nguoiDung.getTendangnhap(), //
                nguoiDung.getMatkhau(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);
 
        return thongtin;
    }
}
