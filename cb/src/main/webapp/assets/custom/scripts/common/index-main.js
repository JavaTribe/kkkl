/*!
 * 
 */
require.config({
	baseUrl: 'assets/global/plugins',
	
	paths: {
		scripts: '../scripts',
		
		"jquery": 'jquery-1.11.0.min',
		"jquery_migrate": 'jquery-migrate-1.2.1.min',
		"jquery_ui": 'jquery-ui/jquery-ui-1.10.3.custom.min',
		"bootstrap": 'bootstrap/js/bootstrap.min',
		"bootstrap_hover_dropdown": 'bootstrap-hover-dropdown/bootstrap-hover-dropdown.min',
		"jquery_slimscroll": 'jquery-slimscroll/jquery.slimscroll.min',
		"jquery_blockui": 'jquery.blockui.min',
		"jquery_cokie": 'jquery.cokie.min',
		"jquery_uniform": 'uniform/jquery.uniform.min',
		"bootstrap_select" : "bootstrap-select/bootstrap-select.min",
		
		// CUSTOM PLUGINS
		"jquery_placeholder" : "../../custom/plugins/jquery.placeholder",
		
		"metronic": '../scripts/metronic',
		"layout": '../layout/scripts/layout'
    },

	shim: {
		"bootstrap_select" : {
			deps: ['jquery']
		},
		"jquery_placeholder" : {
			deps: ['jquery']
		},
		"jquery_migrate" : {
			deps: ['jquery']
		},
		"jquery_ui" : {
			deps: ['jquery']
		},
		"bootstrap" : {
			deps: ['jquery', 'jquery_ui']
		},
		"bootstrap_hover_dropdown" : {
			deps: ['jquery', 'bootstrap']
		},
		"jquery_slimscroll" : {
			deps: ['jquery']
		},
		"jquery_blockui" : {
			deps: ['jquery']
		},
		"jquery_cokie" : {
			deps: ['jquery']
		},
		"jquery_uniform" : {
			deps: ['jquery']
		},
		"jquery" : {
			exports: "$"
		},
		
		"metronic" : {
			deps: ['jquery_slimscroll'],
			exports: "Metronic"
		}
	}
});

require([ "jquery", "metronic", "layout", "jquery_migrate", "jquery_ui",
		"bootstrap", "bootstrap_hover_dropdown", "jquery_blockui",
		"jquery_cokie", "jquery_uniform", "jquery_placeholder","bootstrap_select"], function($) {
	
	$(document).ready(function() {
		Metronic.init(); // init metronic core components
		Layout.init(); // init current layout
		$("#homePage").click();
	});
	
});