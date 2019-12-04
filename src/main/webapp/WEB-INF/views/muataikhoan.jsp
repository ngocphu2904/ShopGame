<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page autoFlush="true" buffer="1094kb"%>
 
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="_headercss.jsp"/>
</head>
<body class="c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">
 
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
                                    <li><a href="thongtin" class="c-font-white">Thông tin người dùng</a></li>
                                    <li><a href="${pageContext.request.contextPath}/taikhoandamua?ten=${pageContext.request.userPrincipal.name}" class="c-font-white">Tài khoản đã mua</a></li>
                                    <li><a href="doimatkhau" class="c-font-white">Đổi mật khẩu</a></li>
                                    <security:authorize  access="hasRole('ROLE_QUAN_TRI')">
                                    	<li><a href="themtaikhoan" class="c-font-white">Thêm tài khoản</a></li>
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
                                    <li><a href="#" class="c-font-white load-modal">Chuyển tiền từ ATM - Ví Điện Tử</a>
                                   	</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <form method="POST">
	                <div class="c-layout-sidebar-content ">
	                    <!-- BEGIN: PAGE CONTENT -->
	                    <!-- BEGIN: CONTENT/SHOPS/SHOP-CUSTOMER-DASHBOARD-1 -->
	                    <div class="c-content-title-1" style="margin-left: 85px;">
	                        <h3 class="c-font-uppercase c-font-bold c-font-white">Xác nhận mua tài khoản</h3>
	                    </div>
	                    <c:forEach items="${muataikhoan}" var="mua">
		                    <table class="table c-font-white">
		                        <tbody>
		                            <tr>
		                                <td scope="row">Mã tài khoản:</td>
		                                <th>${mua.ma}</th>
		                            </tr>
		                            <tr>
		                                <td scope="row">Chuyên:</td>
		                                <th>${mua.loai}</th>
		                            </tr>
		                            <tr>
		                                <td scope="row">Thông tin tài khoản:</td>
		                                <th>${mua.thongTin}</th>
		                            </tr>
		                            <tr>
		                                <td scope="row">Số vip:</td>
		                                <th>${mua.vip}</th>
		                            </tr>
		                            <tr>
		                                <td scope="row">Giá tài khoản:</td>
		                                <th style="color:yellow">
		                                	<fmt:formatNumber value="${mua.gia}" 
		                                	type="currency"/>     	
		                                </th>
		                            </tr>
		                            <tr>
		                                <td scope="row">Số tiền của bạn:</td>
		                                <th><fmt:formatNumber value="${mua.tien}" 
		                                	type="currency"/></th>
		                            </tr>
		                            <tr>
		                                <td scope="row"></td>
		                                <td></td>
		                            </tr>
		                        </tbody>
		                    </table>
		                    <c:set var="gia" value="${mua.gia}"/>
		                    <c:set var="tien" value="${mua.tien}"/>
							<c:if test="${gia le tien}">
							    <div class="c-content-title-1" style="margin-left: 180px">
									<button type="submit" value="Submit" class="btn c-btn c-theme-btn c-font-uppercase c-font-bold c-btn-square">
										Xác nhận mua
									</button>
								</div>
						    </c:if>
						    <c:if test="${gia gt tien}">
								<div class="form-group">
				                    <p class="c-font-yellow c-font-bold">
										Số tiền của bạn không đủ để mua tài khoản này. Vui lòng nạp tiền và quay lại sau.
										Hoặc bạn cũng có thể chuyển tiền qua ATM hoặc ví điện tử.
				                   	</p>  
							    </div>
							    <div class="c-content-title-1" style="margin: 25px 0 0 116px">
									<a href="#" class="btn c-btn btn-danger c-font-uppercase c-font-bold c-btn-square load-modal">
										Chuyển tiền qua ATM - Ví điện tử 
									</a>
								</div>
						    </c:if>
						</c:forEach>
	                </div>
                </form>	
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