<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="_headercss.jsp" />
</head>

<body class="c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">

   <jsp:include page="_header.jsp" />
   
	 <div class="c-layout-page">
	 
	 	<div class="c-content-box c-size-md c-bg-white">
       		<div class="container">
			 	<div class="login-box">
		        <!-- /.login-logo -->
			        <div class="login-box-body box-custom" ">
			            <p class="login-box-msg c-font-white">Đăng ký tài khoản</p>
			            
			            <form:form modelAttribute="formnguoidung" method="POST">
			                <div class="form-group has-feedback">
			                    <form:input type="text" class="form-control" path="tenNguoiDung" required="true"
			                    	id="name" placeholder="Nhập tên của bạn"/>
			                    <span class="fa fa-user-o form-control-feedback" style="color:#000000;"></span>
			                </div>
			                <div class="form-group has-feedback">
			                    <form:input type="text" class="form-control" path="tenDangNhap" required="true"
			                    	id="username" placeholder="Nhập tên tài khoản"/>
			                    <span class="fa fa-users form-control-feedback" style="color:#000000;"></span>
			                </div>
			                <div class="form-group has-feedback">
			                     <form:input type="password" class="form-control" path="matKhau" required="true"
			                     	id="password" placeholder="Nhập mật khẩu" onkeyup='check();'/>
			                    <span class="fa fa-key form-control-feedback"  style="color:#000000;"></span>
			                </div>
			                <div class="form-group has-feedback" style="width: 320px;">
			                    <input type="password" class="form-control" name="confirm_password" required="true"
			                    	id="confirm_password" placeholder="Nhập lại mật khẩu" onkeyup='check();'/>
			                    <span class="fa fa-key form-control-feedback"  style="color:#000000"></span>
			                  	<p id='message' style="margin: -30px 33px 0 0;float: right;"/>
			                </div>
			                <div class="form-group has-feedback">
			                    <form:input type="email" class="form-control" path="email" required="true"
			                    	id="email" placeholder="Nhập email"/>
			                    <span class="fa fa-envelope-o form-control-feedback" style="color:#000000;"></span>
			                </div>
			                <div class="form-group has-feedback">
			                    <form:input type="text" class="form-control" path="soDienThoai" required="true"
			                    	id="phone" placeholder="Nhập số điện thoại"/>
			                    <span class="fa fa-phone form-control-feedback" style="color:#000000;"></span>
			                </div>
			                 <p style="margin: 0px 0px 14px 0px;color: red;" id="message" 
			                	onkeyup='dangky();' >  ${checkuser } </p>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <button type="submit" value="Register" 
				                        class="btn btn-danger btn-block btn-flat" 
				                        style="margin: 0px 0 0 0;"><i class="fa fa-key"></i>Đăng ký
			                        </button>
			                    </div>
			                </div>
			            </form:form>
			
			            <div class="social-auth-links text-center c-font-white">
			                <p style="margin-top: 10px">- HOẶC -</p>  
			                <a href="${pageContext.request.contextPath}/login" 
			                class="btn btn-primary btn-block btn-flat"><i class="fa fa-sign-in"></i>
			                Đăng nhập</a>
			            </div>
			            <!-- /.social-auth-links -->
			        </div>
		        <!-- /.login-box-body -->
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