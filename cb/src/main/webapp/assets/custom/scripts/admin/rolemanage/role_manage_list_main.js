requirejs.config({
	baseUrl : "assets/global/plugins",
    waitSeconds: 0,
	paths : {
		"jquery_dataTables" : "data-tables/jquery.dataTables.min",
		"DT_bootstrap" : "data-tables/DT_bootstrap",
		"datatable" : "../scripts/datatable",
		"datatable_ajax" : "../../custom/scripts/common/datatable-ajax",
		"role_manage_list_init" : "../../custom/scripts/admin/rolemanage/role_manage_list_init"
	},

	shim : {
		"DT_bootstrap" : {
			deps : ["jquery_dataTables"]
		},
		"datatable_ajax" : {
			deps : ["DT_bootstrap", "datatable"],
			exports : "DataTableAjax"
		},
		"role_manage_list_init" : {
			deps : ["datatable_ajax"],
			exports : "RoleManageListInit"
		}

	}

});

require(["jquery", "role_manage_list_init"],
		function($, RoleManageListInit) {
			$(document).ready(function() {
				RoleManageListInit.init();
			});

		});