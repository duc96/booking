<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="styles/facehome.css">
<title>Document</title>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="jumbotron" style="margin-bottom: 0;">
				<div class="container">
					<p>Khách sạn và những khu nghĩ dưỡng hiện đại thanh bình.</p>
					<div class="row">
						<div class="col-md-5">
							<div class="input-group">
								<span class="input-group-addon glyphicon glyphicon-bed"></span>
								<input placeholder="Bạn muốn đến đâu."
									style="margin-top: 0; top: 1px;" type="text"
									class="form-control" aria-label="...">
							</div>
						</div>
						<div class="col-md-5">
							<div class="input-group">
								<span class="input-group-addon glyphicon glyphicon-calendar"></span>
								<input id="from" style="margin-top: 0; top: 1px; width: 50%;"
									type="text" class="form-control" placeholder="Nhận phòng"
									aria-label="..."> <input id="to"
									style="margin-top: 0; top: 1px; width: 50%" type="text"
									class="form-control" placeholder="Trả phòng" aria-label="...">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<h2>
					<b>Địa điểm nổi bật</b>
				</h2>
				<p>Cùng Booking để trải nghiệm một kì nghỉ thật thú vị nào !!!</p>
				<center>
					<img class="img" src="img/danang.PNG"> <img class="img"
						src="img/hanoi.PNG"> <img class="img" src="img/hcm.PNG">
					<img class="img" src="img/nha trang.PNG"> <img class="img"
						src="img/vungtau.PNG">
				</center>
				<h2>Giá tốt nhất khu vực</h2>
				<p>Hoàn tiền nếu bạn tìm được giá tốt hơn !!!</p>
				<center>
					<table>
						<td>
							<div class="room">
								<img src="img/bietthu.PNG"><br> <b>Biệt thự</b>
								<p>1.256 biệt thự lớn nhỏ</p>
							</div>
						</td>
						<td>
							<div class="room">
								<img src="img/canho.PNG"><br> <b>Căn hộ</b>
								<p>2.458 căn hộ</p>
							</div>
						</td>
						<td>
							<div class="room">
								<img src="img/nhadongian.PNG"><br> <b>Nhà đơn
									giản</b>
								<p>958 nhà đơn giản các kiểu</p>
							</div>
						</td>
						<td>
							<div class="room">
								<img src="img/nhago.PNG"><br> <b>Nhà gỗ</b>
								<p>3.124 nhà gỗ</p>
							</div>
						</td>
						<td>
							<div class="room">
								<img src="img/resort.PNG"><br> <b>Resort</b>
								<p>Hơn 879 resort khác nhau</p>
							</div>
						</td>
					</table>
				</center>
			</div>
		</div>
	</div>
</body>
<script>
	$(function() {
		var dateFormat = "mm/dd/yy", from = $("#from").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 1
		}).on("change", function() {
			to.datepicker("option", "minDate", getDate(this));
		}), to = $("#to").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 1
		}).on("change", function() {
			from.datepicker("option", "maxDate", getDate(this));
		});

		function getDate(element) {
			var date;
			try {
				date = $.datepicker.parseDate(dateFormat, element.value);
			} catch (error) {
				date = null;
			}

			return date;
		}
	});
</script>
</html>