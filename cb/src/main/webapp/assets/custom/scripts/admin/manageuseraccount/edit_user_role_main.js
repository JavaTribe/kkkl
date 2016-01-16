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
		"jquery_validate" : "jquery-validation/js/jquery.validate.min",

		// CUSTOM PLUGINS
		"jquery_placeholder" : "../../custom/plugins/jquery.placeholder",
		"jquery_validator_messages" : "../scripts/jquery.validator.messages",

		// PAGE LEVEL SCRIPTS
		"datatable" : "../scripts/datatable",
		"datatable_ajax" : "../../custom/scripts/common/datatable-ajax",
		"edit_user_role_init" : "../../custom/scripts/admin/manageuseraccount/edit_user_role_init"
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
		"ajaxfileupload" : {
			deps : ["jquery"],
			exports : "AjaxFileUpload"
		},
		"jquery_blockui":{
			deps : ["jquery"],
			exports : "JqueryBlockui"
		},
		"jquery_validator_messages" : {
			deps : ["jquery_validate"]
		},
		"edit_user_role_init" : {
			exports : "editUserRoleInit"
		}
	}

});

require(["jquery", "edit_user_role_init", "bootstrap_modal","bootstrap_filestyle","jquery_blockui",
         "jquery_validator_messages", "jquery_placeholder"],
		function($, editUserRoleInit) {
			$(document).ready(function() {
				Metronic.init();
				editUserRoleInit.init();
			});

		});