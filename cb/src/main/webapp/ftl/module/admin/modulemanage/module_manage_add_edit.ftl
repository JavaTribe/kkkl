<!--START MODAL-->
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		 <#if module??>
			<h4 class="modal-title">编辑模块</h4>
		 <#else>
			<h4 class="modal-title">添加模块</h4>
		 </#if>
	</div>
	<div class="modal-body">
		<div class="portlet-body form">
			<form action="javascript:void(0)" role="form" class="form-horizontal"  id="moduleForm">
					<div class="form-body">
					<div class="alert alert-danger display-hide">
					<button class="close" data-close="alert"></button>
					填写信息不完整或有误，请重新检查！
					</div>
					<div class="alert alert-success display-hide">
						<button class="close" data-close="alert"></button>
						操作成功!
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">父模块</label>
						<div class="col-md-9">
							<select class="form-control select2me" name="pamoId">
								<#list parentModules as parentModule  >
									<option value="${parentModule.pamoId}" <#if module??&&module.pamoId==parentModule.pamoId> selected </#if> >${parentModule.pamoName}</option>
								</#list>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">模块名称
							<span class="required">*</span>
						</label>
						<div class="col-md-9">
							<input type="text" name="moduName" class="form-control" placeholder="模块名称" <#if module??> value="${module.moduName}" </#if>>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">模块URL</label>
						<div class="col-md-9">
							<input type="text"  name="moduUrl"   class="form-control" placeholder="模块URL" <#if module??> value="${module.moduUrl!}" </#if> >
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">资源</label>
						<div class="col-md-9">
							<input type="text"  name="moduResource"   class="form-control" placeholder="资源" <#if module??> value="${module.moduResource!}" </#if> >
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">启用状态</label>
						<div class="col-md-9">
							<select class="form-control select2me" name="moduUseStatus">
								<option value="1" <#if module??&&module.moduUseStatus==1> selected </#if> >启用</option>
								<option value="0" <#if module??&&module.moduUseStatus==0> selected </#if>  >关闭</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">图标样式
						</label>
						<div class="col-md-9">
							<input type="text"  name="moduIcon"   class="form-control" placeholder="图标样式" <#if module??> value="${module.moduIcon!}" </#if> >
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">模块排序
						</label>
						<div class="col-md-9">
							<input type="text"  name="moduSort"   class="form-control" placeholder="模块排序" <#if module??> value="${module.moduSort!}" </#if>>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">模块描述</label>
						<div class="col-md-9">
							<textarea class="form-control" name="moduDescribe" rows="3" ><#if module??>${module.moduDescribe!}</#if></textarea>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn default">取消</button>
			<a id="submitModule" href="admin/moduleManage/saveModule?moduId=<#if module??>${module.moduId}</#if>" class="btn green">
				<i class="fa fa-check"></i> 提交
			</a>
	</div>
<!--END MODAL-->

<script src="assets/custom/scripts/admin/modulemanage/module_manage_add_edit_main.js" type="text/javascript"></script>

