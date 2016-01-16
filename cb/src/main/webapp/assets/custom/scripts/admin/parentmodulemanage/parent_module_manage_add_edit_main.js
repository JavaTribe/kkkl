requirejs.config({
	baseUrl : "assets/global/plugins",
    waitSeconds: 0,
	paths : {
		"jquery_validate" : "jquery-validation/js/jquery.validate.min",
		"jquery_validator_messages" : "../scripts/jquery.validator.messages",
		"bootstrap_select" : "bootstrap-select/bootstrap-select.min",
		"parent_module_manage_add_edit_init" : "../../custom/scripts/admin/parentmodulemanage/parent_module_manage_add_edit_init",
		"parent_module_manage_list_init" : "../../custom/scripts/admin/parentmodulemanage/parent_module_manage_list_init"
	},

	shim : {
		
		"jquery_validate" : {
			deps : ['jquery']
		},
		"jquery_validator_messages" : {
			deps : ["jquery_validate"]
		},
		"parent_module_manage_list_init" : {
			deps : ["datatable_ajax"],
			exports : "ParentModuleManageListInit"
		},
		"parent_module_manage_add_edit_init" : {
			deps : ["datatable_ajax","jquery_validator_messages","parent_module_manage_list_init"],
			exports : "ParentModuleManageAddEditInit"
		}
	}

});

require(["jquery", "parent_module_manage_add_edit_init", "bootstrap_select"],
		function($, ParentModuleManageAddEditInit) {
			$(document).ready(function() {
				ParentModuleManageAddEditInit.init();
			});

		});