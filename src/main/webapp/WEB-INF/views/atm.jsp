<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- BẤM NÚT VÀ HIỆN MODAL -->
<div class="modal fade" id="LoadModal" role="dialog" aria-labelledby="exampleModalCenterTitle"aria-hidden="true" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title">Nạp tiền từ ATM hoặc ví điện tử</h4>
            </div>
            <div class="modal-body">
                <div class="c-content-tab-4 c-opt-3" role="tabpanel">
                    <div class="text-center" style="text-transform: uppercase;margin: 5px 0 20px 0;">
	                    <p style="color: #c0392b ;font-size: 17px">
	                    	<b>Hướng dẫn chi tiết chuyển tiền từ ATM - VÍ điện tử</b>
	                    </p>
                    </div>
                    <ul class="nav nav-justified" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#bank" role="tab" data-toggle="tab" class="c-font-16" aria-expanded="true">ATM</a>
                        </li>
                        <li role="presentation" class="">
                            <a href="#wallet" role="tab" data-toggle="tab" class="c-font-16" aria-expanded="false">Ví điện tử</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="bank">
                            <ul class="c-tab-items p-t-0 p-b-0 p-l-5 p-r-5">
                                <li class="c-font-dark">
                                    <table cellpadding="10" class="table table-striped">
                                        <tbody>
                                            <tr>
                                                <th colspan="3">CHUYỂN TIỀN TỪ NGÂN HÀNG (Tên chủ khoản: TRAN VAN A)</th>
                                            </tr>
                                        </tbody>
                                        <tbody>
                                            <tr>
                                                <th>Tên ngân hàng</th>
                                                <th>Số tài khoản</th>
                                                <th>Chi nhánh</th>
                                            </tr>
                                            <tr>
                                                <td>Vietcombank</td>
                                                <td>0123456789</td>
                                                <td>VIỆT NAM</td>
                                            </tr>
                                            <tr>
                                                <td>DongABank</td>
                                                <td>0123456789</td>
                                                <td>VIỆT NAM</td>
                                            </tr>
                                            <tr>
                                                <td>BIDV</td>
                                                <td>0123456789</td>
                                                <td>VIỆT NAM</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </li>
                            </ul>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="wallet">
                            <ul class="c-tab-items p-t-0 p-b-0 p-l-5 p-r-5">
                                <li class="c-font-dark">
                                    <table class="table table-striped">
                                        <tbody>
                                            <tr>
                                                <th colspan="3">NẠP TIỀN TỪ VÍ ĐIỆN TỬ (Tên chủ ví: TRAN VAN A)</th>
                                            </tr>
                                        </tbody>
                                        <tbody>
                                            <tr>
                                                <th>Tên ví</th>
                                                <th>Số ví</th>
                                            </tr>
                                            <tr>
                                                <td>MoMo</td>
                                                <td>0335623523</td>
                                            </tr>
                                            <tr>
                                                <td>Viettelpay</td>
                                                <td>0335623523</td>
                                            </tr>
                                            <tr>
                                                <td>Zalopay</td>
                                                <td>0335623523</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-bottom: -10px">
                    <p class="c-font-black c-font-bold">Nội dung thanh toán: <span style="color:#c0392b">
                    	{ID tài khoản muốn mua và tên tài khoản đăng nhập vào shop}</span>
                   	</p>
                   	<p class="c-font-black">Chuyển xong liên hệ fb: <span style="color:#c0392b"><strong>
                   		https://www.facebook.com/abc</strong></span> hoặc Hotline <span style="color:#c0392b">
                   		<strong> 0123456789 </strong></span> để được xử lý.
                   	</p>   
			    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn c-theme-btn c-btn-border-2x c-btn-square c-btn-bold c-btn-uppercase" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<!-- SCRIPT CỦA BẤM NÚT HIỆN MODAL -->
<script>
    $(document).ready(function () {
        $('.load-modal').each(function (index, elem) {
            $(elem).unbind().click(function (e) {
                e.preventDefault();
                e.preventDefault();
                var curModal = $('#LoadModal');
                curModal.modal('show').find('.modal-content').load($(elem).attr('rel'));
            });
        });
    });
</script>