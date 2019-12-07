<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="_headercss.jsp" />
</head>
<body
	class=" c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">

	<jsp:include page="_header.jsp" />

	<fmt:setLocale value="vi_VN" scope="session" />

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
								<h3 class="c-left c-font-uppercase c-font-white">Menu tài
									khoản</h3>
								<div class="c-line c-dot c-dot-left "></div>
							</div>
							<div class="c-content-ver-nav c-content-title-1">
								<ul class="c-menu c-arrow-dot c-square c-theme">
									<li><a href="thongtin" class="c-font-white">Thông tin cá nhân</a></li>
									<li><a href="${pageContext.request.contextPath}/taikhoandamua" class="active c-font-white"><b>Tài khoản đã mua</b></a></li>
									<li><a href="doimatkhau" class="c-font-white">Đổi mật khẩu</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-12 col-sm-6 col-xs-6 m-t-15">
							<div class="c-content-title-3 c-title-md c-theme-border">
								<h3 class="c-left c-font-uppercase c-font-white">Menu nạp
									tiền</h3>
								<div class="c-line c-dot c-dot-left "></div>
							</div>
							<div class="c-content-ver-nav m-b-20">
								<ul class="c-menu c-arrow-dot c-square c-theme">
									<li><a href="#" class="c-font-white load-modal">Chuyển
											tiền từ ATM - Ví Điện Tử</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="c-layout-sidebar-content ">
					<!-- BEGIN: PAGE CONTENT -->
					<!-- BEGIN: CONTENT/SHOPS/SHOP-CUSTOMER-DASHBOARD-1 -->
					<div class="c-content-title-1" style="margin-left: 133px;">
						<h3 class="c-font-uppercase c-font-bold c-font-white">Tài
							khoản đã mua</h3>
					</div>

					<!-- Duyet danh sach -->
					<table class="table c-font-white text-center">
						<tbody>
							<tr>
								<th class="text-center">STT</th>
								<th class="text-center">Thời gian</th>
								<th class="text-center">Mã tài khoản</th>
								<th class="text-center">Trị giá</th>
								<th class="text-center"></th>
							</tr>
							<%
								int stt = 1;
							%>
							<c:forEach items="${ds}" var="ds">
								<!-- Bảng tài khoản đã mua -->
								<tr>
									<td><%=stt++%></td>
									<td><fmt:formatDate type="both" dateStyle="medium"
											timeStyle="medium" value="${ds.ngayMua}" /></td>
									<td>${ds.ma}</td>
									<td class=""><fmt:formatNumber value="${ds.gia}"
											type="currency" /></td>
									<td><a href="" class="btn btn-xs btn-info c-btn-square"
										data-toggle="modal" data-target="#chiTietTaiKhoan${ds.ma}">
											Chi tiết </a></td>
								</tr>

								<!-- Chi tiết tài khoản đã mua (modal) -->
								<div class="modal fade" id="chiTietTaiKhoan${ds.ma}"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">×</span>
												</button>
												<h4 class="modal-title">Chi tiết tài khoản CF-${ds.ma}</h4>
											</div>
											
											<div class="modal-body">
								                <div class="form-group">
													<label class="col-md-5 control-label">
														<b>Tên tài khoản:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-bold c-font-red">${ds.tenTaiKhoan}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>Mật khẩu tài khoản:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-bold c-font-red">${ds.matKhauTaiKhoan}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>VIP:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-slim c-font-black">${ds.vip}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>Chuyên:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-slim c-font-black">${ds.loai}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>Thông tin:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-slim c-font-black">${ds.thongTin}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>Câu hỏi bảo mật:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-slim c-font-black">${ds.cauHoiBaoMat}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>Trả lời câu hỏi bảo mật:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-slim c-font-black">${ds.cauTraLoiBaoMat}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>Email tài khoản:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square  c-font-slim c-font-black">${ds.emailTaiKhoan}</p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">
														<b>CMND:</b>
													</label>
													<div class="col-md-7">
														<p class="form-control c-square c-font-slim c-font-black">${ds.CMND}</p>
													</div>
												</div>
												<div style="clear: both"></div>
								            </div>
											<div class="modal-footer">
												<button type="button" class="btn c-theme-btn c-btn-border-2x c-btn-square c-btn-bold c-btn-uppercase" data-dismiss="modal">Đóng</button>
											</div>
										</div>
									</div>
								</div>

							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td><c:if test="${TongTienDaMua != 0 }">
										<td class="c-font-yellow">Tổng: <fmt:formatNumber
												value="${TongTienDaMua}" type="currency" /></td>
									</c:if> <c:if test="${TongTienDaMua == 0 }">
										<td></td>
									</c:if></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			<!-- End-->
			</div>
		</div>
	</div>

	<jsp:include page="_footer.jsp" />
	
	<style>
		label.control-label{
			font-size:17px;
		}
		p.form-control.c-square{
			font-size: 15px;
		}
	</style>

</body>
</html>
