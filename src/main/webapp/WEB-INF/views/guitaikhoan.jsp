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
	                   <h3 class="c-center c-font-uppercase c-font-bold c-font-white">Gửi tài khoản cho người dùng</h3>
	                   <div class="c-line-center c-theme-bg"></div>
	               </div>
	              	
					<form action="guitaikhoan" role="form" method="POST">
						<div class="row row-flex item-list">
							<div class="col-md-2 col-sm-4 col-xs-12"></div>
							<div class="col-md-4 col-sm-12 col-xs-12 text-center">
								<div class="input-group c-square">
									<span class="input-group-addon" style="">Người dùng cần gửi</span> 
									<select style="" class="form-control c-square" name="tendangnhap" required="true">
										<option value="">-- Không chọn --</option>
										<c:forEach items="${dsnguoidung}" var="dsnguoidung">
										<option value="${dsnguoidung.tenDangNhap }"> ${dsnguoidung.tenDangNhap }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 text-center">
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
							<div class="col-md-2 col-sm-4 col-xs-12 text-center"></div>
						</div>
						
						<div class="row" style="margin: 15px 0 30px 0;">
							<div class="col-md-12 col-sm-12 no-radius text-center">
								<button type="submit" class="btn c-square c-theme-btn">
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


											
