define(['bootstrap_modalmanager'],function() {

	var loginAjax = function() {
		$("#usernameError").hide();
		$("#captchaError").hide();
		$.ajax({
			type : "post",
			url : "admin/j_spring_security_check",
			dataType : "json",
			data : $(".login-form").serializeArray(),
			success : function(res) {
				if(res.message === "captchaError"){
					$("#captchaError").show();
				}
				if(res.message === "usernameError"){
					$("#usernameError").show();
				}
				if(res.message === "success"){
					window.location.href=res.address;
					return ;
				}
				if(res.message === "chooseRole"){
					var $modal = $('#chooseRole');
					// create the backdrop and wait for next modal to be triggered
					Metronic.stopPageLoading();
					$('body').modalmanager('loading');
					$modal.load(res.address+'?'+Math.random(), '', function(){
						$modal.modal();
					});
					return;
				}
				$("#captcha").click();
				$("#kaptcha").val("");
				Metronic.stopPageLoading();
			},
			error : function(xhr, ajaxOptions, thrownError) {
				Metronic.stopPageLoading();
			}
		});
	};

	var handleLogin = function() {
		$('.login-form').validate({
					errorElement : 'span', // default input error message
					// container
					errorClass : 'help-block', // default input error message
					// class
					focusInvalid : false, // do not focus the last invalid
					// input
					rules : {
						j_username : {
							required : true
						},
						j_password : {
							required : true
						},
//						challenge : {
//							required : true
//						},
						remember : {
							required : false
						}
					},

					messages : {
						j_username : {
							required : "请输入您的用户名"
						},
						j_password : {
							required : "请输入您的密码"
						},
						kaptcha : {
							required : "请输入验证码"
						}
					},

					highlight : function(element) { // hightlight error inputs
						$(element).closest('.form-group').addClass('has-error'); // set
					},

					success : function(label) {
						label.closest('.form-group').removeClass('has-error');
						label.remove();
					},

					errorPlacement : function(error, element) {
						error.insertAfter(element.closest('.input-icon'));
					}
				});

	};

	var handleForgetPassword = function() {
		$('.forget-form').validate({
					errorElement : 'span', // default input error message
					// container
					errorClass : 'help-block', // default input error message
					// class
					focusInvalid : false, // do not focus the last invalid
					// input
					ignore : "",
					rules : {
						email : {
							required : true,
							email : true
						}
					},

					messages : {
						email : {
							required : "请输入您的邮箱",
							email : "请输入正确格式的邮箱"
						}
					},

					invalidHandler : function(event, validator) { // display
					},

					highlight : function(element) { // hightlight error inputs
						$(element).closest('.form-group').addClass('has-error'); // set
					},

					success : function(label) {
						label.closest('.form-group').removeClass('has-error');
						label.remove();
					},

					errorPlacement : function(error, element) {
						error.insertAfter(element.closest('.input-icon'));
					},

					submitHandler : function(form) {
						form.submit();
					}
				});

		jQuery('#forget-password').on('click', function() {
					jQuery('.login-form').hide();
					jQuery('.forget-form').show();
				});

		jQuery('#back-btn').on('click', function() {
					jQuery('.login-form').show();
					jQuery('.forget-form').hide();
				});

	};

	var initBackgroud = function() {
		$.backstretch(["assets/custom/img/bg/1.jpg",
				"assets/custom/img/bg/2.jpg",
				"assets/custom/img/bg/3.jpg",
				"assets/custom/img/bg/4.jpg"], {
			fade : 1000,
			duration : 8000
		});
	};
	
	
	var initSubmit = function() {
		$("#loginButton").on('click', function() {
			if ($(".login-form").valid()) {
				Metronic.startPageLoading();
				loginAjax();
			}
		});
		$('.login-form input').keypress(function(e) {
			if (e.which == 13) {
				if ($('.login-form').valid()) {
					Metronic.startPageLoading();
					loginAjax();
				}
				return false;
			}
		});
		$('.forget-form input').keypress(function(e) {
			if (e.which == 13) {
				if ($('.forget-form').validate().form()) {
					$('.forget-form').submit();
				}
				return false;
			}
		});
	};
	
	return {
		// main function to initiate the module
		init : function() {
			handleLogin();
			handleForgetPassword();
			initBackgroud();
			initSubmit();
		}
	};

});
