<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
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
	                   <h3 class="c-center c-font-uppercase c-font-bold c-font-white">Tài khoản đột kích</h3>
	                   <div class="c-line-center c-theme-bg"></div>
	               </div>
	               
	               <div class="row row-flex item-list">
		                <!-- Duyet danh sach -->
	               		<c:forEach items="${ds}" var="ds">

							<div class="col-sm-6 col-md-3" style="margin-bottom: 30px">
								<div class="classWithPad">
									<div class="image">
										<a href="chitiettaikhoan?ma=${ds.ma}" title="Chi tiết tài khoản CF-${ds.ma}">
											<img src="hinhAnhTaiKhoan?maHinhAnh=${ds.maHinhAnh}">
											<span class="ms">MS: CF-${ds.ma}</span>
										</a>
									</div>
									<div class="description">${ds.thongTin}</div>
									<div class="attribute_info">
										<div class="row">
											<div class="col-xs-6 a_att c-font-white">
												Chuyên: <b>${ds.loai}</b>
											</div>
											<div class="col-xs-6 a_att c-font-white">
												Số VIP: <b>${ds.vip}</b>
											</div>
										</div>
									</div>
									<div class="a-more" style="margin-top: -35px;">
										<div class="row">
											<div class="col-xs-12">
												<div class="price_item c-font-bold" style="border: 1px solid #ffff00;color: #ffff00;">
													<fmt:formatNumber value="${ds.gia}" type="currency"/>
												</div>
											</div>
										</div>
									</div>
									<div class="a-more" style="margin-top: -30px;">
										<div class="row">
											<div class="col-xs-6 ">
												<div class="view">
													<security:authorize access="hasRole('ROLE_QUAN_TRI')">
														<a href="xoataikhoan?ma=${ds.ma}" 
														title="Xóa tài khoản CF-${ds.ma}">Xóa</a>
													</security:authorize>
													<security:authorize access="!hasRole('ROLE_QUAN_TRI')">
														<a href="chitiettaikhoan?ma=${ds.ma}" 
														title="Chi tiết tài khoản CF-${ds.ma}">Chi tiết</a>
													</security:authorize>
												</div>
											</div>
											<div class="col-xs-6 ">
												<div class="view">
													<security:authorize access="hasRole('ROLE_QUAN_TRI')">
														<a href="suataikhoan?ma=${ds.ma}" 
														title="Sửa tài khoản CF-${ds.ma}">Sửa</a>
													</security:authorize>
													<security:authorize access="!hasRole('ROLE_QUAN_TRI')">
														<a href="buyProduct?code=${ds.ma}" 
														title="Mua tài khoản CF-${ds.ma}">Mua</a>
													</security:authorize>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
	                   </c:forEach>
	               </div>
	               <!-- End-->
	           </div>
	           <!-- End-->
	       </div>
	   </div>
   </div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>