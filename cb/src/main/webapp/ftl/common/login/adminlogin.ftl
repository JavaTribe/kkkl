<!DOCTYPE html>
<!-- BEGIN HEAD -->
<head>
	
	<base href="${base}/">
	<meta charset="utf-8" />
	<title>蓝盾股份运维管理系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!--[if IE 8]> <html lang="zh" class="ie8 no-js"> <![endif]-->
	<!--[if IE 9]> <html lang="zh" class="ie9 no-js"> <![endif]-->
	<!--[if !IE]><!-->
	<html lang="zh" class="no-js">
	<!--<![endif]-->
	<meta name="renderer" content="webkit">
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<script type="text/javascript"> 
		<!-- 
		javascript:window.history.forward(1); 
		//--> 
	</script>
	<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
	<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="assets/custom/css/common/login-soft.css" rel="stylesheet" type="text/css" />
	<link href="assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
	<link href="assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
	<!-- END PAGE LEVEL SCRIPTS -->
	<!-- BEGIN THEME STYLES -->
	<link href="assets/global/css/components.css" rel="stylesheet" type="text/css" />
	<link href="assets/global/css/plugins.css" rel="stylesheet" type="text/css" />
	<link href="assets/global/layout/css/layout.css" rel="stylesheet" type="text/css" />
	<link id="style_color" href="assets/global/layout/css/themes/default.css" rel="stylesheet" type="text/css" />
	<!-- END THEME STYLES -->
	<link rel="shortcut icon" href="favicon.ico" />
	
	</head>
	<!-- END HEAD -->
	<!-- BEGIN BODY -->
	<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
	<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
	<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
	<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
	<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
	<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
	<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
	<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
	<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
	<body class="login">
		<!-- BEGIN LOGO -->
		<div class="logo">
		</div>
		<!-- END LOGO -->
		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
		<div class="menu-toggler sidebar-toggler"></div>
		<!-- END SIDEBAR TOGGLER BUTTON -->
		<!-- BEGIN LOGIN -->
		<div class="content">
			<!-- BEGIN LOGIN FORM -->
			<form action="javascript:void(0)" name="loginForm" class="login-form" method="post">
				<h3 class="form-title text-center"><img src="assets/custom/img/logo-big.png" class="loginLogo" alt="毕业论文（设计）管理信息系统"/></h3>
				<div id="usernameError" class="alert alert-danger display-hide">
					<button class="close" data-close="alert"></button>
					<span> 用户名或密码错误！ </span>
				</div>
				<div id="captchaError" class="alert alert-danger display-hide">
					<button class="close" data-close="alert"></button>
					<span> 验证码错误！ </span>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">用户名</label>
					<div class="input-icon">
						<i class="fa fa-user"></i> 
						<input class="form-control" type="text" autocomplete="off" placeholder="管理员" name="j_username" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">密码</label>
					<div class="input-icon">
						<i class="fa fa-lock"></i> 
						<input class="form-control" type="password" autocomplete="off" placeholder="密码" name="j_password" />
					</div>
				</div>
				<div class="form-group">
					<input id="kaptcha" name="kaptcha" class="form-control kaptcha" type="text" placeholder="输入验证码" />
					<img class="captcha" id="captcha" name="captcha" src="getCaptcha?${.now?long}" onclick="document.loginForm.captcha.src='getCaptcha?' + Math.random()"/>
				</div>	
				<div class="form-actions" >
					<a id="loginButton" href="javascript:;" class="btn blue" style="width:100%">
						登录 
					</a>
				</div>
	
				<#--
				<div class="forget-password">
					<p>
						<a href="javascript:;" id="forget-password"> 忘记密码？ </a>
					</p>
				</div>
				-->
			</form>
			<!-- END LOGIN FORM -->
			<!-- BEGIN FORGOT PASSWORD FORM -->
			<form action="javascript:void(0)" class="forget-form" action="index.html" method="post">
				<h3 class="text-center">忘记密码？</h3>
				<p>输入您绑定的邮箱进行密码重置</p>
				<div class="form-group">
					<div class="input-icon">
						<i class="fa fa-envelope"></i> 
						<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Email" name="email" />
					</div>
				</div>
				<div class="form-actions">
					<button type="button" id="back-btn" class="btn">
						<i class="m-icon-swapleft"></i> 返回
					</button>
					<button type="submit" class="btn blue pull-right">
						提交 <i class="m-icon-swapright m-icon-white"></i>
					</button>
				</div>
			</form>
			<!-- END FORGOT PASSWORD FORM -->
	
		</div>
		<!-- END LOGIN -->
		<!-- BEGIN COPYRIGHT -->
		<div class="copyright">&copy; 2015  蓝盾股份  版权所有</div>
		<!-- END COPYRIGHT -->
	
		<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
		<!-- BEGIN CORE PLUGINS -->
		<!--[if lt IE 9]>
		<script src="assets/global/plugins/respond.min.js"></script>
		<script src="assets/global/plugins/excanvas.min.js"></script> 
		<![endif]-->
	
		<script src="assets/custom/plugins/requirejs/require.js" data-main="assets/custom/scripts/common/admin-login-main.js" type="text/javascript"></script>
	
		<!-- END JAVASCRIPTS -->
		
		<!--START MODAL-->
		<div id="chooseRole" class="modal fade modal-scroll" data-backdrop="static" data-attention-animation="false" tabindex="-1" aria-hidden="true" >
		
		</div>
		<!--END MODAL-->
	</body>
	<!-- END BODY -->
</html>