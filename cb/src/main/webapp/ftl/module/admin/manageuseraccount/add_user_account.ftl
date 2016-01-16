<#--BEGIN PAGE LEVEL STYLES-->
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
<#--END PAGE LEVEL STYLES-->

<#-- BEGIN PAGE HEADER-->
<div class="row">
	<div class="col-md-12">
		<#-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title">
			添加用户账号 <small></small>
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
				<a href="javascript:;">添加学生账号</a>
			</li>
		</ul>
	<#-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<#-- END PAGE HEADER-->
<div class="note note-danger">
	添加用户的规则说明：
	<ol>
		<li>用户账号长度为6~16位，而且只能为数字，不能包含其他字符</li>
		<li>密码默认为666666</li>
		<li>创建用户必须选择所属部门</li>
	</ol>
</div>
<div class="row">
	<div class="col-md-12">
		<#-- BEGIN VALIDATION STATES-->
			<form action="javascript:void(0)" class="form-horizontal" id="addNewUserAccountForm">
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-edit"></i>添加用户账号
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
							<h3 class="form-section">添加账号管理</h3>
							
							
							<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label col-md-2">
													用户账号
													<span class="required">*</span>
												</label>
												<div class="col-md-10"> 
													<div class="input-icon right">
														<i class="fa"></i>
														<input type="text" name="usbaAccount" class="form-control" placeholder="请输入用户账号" value="">	
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label col-md-2">
												用户姓名
														<span class="required">*</span>
												</label>
												<div class="col-md-10"> 
													<div class="input-icon right">
														<i class="fa"></i>
														<input type="text" name="usbaName" class="form-control " placeholder="请输入用户姓名" value="">	
													</div>
												</div>
											</div>
										</div>
								
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label col-md-2">
												性别
												<span class="required">*</span>
												</label>
												<div class="col-md-10">
													<div class="input-icon right">
														<i class="fa"></i>
														<select class="bs-select form-control" name="usbaSex">
															<option value="0" selected>男</option>
															<option value="1">女 </option>
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
												<select class="bs-select form-control" name="depaId">
													<option value="" selected>请选择...</option>
													<#if departmentTree??>
														<option value="${departmentTree.depaId!}">${departmentTree.depaName!}</option>
														<#list departmentTree.childList as child>
															<option value="${child.depaId!}">${child.depaName!}</option>
														</#list>
													</#if>
												</select>
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
												<select class="bs-select form-control" name="usbaAccountEnable">
													<option value="0">是</option>
													<option value="1" selected>否 </option>
												</select>
											</div>
										</div>
									</div>
								</div>
								
							</div>
							<!--/row-->
						</div>
						
						<div class="form-actions fluid">
							<div class="row text-center">
								<div class=" col-md-12">
									<button class="btn blue" data-target="#static" href="admin/manageUserAccount/addNewUserAccount" id="addNewUserAccountSubmit">
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
		<#-- END VALIDATION STATES-->
	</div>
</div>
<#-- END PAGE CONTENT-->
<script src="assets/custom/scripts/admin/manageuseraccount/add_user_account_main.js" type="text/javascript"></script>

<script type="text/javascript">
	var handleValidation = function() {
        var form= $('#addNewUserAccountForm');
        form.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
		            	usbaAccount :{
								required: true,
								minlength: 6,
								maxlength: 30,
		            	},
		            	usbaName : {
								required: true,
								minlength: 1,
								maxlength:30,
		            	},
		            	depaId : {
							required: true,
			            }
            },
			
			// display error alert on form submit
			invalidHandler : function(event, validator) {
				Metronic.alert({
                		type: 'danger', 
                		icon: 'warning', 
                		message: "填写信息不完整或有误，请重新检查！", 
                		container: form, 
                		place: 'prepend'
                	});
			},
			
			// render error placement for each input type
			errorPlacement : function(error, element) {
				var icon = $(element).parent(".input-icon")
						.children("i");
				icon.removeClass("fa-check").addClass("fa-warning");
				icon.attr("data-original-title", error.text()).tooltip(
					{
						"container" : "body"
					});
			},
			
			// hightlight error inputs
			highlight : function(element) {
				// set error class to the control group
				$(element).closest(".form-group") .removeClass("has-success") .addClass("has-error");
			},

			success : function(label, element) {
				var icon = $(element).parent(".input-icon") .children("i");
				$(element).closest(".form-group") .removeClass("has-error") .addClass("has-success");
				icon.removeClass("fa-warning").addClass("fa-check");
			}
    	 });
	 };
</script>