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
	           <!-- Begin: Testimonals 1 component -->
	           <div class="c-content-client-logos-slider-1  c-bordered" data-slider="owl">
	               <!-- Begin: Title 1 component -->
	               <div class="c-content-title-1">
	                   <h3 class="c-center c-font-uppercase c-font-bold c-font-white">Danh sách tài khoản chưa bán</h3>
	                   <div class="c-line-center c-theme-bg"></div>
	               </div>
	              	<div class="row" style="margin-bottom: 15px">
						<div class="m-l-10 m-r-10">
							<form  action="thongke" class="form-inline m-b-10" role="form" method="POST">
								<div class="col-md-3 col-sm-4 col-xs-12  p-5 field-search">
									<div class="input-group c-square" style="width: 300px;" >
										<span class="input-group-addon" style="">Tài khoản người dùng </span> 
										<select style="" class="form-control c-square" name="tendangnhap"  >
											<option value="">-- Không chọn --</option>
											<c:forEach items="${dsnguoidung}" var="dsnguoidung">
											<option value="${dsnguoidung.tenDangNhap }"> ${dsnguoidung.tenDangNhap }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3 col-sm-4 col-xs-12  p-5 field-search">
									<div class="input-group c-square" style="margin-left: 50px; width: 300px;">
										<span class="input-group-addon">Tài khoản chưa bán</span> 
										<select name="mataikhoan" class="form-control c-square"
											title="-- Không chọn --">
											<option value="">-- Không chọn --</option>
											<c:forEach items="${dstaikhoan}" var="dstaikhoan">
											<option value="${dstaikhoan.ma }"> ${dstaikhoan.ma }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3 col-sm-4 p-5 no-radius">
									<button type="submit"  style="margin-left: 100px;width: 100px;" class="btn c-square c-theme c-btn-green">
										Gửi </button> <p style="color: blue"> ${kq }</p>
										
								</div>
							</form>
						</div>
					</div>
	           <!-- End-->
	       </div>
	   </div>
   </div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>


											
