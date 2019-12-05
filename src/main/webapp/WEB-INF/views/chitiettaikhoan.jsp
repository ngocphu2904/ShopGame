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
											<a href="xoataikhoan?ma=${chitiet.ma}" onclick="return confirm('Bạn có muốn xóa tài khoản CF-${chitiet.ma}?');"
												title="Xóa tài khoản CF-${chitiet.ma}"
												class="btn c-btn btn-lg btn-danger c-font-uppercase c-font-bold c-btn-square m-t-20">
												 Xóa tài khoản
											</a>
										</security:authorize>
										<security:authorize access="!hasRole('ROLE_QUAN_TRI')">
											<a href="" data-toggle="modal" data-target="#mua"
												class="btn c-btn btn-lg c-theme-btn c-font-uppercase c-font-bold c-btn-square m-t-20">
												Mua ngay
											</a> 
											<a href=""  
											class="btn c-btn btn-lg btn-danger c-font-uppercase c-font-bold c-btn-square m-t-20 load-modal">
											 ATM - Ví điện tử
										</a>
										</security:authorize>
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
							<a href="" data-toggle="modal" data-target="#mua"
								class="btn c-btn btn-lg c-theme-btn c-font-uppercase c-font-bold c-btn-square m-t-20">
								Mua ngay
							</a> 
						</security:authorize>
					</div>
				</c:forEach>
			</div>
			
			<form method="POST">
				<!-- Kiểm tra tiền và đăng nhập trước khi mua (modal) -->
				<div class="modal fade" id="mua"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
								<c:forEach items="${chitiettaikhoan}" begin="0" end="0" var="chitiet">
									<h4 class="modal-title">Mua tài khoản CF-${chitiet.ma}</h4>
								</c:forEach>
							</div>
							
							<div class="modal-body">
							    <div class="c-content-tab-4 c-opt-3" role="tabpanel">
							        <ul class="nav nav-justified" role="tablist">
							            <li role="presentation" class="active">
							                <a href="#payment" role="tab" data-toggle="tab" class="c-font-16" aria-expanded="true">Thanh toán</a>
							            </li>
							            <li role="presentation" class="">
							                <a href="#info" role="tab" data-toggle="tab" class="c-font-16" aria-expanded="false">Tài khoản</a>
							            </li>
							        </ul>
							        <c:forEach items="${chitiettaikhoan}" begin="0" end="0" var="chitiet">
								        <div class="tab-content">
								            <div role="tabpanel" class="tab-pane fade active in" id="payment">
								                <ul class="c-tab-items p-t-0 p-b-0 p-l-5 p-r-5">
								                    <li class="c-font-dark">
								                        <table class="table table-striped">
								                            <tbody>
									                            <tr>
									                                <th colspan="2">Thông tin tài khoản CF-${chitiet.ma}</th>
									                            </tr>
								                            </tbody>
								                            <tbody>
									                            <tr>
									                                <td>Nhà phát hành:</td>
									                                <th>VTC Game</th>
									                            </tr>
									                            <tr>
									                                <td>Tên game:</td>
									                                <th>Đột Kích (CF)</th>
									                            </tr>
									                            <tr>
									                                <td>Giá tiền:</td>
									                                <th class="text-danger">
									                                	<fmt:formatNumber value="${chitiet.gia}" type="currency"/>
								                                	</th>
									                            </tr>
								                            </tbody>
								                        </table>
								                    </li>
								                </ul>
								            </div>
								            <div role="tabpanel" class="tab-pane fade" id="info">
								                <ul class="c-tab-items p-t-0 p-b-0 p-l-5 p-r-5">
								                    <li class="c-font-dark">
														<table class="table table-striped">
								                            <tbody>
									                            <tr>
									                                <th colspan="2">Chi tiết tài khoản CF-${chitiet.ma}</th>
									                            </tr>
								                            </tbody>
								                            <tbody>
									                            <tr>
									                                <td>Chuyên:</td>
									                                <th>${chitiet.loai}</th>
									                            </tr>
									                            <tr>
									                                <td>Thông tin:</td>
									                                <th>${chitiet.thongTin}</th>
									                            </tr>
									                            <tr>
									                                <td>VIP:</td>
									                                <th>${chitiet.vip}</th>
									                            </tr>
								                            </tbody>
								                        </table>
								                    </li>
								                </ul>
								            </div>
								        </div>
							        </c:forEach>
							    </div>
	
					            <c:if test="${pageContext.request.userPrincipal.name == null}">
								    <div class="form-group ">
					                    <label class="col-md-12 form-control-label text-danger" style="text-align: center;margin: 10px 0; ">
							                Bạn chưa đăng nhập. Vui lòng đăng nhập và quay trở lại sau.
							            </label>
								    </div>
							    </c:if>
							    
							    <c:forEach items="${donMua}" var="dm">
							    	<c:set var="gia" value="${dm.gia}"/>
			                    	<c:set var="tien" value="${dm.tien}"/>
		                    	</c:forEach>
		                    	<c:if test="${gia gt tien}">
		                    		<div class="form-group ">
					                    <label class="col-md-12 form-control-label text-danger" style="text-align: center;margin: 10px 0; ">
							                Số tiền của bạn không đủ để mua tài khoản này. Vui lòng nạp tiền và quay lại sau.
											Hoặc bạn cũng có thể chuyển tiền qua ATM hoặc ví điện tử.
							            </label>
								    </div>
		                    	</c:if>
							    
							    <div style="clear: both"></div>
							</div>
							
							<div class="modal-footer">
								<c:if test="${pageContext.request.userPrincipal.name == null}">
									<a href="dangnhap"
										class="btn c-theme-btn c-btn-square c-btn-uppercase c-btn-bold">
										Đăng nhập
									</a>
								</c:if>
								
								<c:if test="${gia gt tien}">
									<a href="" data-dismiss="modal"
										class="btn c-bg-green-4 c-font-white c-btn-square c-btn-uppercase c-btn-bold load-modal">
										Chuyển tiền qua ATM - Ví điện tử 
									</a>
								</c:if>
								
								<c:if test="${pageContext.request.userPrincipal.name != null}">
									<c:if test="${gia le tien}">
										<button type="submit" value="Submit"
											class="btn btn-danger c-btn-square c-btn-uppercase c-btn-bold">
											Xác nhận mua
										</button>
									</c:if>
								</c:if>
								
								<button type="button"
									class="btn c-theme-btn c-btn-border-2x c-btn-square c-btn-bold c-btn-uppercase"
									data-dismiss="modal">Đóng
								</button>
								
							</div>
							
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="_footer.jsp" />
</body>
</html>