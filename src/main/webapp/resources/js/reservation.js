		$(function(){

            $("#allergy1").on("click",function(){
			 var isclick = $("#allergy1").is(":checked");
             console.log(isclick);
			 if(isclick){
				$("#allergyinfo").css("display","block");
			 } else{
				$("#allergyinfo").css("display","none");
			 }
		 })

        });