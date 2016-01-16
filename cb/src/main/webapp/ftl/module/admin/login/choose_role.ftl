<!--START MODAL-->
<form action="admin/login/initData" method="post">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	<h4 class="modal-title">选择角色</h4>
</div>
<div class="modal-body">
	<div class="scroller" data-always-visible="1" data-rail-visible1="1">
		<div class="row">
			<div class="col-md-6">
				<h4>学生角色</h4>
				<div class="form-group">
					<div class="radio-list">
						<#list adminRoles as adminRole>
						<label>
						<input type="radio" name="adIds" id="optionsRadios1" value="${adminRole.adroId},${adminRole.adroRole.roleId}" checked> ${adminRole.adroRole.roleName}</label>
						</#list>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal-footer">
	<a class="btn default" data-dismiss="modal" href="admin/j_spring_security_logout">取消</a>
	<input type="submit" class="btn green" value="确定" />
</div>
</form>
<!--END MODAL-->