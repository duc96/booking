$(document).ready(function() {
	var lock = false;
	var isEdit = false;
	var _editData = null;
	var grid = $("#grid-data-api").bootgrid({
	    ajax: true,
	    sorting: false,
	    columnSelection: false,
	    searchSettings: false,
	    keepSelection:false,
	    ajaxSettings: {
	        method: "GET",
	        cache: false
	    },
	    labels: {
	    	infos: ""
	    },
	    url: document.ctx + "/api/service/types",
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
	    	var _data = $(this).data();
	        confirmObj.show("Bạn có muốn xoá dữ liệu?", function(){
	        	removeData(_data);
	        });
	    });
	});
	
	//Delete data
	function removeData(data)
	{
		clientRequest.remove("/api/service/type", {id: data.rowId + "" })
		.then(function(res) {
			if(res.status == "Success") {
				toast.success("Xoá thành công.");
				reloadData();
				confirmObj.close();
			} else {
				toast.error("Xoá thất bại.");
			}
		})
	}
	
	//Edit data
	function editData(data)
	{
		clientRequest.get("/api/service/type", {id: parseInt(data.rowId)})
		.then(function(res) {
			if(res.status == "Success") {
				isEdit = true;
				_editData = res.rows[0];
				$("#servicetype-form input[name=service_type_name]").val(_editData.service_type_name);
				$("#servicetype-form textarea[name=service_type_description]").val(_editData.service_type_description);
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
		$("#servicetype-form #postbtn").text("Chỉnh Sửa");
		$('#appservicetype').css({display: "block"});
	}
	
	//Close modal
	function closeModal()
	{
		document.getElementById('appservicetype').style.display='none';
		resetForm();
	}
	
	//Reset form data
	function resetForm()
	{
		isEdit = false;
		_editData = null;
		document.getElementById("signup-form").reset();
		$("#servicetype-form #postbtn").text("Tạo Mới");
	}
	
	//Hiển thị màn hình Signup khi click vào button 
	$('#servicetype-action-add').on("click", function(event) {
		$('#appservicetype').css({display: "block"});
	});
	
	//Đăng ký sự kiện đóng modal
	$("#appservicetype .close").on("click", closeModal);
	
	//Đăng ký sự kiên click, tạo mới / Chỉnh sửa data
	$("#appservicetype #postbtn").on("click", function(event) {
		if(!signInValidate()) {
			return;
		}
		
		var postData = {
			ServiceTypeName: $("#servicetype-form input[name=service_type_name]").val(),
			ServiceTypeDescription: $("#servicetype-form textarea[name=service_type_description]").val().trim()
		};
		
		if(!validateData(postData)) {
			return;
		}
		var apiUrl = "/api/service/type"; 
		var _method = "post"
		if(isEdit == true) {
			_method = "put";
			postData['id'] = _editData['id'] + "";
			if(postData['ServiceTypeName'] == _editData['service_type_name']) {
				delete postData['ServiceTypeName'];
			}
		}
		clientRequest[_method](apiUrl, postData)
		.then(function(res) {
			if(res.status == "Success") {
				toast.success(isEdit?"Cập nhật thành công.":"Tạo mới thành công.");
				reloadData();
				closeModal();
			} else {
				toast.error(isEdit?"Cập nhật thất bại.":"Tạo mới thất bại.");
			}
		})
	});
	
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
	function validateData(postData)
	{
		if(!isEdit) {
			return true;
		}
		var mapp = {
				'ServiceTypeName': 'service_type_name',
				'ServiceTypeDescription': 'service_type_description'
		};
		for(var i in postData) {
			if(postData[i] != _editData[mapp[i]]) {
				return true;
			}
		}
		
		toast.warning("Bạn chưa thay đổi dữ liệu.");
		
		return false;
	}
})