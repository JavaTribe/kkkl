<#--BEGIN PAGE LEVEL STYLES-->
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/data-tables/DT_bootstrap.css" type="text/css" rel="stylesheet" />
<#--END PAGE LEVEL STYLES-->

<#-- BEGIN PAGE HEADER-->
<div class="row">
	<div class="col-md-12">
		<#-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title">
			编辑学生账号 <small></small>
		</h3>
		<ul class="page-breadcrumb breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a  href="admin/home/page" class="ajaxify">首页</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:;">账号管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="admin/manageUserAccount/toUserAccountList" class="ajaxify">用户角色管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:;">用户角色</a>
			</li>
		</ul>
	<#-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<#-- END PAGE HEADER-->

<div class="row">
	<div class="col-md-12">
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-shopping-cart"></i>用户角色
				</div>
			</div>
			<input type="hidden" name="usbaId" id="usbaId" value="${userDetails.usba_id}">
			<div class="portlet-body form">
				<div class="form-horizontal">
					<div class="form-body">
						<#if userDetails["usba_name"]??>
							<h3 class="form-section">用户信息</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label col-md-4">
										 	姓名
										</label>
										<div class="col-md-8">
											<div class="input-icon right">
												<label class="col-md-12 form-control">${userDetails["usba_name"]!}</label>
											</div>
										</div>
									</div>
								</div>
								<#if userDetails["usba_account"]??>
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label col-md-4">
											 	用户账号
											</label>
											<div class="col-md-8">
												<div class="input-icon right">
													<label class="col-md-12 form-control">${userDetails["usba_account"]!}</label>
												</div>
											</div>
										</div>
									</div>
								</#if>
								<#if userDetails["depa_name"]??>
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label col-md-4">
											 	部门
											</label>
											<div class="col-md-8">
												<div class="input-icon right">
													<label class="col-md-12 form-control">${userDetails["depa_name"]!}</label>
												</div>
											</div>
										</div>
									</div>
								</#if>
							</div>
						</#if>
					
						<h3 class="form-section" style="margin-top:10px"></h3>
			
						<div class="table-toolbar">
							<div class="btn-group">
								<a class="btn default ajaxify" href="admin/manageUserAccount/toUserAccountList">
								<i class="fa fa-mail-reply"></i> 返回
								</a>
							</div>
							<div class="btn-group">
								<a class="btn blue" data-target="#addUserRoleModel" data-toggle="modal">
								<i class="fa fa-plus"></i> 添加用户角色
								</a>
							</div>
						</div>
						<div class="table-container">
							<div class="table-actions-wrapper">
								<span></span> 
								<select class="table-group-action-input form-control input-inline input-sm">
									<option value="">选择事项...</option>
									<option value="start">启用</option>
									<option value="disable">禁用</option>
									<option value="delete">删除</option>
								</select> 
								<a class="btn btn-sm yellow table-group-action-submit"data-target="#staticModal"> 
									<i class="fa fa-check"></i> 确定
								</a>
								<#-- static modal-->
								<div id="staticModal" class="modal fade confirm-submit"
									tabindex="-1" data-backdrop="static" data-keyboard="false">
									<div class="modal-body">
										<p>你确定执行此操作？</p>
									</div>
									<div class="modal-footer">
										<button type="button" data-dismiss="modal" class="btn blue sure-submit">确定</button>
										<button type="button" data-dismiss="modal" class="btn btn-default">返回</button>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered table-hover" id="userRoleList">
								<thead>
									<tr role="row" class="heading">
										<th width="5%"></th>
										<th width="15%">角色名称</th>
										<th width="45%">部门</th>
										<th width="25%">创建时间</th>
										<th width="10%">状态</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</div>
<#-- END PAGE CONTENT-->
<#--START MODAL 选择收件人的modal;-->
 <#include "add_user_role_model.ftl">
<#--END MODAL-->

<script src="assets/custom/scripts/admin/manageuseraccount/edit_user_role_main.js" type="text/javascript"></script>