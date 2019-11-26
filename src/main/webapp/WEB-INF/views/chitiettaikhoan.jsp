<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="_headercss.jsp" />
</head>
<body
	class=" c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">

	<jsp:include page="_header.jsp" />

	<fmt:setLocale value="vi_VN" scope="session" />
	
	<div class="c-layout-page">
		<!-- BEGIN: PAGE CONTENT -->
		<div class="c-content-box c-size-md c-bg-white">
			<div class="container">
				<div class="c-shop-product-details-4">
					<c:forEach items="${chitiettaikhoan}" begin="0" end="0" var="chitiet">
						<div class="row">
							<div class="col-md-4 m-b-20">
								<div class="c-product-header">
									<div class="c-content-title-1" style="margin-top: 10px;">
										<h3 class="c-font-uppercase c-font-bold"><span
										class="ms c-font-white" style="background-color: #e7505a;">MS: CF-${chitiet.ma}</span>
										</h3>
										<span class="c-font-white c-font-bold">Đột Kích (CF)</span>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="c-product-meta">
									<div class="c-product-price c-font-yellow"
										style="float: none; text-align: center;margin-left:15px">
										<fmt:formatNumber value="${chitiet.gia}" type="currency"/>
									</div>
								</div>
							</div>
							<div class="col-md-4 text-right">
								<div class="c-product-header">
									<div class="c-content-title-1">
										<security:authorize access="hasRole('ROLE_QUAN_TRI')">
											<a href="suataikhoan?ma=${chitiet.ma}"
												class="btn c-btn btn-lg c-theme-btn c-font-uppercase c-font-bold c-btn-square m-t-20">
												Sửa tài khoản
											</a> 
										</security:authorize>
										<security:authorize access="!hasRole('ROLE_QUAN_TRI')">
											<a href="muataikhoan?ma=${chitiet.ma}&tdn=${pageContext.request.userPrincipal.name}"
												class="btn c-btn btn-lg c-theme-btn c-font-uppercase c-font-bold c-btn-square m-t-20">
												Mua ngay
											</a> 
										</security:authorize>
										<a href=""  
											class="btn c-btn btn-lg btn-danger c-font-uppercase c-font-bold c-btn-square m-t-20 load-modal">
											 ATM - Ví điện tử
										</a>
									</div>
								</div>
							</div>
						</div>
					
						<div class="c-product-meta visible-md visible-lg">
							<div class="c-content-divider c-font-white" style="margin-bottom: 31px">
								<i class="icon-dot"></i>
							</div>
	
							<div class="row">
								<div class="col-sm-4 c-font-white">
									<p
										class="c-font-uppercase c-font-bold c-font-center">
										Chuyên: <span style="color: #ffff00">${chitiet.loai}</span>
									</p>
	
								</div>
								<div class="col-sm-4 c-font-white">
									<p
										class="c-font-uppercase c-font-bold c-font-center">
										Thông tin: <span style="color: #ffff00">${chitiet.thongTin} </span>
									</p>
								</div>
	
								<div class="col-sm-4 c-font-white">
									<p
										class="c-font-uppercase c-font-bold c-font-center">
										VIP: <span style="color: #ffff00"> ${chitiet.vip} </span>
									</p>
								</div>
							</div>
							<div class="c-content-divider c-font-white">
								<i class="icon-dot"></i>
							</div>
						</div>
					</c:forEach>
				</div>
			
			<div class="content_post" style="margin-top:50px">
				<c:forEach items="${chitiettaikhoan}" var="chitiet">
					<p>
						<img src="hinhAnhTaiKhoan?maHinhAnh=${chitiet.maHinhAnh}" class="zoom">
					</p>
				</c:forEach>
				<c:forEach items="${chitiettaikhoan}" begin="0" end="0" var="chitiet">
					<div class="buy-footer" style="text-align: center">
						<security:authorize access="hasRole('ROLE_QUAN_TRI')">
							<a href="suataikhoan?ma=${chitiet.ma}"
								class="btn c-btn btn-lg c-theme-btn c-font-uppercase c-font-bold c-btn-square m-t-20">
								Sửa tài khoản
							</a> 
						</security:authorize>
						<security:authorize access="!hasRole('ROLE_QUAN_TRI')">
							<a href="muataikhoan?ma=${chitiet.ma}&tdn=${pageContext.request.userPrincipal.name}"
								class="btn c-btn btn-lg c-theme-btn c-font-uppercase c-font-bold c-btn-square m-t-20">
								Mua ngay
							</a> 
						</security:authorize>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	</div>

	<jsp:include page="_footer.jsp" />
</body>
</html>