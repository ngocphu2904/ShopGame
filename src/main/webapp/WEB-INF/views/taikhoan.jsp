<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="_headercss.jsp" />
 
</head>
<body class=" c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">
 
   <jsp:include page="_header.jsp" />
   
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
                                    <li><a href="thongtin" class="c-font-white">Thông tin tài khoản</a></li>
                                    <li><a href="doimatkhau" class="c-font-white">Đổi mật khẩu</b></a></li>
                                    <li><a href="taikhoan" class="active c-font-white"><b>Thêm nick</b></a></li>
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
                                    <li><a class="load-modal c-font-white" href="#">Chuyển tiền từ ATM - Ví Điện Tử</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="c-layout-sidebar-content ">
                    <!-- BEGIN: PAGE CONTENT -->
                    <!-- BEGIN: CONTENT/SHOPS/SHOP-CUSTOMER-DASHBOARD-1 -->
                    <div class="c-content-title-1" style="margin-left: 180px;">
                        <h3 class="c-font-uppercase c-font-bold c-font-white">Thêm nick</h3>
                    </div>
					<form:form action="luuTaiKhoan" modelAttribute="taikhoan" method="POST" enctype="multipart/form-data" class="form-horizontal form-charge">
                        <form:hidden path="ma"/>
                        <div class="form-group">
                            <label class="col-md-3 control-label c-font-white">Loại tài khoản:</label>
                            <div class="col-md-6">
                                <form:select class="form-control c-square c-theme" path="loai">
                                    <form:option value="TẤT CẢ" label="TẤT CẢ"/>
                                    <form:option value="ZOMBIE" label="CHUYÊN ZOMBIE"/>
                                    <form:option value="SNIPER" label="CHUYÊN SNIPER"/>
                                    <form:option value="ĐẶT BOOM C4" label="ĐẶT BOOM C4"/>
                                    <form:option value="CẬN CHIẾN" label="CẬN CHIẾN"/>
                                </form:select>
                            </div>
                        </div>

						<div class="form-group">
                            <label class="col-md-3 control-label c-font-white">Giá:</label>
                            <div class="col-md-6">
                                <form:input class="form-control c-square c-theme" path="gia" 
                                type="number" required="true" placeholder="Nhập giá tài khoản"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-3 control-label c-font-white">Thông tin:</label>
                            <div class="col-md-6">
                                <form:select class="form-control  c-square c-theme" path="thongTin" name="type" id="type">
                                    <form:option value="Trắng thông tin" label="Trắng thông tin"/>
                                </form:select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-3 control-label c-font-white">VIP:</label>
                            <div class="col-md-6">
                                <form:input class="form-control c-square c-theme" path="vip" 
                                type="number" required="true" placeholder="Nhập số lượng vip của tài khoản"/>
                            </div>
                        </div>
                        <%-- <div class="form-group">
                            <label class="col-md-3 control-label c-font-white">Hình ảnh:</label>
                            <div class="col-md-6">
                                <img src="#" width="100"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label c-font-white">Tải ảnh lên:</label>
                            <div class="col-md-6">
                                <form:input class="custom-file-input" id="customFile" name="files"
                                	type="file" path="" required="true" multiple="multiple"/>
	                                <label class="custom-file-label" for="customFile" >Nhấn chọn hình ảnh...</label>
                            </div>
                        </div> --%>

						<style tyle="text/css">
							.custom-file {
								position: relative;
								display: inline-block;
								height: calc(2.25rem + 2px);
								margin-bottom: 0;
							}
							
							.custom-file-input {
								position: relative;
								z-index: 2;
								width: 100%;
								height: calc(2.25rem + 2px);
								margin: 0;
								opacity: 0;
							}
							
							.custom-file-label {
								position: absolute;
								top: 0;
								right: 0;
								left: 0;
								z-index: 1;
								padding: 6px 0px 5px 13px;
								font-weight: 400;
							    width: 93%;
							    height: 35px;
							    margin-left: 15px;
								color: #848b92;
								font-size: 16px;
								background-color: #fff;
								border: 1px solid #ced4da;
								border-radius: .25rem;
							}
							
							.custom-file-button{
							    position: absolute;
							    margin: -7px -2px 0px 0px;
							    height: 35px;
							    right: 0;
						        background-color: #e6e6e6;
							    color: #000000;
							}
						</style>
						
						<script>
						// Hien thi ten tep khi chon
							$(".custom-file-input").on("change", function() {
							  var fileName = $(this).val().split("\\").pop();
							  if(fileName === ""){
							  	$(this).siblings(".custom-file-label").addClass("selected").html("Nhấn chọn hình ảnh...");}
							  else{
								  $(this).siblings(".custom-file-label").addClass("selected").html(fileName+",...");}
							});
						</script>

						<div class="form-group c-margin-t-40">
                            <div class="col-md-offset-3 col-md-6">
                            	<%-- <c:if test="${productForm.code == null}"> --%>
	                                <button type="submit" value="Submit" class="btn btn-submit 
	                                c-theme-btn c-btn-square c-btn-uppercase c-btn-bold btn-block">
	                                Thêm</button>
                                <%-- </c:if>
                                <c:if test="${productForm.code != null}">
	                                <button type="submit" value="Submit" class="btn btn-submit 
	                                c-theme-btn c-btn-square c-btn-uppercase c-btn-bold btn-block">
	                                Cập nhật</button>
                                </c:if> --%>
                            </div>
                        </div>  
                    </form:form>
                </div>
            </div>
	        
        </div>
   	</div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>