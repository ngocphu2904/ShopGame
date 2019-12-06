<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="_headercss.jsp" />
</head>

<body class="c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">

   <jsp:include page="_header.jsp" />
   
	 <div class="c-layout-page">
	 
	 	<div class="c-content-box c-size-md c-bg-white">
       		<div class="container" >
				
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
                                    <li><a href="thongtin" class=" c-font-white">Thông tin cá nhân</a></li>
                                    <security:authorize  access="hasRole('ROLE_NGUOI_DUNG')">
                                    	<li><a href="${pageContext.request.contextPath}/taikhoandamua" class="c-font-white">Tài khoản đã mua</a></li>
                                    </security:authorize>
                                    <li><a href="doimatkhau" class="active c-font-white"><b>Đổi mật khẩu</b></a></li>
                                    <security:authorize  access="hasRole('ROLE_QUAN_TRI')">
                                    	<li><a href="themtaikhoan" class="c-font-white">Thêm tài khoản</a></li>
                                    </security:authorize>
                                    <security:authorize  access="hasRole('ROLE_QUAN_TRI')">
                                    	<li><a href="guitaikhoan" class="c-font-white">Gửi tài khoản</a></li>
                                    </security:authorize>
                                    <security:authorize  access="hasRole('ROLE_QUAN_TRI')">
                                    	<li><a href="danhsachmua" class="c-font-white">Danh sách mua</a></li>
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
                                    <li><a class="c-font-white load-modal" href="#">Chuyển tiền từ ATM - Ví Điện Tử</a>
                                   	</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
       		
			 	<div class="c-layout-sidebar-content ">
                    <!-- BEGIN: PAGE CONTENT -->
                    <!-- BEGIN: CONTENT/SHOPS/SHOP-CUSTOMER-DASHBOARD-1 -->
                    <div class="c-content-title-1" style="margin-left: 160px;">
                        <h3 class="c-font-uppercase c-font-bold c-font-white">Đổi mật khẩu</h3>
                    </div>
			            
			            <form:form modelAttribute="formdoimatkhau" method="POST" class="form-horizontal form-charge">
			            	
			            	<div class="form-group">
			            		<label class="col-md-3 control-label c-font-white">Mật khẩu cũ:</label>
		                     	<div class="col-md-6">
				                     <input type="password" class="form-control" name="matKhauHienTai" required="true"
				                     	id="matkhau" placeholder="Nhập mật khẩu hiện tại" />
			                    </div>
			                </div>
			                
			                <div class="form-group">
			                	<label class="col-md-3 control-label c-font-white">Mật khẩu mới:</label>
		                     	<div class="col-md-6">
		                     		<form:input type="password" class="form-control" path="matKhau" required="true"
			                     	id="password" placeholder="Nhập mật khẩu mới" onkeyup='check();'/>
		                     	</div>
			                </div>
			                
			                <div class="form-group">
			                	<label class="col-md-3 control-label c-font-white">Nhập lại mật khẩu mới:</label>
			                    <div class="col-md-6">
				                    <input type="password" class="form-control" name="nhapLaiMatKhauMoi" required="true"
				                    	id="confirm_password" placeholder="Nhập lại mật khẩu mới" onkeyup='check();' />
			                  		<p id='message' style="margin: -30px 10px 0 0;float: right;"/>
			                  	</div>
			                </div>
			                
			                <div class="form-group">
			                	<label class="col-md-3"></label>
				                <div class="col-md-6">
			                 		<p style="margin: 0px 0px 0px 0px;color: red;" id="message" 
				                	onkeyup='dangky();' >  ${checkuser } </p>
			                	</div>
		                	</div>
			                
			                <div class="form-group c-margin-t-40">
			                	<div class="col-md-offset-3 col-md-6">
			                        <button type="submit" value="update" style="margin-top:-25px"
				                        class="btn btn-primary btn-block btn-flat" 
				                        style="margin: 0px 0 0 0;"><i class="fa fa-key"></i>Đổi mật khẩu
			                        </button>
			                    </div>
			                </div>
			            </form:form>
			            <!-- /.social-auth-links -->
			        </div>
		    	</div>
	    	</div>
    	</div>
   	
   
   <style>
	    .login-box, .register-box {
	        width: 400px;
	        margin: 7% auto;
	        padding: 20px;;
	    }
	
	    @media (max-width: 767px){
	        .login-box, .register-box {
	            width: 100%;
	        }
	
	    }
	
	    .login-box-msg, .register-box-msg {
	        margin: 0;
	        text-align: center;
	        padding: 0 20px 20px 20px;
	        text-align: center;
	        font-size: 20px;;
	        font-weight: bold;
	    }
	
	    .box-custom{
	        border: 1px solid #cccccc;
	        padding: 20px;
	
	        color: #666;
	    }
	</style>
 
 
   <jsp:include page="_footer.jsp" />
 
 	
</body>
</html>
