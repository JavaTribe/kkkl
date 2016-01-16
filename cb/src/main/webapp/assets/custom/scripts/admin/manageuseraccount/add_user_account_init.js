define(function() {	
	 var addNewUserAccountSubmit = function(){
		$("#addNewUserAccountSubmit").on('click', function(e) {
	     	e.preventDefault();
	     	if($("#addNewUserAccountForm").valid()){
	     		Layout.ajaxSubmit("#addNewUserAccountForm", "#addNewUserAccountSubmit");
	     	}
	     });
	};
	return { 
		init : function(){
			addNewUserAccountSubmit();
			handleValidation();
		}
	};
});