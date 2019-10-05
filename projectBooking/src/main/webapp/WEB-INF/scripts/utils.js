$(document).ready(function() {
	window.toast = {
			error: function(msg) {
				$.toast({
				    text: msg || "Lỗi",
				    heading: 'Lỗi',
				    showHideTransition: 'slide',
				    position: 'bottom-right',
				    icon: 'error'
				});
			},
			warning: function(msg) {
				$.toast({
				    text: msg || "Cảnh báo",
				    heading: 'Cảnh Báo',
				    showHideTransition: 'slide',
				    position: 'bottom-right',
				    icon: 'warning'
				});
			},
			success: function(msg) {
				$.toast({
				    text: msg || "Lỗi",
				    heading: 'Thành Công',
				    showHideTransition: 'slide',
				    position: 'bottom-right',
				    icon: 'success'
				});
				
			},
			info: function(msg) {
				$.toast({
				    text: msg || "Thông tin",
				    heading: 'Thông Tin',
				    showHideTransition: 'slide',
				    position: 'bottom-right',
				    icon: 'info'
				});
			}
	};
	
	window.confirmObj = {
		ok: function() {
			if(this.callFn && typeof this.callFn == "function") {
				this.callFn();
			}
		},
		cancel: function() {
			this.close();
		},
		init: function() {
			
			//Đăng ký sự kiện khi click vào icon close
			$('#appconfirm .close').on("click", function(event) {
				window.confirmObj.close();
			});
			
			//Đăng ký sự kiện khi click vào button "Đông Ý"
			$('#appconfirm #btn-ok').on("click", function(event) {
				window.confirmObj.ok();
			});
			
			//Đăng ký sự kiện khi click vào button  "Thoát"
			$('#appconfirm #btn-cancel').on("click", function(event) {
				window.confirmObj.close();
			});
		},
		show: function(message, fn) {
			this.callFn = fn;
			$('#appconfirm .confirm-message').html(message || "");
			$('#appconfirm').css({display: "block"});
		},
		close: function() {
			$('#appconfirm').css({display: "none"});
			this.callFn = null;
		}
	}
	
	//Khởi tạo confirm
	window.confirmObj.init();
});