define(['datatable_ajax'],function(DataTableAjax) {	
	
	var aoData = [
	{
		"sTitle" : '<input type="checkbox" class="group-checkable">',
		"mData" : "usro_id",
		"mRender" : function(data, type, full){
			return '<input type="checkbox" name="usba_id" value="'+ data +'">';
		}
	}, {
		"sTitle" : "角色名称",
		"mData" : "role_name"
	},{
		"sTitle" : "部门",
		"mData" : "depa_name"
	},{
		"sTitle" : "创建时间",
		"mData" : "usro_create_date"
	},{
		"sTitle" : "状态",
		"mData" : "usro_status",
		"mRender" : function(data, type, full){
			var str = '';
			if(data == 0 || data==1){
				str = '<span class="label label-warning">未启用</span>';
			}
			else if(data == 2){
				str = '<span class="label label-success">启用</span>';
			}
			
			return str;
		}
	}];
	var dataTable = null;
	var initDataTableAjax = function(){
		var usbaId = $('#usbaId').val();
		dataTable=DataTableAjax.init("#userRoleList", "admin/manageUserAccount/getUserRoleList/"+usbaId, aoData);
	};
	
	var initAddUserRoleModel = function(){
		$('#addUserRoleSubmit').on('click', function(){
			Layout.ajaxSubmitModel("#addUserRoleForm", "#addUserRoleSubmit",function(){
				dataTable.addAjaxParam("iTotalRows", '0');
				dataTable.getDataTable().fnDraw();
				dataTable.clearAjaxParams();
				$('#addUserRoleModel').modal('hide');
			});
		});
	};
		
	return { 
		init : function(){;
			initDataTableAjax();
			initAddUserRoleModel();
		}
	};
});