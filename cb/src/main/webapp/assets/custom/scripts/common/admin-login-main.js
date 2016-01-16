requirejs.config({
	baseUrl : "assets/global",
    waitSeconds: 0,
	paths : {
		// CORE PLUGINS
		"jquery" : "plugins/jquery-1.11.0.min",
		"jquery_migrate" : "plugins/jquery-migrate-1.2.1.min",
		"bootstrap" : "plugins/bootstrap/js/bootstrap.min",
		"bootstrap_hover_dropdown" : "plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min",
		"jquery_slimscroll" : "plugins/jquery-slimscroll/jquery.slimscroll.min",
		"jquery_blockui" : "plugins/jquery.blockui.min",
		"jquery_cokie" : "plugins/jquery.cokie.min",
		"jquery_uniform" : "plugins/uniform/jquery.uniform.min",
		"bootstrap_modalmanager" : "plugins/bootstrap-modal/js/bootstrap-modalmanager",
		"bootstrap_modal" : "plugins/bootstrap-modal/js/bootstrap-modal",

		// PAGE LEVEL PLUGINS
		"jquery_backstretch" : "plugins/backstretch/jquery.backstretch.min",
		"jquery_validate" : "plugins/jquery-validation/js/jquery.validate.min",

		// PAGE LEVEL SCRIPTS
		"metronic" : "scripts/metronic",
		"layout" : "layout/scripts/layout",
		"admin_login_init" : "../custom/scripts/common/admin_login_init"
	},
	shim : {
		"jquery_migrate" : {
			deps : ['jquery']
		},
		"bootstrap" : {
			deps : ['jquery']
		},
		"bootstrap_hover_dropdown" : {
			deps : ['jquery', 'bootstrap']
		},
		"jquery_slimscroll" : {
			deps : ['jquery']
		},
		"jquery_blockui" : {
			deps : ['jquery']
		},
		"jquery_cokie" : {
			deps : ['jquery']
		},
		"jquery_uniform" : {
			deps : ['jquery']
		},
		"jquery_backstretch" : {
			deps : ['jquery']
		},
		"jquery_validate" : {
			deps : ['jquery']
		},

		"jquery" : {
			exports : "$"
		},
		"metronic" : {
			deps : ['jquery_slimscroll'],
			exports : "Metronic"
		},
		"bootstrap_modal" : {
			deps : ["bootstrap_modalmanager"]
		},
		"admin_login_init" : {
			deps : ['metronic'],
			deps : ['jquery'],
			deps : ['bootstrap_modal'],
			exports : "AdminLoginInit"
		}
	}
});

require(["jquery", "admin_login_init", "metronic", "jquery_backstretch", "jquery_validate",
				"layout", "jquery_migrate", "bootstrap",
				"bootstrap_hover_dropdown", "jquery_slimscroll",
				"jquery_cokie", "jquery_uniform"], function($, AdminLoginInit) {

	$(document).ready(function() {
		Metronic.init(); // init metronic core components
		Layout.init(); // init current layout
		AdminLoginInit.init();
	});
});