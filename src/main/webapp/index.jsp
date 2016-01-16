<html>
<head>
	<script type="text/javascript" src="script/jquery-2.2.0.js"></script>
	<script type="text/javascript" src="script/jquery.serialize-object.js"></script>
	<script type="text/javascript" src="script/underscore.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		console.log("ready");
		
		
		$("#send").click(function() {
			//var formData = JSON.stringify($("#message").serializeArray());
			var formData = $("#message").serializeJSON();
			console.log("Sending: " + formData);
			
			$.ajax({
				type: "POST",
				url: "/rest/message",
				data: formData,
				success: function(){},
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			});
		});
		
		var timerId = setInterval(function() {
			$.ajax({
				type: "GET",
				url: "/rest/message",
				dataType: "json",
				cache: false,
				success: function(data) {
					console.log(JSON.stringify(data));
					$("#chat").empty();
					for (var i = 0; i < data.length; i++) {
					    dl = $("<dl>");
					    //Don't create author line if same author
					    if(i>0 && data[i].author == data[i-1].author){
					    	dl = $("#chat dl:last-child");
					    } else {
					    	dl.append(
								$("<dt>").html(data[i].author)
							);	
					    }
					    
					    dl.append(
					    	$("<dd>").html(data[i].body)		
					    );
					    $("#chat").append(dl);
					    $('#chat').scrollTop($("#chat").prop("scrollHeight"));
					}
				}
			});
		}, 2000);
	});
	

	</script>
</head>
<body>

<div style="width: 750px; height: 375px; border: 1px solid black; overflow-y: scroll;" id="chat"></div>

<form id="message" action="/">

<input type="text" name="author" style="width: 100px"/>
<input type="text" name="body" style="width: 600px"/>
<input type="button" id="send" value="send"/>
</form>

</body>
</html>
