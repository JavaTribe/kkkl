requirejs.config({
	baseUrl : "assets/global/plugins",
    waitSeconds: 0,
	paths : {
		// CORE PLUGINS
		//"jquery" : "jquery-1.11.0.min",
		"jquery_dataTables" : "data-tables/jquery.dataTables.min",
		"DT_bootstrap" : "data-tables/DT_bootstrap",
		"bootstrap_modalmanager" : "bootstrap-modal/js/bootstrap-modalmanager",
		"bootstrap_modal" : "bootstrap-modal/js/bootstrap-modal",
		"bootstrap_filestyle" : "../../custom/plugins/bootstrap-filestyle/bootstrap-filestyle.min",
		"ajaxfileupload" : "../../custom/plugins/ajaxfileupload",
		"jquery_chained" : "../../custom/plugins/jquery-chained/jquery.chained.min",

		// PAGE LEVEL SCRIPTS
		"datatable" : "../scripts/datatable",
		"datatable_ajax" : "../../custom/scripts/common/datatable-ajax",
		"form_file_upload" : "../../custom/scripts/common/form_file_upload",
		"department_list_init" : "../../custom/scripts/admin/department/department_list_init"
	},

	shim : {
		"DT_bootstrap" : {
			deps : ["jquery_dataTables"]
		},
		"bootstrap_modal" : {
			deps : ["bootstrap_modalmanager"]
		},
		"datatable_ajax" : {
			deps : ["DT_bootstrap", "datatable"],
			exports : "DataTableAjax"
		},
		"bootstrap_filestyle" : {
			deps : ["jquery"],
			exports : "bootstrapFilestyle"
		},
		"jquery_chained" : {
			deps : ["jquery"],
			exports : "JqueryChained"
		},
		"department_list_init" : {
			deps : ["datatable_ajax"],
			exports : "DepartmentListInit"
		},
		"ajaxfileupload" : {
			deps : ["jquery"],
			exports : "AjaxFileUpload"
		},
		"form_file_upload":{
			deps : ["ajaxfileupload","jquery_blockui"],
			exports : "FormFileUpload"
		}

	}

});

require(["jquery", "department_list_init", "bootstrap_modal","bootstrap_filestyle","form_file_upload","jquery_chained"],
		function($, DepartmentListInit) {
			$(document).ready(function() {
				Metronic.init();
				DepartmentListInit.init();
			});

		});