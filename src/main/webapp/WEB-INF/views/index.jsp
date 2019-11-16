<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- BAT DAU SLIDER -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<!-- KET THUC SLIDER -->
	
	<jsp:include page="_headercss.jsp" />
</head>
<body
	class="c-layout-header-fixed c-layout-header-mobile-fixed c-layout-header-topbar c-layout-header-topbar-collapse c-page-on-scroll">

	<jsp:include page="_header.jsp" />

	<!-- BEGIN: PAGE CONTAINER -->
	<div class="c-layout-page">
		<!-- BEGIN: PAGE CONTENT -->
		<div class="c-content-box">
			<div id="myCarousel" class="carousel slide" data-ride="carousel" 
				style="border: 1px solid #5f6165; margin-top:30px">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item active">
						<a href="danhsachtaikhoan"><img src="images/slide3.jpg" title="Xem nhiều tài khoản hơn" style="width: 100%;"></a>
						<div class="carousel-caption">
							<p><b>UY TÍN NHẤT</b></p>
						</div>
					</div>
					
					<div class="item">
						<a href="danhsachtaikhoan"><img src="images/slide4.jpg" title="Xem nhiều tài khoản hơn" style="width: 100%;"></a>
						<div class="carousel-caption">
							<p><b>CHẤT LƯỢNG NHẤT</b></p>
						</div>
					</div>
					
					<div class="item">
						<a href="danhsachtaikhoan"><img src="images/slide1.jpg" title="Xem nhiều tài khoản hơn" style="width: 100%;"></a>
						<div class="carousel-caption">
							<p><b>ĐA DẠNG NHẤT</b></p>
						</div>
					</div>
					
					<div class="item">
						<a href="danhsachtaikhoan"><img src="images/slide5.jpg" title="Xem nhiều tài khoản hơn" style="width: 100%;"></a>
						<div class="carousel-caption">
							<p><b>GIÁ RẺ NHẤT</b></p>
						</div>
					</div>

				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" data-slide="prev" title="Sau">
					<span class="glyphicon glyphicon-chevron-left" style="left: 0;margin-left: 50px;"></span>
					<span class="sr-only">Previous</span>
				</a> 
				<a class="right carousel-control" href="#myCarousel" data-slide="next" title="Tiếp">
					<span class="glyphicon glyphicon-chevron-right" style="right: 0;margin-right: 50px;"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>

		<div class="c-content-box c-size-md c-bg-white">
			<div class="container">
				<!-- Begin: Testimonals 1 component -->
				<div class="c-content-client-logos-slider-1  c-bordered"
					data-slider="owl">
					<!-- Begin: Title 1 component -->
					<div class="c-content-title-1">
						<h3 class="c-center c-font-uppercase c-font-bold c-font-white">Tài khoản</h3>
						<div class="c-line-center c-theme-bg"></div>
					</div>
					<div class="row row-flex-safari game-list">
						<div class="col-sm-3 p-5"></div>
						<div class="col-sm-3 p-5">
							<div class="classWithPad" style="height: 275px">
								<div class="news_image">
									<a href="https://www.facebook.com" target="_blank">
										<img src="images/chushop.png" title="FB Chủ Shop">
									</a>
								</div>
							</div>
						</div>
						<div class="col-sm-3 p-5">
							<div class="classWithPad" style="height: 275px">
								<div class="news_image">
									<a href="thongtin"> <img src="images/taikhoancuaban.jpg"
										title="Trang Cá Nhân">
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
				<div class="c-content-client-logos-slider-1  c-bordered"
					data-slider="owl">
					<!-- Begin: Title 1 component -->
					<div class="c-content-title-1">
						<h3 class="c-center c-font-uppercase c-font-bold c-font-white">Danh mục
							game</h3>
						<div class="c-line-center c-theme-bg"></div>
					</div>
					<div class="row row-flex-safari game-list item-list">
						<div class="col-sm-3 p-5"></div>
						<div class="col-sm-3 p-5">
							<div class="classWithPad" style="height: 345px;">
								<div class="news_image">
									<a href="danhsachtaikhoan" title="Đột Kích (CF)"> <img
										src="images/gifdotkich.gif">
									</a>
								</div>
								<div class="news_title">
									<h2>
										<a href="danhsachtaikhoan" class="c-font-yellow" title="Đột Kích (CF)">Đột Kích (CF)</a>
									</h2>
								</div>
								<div class="news_description c-font-white">
                                    <p>
                                        Số tài khoản: ${sotaikhoan }
                                    </p>
                                    <p>
                                        Đã bán: ${mua }
                                    </p>
                                </div>
								<div class="a-more">
									<div class="row">
										<div class="col-xs-12">
											<div class="view">
												<a href="danhsachtaikhoan" class="c-font-bold" title="Đột Kích (CF)">Xem tất cả</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-3 p-5">
							<div class="classWithPad" style="height: 345px;">
								<div class="news_image">
									<a href="#" title="Liên Quân Mobile" class=""> <img
										src="images/giflienquan.gif">
									</a>
								</div>
								<div class="news_title">
									<h2>
										<a href="#" class="c-font-yellow" title="Liên Quân Mobile">Liên Quân Mobile</a>
									</h2>
								</div>
								<div class="news_description c-font-white">
                                    <p>
                                        Số tài khoản: 20
                                    </p>
                                    <p>
                                        Đã bán: 5
                                    </p>
                                </div>
								<div class="a-more">
									<div class="row">
										<div class="col-xs-12">
											<div class="view">
												<a href="#" class="c-font-bold" title="Liên Quân Mobile">Xem tất cả</a>
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