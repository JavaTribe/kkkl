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

		// PAGE LEVEL SCRIPTS
		"datatable" : "../scripts/datatable",
		"datatable_ajax" : "../../custom/scripts/common/datatable-ajax",
		"user_account_list_init" : "../../custom/scripts/admin/manageuseraccount/user_account_list_init",
		"button_click_event" : "../../custom/scripts/common/button_click_event"
	},

	shim : {
		"DT_bootstrap" : {
			deps : ["jquery_dataTables"]
		},
		"bootstrap_modal" : {
			deps : ["bootstrap_modalmanager"]
		},
		"datatable_ajax" : {
			deps : ["jquery_dataTables","DT_bootstrap", "datatable"],
			exports : "DataTableAjax"
		},
		"bootstrap_filestyle" : {
			deps : ["jquery"],
			exports : "bootstrapFilestyle"
		},
		"user_account_list_init" : {
			deps : ["datatable_ajax"],
			exports : "UserAccountListInit"
		},
		"ajaxfileupload" : {
			deps : ["jquery"],
			exports : "AjaxFileUpload"
		},
		"button_click_event" : {
			deps : ["datatable_ajax"],
			exports : "buttonClickEvent"
		}
	}

});

require(["jquery", "user_account_list_init", "button_click_event", "bootstrap_modal","bootstrap_filestyle","jquery_blockui"],
		function($, UserAccountListInit, buttonClickEvent) {
			$(document).ready(function() {
				UserAccountListInit.init();
			});

		});