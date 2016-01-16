<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU --> 
		        <ul class="page-sidebar-menu" data-auto-scroll="false" data-auto-speed="200">
		        	<li class="sidebar-toggler-wrapper">
						<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
						<div class="sidebar-toggler">
						</div>
						<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					</li>
					<li class="start">
						<a href="admin/home/page" id="homePage" class="ajaxify" >
						<i class="fa fa-home"></i>
						<span class="title">首页</span>
						<span class="selected"></span>
						</a>
					</li>
					<#list parentModules as parentModule>
						<li>
						<a href="javascript:void(0);">
		        		<i class="${parentModule.pamoIcon}"></i>
		        		<span class="title">${parentModule.pamoName}</span>
		        		<span class="arrow"></span>
						<span class="selected"></span>
		        		</a>
		        		<!-- Begin submenu -->
		        		<ul class="sub-menu">
						<#list parentModule.pamoModules as module>
							<li>
		        				<a class="ajaxify" href="${module.moduUrl}">
		        				<i class="${module.moduIcon }"></i>
		        				${module.moduName }
		        				</a>
		        			</li>
						</#list>
						</ul>
						<!-- End submenu -->
					</#list>
					
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
<!-- END SIDEBAR -->