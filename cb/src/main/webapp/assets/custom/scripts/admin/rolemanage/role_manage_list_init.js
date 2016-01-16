define(['datatable_ajax'], function(DataTableAjax) {

	var aoData = [
				{
				"sTitle" : '<input type="checkbox" class="group-checkable">',
				"mData" : "roleId",
				"mRender" : function(data, type, full){
					return '<input type="checkbox" name="roleId" value="'+ data +'">';
				}},
				{
					"sTitle" : "角色名称",
					"mData" : "roleName"
				},{
					"sTitle" : "描述",
					"mData" : "roleDescribe"
				},{
					"sTitle" : "启用状态",
					"mData" : "roleUseStatus",
					"mRender" : function(data, type, full){
						if(data === 0) {
							return '<span class="label label-danger"> 关闭 </span>';
						}
						else {
							return '<span class="label label-success"> 启用 </span>';
						}
					}
				},{
					"sTitle" : "角色类型",
					"mData" : "roleType",
					"mRender" : function(data, type, full){
						if(data === 0) {
							return '办事员';
						}
						else if(data === 1){
							return '科级';
						}
						else if(data === 2){
							return '处级';
						}
						else if(data === 3){
							return '司级';
						}
						else {
							return '管理员';
						}

					}
				},{
					"sTitle" : "操作",
					"mData" : "roleId",
					"mRender" : function(data, type, full){
							return '<a href="admin/roleManage/toRoleManageAddOREdit?editRoleId='+full.roleId+'" class="btn btn-xs default ajaxify">编辑</a>';
					}
				}];
	var initDataTableAjax = function(){
		DataTableAjax.init("#adminRoleManageList", "admin/roleManage/getRoleManageList", aoData);
	};
    
    var initEvent = function() {
		$('#uploadExcelFileSubmit').on('click', function(e){
			FormFileUpload.ajaxSubmitModelFile("#uploadExcelFileFrom","#uploadExcelFileSubmit","uploadExcelFileInput");
		});
	  	
	};
	
	return {
		init : function(){
			initDataTableAjax();
			initEvent();
		}
	};
});