define(['parent_module_manage_list_init'], function(ParentModuleManageListInit) {
	

	var initEvent = function() {
		$('#submitParentModule').on('click', function(e){
			e.preventDefault();
			if($("#parentModuleForm").valid()){
				Layout.ajaxSubmitModel("#parentModuleForm", "#submitParentModule",
				function(){
				$('#parentModuleModel').modal('hide');
					dataTable=ParentModuleManageListInit.getDataTableObject();
					dataTable.addAjaxParam("iTotalRows", '0');
					dataTable.getDataTable().fnDraw();
				});
	  		}
		});
	  	
	};
	 var handleValidation = function() {
            var form= $('#parentModuleForm');
  			var error = $('.alert-danger', form);
            var success = $('.alert-success', form);
            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "", // validate all fields including form hidden input
                rules: {
                    pamoName: {
                        minlength: 2,
                        required: true
                    },
                    pamoSort: {
                    	maxlength: 2,
						digits: true
                    }
                },
                messages : {
					pamoName : {
						required : "请输入部门编号"
					},
					pamoSort : {
						required : "请输入数字"
					}
				},
				invalidHandler : function(event, validator) {
					success.hide();
					error.show();
					Metronic.scrollTo(error, 0);
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
	 
	return {
		init : function(){
			initEvent();
			handleValidation();
		}
	};
});