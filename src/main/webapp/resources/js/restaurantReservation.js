/**
 * 
 */
	$(function() {

		$("#rrTime")
				.on(
						"change",
						function() {
							var rn = $("#rrn").val();
							var date = $("#rrDate").val();
							var time = $("#rrTime").val();

							var dateTime = date + " " + time

							console.log(rn);
							$
									.ajax({
										url : "table",
										method : 'get',
										data : "resname=" + rn + "&datetime="
												+ dateTime,
										dataType : 'html',
										success : function(data) {
											$("#tablecount").html(data);
											
										}
									})
						})
		$("#subBtn")
				.on(
						"click",
						function() {
							var date = $("#rrDate").val();
							var time = $("#rrTime").val();
							console.log(date + time);
							var hiddenText = "<input type = 'hidden' name ='rrDate' value = '"+date+" "+time+"'>"
							$("#hb").html(hiddenText);
							alert("예약이 완료되었습니다.")
						})

	});
	
	function exist() {

		var a = document.getElementById("al").value;

		var b = "Y";
		console.log(a);

		if (a == b) {
			$("#albox").css("display", "block");
		} else {
			$("#albox").css("display", "none");
		}

	}

	$(function() {

		var inputHidden = "<input   type = 'hidden' id = 'ale' name="

		$("#submitBtn")
				.on(
						"click",
						function(e) {
							var al = $("#al").val() + $("#albox").val()
							var checkInHiddenHtml = inputHidden
									+ "'customer.cosAllergy' value='" + al
									+ "'>"

							console.log(checkInHiddenHtml);

							$("#hiddenBox").html(checkInHiddenHtml);

							var lname = $("#ln").val()
							var nnane = $("#nl").val()
							var phone = $("#ph").val()
							var email = $("#em").val()
							var allergy = $("#ale").val()

							$
									.ajax({
										url : "../reservation",
										method : 'get',
										data : "cosLName=" + lname
												+ "&cosFName=" + nnane
												+ "&cosTelno=" + phone
												+ "&cosEmail=" + email
												+ "&cosAllergy=" + allergy,
										dataType : 'html',
										success : function(data) {
											$("#contents").html(data);
										}
									})

						})

	});