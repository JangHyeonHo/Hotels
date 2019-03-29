/**
 * 
 */

$(function(){
	$("#room").hover(function(){
		$(".roommenu").css("display","block");
	});
	$("#room").mouseleave(function(){
		$(".roommenu").css("display","none");
	});
	
	$("#restaurant").hover(function(){
		$(".Restaurantmenu").css("display","block");
	});
	$("#restaurant").mouseleave(function(){
		$(".Restaurantmenu").css("display","none");
	});
	
	$("#banquet").hover(function(){
		$(".banquetmenu").css("display","block");
	});
	$("#banquet").mouseleave(function(){
		$(".banquetmenu").css("display","none");
	});
	
	$("#About").hover(function(){
		$(".Aboutmenu").css("display","block");
	});
	$("#About").mouseleave(function(){
		$(".Aboutmenu").css("display","none");
	});
	
	
	
	
	
	
});