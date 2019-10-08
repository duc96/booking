<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="styles/facehome.css">
<title>Document</title>
<style>
body {
	background-image: url(img/flying_bird.png);
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
</style>
</head>

<body>
	<div class="container-fluid flight-content">
		<div class="container">
			<div class="row">
				<div class="jumbotron"
					style="margin-bottom: 0; margin-top: 100px; text-align: center; padding: 0;">
					<div class="container">
						<p style="font-weight: 900;">Tìm những chuyến bay giá rẽ với
							mức giá tốt nhất.</p>
						<div class="row">
							<div class="col-md-6">
								<div class="input-group" style="width: 100%">
									<input id="fromplace"
										style="margin-bottom: 10px; margin-top: 0; top: 1px; width: 100%"
										type="text" class="form-control" placeholder="Nơi đi"
										aria-label="...">
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group" style="width: 100%">
									<input id="toplace"
										style="margin-bottom: 10px; margin-top: 0; top: 1px; width: 100%"
										type="text" class="form-control" placeholder="Nơi đến"
										aria-label="...">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="input-group">
									<span class="input-group-addon glyphicon glyphicon-calendar"></span>
									<input id="from" style="margin-top: 0; top: 1px; width: 100%;"
										type="text" class="form-control" placeholder="Ngày khởi hành"
										aria-label="...">
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group">
									<span class="input-group-addon glyphicon glyphicon-calendar"></span>
									<input id="to" style="margin-top: 0; top: 1px; width: 100%;"
										type="text" class="form-control" placeholder="Ngày đến"
										aria-label="...">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<button>Tìm Kiếm</button>
							</div>
						</div>
					</div>
				</div>
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