<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
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
			        <div class="login-box-body box-custom">
			            <p class="login-box-msg c-font-white">Đăng nhập hệ thống</p>
						<span class="help-block" style="text-align: center;color: yellow">
			                <strong> 
			                	<c:if
									test="${param.loi == 'true'}">
									<div>
										Tên đăng nhập hoặc mật khẩu không đúng!!!
									</div>
								</c:if>
						</strong>
			            </span>
			            
			            <form method="POST" action="dangnhap">
			                <div class="form-group has-feedback">
			                    <input type="text" class="form-control" required name="tenDangNhap" value="" placeholder="Tên đăng nhập">
			                    <span class="fa fa-user-o form-control-feedback" style="color:#000000;"></span>
			                </div>
			                <div class="form-group has-feedback">
			                    <input type="password" class="form-control" required name="matKhau" placeholder="Mật khẩu">
			                    <span class="fa fa-key form-control-feedback" style="color:#000000;"></span>
			                </div>
			
			                <div class="row">
			                    <div class="col-xs-12">
			                        <button type="submit" value="Login" class="btn btn-primary btn-block btn-flat" 
			                        style="margin: 0 auto;"><i class="fa fa-sign-in"></i>Đăng nhập</button>
			                    </div>
			                </div>
			            </form>
			
			            <div class="social-auth-links text-center c-font-white">
			                <p style="margin-top: 10px">- HOẶC -</p>  
			                <a href="dangky" class="btn btn-danger btn-block btn-flat"><i class="fa fa-key"></i>Tạo tài khoản</a>
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