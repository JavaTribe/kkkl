requirejs.config({
	baseUrl : "assets/global/plugins",
    waitSeconds: 0,
	paths : {
		"bootstrap_modalmanager" : "bootstrap-modal/js/bootstrap-modalmanager",
		"jquery_validate" : "jquery-validation/js/jquery.validate.min",
		"bootstrap_select" : "bootstrap-select/bootstrap-select.min",
		"jquery_placeholder" : "../../custom/plugins/jquery.placeholder",
		"jquery_validator_messages" : "../scripts/jquery.validator.messages",
		"role_manage_add_edit_init" : "../../custom/scripts/admin/rolemanage/role_manage_add_edit_init"
	},

	shim : {

		"jquery_validator_messages" : {
			deps : ["jquery_validate"]
		},
		"role_manage_add_edit_init" : {
			deps : ["jquery_validator_messages"],
			exports : "RoleManageAddEditInit"
		}
	}

});

require(["jquery", "role_manage_add_edit_init", "bootstrap_select", 
				"jquery_placeholder"], function($, RoleManageAddEditInit) {
			$(document).ready(function() {
				Metronic.init();
				RoleManageAddEditInit.init();
			});
		});