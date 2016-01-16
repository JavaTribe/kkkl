<link rel="stylesheet" type="text/css" href="${base}/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${base}/assets/global/plugins/select2/select2-bootstrap.css"/>
<!--START MODAL-->
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		 <#if parentModule??>
			<h4 class="modal-title">编辑模块</h4>
		 <#else>
			<h4 class="modal-title">添加父模块</h4>
		 </#if>
	</div>
	<div class="modal-body">
		<div class="portlet-body form">
			<form action="javascript:void(0)" role="form" class="form-horizontal"  id="parentModuleForm">
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
						<label class="col-md-3 control-label">模块名称
							<span class="required">*</span>
						</label>
						<div class="col-md-9">
							<input type="text" name="pamoName" class="form-control" placeholder="模块名称" <#if parentModule??> value="${parentModule.pamoName}" </#if>>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">启用状态</label>
						<div class="col-md-9">
							<select class="form-control select2" name="pamoUseStatus">
								<option value="1" <#if parentModule??&&parentModule.pamoUseStatus==1> selected </#if> >启用</option>
								<option value="0" <#if parentModule??&&parentModule.pamoUseStatus==0> selected </#if>  >关闭</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">图标样式
						</label>
						<div class="col-md-9">
							<input type="text"  name="pamoIcon"   class="form-control" placeholder="图标样式" <#if parentModule??> value="${parentModule.pamoIcon!}" </#if> >
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">模块排序
						</label>
						<div class="col-md-9">
							<input type="text"  name="pamoSort"   class="form-control" placeholder="模块排序" <#if parentModule??> value="${parentModule.pamoSort!}" </#if>>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">模块描述</label>
						<div class="col-md-9">
							<textarea class="form-control" name="pamoDescribe" rows="3"  ><#if parentModule??>${parentModule.pamoDescribe!} </#if></textarea>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn default">取消</button>
			<a id="submitParentModule" href="admin/parentModuleManage/saveParentModule?pamoId=<#if parentModule??>${parentModule.pamoId} </#if>" class="btn green">
				<i class="fa fa-check"></i> 提交
			</a>
	</div>
<!--END MODAL-->

<script src="assets/custom/scripts/admin/parentmodulemanage/parent_module_manage_add_edit_main.js" type="text/javascript"></script>

