$(document).ready(function() {
	var lock = false;
	var isEdit = false;
	var _editData = null;
	
	var grid = $("#grid-data-api").bootgrid({
	    ajax: true,
	    ajaxSettings: {
	        method: "GET",
	        cache: false
	    },
	    labels: {
	    	infos: "[{{ctx.start}} - {{ctx.end}}] {{ctx.total}}"
	    },
	    url: document.ctx + "/api/user/list",
	    formatters: {
	        "commands": function(column, row)
	        {
	            return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><i class=\"fas fa-pencil-alt\"></i></button> " + 
	                "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><i class=\"fas fa-trash-alt\"></i></button>";
	        }
	    }
	}).on("loaded.rs.jquery.bootgrid", function()
	{
	    grid.find(".command-edit").on("click", function(e)
	    {
	        editData($(this).data());
	    }).end().find(".command-delete").on("click", function(e)
	    {
	        confirmObj.show("Bạn có muốn xoá dữ liệu?", function(){
	        	removeData($(this).data());
	        });
	    });
	});
	
	//Delete data
	function removeData(data)
	{
		clientRequest.get("/api/user/remove", {id: parseInt(data.rowId)})
		.then(function(res) {
			console.log(res)
			if(res.status == "Success") {
			}
		})
	}
	
	//Edit data
	function editData(data)
	{
		clientRequest.get("/api/user/getone", {id: parseInt(data.rowId)})
		.then(function(res) {
			if(res.status == "Success") {
				isEdit = true;
				_editData = res.rows[0];
				$("#signup-form input[name=email]").val(_editData.email)
				.attr("disabled", true);
				$("#signup-form input[name=fullname]").val(_editData.fullname);
				$("#signup-form input[name=password]").val(_editData.password);
				$("#signup-form input[name=repassword]").val(_editData.password);
				openModal();
			}
		})
	}
	
	//Reload data
	function reloadData()
	{
		$("#grid-data-api").bootgrid("reload");
	}
	
	//Close modal
	function openModal()
	{
		$("#signup-form #postbtn").text("Chỉnh Sửa");
		$('#appsignup').css({display: "block"});
	}
	
	//Close modal
	function closeModal()
	{
		document.getElementById('appsignup').style.display='none';
		resetForm();
	}
	
	//Reset form data
	function resetForm()
	{
		isEdit = false;
		_editData = null;
		document.getElementById("signup-form").reset();
		$("#signup-form input[name=email]").attr("disabled", false);
		$("#signup-form #postbtn").text("Tạo Mới");
	}
	
	//Hiển thị màn hình Signup khi click vào button 
	$('#user-action-add').on("click", function(event) {
		$('#appsignup').css({display: "block"});
	});
	
	//Đăng ký sự kiện đóng modal
	$("#appsignup .close").on("click", closeModal);
	
	//Đăng ký sự kiên click, tạo mới / Chỉnh sửa data
	$("#appsignup #postbtn").on("click", function(event) {
		if(lock == true) {
			return;
		}
		lock = true;
		if(!signInValidate()) {
			return;
		}
		if(!validateData()) {
			return;
		}
		
		var postData = {
			email: $("#signup-form input[name=email]").val(),
			fullname: $("#signup-form input[name=fullname]").val(),
			password: $("#signup-form input[name=password]").val(),
		};
		
		var apiUrl = "/api/user/create"; 
		if(isEdit == true) {
			apiUrl = "/api/user/update"; 
			postData['id'] = _editData.id + "";
			if(!postData.password) {
				delete postData.password;
			}
		}
		clientRequest.post(apiUrl, postData)
		.then(function(res) {
			if(res.status == "Success") {
				toast.success(isEdit?"Cập nhật thành công.":"Tạo mới thành công.");
				reloadData();
				closeModal();
			} else {
				toast.error(isEdit?"Cập nhật thất bại.":"Tạo mới thất bại.");
			}
			lock = false;
		})
	});
	
	function removeUser(id)
	{
		
	}
	
	//Validate form
	function signInValidate() {
		if(isEdit) {
			return true;
		}
		 var pristine = new Pristine(document.getElementById("signup-form"));
		 if(!pristine.validate()) {
			 var eles = $("#appsigupcontent .has-danger input");
			 if(eles.length) {
				 $(eles[0]).focus();
			 }
			 return false;
		 }
		 return true;
	}
	
	//Validate data
	function validateData()
	{
		if(isEdit) {
			return true;
		}
		
		if($("#signup-form .has-danger").length) {
			return false;
		}
		var p1 = $("#signup-form input[name=password]").val()
		var p2 = $("#signup-form input[name=repassword]").val();
		if(p1 != p2) {
			$("#signup-form input[name=password]").parent().addClass("has-danger");
		}else {
			$("#signup-form input[name=password]").parent().removeClass("has-danger");
		}
		return true;
	}
	
	//Validate password
	$("#signup-form .input-password").on("keyup", function(){
		var p1 = $("#signup-form input[name=password]").val()
		var p2 = $("#signup-form input[name=repassword]").val();
		if(p1.length > 6 && p2.length > 6) {
			if(p1 != p2) {
				if(!$(this).parent().hasClass("has-danger")) {
					$(this).parent().addClass("has-danger");
				}
			} else {
				$(this).parent().removeClass("has-danger");
			}
		}
	});
	
	//Enable tool-tip
	$('[data-toggle="tooltip"]').tooltip()
})