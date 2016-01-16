<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" type="text/css"  />
<!-- END PAGE LEVEL STYLES -->

<!-- BEGIN PAGE HEADER-->
<div class="row">
	<div class="col-md-12">
		<ul class="page-breadcrumb breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a  href="student/home/page" class="ajaxify">首页</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:;">角色管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:;">新建角色</a>
			</li>
		</ul>
	</div>
</div>
<!-- END PAGE HEADER-->

<!-- BEGIN PAGE CONTENT-->
<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">
			<#if editRoleId??>
				<i class="fa fa-pencil"></i>编辑角色
			<#else>
				<i class="fa fa-pencil"></i>新建角色
			</#if>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
		<form action="javascript:void(0)" class="form-horizontal" id="roleMangeForm">
			<#if editRoleId??>
				<input type="hidden" name="roleId" value="${editRoleId}"	> 
			</#if>
			
			
			
			<div class="form-body">
				<div class="alert alert-danger display-hide">
					<button class="close" data-close="alert"></button>
					填写信息不完整或有误，请重新检查！
				</div>
				<div class="alert alert-success display-hide">
					<button class="close" data-close="alert"></button>
					操作成功!
				</div>
				<p style="margin:10px 0px 0px 0px  ;">
					<font size="4" face="Verdana">
						角色基本信息
					</font>
				</p>
				<hr style="FILTER: alpha(opacity=100,finishopacity=0,style=2);margin: 0px 0px 10px 0px  ;padding:0;"  color=#987cb9 SIZE=3/>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-4">
								角色名称
								<span class="required">*</span>
							</label>
							<div class="col-md-8"> 
								<div class="input-icon right">
									<i class="fa"></i> 
									<input type="text" name="roleName" class="form-control" <#if role??> value="${role.roleName}" </#if>
										placeholder="角色名称" >
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label col-md-6">
								启用状态
								<span class="required">*</span>
							</label>
							<div class="col-md-6"> 
								<div class="input-icon right">
									<i class="fa"></i> 
									<select class="bs-select form-control" name="roleUseStatus">
										<option value="1" <#if role??&&role.roleUseStatus==1> selected </#if> >启用</option>
										<option value="0" <#if role??&&role.roleUseStatus==0> selected </#if> >关闭</option> 
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label col-md-6">
								角色类型
								<span class="required">*</span>
							</label>
							<div class="col-md-6"> 
								<div class="input-icon right">
									<i class="fa"></i> 
									<select class="bs-select form-control" name="roleType">
										<option value="0" <#if role??&&role.roleType==0> selected </#if>>办事员</option>
										<option value="1" <#if role??&&role.roleType==1> selected </#if>>科级</option>
										<option value="2" <#if role??&&role.roleType==2> selected </#if>>处级</option>
										<option value="3" <#if role??&&role.roleType==3> selected </#if>>司级</option>
										<option value="100" <#if role??&&role.roleType==100> selected </#if>>管理员</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label col-md-2">
								角色描述
							</label>
							<div class="col-md-10"> 
								<div class="input-icon right">
									<i class="fa"></i> 
									<input type="text" name="roleDescribe" class="form-control" <#if role??> value="${role.roleDescribe}" </#if>
										placeholder="角色描述" >
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<p style="margin:10px 0px 0px 0px  ;">
					<font size="4" face="Verdana">
						权限范围
					</font>
				</p>
				<hr style="FILTER: alpha(opacity=100,finishopacity=0,style=2);margin: 0px 0px 10px 0px  ;padding:0;"  color=#987cb9 SIZE=3/>
				
				<!-- 遍历模块信息 -->
				<#list parentModules as parentModule>
					<div class="row" style="padding-left:15px;padding-right:15px;">
						<!-- BEGIN REGIONAL STATS PORTLET-->
						<div class="portlet box blue-hoki">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-globe"></i>${parentModule.pamoName}
								</div>
								
								<div class="tools">
									<a href="" class="collapse"></a>
								</div>
							</div>
							
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<#list parentModule.pamoModules as module>
												<label class="control-label col-md-3" style="text-align:left">
													<input type="checkbox" name="moduleId" id="module_${module.moduId}" value="${module.moduId}" title="${module.moduDescribe!}">
														${module.moduName }
												</label>
											</#list>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</#list>
				<!-- 遍历结束 -->
			</div>
			<div class="form-actions fluid">
				<div class="row">
					<div class="col-md-12 text-center">
						<a id="saveRoleMange" href="admin/roleManage/saveRoleMange" class="btn blue">
							<i class="fa fa-save"></i> 保存
						</a>
						<a href="admin/roleManage/toRoleManageList" class="btn default ajaxify">
							<i class="fa fa-mail-reply"></i> 返回
						</a>
					</div>
				</div>
			</div>
		</form>
		<!-- END FORM-->
	</div>
</div>
<!-- END PAGE CONTENT-->
<script src="assets/custom/scripts/admin/rolemanage/role_manage_add_edit_main.js" type="text/javascript"></script>
<#if editRoleId??>
<!-- 编辑状态时,设置当前角色已经选中checkbox -->
<script type="text/javascript">
	var moduIds= ${moduIds};
	for(var i=0;i<moduIds.length;i++){
		$('#module_'+moduIds[i]).attr("checked",'true');
		
	}
</script>
</#if>

