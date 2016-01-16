requirejs.config({
	baseUrl : "assets/global/plugins",
    waitSeconds: 0,
	paths : {
		"jquery_dataTables" : "data-tables/jquery.dataTables.min",
		"DT_bootstrap" : "data-tables/DT_bootstrap",
		"datatable" : "../scripts/datatable",
		"datatable_ajax" : "../../custom/scripts/common/datatable-ajax",
		"bootstrap_modalmanager" : "bootstrap-modal/js/bootstrap-modalmanager",
		"bootstrap_modal" : "bootstrap-modal/js/bootstrap-modal",
		"module_manage_list_init" : "../../custom/scripts/admin/modulemanage/module_manage_list_init"
	},

	shim : {
		"DT_bootstrap" : {
			deps : ["jquery_dataTables"]
		},
		"datatable_ajax" : {
			deps : ["DT_bootstrap", "datatable"],
			exports : "DataTableAjax"
		},
		"bootstrap_modal" : {
			deps : ["bootstrap_modalmanager"]
		},
		"module_manage_list_init" : {
			deps : ["datatable_ajax"],
			exports : "ModuleManageListInit"
		}
	}

});

require(["jquery", "module_manage_list_init","bootstrap_modal"],
		function($, ModuleManageListInit) {
			$(document).ready(function() {
				ModuleManageListInit.init();
			});

		});