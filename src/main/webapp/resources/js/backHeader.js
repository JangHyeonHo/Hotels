/**
 * 
 */

$(function(){
	$("#front").hover(function(){
		$(".frontmenu").css("display","block");
	});
	$("#front").mouseleave(function(){
		$(".frontmenu").css("display","none");
	});
	
	$("#hr").hover(function(){
		$(".hrmenu").css("display","block");
	});
	$("#hr").mouseleave(function(){
		$(".hrmenu").css("display","none");
	});
	
	$("#fb").hover(function(){
		$(".fbmenu").css("display","block");
	});
	$("#fb").mouseleave(function(){
		$(".fbmenu").css("display","none");
	});
	
	$("#member").hover(function(){
		$(".membertmenu").css("display","block");
	});
	$("#member").mouseleave(function(){
		$(".membertmenu").css("display","none");
	});
	
	$("#logistics").hover(function(){
		$(".logisticsmenu").css("display","block");
	});
	$("#logistics").mouseleave(function(){
		$(".logisticsmenu").css("display","none");
	});
	
	
	
	
});