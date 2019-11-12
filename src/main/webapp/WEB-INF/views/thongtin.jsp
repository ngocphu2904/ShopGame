<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="_headercss.jsp"/>
</head>
<body class=" c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">
 
   <jsp:include page="_header.jsp" />
   
   <fmt:setLocale value="vi_VN" scope="session"/>

   <!-- BEGIN: PAGE CONTAINER -->
    <div class="c-layout-page">
        <!-- BEGIN: PAGE CONTENT -->
        <div class="c-content-box c-size-md c-bg-white">
        	<div class="container">
        		
				<div class="c-content-title-1" style="margin-top: 30px;">
					<h2 class="c-center c-font-bold c-font-28 c-font-white">${thongtin.tenNguoiDung}</h2>
					<h2 class="c-center c-font-22 c-font-white">${thongtin.kieuNguoiDung}</h2>
					<h2 class="c-center c-font-22 c-font-yellow">
						<fmt:formatNumber value="${thongtin.tien}" type="currency"/>
                    </h2>
					<div class="c-line-center c-theme-bg"></div>
				</div>

				<div class="c-layout-sidebar-menu c-theme" style="margin-top: 70px;">
                    <div class="row">
                        <div class="col-md-12 col-sm-6 col-xs-6 m-t-15 m-b-20">
                            <!-- BEGIN: LAYOUT/SIDEBARS/SHOP-SIDEBAR-DASHBOARD -->
                            <div class="c-content-title-3 c-title-md c-theme-border">
                                <h3 class="c-left c-font-uppercase c-font-white">Menu tài khoản</h3>
                                <div class="c-line c-dot c-dot-left "></div>
                            </div>
                            <div class="c-content-ver-nav c-content-title-1">
                                <ul class="c-menu c-arrow-dot c-square c-theme">
                                    <li><a href="thongtin" class="active c-font-white"><b>Thông tin tài khoản</b></a></li>
                                    <li><a href="changepass?userName=${pageContext.request.userPrincipal.name}" class="c-font-white">Đổi mật khẩu</a></li>
                                    <security:authorize  access="hasRole('ROLE_QUAN_TRI')">
                                    	<li><a href="themtaikhoan" class="c-font-white">Thêm nick</a></li>
                                    </security:authorize>
                                </ul>
                            </div>
                        </div>
                        
                        <div class="col-md-12 col-sm-6 col-xs-6 m-t-15">
                            <div class="c-content-title-3 c-title-md c-theme-border">
                                <h3 class="c-left c-font-uppercase c-font-white">Menu nạp tiền</h3>
                                <div class="c-line c-dot c-dot-left "></div>
                            </div>
                            <div class="c-content-ver-nav m-b-20">
                                <ul class="c-menu c-arrow-dot c-square c-theme">
                                    <li><a class="load-modal c-font-white" href="#">Chuyển tiền từ ATM - Ví Điện Tử</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="c-layout-sidebar-content ">
                    <!-- BEGIN: PAGE CONTENT -->
                    <!-- BEGIN: CONTENT/SHOPS/SHOP-CUSTOMER-DASHBOARD-1 -->
                    <div class="c-content-title-1" style="margin-left: 110px;">
                        <h3 class="c-font-uppercase c-font-bold c-font-white">Thông tin tài khoản</h3>
                    </div>
                    <table class="table c-font-white">
                        <tbody>
                            <tr>
                                <th scope="row">Tên đăng nhập:</th>
                                <th>${thongtin.tenDangNhap}</th>
                            </tr>
                            <tr>
                                <th scope="row">Tên của bạn:</th>
                                <td>${thongtin.tenNguoiDung}</td>
                            </tr>
                            <tr>
                                <th scope="row">Số dư của bạn:</th>
                                <th style="color:yellow">
                                	<fmt:formatNumber value="${thongtin.tien}" 
                                	type="currency"/>     	
                                </th>
                            </tr>
                            <tr>
                                <th scope="row">Địa chỉ Email:</th>
                                <td>${thongtin.email}</td>
                            </tr>
                            <tr>
                                <th scope="row">Số điện thoại:</th>
                                <td>${thongtin.soDienThoai}</td>
                            </tr>
                            <tr>
                                <th scope="row">Loại tài khoản:</th>
                                <td>${thongtin.kieuNguoiDung}</td>
                            </tr>
                            <tr>
                                <th scope="row"></th>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
	        
        </div>
   	</div>
 
 
   <jsp:include page="_footer.jsp" />
   
   	<!-- BEGIN: CORE PLUGINS -->
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!-- END: CORE PLUGINS -->
    <!-- BEGIN: LAYOUT PLUGINS -->
    <script src="js/js.cookie.js" type="text/javascript"></script>
    <!-- END: LAYOUT PLUGINS -->
    <!-- BEGIN: THEME SCRIPTS -->

    <!-- TRANSITION THANH TRANG CHỦ -->
    <script src="js/components.js" type="text/javascript"></script>

    <!-- END: THEME SCRIPTS -->
 
</body>
</html>