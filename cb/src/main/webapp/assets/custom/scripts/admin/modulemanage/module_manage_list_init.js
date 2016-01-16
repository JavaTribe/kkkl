define(['datatable_ajax'], function(DataTableAjax) {

	var aoData = [
				{
				"sTitle" : '<input type="checkbox" class="group-checkable">',
				"mData" : "modu_id",
				"mRender" : function(data, type, full){
					return '<input type="checkbox" name="modu_id" value="'+ full.modu_id +'">';
				}},
				{
					"sTitle" : "模块名称",
					"mData" : "modu_name"
				},{
					"sTitle" : "父模块名称",
					"mData" : "pamo_name"
				},{
					"sTitle" : "模块URL",
					"mData" : "modu_url"
				},{
					"sTitle" : "模块权限",
					"mData" : "modu_resource"
				},{
					"sTitle" : "模块状态",
					"mData" : "modu_use_status",
					"mRender" : function(data, type, full){
						if(data === 0) {
							return '<span class="label label-danger"> 关闭 </span>';
						}
						else {
							return '<span class="label label-success"> 启用 </span>';
						}
					}
				},{
					"sTitle" : "排序",
					"mData" : "modu_sort"
				},{
					"sTitle" : "操作",
					"mData" : "modu_id",
					"mRender" : function(data, type, full){
							return '<a moduId="'+full.modu_id+'" class="btn btn-xs default toModel">编辑</a>';
					}
				}];
	var dataTable;
	var initDataTableAjax = function(){
		dataTable=DataTableAjax.init("#adminModuleManageList", "admin/moduleManage/getModuleManageList", aoData);
	};
    
	var moduleManageModel =function(moduId) {
		var $modal = $('#moduleModel');
		$('body').modalmanager('loading');
		if(typeof(moduId)=="undefined"){
			$modal.load("admin/moduleManage/toModuleManageAddOREdit?"+Math.random(), '', function(){
				$modal.modal();
			});
		}else{
			$modal.load("admin/moduleManage/toModuleManageAddOREdit?"+Math.random()+"&moduId="+moduId, '', function(){
				$modal.modal();
			});
		
		}
    };
    
    
     var initEvent = function () {
    	//添加模块
    	$('#addModuleManage').on('click', function(e){
    		moduleManageModel();
    	});
    	//注册编辑事件
    	$("#adminModuleManageList").on("click", '.toModel', function(){
    		var moduId = $(this).attr('moduId');
	 		moduleManageModel(moduId);
	 	});
    };
	
	return {
		init : function(){
			initDataTableAjax();
			initEvent();
		},
		getDataTableObject: function(){
			return  dataTable;
		}
	};
});