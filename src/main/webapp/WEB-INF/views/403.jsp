<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			   <div class="form-group c-font-center">
                    <p class="c-font-yellow c-font-bold">
						Xin lỗi bạn không có quyền truy cập trang này!
                   	</p>  
			    </div>
			    <div class="c-content-title-1 c-font-center" style="margin: 25px 0 0 0">
					<a href="dangnhap" class="btn c-btn c-theme-btn c-font-uppercase c-font-bold c-btn-square">
						Đăng nhập
					</a>
				</div>
   			</div>
   		</div>
   </div>
  
   <jsp:include page="_footer.jsp" />
 
</body>
</html>