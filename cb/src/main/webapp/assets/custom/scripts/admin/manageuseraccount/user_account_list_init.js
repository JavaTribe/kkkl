define(['datatable_ajax', 'button_click_event' ,'ajaxfileupload'], 
		function(DataTableAjax, buttonClickEvent) {

	var aoData = [
				{
				"sTitle" : '<input type="checkbox" class="group-checkable">',
				"mData" : "usba_id",
				"mRender" : function(data, type, full){
					return '<input type="checkbox" name="usba_id" value="'+ data +'">';
				}},
				{
					"sTitle" : "部门名称",
					"mData" : "depa_name"
				},{
					"sTitle" : "用户账号",
					"mData" : "usba_account"
				},{
					"sTitle" : "用户名称",
					"mData" : "usba_name"
				},{
					"sTitle" : "启用状态",
					"mData" : "usba_account_enable",
					"mRender" : function(data, type, full){
						if(data === 0) {
							return '<span class="label label-danger"> 禁用 </span>';
						}
						else {
							return '<span class="label label-success"> 启用 </span>';
						}
					}
				},{
					"sTitle" : "锁定状态",
					"mData" : "usba_account_locked",
					"mRender" : function(data, type, full){
						if(data === 0) {
							return '<span class="label label-danger">锁定 </span>';
						}
						else {
							return '<span class="label label-success">开放 </span>';
						}
					}
				},{
					"sTitle" : "操作",
					"mData" : "usba_id",
					"mRender" : function(data, type, full){
						return '<a href="admin/manageUserAccount/toEditUserAccount/'+data+'" class="btn btn-xs default ajaxify">编辑</a>'+
						'<a href="admin/manageUserAccount/toEditUserRole/'+data+'" class="btn btn-xs default ajaxify">角色</a>';
					}
				}];
	var dataTable;
	var initDataTableAjax = function(){
		dataTable=DataTableAjax.init("#adminUserAccountList", "admin/manageUserAccount/getUserAccountList", aoData);
	};
    
    var initEvent = function() {
    	
		$('#uploadUserAccountExcelFileSubmit').on('click', function(e){
			var fileName=$("#uploadUserAccountFile").val();
			//判断是否选择文件
			if(fileName!=''){
				var fileSuffix=fileName.substring(fileName.lastIndexOf(".")+1);
				//判断文件格式
				if(fileSuffix=='xls'){
					 Metronic.blockUI({
		                target: '#uploadUserAccountExcelFile',
		                boxed: true,
		                message: '正在导入...'
		            });
		
					$.ajaxFileUpload({
						type : "post",
						cache : false,
		                url: 'admin/manageUserAccount/uploadUserAccountExcelFile', //用于文件上传的服务器端请求地址
		                secureuri: false, //是否需要安全协议，一般设置为false
		                fileElementId: 'uploadUserAccountFile', //文件上传域的ID
		                dataType: 'text', //返回值类型 一般设置为json，要大写
		                success: function (response)  //服务器成功响应处理函数
		                {
				            Metronic.unblockUI('#uploadUserAccountExcelFile');
				            if(response=="success"){
					            $('#uploadUserAccountExcelFile').modal('hide');
								dataTable.addAjaxParam("iTotalRows", '0');
								dataTable.getDataTable().fnDraw();
				            }else{
		                    	alert("上传出错，检查是否上传内容有误或已存在账号");
				            }
				            reCreateFileStyle();
		                },
		                error: function (response, status, e)//服务器响应失败处理函数
		                {
		                	Metronic.unblockUI('#uploadUserAccountExcelFile');
		                    alert("上传异常");
				            reCreateFileStyle();
		                }
		            });
				}else{
					alert("请选择格式为XLS文件");
				}
			}else{
				alert("请选择文件");
			}
		});
	};
	
	/** 启用所有的用户账号 */
	var activateAllUserAccountBtn = function(){
		$('#activateAllUserAccountBtn').on('click', function(e){
			e.preventDefault();
			ButtonClickEvent.btnClick("#activateAllUserAccountBtn",".table-container");
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
			initEvent();
			activateAllUserAccountBtn();
			initFilestyle();
		},
		getDataTableObject: function(){
			return  dataTable;
		}
	};
});