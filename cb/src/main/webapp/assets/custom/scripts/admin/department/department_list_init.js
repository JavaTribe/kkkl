define(['datatable_ajax','ajaxfileupload'], function(DataTableAjax) {

	var aoData = [
				{
				"sTitle" : '<input type="checkbox" class="group-checkable">',
				"mData" : "depa_id",
				"mRender" : function(data, type, full){
					return '<input type="checkbox" name="depa_id" value="'+ data +'">';
				}},
				{
					"sTitle" : "部门名称",
					"mData" : "depa_name"
				},{
					"sTitle" : "部门编号",
					"mData" : "depa_no"
				},{
					"sTitle" : "部门级别",
					"mData" : "grad_grade_name"
				},{
					"sTitle" : "父部门名称",
					"mData" : "parent_depa_name"
				},{
					"sTitle" : "父部门编号",
					"mData" : "parent_depa_no"
				},{
					"sTitle" : "操作",
					"mData" : "depa_id",
					"mRender" : function(data, type, full){
							return '<a depa_id="'+full.depa_id+'" class="btn btn-xs default toModel">编辑</a>';
					}
				}];
	var dataTable;
	var initDataTableAjax = function(){
		dataTable=DataTableAjax.init("#adminDepartmentList", "admin/department/getDepartmentList", aoData);
	};

	var departmentInfoModel =function(depa_id) {
		var $modal = $('#departmentInfo');
		$('body').modalmanager('loading');
		if(typeof(depa_id)=="undefined"){
			$modal.load("admin/department/toAddOrEidtDepartment?"+Math.random(), '', function(){
				$modal.modal();
			});
		}else{
			
			$modal.load("admin/department/toAddOrEidtDepartment?"+Math.random()+"&depaId="+depa_id, '', function(){
				$modal.modal();
			});
		
			
		}
    };
    
    var initEvent = function() {
    	
		$('#uploadDepartmentExcelFileSubmit').on('click', function(e){
			var fileName=$("#uploadDepartmentFile").val();
			//判断是否选择文件
			if(fileName!=''){
				var fileSuffix=fileName.substring(fileName.lastIndexOf(".")+1);
				//判断文件格式
				if(fileSuffix=='xls'){
					 Metronic.blockUI({
		                target: '#uploadDepartmentExcelFile',
		                boxed: true,
		                message: '正在导入...'
		            });
		
					$.ajaxFileUpload({
						type : "post",
						cache : false,
		                url: 'admin/department/uploadDepartmentExcelFile', //用于文件上传的服务器端请求地址
		                secureuri: false, //是否需要安全协议，一般设置为false
		                fileElementId: 'uploadDepartmentFile', //文件上传域的ID
		                dataType: 'text', //返回值类型 一般设置为json，要大写
		                success: function (response)  //服务器成功响应处理函数
		                {
				            Metronic.unblockUI('#uploadDepartmentExcelFile');
				            if(response=="success"){
					            $('#uploadDepartmentExcelFile').modal('hide');
								dataTable.addAjaxParam("iTotalRows", '0');
								dataTable.getDataTable().fnDraw();
				            }else{
				            	alert(response);
				            }
				            reCreateFileStyle();
		                },
		                error: function (response, status, e)//服务器响应失败处理函数
		                {
		                	Metronic.unblockUI('#uploadDepartmentExcelFile');
		                    alert("上传异常：" + e);
		                }
		            });
				}else{
					alert("请选择格式为XLS文件");
				}
			}else{
				alert("请选择文件");
			}
		});
		
	  	//添加部门
    	$('#addDepartment').on('click', function(e){
    		departmentInfoModel();
    	});
    	//注册编辑事件
    	$("#adminDepartmentList").on("click", '.toModel', function(){
    		var depa_id = $(this).attr('depa_id');
	 		departmentInfoModel(depa_id);
	 	});
	};
	
	/** 销毁filestyle，然后重新创建*/
	var reCreateFileStyle = function(){
		$(":file").filestyle('destroy');
		$(":file").filestyle({buttonText: "选择"});
	};
	
	//初始化上传文件控件样式
	var initFilestyle=function(){
		$(":file").filestyle({icon: true,buttonText:'选择'});
	};
	
	return {
		init : function(){
			initDataTableAjax();
			initFilestyle();
			initEvent();
		},
		getDataTableObject: function(){
			return  dataTable;
		}
	};
});