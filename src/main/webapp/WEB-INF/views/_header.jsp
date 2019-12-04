<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- BEGIN: LAYOUT/HEADERS/HEADER-1 -->
    <!-- BEGIN: HEADER -->
    <header class="c-layout-header c-layout-header-4 c-layout-header-default-mobile" data-minimize-offset="80">
        <div class="c-topbar c-topbar-light">
            <div class="container">
                <!-- BEGIN: INLINE NAV -->
                <nav class="c-top-menu c-pull-left">
                    <ul class="c-icons c-theme-ul">
                        <li>
                            <a href="https://www.facebook.com" target="_blank">
                                <i class="fa fa-facebook"></i>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.youtube.com" target="_blank">
                                <i class="fa fa-youtube"></i>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- END: INLINE NAV -->
                <!-- BEGIN: INLINE NAV -->
                <nav class="c-top-menu c-pull-right m-t-10">
                    <ul class="c-links c-theme-ul">
                        <li class="c-font-white">
                            Hotline: <a href="tel:0123456789" class="c-font-white">0123456789 08:00 - 22:00</a>
                        </li>
                    </ul>
                </nav>
                <!-- END: INLINE NAV -->
            </div>
        </div>
        <div class="c-navbar">
            <div class="container">
                <!-- BEGIN: BRAND -->
                <div class="c-navbar-wrapper clearfix">
                    <div class="c-brand c-pull-left absolute_pos">
                        <h1 style="margin: -2px 0 0 0;display: inline-block">
                            <a href="" class="c-logo">
                                <img height="35px" src="images/logo.png" title="Trang chủ" class="c-desktop-logo">
                                <img height="29px" src="images/logo.png" title="Trang chủ" class="c-desktop-logo-inverse">
                        	</a>
                        </h1>
                        <style type="text/css">
	                        @media screen and (max-width: 991px) {
	                            .c-mobile-logo {
	                                position: absolute;
	                                left: calc(50% - 5%);
	                                left: -webkit-calc(50% - 5%);
	                                top: 1.5vh;
	                            }

	                            .c-btn-uppercase.btn-sm {
	                                padding: 3px 9px 0px 7px
	                            }

	                            .c-btn-border-1x.c-btn-dark {
	                                border-color: #2f353b;
	                                color: #2f353b;
	                                background: none;
	                                font-size: 1.1vh;
	                                border-color: #2f353b;
	                            }

	                            .button_top {
	                                margin: 0 !important;
	                                position: absolute;
	                                top: 2.5vh;
	                                left: 0.2vh;
	                            }

	                            .top_button {
	                                float: left;
	                                margin-left: 0.5vh
	                            }

	                            .float_right {
	                                display: none !important;
	                            }
	                        }

	                        @media only screen and (min-width: 1290px) {
	                            .nav_container {
	                                position: relative;
	                            }

	                            .c-pull-left.absolute_pos {
	                                position: absolute;
	                                width: 100%;
	                                left: 0;
	                                margin: 0;
	                                top: -10px
	                            }

	                            .c-page-on-scroll .c-pull-left.absolute_pos {
	                                top: 0px
	                            }

	                            .c-layout-header .c-brand {
	                                margin: 0 !important;
	                            }

	                            .c-pull-left h1 {
	                                width: 100%;
	                                display: block;
	                            }

	                            .c-logo {
	                                display: block;
	                            }

	                            .c-logo img {
	                                margin: 0 auto
	                            }

	                            .c-layout-header .c-brand .c-desktop-logo {
	                                height: 115px !important;
	                                margin-top: 4px;
	                                display: block;
	                            }

	                            .c-page-on-scroll.c-layout-header-fixed .c-layout-header .c-brand .c-desktop-logo {
	                                display: none !important;
	                            }

	                            .c-layout-header .c-navbar .c-mega-menu.c-pull-right {
	                                float: left;
	                                width: 105%;
	                                margin-left: -33px;
	                            }

	                            .float_right {
	                                float: right !important
	                            }

	                            .c-layout-header .c-navbar .c-mega-menu>.nav.navbar-nav {
	                                width: 100%
	                            }

	                            .c-page-on-scroll.c-layout-header-fixed .c-layout-header .c-brand .c-desktop-logo-inverse {
	                                height: 70px !important;
	                            }
	                        }
                        </style>
                        
                    </div>
                    <!-- END: BRAND -->

                    <!-- BEGIN: HOR NAV -->
                    <!-- BEGIN: LAYOUT/HEADERS/MEGA-MENU -->
                    <!-- BEGIN: MEGA MENU -->
                    <!-- Dropdown menu toggle on mobile: c-toggler class can be applied to the link arrow or link itself depending on toggle mode -->
                    <style>
                        .c-menu-type-mega:hover {
						transition-delay: 1s;
						}

						.c-layout-header.c-layout-header-4 .c-navbar .c-mega-menu > .nav.navbar-nav > li:focus > a:not(.btn), .c-layout-header.c-layout-header-4 .c-navbar .c-mega-menu > .nav.navbar-nav > li:active > a:not(.btn), .c-layout-header.c-layout-header-4 .c-navbar .c-mega-menu > .nav.navbar-nav > li:hover > a:not(.btn) {
							color: #3a3f45;
							background: #FAFAFA;
						}
					</style>

                    <nav class="c-mega-menu c-pull-right c-mega-menu-dark c-mega-menu-dark-mobile c-fonts-uppercase c-fonts-bold d-none hidden-xs hidden-sm">
                        <ul class="nav navbar-nav c-theme-nav ">
                            <li class="c-menu-type-classic">
                            	<a href="${pageContext.request.contextPath}" class="c-font-white c-link dropdown-toggle ">TRANG CHỦ</a>
                            </li>
                            <li class="c-menu-type-classic">
                            	<a href="${pageContext.request.contextPath}/danhsachtaikhoan" class="c-font-white c-link dropdown-toggle" >ĐỘT KÍCH</a>
                            </li>
                            <security:authorize  access="!hasRole('ROLE_QUAN_TRI')">
	                            <li class="c-menu-type-classic">
	                            	<a href="#" class="c-font-white c-link dropdown-toggle load-modal" >CHUYỂN TIỀN</a>
	                            </li>
                            </security:authorize>
                            <security:authorize  access="hasRole('ROLE_NGUOI_DUNG')">
	                            <li class="c-menu-type-classic">
	                           		<a href="${pageContext.request.contextPath}/taikhoandamua" class="c-font-white c-link dropdown-toggle " >TÀI KHOẢN ĐÃ MUA</a>
	                            </li>
                            </security:authorize>
                           	<security:authorize  access="hasRole('ROLE_QUAN_TRI')">
	                            <li class="c-menu-type-classic">
	                           		<a href="${pageContext.request.contextPath}/danhsachmua" class="c-font-white c-link dropdown-toggle " >DANH SÁCH MUA</a>
	                            </li>
                            </security:authorize>
                            <security:authorize  access="hasRole('ROLE_QUAN_TRI')">
	                            <li class="c-menu-type-classic">
	                            	<a href="${pageContext.request.contextPath}/themtaikhoan" class="c-font-white c-link dropdown-toggle " >THÊM NICK</a>
	                            </li>
                            </security:authorize>
                             <security:authorize  access="hasRole('ROLE_QUAN_TRI')">
	                            <li class="c-menu-type-classic">
	                            	<a href="${pageContext.request.contextPath}/guitaikhoan" class="c-font-white c-link dropdown-toggle " >GỬI NICK</a>
	                            </li>
                            </security:authorize>
                           	<c:if test="${pageContext.request.userPrincipal.name == null}">
	                        	<li class="float_right">
	                            	<a href="${pageContext.request.contextPath}/dangnhap" class="c-font-white c-btn-border-opacity-04 c-btn btn-no-focus c-btn-header btn btn-sm c-btn-border-1x c-btn-dark c-btn-circle c-btn-uppercase c-btn-sbold">
	                                    <i class="fa fa-sign-in"></i>Đăng nhập
	                                </a>
                               </li> 
	                        	<li class="float_right">
	                                <a href="${pageContext.request.contextPath}/dangky" class="c-font-white c-btn-border-opacity-04 c-btn btn-no-focus c-btn-header btn btn-sm c-btn-border-1x c-btn-dark c-btn-circle c-btn-uppercase c-btn-sbold">
	                                    <i class="fa fa-key"></i>Đăng ký
	                                 </a>
                                 </li>
                            </c:if>
                            
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
	                            <li class="float_right">
						           <a href="${pageContext.request.contextPath}/dangxuat" class="c-font-white c-btn-border-opacity-04 c-btn btn-no-focus c-btn-header btn btn-sm c-btn-border-1x c-btn-dark c-btn-circle c-btn-uppercase c-btn-sbold">
						           		<i class="fa fa-sign-out"></i>Đăng xuất
						           </a>
				           		</li>
	                            <li class="float_right">
						           <a href="${pageContext.request.contextPath}/thongtin" class="c-font-white c-btn-border-opacity-04 c-btn btn-no-focus c-btn-header btn btn-sm c-btn-border-1x c-btn-dark c-btn-circle c-btn-uppercase c-btn-sbold">
						                <i class="fa fa-user-o"></i>${pageContext.request.userPrincipal.name}
						           </a>
				                </li>
					        </c:if>					        
                        </ul>
                    </nav>
                    <!-- END: MEGA MENU -->
                    <!-- END: LAYOUT/HEADERS/MEGA-MENU -->
                    <!-- END: HOR NAV -->
                </div>
                <!-- BEGIN: LAYOUT/HEADERS/QUICK-CART -->
                <!-- BEGIN: CART MENU -->
                <!-- END: CART MENU -->
                <!-- END: LAYOUT/HEADERS/QUICK-CART -->
            </div>
        </div>
    </header>
    <!-- END: HEADER -->
    <!-- END: LAYOUT/HEADERS/HEADER-1 --> 
    
    <jsp:include page="atm.jsp"></jsp:include>
    