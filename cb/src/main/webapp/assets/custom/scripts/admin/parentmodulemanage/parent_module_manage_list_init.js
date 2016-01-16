define(['datatable_ajax'], function(DataTableAjax) {

	var aoData = [
				{
				"sTitle" : '<input type="checkbox" class="group-checkable">',
				"mData" : "pamo_id",
				"mRender" : function(data, type, full){
					return '<input type="checkbox" name="pamo_id" value="'+ full.pamo_id +'">';
				}},{
					"sTitle" : "父模块名称",
					"mData" : "pamo_name"
				},{
					"sTitle" : "模块描述",
					"mData" : "pamo_describe"
				},{
					"sTitle" : "模块状态",
					"mData" : "pamo_use_status",
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
					"mData" : "pamo_sort"
				},{
					"sTitle" : "图标样式",
					"mData" : "pamo_icon"
				},{
					"sTitle" : "操作",
					"mData" : "pamo_id",
					"mRender" : function(data, type, full){
							return  '<a pamoId="'+full.pamo_id+'" class="btn btn-xs default toModel">编辑</a>';
					}
				}];
				
	var dataTable;
	var initDataTableAjax = function(){
		dataTable=DataTableAjax.init("#adminParentModuleManageList", "admin/parentModuleManage/getParentModuleManageList", aoData);
	};
	
	var parentModuleManageModel =function(pamoId) {
		var $modal = $('#parentModuleModel');
		$('body').modalmanager('loading');
		if(typeof(pamoId)=="undefined"){
			$modal.load("admin/parentModuleManage/toParentModuleManageAddOREdit?"+Math.random(), '', function(){
				$modal.modal();
			});
		}else{
			$modal.load("admin/parentModuleManage/toParentModuleManageAddOREdit?"+Math.random()+"&pamoId="+pamoId, '', function(){
				$modal.modal();
			});
		
		}
    };
    
     var initEvent = function () {
    	//添加父模块
    	$('#addParentModuleManage').on('click', function(e){
    		parentModuleManageModel();
    	});
    	//注册编辑事件
    	$("#adminParentModuleManageList").on("click", '.toModel', function(){
    		var pamoId = $(this).attr('pamoId');
	 		parentModuleManageModel(pamoId);
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