<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<jsp:include page="_headercss.jsp"/>

</head>
<body class="c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">
 
   <jsp:include page="_header.jsp" /> 
 
<!-- BEGIN: PAGE CONTAINER -->
    <div class="c-layout-page">
        <!-- BEGIN: PAGE CONTENT -->
        <div class="c-content-box">
            <div id="slider" class="owl-theme section section-cate slideshow_full_width ">
                <div id="slide_banner" class="owl-carousel owl-loaded owl-drag">
                    <div class="owl-stage-outer">
                    	<div class="owl-stage" style="width: 8082px; transform: translate3d(-4041px, 0px, 0px); transition: all 0.25s ease 0s;">
                            <div class="owl-item cloned" style="width: 1350px;">
                                <div class="item">
                                    <a href="#">
                                        <img src="images/thumb_9291.jpg">
                                    </a>
                                </div>
                            </div>
                            <div class="owl-item cloned" style="width: 1350px;">
                                <div class="item">
                                    <a href="#">
                                        <img src="images/maxresdefault.jpg">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="owl-nav">
                    	<button type="button" role="presentation" class="owl-prev"><i class="fa fa-angle-left"></i></>
                    	<button type="button" role="presentation" class="owl-next"><i class="fa fa-angle-right right_button" aria-hidden="true"></i></>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="c-content-box c-size-md c-bg-white">
            <div class="container">
                <!-- Begin: Testimonals 1 component -->
                <div class="c-content-client-logos-slider-1  c-bordered" data-slider="owl">
                    <!-- Begin: Title 1 component -->
                    <div class="c-content-title-1">
                        <h3 class="c-center c-font-uppercase c-font-bold">Tài khoản</h3>
                        <div class="c-line-center c-theme-bg"></div>
                    </div>
                    <div class="row row-flex-safari game-list">
                    	<div class="col-sm-3 p-5"></div>
                        <div class="col-sm-3 p-5">
                            <div class="classWithPad" style="height: 275px">
                                <div class="news_image">
                                    <a href="https://www.facebook.com">
                                    	<img src="images/chushop.png" title="FB Chủ Shop">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3 p-5">
                            <div class="classWithPad" style="height: 275px">
                                <div class="news_image">
                                    <a href="accountInfo">
                                    	<img src="images/taikhoancuaban.jpg" title="Trang Cá Nhân">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3 p-5"></div>
                    </div>
                    <!-- End-->
                </div>
                <!-- End-->
            </div>
        </div>
        <div class="c-content-box c-size-md c-bg-white">
            <div class="container">
                <!-- Begin: Testimonals 1 component -->
                <div class="c-content-client-logos-slider-1  c-bordered" data-slider="owl">
                    <!-- Begin: Title 1 component -->
                    <div class="c-content-title-1">
                        <h3 class="c-center c-font-uppercase c-font-bold">Danh mục game</h3>
                        <div class="c-line-center c-theme-bg"></div>
                    </div>
                    <div class="row row-flex-safari game-list item-list">
                    	<div class="col-sm-3 p-5"></div>
                        <div class="col-sm-3 p-5">
                            <div class="classWithPad" style="height: 300px;">
                                <div class="news_image">
                                    <a href="productList" title="Đột Kích (CF)">
                                    	<img src="images/gifdotkich.gif">
                                    </a>
                                </div>
                                <div class="news_title">
                                    <h2>
                                        <a href="productList" title="Đột Kích (CF)">Đột Kích (CF)</a>
                                    </h2>
                                </div>
                                <div class="a-more">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="view">
                                                <a href="productList" title="Đột Kích (CF)" >Xem tất cả</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3 p-5">
                            <div class="classWithPad" style="height: 300px;">
                                <div class="news_image">
                                    <a href="#" title="Liên Quân Mobile" class="">
                                    	<img src="images/giflienquan.gif">
                                   	</a>
                                </div>
                                <div class="news_title">
                                    <h2>
                                        <a href="#" title="Liên Quân Mobile">Liên Quân Mobile</a>
                                    </h2>
                                </div>
                                <div class="a-more">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="view">
                                                <a href="#" title="Liên Quân Mobile" >Xem tất cả</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3 p-5"></div>
                    </div>
                    <!-- End-->
                </div>
                <!-- End-->
            </div>
        </div>
    </div>
  
   <jsp:include page="_footer.jsp" />
 
</body>
</html>