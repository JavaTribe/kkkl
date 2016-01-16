define(function() {

    var initEvent = function() {
		$('#saveRoleMange').on('click',function(e){
			e.preventDefault();
			Layout.ajaxSubmit("#roleMangeForm","#saveRoleMange");
		});
	};
	var initSelect = function() {
		//解决Select对齐问题
		$(".bs-select").each(function(){
			$(this).css("padding-right","0px");
			$(this).css("padding-left","0px");
		});
	};
	return {
		init : function(){
			initEvent();
			initSelect();
		}
	};
});