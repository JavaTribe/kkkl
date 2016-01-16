define(['datatable_ajax'],function(DataTableAjax) {	
	var handleValidation = function() {
        var form= $('#editUserAccountForm');
        form.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	tebaNo :{
            		required: true,
            		minlength:5,
            		maxlength:15
            	},
            	tebaName : "required"
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
	 
	/**重置密码.*/
	var resetUserAccountPassword = function(){
		$('#resetUserPasswordSubmit').on('click', function(e){
			e.preventDefault();
			$.ajax({
				   type: "POST",
				   url: "admin/manageUserAccount/resetUserAccountPassword",
				   data: "usbaId="+$('#usbaId').val(),
				   success: function(res){
					   Metronic.stopPageLoading();
						if (res.sStatus == true) {
	                   	Metronic.alert({
	                   		type: 'success', 
	                   		icon: 'check', 
	                   		message: res.sMessage, 
	                   		container: $('#editUserAccountForm'), 
	                   		place: 'prepend'
	                   	});
	                   }else if (res.sStatus == false) {
	                   	Metronic.alert({
	                   		type: 'danger', 
	                   		icon: 'warning', 
	                   		message: res.sMessage, 
	                   		container: $('#editUserAccountForm'), 
	                   		place: 'prepend'
	                   	});
	                   }
				   },
				   error : function(res) {
						Metronic.stopPageLoading();
						Metronic.alert({
		            		type: 'danger', 
		            		icon: 'warning', 
		            		message: '内部错误...', 
		            		container: $('#editUserAccountForm'), 
		            		place: 'prepend'
		            	});
					}
				
				});
		});
	};
	 
	 var editUserAccountSubmit = function(){
		$("#editUserAccountSubmit").on('click', function(e) {
	     	e.preventDefault();
	     	if($("#editUserAccountForm").valid()){
	     		Layout.ajaxSubmit("#editUserAccountForm", "#editUserAccountSubmit");
	     	}
	     });
	};
		
	return { 
		init : function(){
			resetUserAccountPassword();
			editUserAccountSubmit();
			handleValidation();
		}
	};
});