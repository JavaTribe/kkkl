<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${base}/assets/global/plugins/select2/select2.css"  rel="stylesheet" type="text/css"/>
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
<link href="${base}/assets/global/plugins/data-tables/DT_bootstrap.css" type="text/css" rel="stylesheet" />
<!-- END PAGE LEVEL STYLES -->

<!-- BEGIN PAGE HEADER-->
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<!-- 面包屑  -->
		<ul class="page-breadcrumb breadcrumb">
			<!-- 面包屑主体 -->
			<li><i class="fa fa-home"></i> <a href="test/home"
				class="ajaxify">首页</a> <i class="fa fa-angle-right"></i></li>
			<li><a href="#">角色模块管理</a> <i class="fa fa-angle-right"></i></li>
			<li><a href="#">角色管理</a></li>
		</ul>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->

<!-- BEGIN PAGE CONTENT-->
<div class="row">
	<div class="col-md-12">
		<!-- Begin: life time stats -->
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-shopping-cart"></i>角色 管理
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-toolbar">
					<div class="btn-group">
						<a class="btn blue ajaxify" href="admin/roleManage/toRoleManageAddOREdit"> 添加角色 
						<i class="fa fa-plus"></i>
						</a>
					</div>
				</div>
				<div class="table-container">
					<div class="table-actions-wrapper">
						<span> </span> 
						<select class="table-group-action-input form-control input-inline input-sm">
							<option value="">选择事项...</option>
							<option value="delete">删除</option>
						</select> 
						<a class="btn btn-sm yellow table-group-action-submit"data-target="#staticModal"> 
							<i class="fa fa-check"></i> 确定
						</a>
						<!-- static modal-->
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
						id="adminRoleManageList">
						<thead>
							<tr role="row" class="heading">
								<th width="5%"></th>
								<th width="28%"></th>
								<th width="40%"></th>
								<th width="10%"></th>
								<th width="10%"></th>
								<th width="7%"></th>
							</tr>
							<tr role="row" class="filter">
								<td></td>
								<td>
									<input type="text" class="form-control form-filter input-sm" name="roleName">
								</td>
								<td>
									<input type="text" class="form-control form-filter input-sm" name="roleDescribe">
								</td>
								<td>
									<select name="roleUseStatus" class="form-control form-filter input-sm">
										<option value="">请选择...</option>
										<option value="0">关闭</option>
										<option value="1">启用</option>
									</select>	
								</td>
								<td>
									<select name="roleType" class="form-control form-filter input-sm">
										<option value="">请选择...</option>
										<option value="0">办事员</option>
										<option value="1">科级</option>
										<option value="2">处级</option>
										<option value="3">司级</option>
										<option value="100">管理员</option>
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
		<!-- End: life time stats -->
	</div>
</div>
<!-- END PAGE CONTENT-->

<script src="assets/custom/scripts/admin/rolemanage/role_manage_list_main.js" type="text/javascript"></script>


