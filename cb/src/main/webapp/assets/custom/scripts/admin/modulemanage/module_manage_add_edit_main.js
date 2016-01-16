requirejs.config({
	baseUrl : "assets/global/plugins",
    waitSeconds: 0,
	paths : {
		"jquery_validate" : "jquery-validation/js/jquery.validate.min",
		"jquery_validator_messages" : "../scripts/jquery.validator.messages",
		"module_manage_add_edit_init" : "../../custom/scripts/admin/modulemanage/module_manage_add_edit_init",
		"module_manage_list_init" : "../../custom/scripts/admin/modulemanage/module_manage_list_init"
	},

	shim : {
		
		"jquery_validate" : {
			deps : ['jquery']
		},
		"jquery_validator_messages" : {
			deps : ["jquery_validate"]
		},
		"module_manage_list_init" : {
			deps : ["datatable_ajax"],
			exports : "ModuleManageListInit"
		},
		"module_manage_add_edit_init" : {
			deps : ["datatable_ajax","jquery_validator_messages","module_manage_list_init"],
			exports : "ModuleManageAddEditInit"
		}
	}

});

require(["jquery", "module_manage_add_edit_init"],
		function($, ModuleManageAddEditInit) {
			$(document).ready(function() {
				ModuleManageAddEditInit.init();
			});

		});