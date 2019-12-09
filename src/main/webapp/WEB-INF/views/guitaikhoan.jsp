<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="_headercss.jsp" />
</head>
<body class=" c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">
 
   <jsp:include page="_header.jsp" />
   
   <fmt:setLocale value="vi_VN" scope="session"/>
   
  <!-- BEGIN: PAGE CONTAINER -->
    <div class="c-layout-page">
    <!-- BEGIN: PAGE CONTENT -->
	   <div class="c-content-box c-size-md c-bg-white">
	       <div class="container">
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
                                    <li><a href="thongtin" class="c-font-white">Thông tin cá nhân</a></li>
                                    <li><a href="doimatkhau" class="c-font-white">Đổi mật khẩu</a></li>
                                    <li><a href="themtaikhoan" class=" c-font-white">Thêm tài khoản</a></li>
                                    <li><a href="guitaikhoan" class="active c-font-white"><b>Gửi tài khoản</b></a></li>
                                    <li><a href="danhsachmua" class=" c-font-white">Danh sách mua</a></li>
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
	               <div class="c-content-title-1 c-font-center">
	                   <h3 class="c-font-uppercase c-font-bold c-font-white">Gửi tài khoản cho người dùng</h3>
	                   <div class="c-line-center c-theme-bg"></div>
	               </div>
              	
					<form action="guitaikhoan" role="form" method="POST">
						<div class="row row-flex item-list">
							<div class="col-md-1 col-xs-12 text-center"></div>
							<div class="col-md-5 col-xs-12 text-center">
								<div class="input-group c-square">
									<span class="input-group-addon" style="">Khách hàng cần gửi</span> 
									<select style="" class="form-control c-square" name="tendangnhap" required="true">
										<option value="">-- Không chọn --</option>
										<c:forEach items="${dsnguoidung}" var="dsnguoidung">
										<option value="${dsnguoidung.tenDangNhap }"> ${dsnguoidung.tenDangNhap }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-5 col-xs-12 text-center">
								<div class="input-group c-square">
									<span class="input-group-addon">Tài khoản cần gửi</span> 
									<select name="mataikhoan" class="form-control c-square" required="true">
										<option value="">-- Không chọn --</option>
										<c:forEach items="${dstaikhoan}" var="dstaikhoan">
										<option value="${dstaikhoan.ma }"> ${dstaikhoan.ma }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-1 col-xs-12 text-center"></div>
						</div>
						
						<div class="row" style="margin: 15px 0 30px 0;">
							<div class="col-md-12 col-sm-12 no-radius text-center">
								<button type="submit" class="btn c-square c-theme-btn c-font-uppercase c-font-bold">
									Gửi tài khoản
								</button>
							</div>
						</div>
						
					</form>
				
					<div class="form-group c-font-center">
	                    <p class="c-font-yellow c-font-bold">${kq}</p>  
				    </div>
				    
				</div>
			</div>
           <!-- End-->
       </div>
   </div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>


											
