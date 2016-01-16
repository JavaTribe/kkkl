<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="index.html">
			<img src="assets/custom/img/logo.png" alt="logo" class="logo-default" />
			</a>
			<div class="menu-toggler sidebar-toggler hide">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<!-- BEGIN NOTIFICATION DROPDOWN -->
				
				<!-- BEGIN NOTIFICATION DROPDOWN -->
				<!-- 还未实现消息提醒功能暂时隐藏-->
				<!-- 
				
				
				
				-->
				
				<!-- END NOTIFICATION DROPDOWN -->
				<!-- BEGIN INBOX DROPDOWN -->
				
				<!-- END INBOX DROPDOWN -->

				<!-- BEGIN USER LOGIN DROPDOWN -->
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<li class="dropdown dropdown-user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<img class="img-circle" src="admin/setbasemessage/initTeaAvatar"/>
					<span class="username">
					 ${Session.SPRING_SECURITY_CONTEXT.authentication.principal.admiAccount}</span>
					</span>
					<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="javascript:;">
							<i class="fa fa-user"></i> 管理员 </a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="admin/j_spring_security_logout" >
							<i class="fa fa-key" id="adminLogout"></i> 退出 </a>
						</li>
					</ul>
				</li>
				<li>
					<!-- END USER LOGIN DROPDOWN -->
					<!-- END USER LOGIN DROPDOWN -->
					<!-- BEGIN RESPONSIVE MENU TOGGLER -->
					<div class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
					</div>
					<!-- END RESPONSIVE MENU TOGGLER -->
				</li>
			</ul>
		</div>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->