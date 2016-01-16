requirejs.config({
	baseUrl : "assets/global",
    waitSeconds: 0,
	paths : {
		"bootstrap_switch" : "plugins/bootstrap-switch/js/bootstrap-switch.min"
	}
});

require(["jquery", "bootstrap_switch"], 
		function($) {
			$(document).ready(function() {
				Metronic.init();
				$("#updateProcessdeFinitionStatus").on('click', function(e) {
					e.preventDefault();
					Layout.ajaxSubmit("#processDefinition", "#updateProcessdeFinitionStatus");
				});
			});
	});