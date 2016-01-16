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
			编辑用户账号 <small></small>
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
				<a href="admin/manageUserAccount/toUserAccountList" class="ajaxify">用户账号管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:;">编辑用户账号</a>
			</li>
		</ul>
	<#-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<#-- END PAGE HEADER-->

<div class="row">
	<div class="col-md-12">
		<#-- BEGIN FORM-->
		<form action="javascript:void(0)" class="form-horizontal" id="editUserAccountForm">
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-edit"></i>编辑用户账号
					</div>
				</div>
				<div class="portlet-body form">
					<#-- BEGIN FORM-->
					<div class="form-horizontal">
						<div class="form-body">
							<div class="alert alert-danger display-hide">
								<button class="close" data-close="alert"></button>
								填写信息不完整或有误，请重新检查！
							</div>
							<div class="alert alert-success display-hide">
								<button class="close" data-close="alert"></button>
								操作成功!
							</div>
							<#--START TASK DEFINITION MESSAGE-->
							<h3 class="form-section">用户账号管理</h3>
							<div class="row">								
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
										 	教工号
											<span class="required">*</span>
										</label>
										<div class="col-md-10"> 
											<div class="input-icon right">
												<i class="fa"></i>
												<input type="text" name="tebaNo" class="form-control " placeholder="" value="${userDetails.usba_account!}">	
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
										 	姓名
											<span class="required">*</span>
										</label>
										<div class="col-md-10"> 
											<div class="input-icon right">
												<i class="fa"></i>
												<input type="text" name="tebaName" class="form-control " placeholder="" value="${userDetails.usba_name!}">	
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
										 	密码
											<span class="required">*</span>
										</label>
										<div class="col-md-10"> 
											<div class="input-icon right">
												<i class="fa"></i>
												<button class="btn blue" href="admin/manageUserAccount/resetUserAccountPassword" id="resetUserPasswordSubmit">
													重置
												</button> 
												<span class="required">*</span>重置后密码为666666
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
											是否禁用
											<span class="required">*</span>
										</label>
										<div class="col-md-10">
											<div class="input-icon right">
												<i class="fa"></i>
												<select class="bs-select form-control" name="tebaAccountEnable">
													<option value="0" 
													<#if userDetails.usba_account_enable?? && userDetails.usba_account_enable==0>selected</#if>>是</option>
													<option value="1" 
													<#if userDetails.usba_account_enable?? && userDetails.usba_account_enable==1>selected</#if>>否 </option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
										 	账号锁定
										 	<span class="required">*</span>
										</label>
										<div class="col-md-10"> 
											<div class="input-icon right">
												<i class="fa"></i>
												<select class="bs-select form-control" name="tebaAccountLocked">
													<option value="0" 
													<#if userDetails.usba_account_locked?? && userDetails.usba_account_locked==0>selected</#if>>是</option>
													<option value="1" 
													<#if userDetails.usba_account_locked?? && userDetails.usba_account_locked==1>selected</#if>>否</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
											所属部门
											<span class="required">*</span>
										</label>
										<div class="col-md-10">
											<div class="input-icon right">
												<i class="fa"></i>
												<select class="bs-select form-control" name="depaId" id="depaId">
													<#list departmentTrees as departmentTree>
														<#if departmentTree.depaId == userDetails.depa_id>
															<option value="${departmentTree.depaId}" selected>${departmentTree.depaName}</option>
														<#else>
															<option value="${departmentTree.depaId}">${departmentTree.depaName}</option>
														</#if>
													</#list>
												</select>
											</div>
										</div>
									</div>
								</div>
								
								
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
										 	账号创建时间
										</label>
										<div class="col-md-10"> 
											<div class="input-icon right">
												<label class="col-md-12 form-control">${userDetails.usba_create_date!}</label>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
										 	账号过期
										</label>
										<div class="col-md-10"> 
											<div class="input-icon right">
												<label class="col-md-12 form-control">
													<#if userDetails.usba_account_expired?? && userDetails.usba_account_expired==0>
														是
													<#elseif userDetails.usba_account_expired?? && userDetails.usba_account_expired==1>
														否
													</#if>
												</label>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">
										 	证书过期
										</label>
										<div class="col-md-10"> 
											<div class="input-icon right">
												<label class="col-md-12 form-control">
													<#if userDetails.usba_credential_expired?? && userDetails.usba_credential_expired==0>
														是
													<#elseif userDetails.usba_credential_expired?? && userDetails.usba_credential_expired==1>
														否
													</#if>
												</label>
											</div>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" name="usbaId" id="usbaId" value="${userDetails.usba_id}">
						</div>
						
						<div class="form-actions fluid">
							<div class="row text-center">
								<div class=" col-md-12">
									<button class="btn blue" data-target="#static" href="admin/manageUserAccount/updateUserAccount" id="editUserAccountSubmit">
										<i class="fa fa-check"></i> 提交
									</button>
									<a class="btn default ajaxify" href="admin/manageUserAccount/toUserAccountList">
										<i class="fa fa-mail-reply"></i> 返回
									</a>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			
			</div>
		</form>
		<#-- END FORM -->
		
	</div>
</div>
<#-- END PAGE CONTENT-->

<script src="assets/custom/scripts/admin/manageuseraccount/edit_user_account_main.js" type="text/javascript"></script>