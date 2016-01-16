requirejs.config({
	baseUrl : "assets/global/plugins",
    waitSeconds: 0,
	paths : {
		// CORE PLUGINS
		//"jquery" : "jquery-1.11.0.min",
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
		"edit_user_account_init" : "../../custom/scripts/admin/manageuseraccount/edit_user_account_init"
	},

	shim : {
		"bootstrap_modal" : {
			deps : ["bootstrap_modalmanager"]
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
		"edit_user_account_init" : {
			exports : "editUserAccountInit"
		}
	}

});

require(["jquery", "edit_user_account_init", "bootstrap_modal","bootstrap_filestyle","jquery_blockui",
         "jquery_validator_messages", "jquery_placeholder"],
		function($, editUserAccountInit) {
			$(document).ready(function() {
				Metronic.init();
				editUserAccountInit.init();
			});

		});