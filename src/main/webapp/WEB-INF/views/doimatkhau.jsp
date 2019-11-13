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
			            <p class="login-box-msg c-font-white">Đổi mật khẩu</p>
			            
			            <form:form modelAttribute="formdoimatkhau" method="POST">
			            	<div class="form-group has-feedback">
			                     <input type="password" class="form-control" name="matKhauhientai" required="true"
			                     	id="matkhau" placeholder="Nhập mật khẩu hiện tại" />
			                    <span class="fa fa-key form-control-feedback"  style="color:#000000;"></span>
			                </div>
			                <div class="form-group has-feedback">
			                     <form:input type="password" class="form-control" path="matKhau" required="true"
			                     	id="password" placeholder="Nhập mật khẩu mới" />
			                    <span class="fa fa-key form-control-feedback"  style="color:#000000;"></span>
			                </div>
			                <div class="form-group has-feedback" style="width: 320px;">
			                    <input type="password" class="form-control" name="nhaplaimatkhaumoi" required="true"
			                    	id="confirm_password" placeholder="Nhập lại mật khẩu mới" onkeyup='check();'/>
			                    <span class="fa fa-key form-control-feedback"  style="color:#000000"></span>
			                  	<p id='message' style="margin: -30px 33px 0 0;float: right;"/>
			                </div>
			                 <p style="margin: 0px 0px 14px 0px;color: red;" id="message" 
			                	onkeyup='dangky();' >  ${checkuser } </p>
			                <div class="row">
			                    <div class="col-xs-12">
			                        <button type="submit" value="update" 
				                        class="btn btn-danger btn-block btn-flat" 
				                        style="margin: 0px 0 0 0;"><i class="fa fa-key"></i>Cập nhật
			                        </button>
			                    </div>
			                </div>
			            </form:form>
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
