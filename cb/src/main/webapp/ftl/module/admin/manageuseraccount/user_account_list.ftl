<#-- BEGIN PAGE LEVEL STYLES -->
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/data-tables/DT_bootstrap.css" type="text/css" rel="stylesheet" />
<#-- END PAGE LEVEL STYLES -->

<#-- BEGIN PAGE HEADER-->
<div class="row">
	<div class="col-md-12">
		<#-- BEGIN PAGE TITLE & BREADCRUMB-->
		<#-- 面包屑  -->
		<ul class="page-breadcrumb breadcrumb">
			<#-- 面包屑主体 -->
			<li>
				<i class="fa fa-home"></i> 
				<a href="admin/home/page"class="ajaxify">首页</a> 
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:;">账号管理</a> 
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:;">用户账号管理</a>
			</li>
		</ul>
		<#-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<#-- END PAGE HEADER-->

<#-- BEGIN PAGE CONTENT-->
<div class="row">
	<div class="col-md-12">
		<#-- Begin: life time stats -->
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-shopping-cart"></i>用户账号
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-toolbar">
					<div class="btn-group">
						<a class="btn blue ajaxify" href="admin/manageUserAccount/toAddUserAccount"> 添加用户
						<i class="fa fa-plus"></i>
						</a>
					</div>
					<div class="btn-group">
						<a class="btn blue" href="admin/manageUserAccount/activateAllUserAccount" id="activateAllUserAccountBtn"> 启用全部用户账号
						<i class="fa fa-plus"></i>
						</a>
					</div>
					
				</div>
				<div class="table-container">
					<div class="table-actions-wrapper">
						<span> </span> 
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
					<table class="table table-striped table-bordered table-hover"
						id="adminUserAccountList">
						<thead>
							<tr role="row" class="heading">
								<th width="3%"></th>
								<th width="18%"></th>
								<th width="11%"></th>
								<th width="12%"></th>
								<th width="9%"></th>
								<th width="6%"></th>
								<th width="12%"></th>
							</tr>
							<tr role="row" class="filter">
								<td></td>
								<td>
									<input type="text" class="form-control form-filter input-sm" name="depa_name">
								</td>
								<td>
									<input type="text" class="form-control form-filter input-sm" name="usba_account">
								</td>
								<td>
									<input type="text" class="form-control form-filter input-sm" name="usba_name">
								</td>
								<td>
									<select name="usba_account_enable" class="form-control form-filter input-sm">
										<option value="">请选择...</option>
										<option value="0">禁用</option>
										<option value="1">启用</option>
									</select>
								</td>
								<td>
									<select name="usba_account_locked" class="form-control form-filter input-sm">
										<option value="">请选择...</option>
										<option value="0">锁定</option>
										<option value="1">开放</option>
									</select>	
								</td>
								<td class="text-center">
									<div class="margin-bottom-5">							
										<button class="btn btn-sm yellow filter-submit">
											<i class="fa fa-search"></i> 查询
										</button>
									</div>
									<button class="btn btn-sm red filter-cancel">
										<i class="fa fa-times"></i> 重置
									</button>
								</td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<#-- End: life time stats -->
	</div>
</div>
<#-- END PAGE CONTENT-->

<#--START MODAL-->
<div id="uploadUserAccountExcelFile" class="modal fade" tabindex="-1" data-keyboard="false" data-width="500">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">用户账号导入</h4>
	</div>
	<div class="modal-body ">
		<div class="row">
			<div class="col-md-9">
				<input type="file" id="uploadUserAccountFile" name="uploadUserAccountFile" class="required" >
			</div>
			<div class="col-md-3" style='padding-left:0px'>
				<a class="btn blue tooltips" href="common/exceltemplate/downloadExcelTemplate?excelName=用户账号Excel.xls" data-placement="top" data-original-title="请下载导入用户基本信息Excel模板"> Excel模板下载
				</a>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn default">取消</button>
		<a id="uploadUserAccountExcelFileSubmit"  class="btn green">
				<i class="fa fa-check"></i> 提交
		</a>
	</div>
</div>	
<#--END MODAL-->

<script src="assets/custom/scripts/admin/manageuseraccount/user_account_list_main.js" type="text/javascript"></script>

