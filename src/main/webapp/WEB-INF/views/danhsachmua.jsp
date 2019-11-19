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
	                   <h3 class="c-center c-font-uppercase c-font-bold c-font-white">Danh sách mua hàng</h3>
	                   <div class="c-line-center c-theme-bg"></div>
	               </div>
					<div class="row row-flex item-list">
		                <!-- Duyet danh sach -->
							<table>
								<tr>
									<th>Ngày Mua</th>
									<th>Tên người mua</th>
									<th>Email</th>
									<th>Số điện thoại</th>
									<th>Tên tài khoản đã mua</th>
									<th>Mật khẩu</th>
									<th>Giá tiền</th>
								</tr>
								<tr>
									<td>01-01-2019</td>
									<td>Quat</td>
									<td>hongocquat0412@gmail.com</td>
									<td>0365255375</td>
									<td> quatps2</td>
									<td>12345</td>
									<td>20000000</td>
								</tr>
							</table>
	           </div>
	           <!-- End-->
	       </div>
	   </div>
   </div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
	<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: ;
}
</style>