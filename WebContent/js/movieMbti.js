/**
 * movieMBTI test js 
 * 작성자 : 궁금해조
 * 작성일 : 2021.03.23
 * ver_1.0
 */
var num = 1;

var q = {
	
		1 : {"title":"문제 1번", "type":"EI", "A":"E", "B":"I"},
		2 : {"title":"문제 2번", "type":"EI", "A":"E", "B":"I"},
		3 : {"title":"문제 3번", "type":"EI", "A":"E", "B":"I"},
		4 : {"title":"문제 4번", "type":"SN", "A":"S", "B":"N"},
		5 : {"title":"문제 5번", "type":"SN", "A":"S", "B":"N"},
		6 : {"title":"문제 6번", "type":"SN", "A":"S", "B":"N"},
		7 : {"title":"문제 7번", "type":"TF", "A":"T", "B":"F"},
		8 : {"title":"문제 8번", "type":"TF", "A":"T", "B":"F"},
		9 : {"title":"문제 9번", "type":"TF", "A":"T", "B":"F"},
		10 : {"title":"문제 10번", "type":"JP", "A":"J", "B":"P"},
		11 : {"title":"문제 11번", "type":"JP", "A":"J", "B":"P"},
		12 : {"title":"문제 12번", "type":"JP", "A":"J", "B":"P"}
	
}

function next() {
	
	if(num == 13) {
		
		$("#A").attr("type", "submit");
		
		$("#B").attr("type", "submit");
		
	}
	
	$(".progress-bar").attr("style", "width:calc(100/12*" + num + "%)");
	
	$("#title").html(q[num]["title"]);
	
	$("#type").val(q[num]["type"]);
	
	$("#A").html(q[num]["A"]);
	
	$("#B").html(q[num]["B"]);
	
	num ++;
	
};


$(function start() {
	
	$(".start").click(function () {
		
		$(".start").hide();
		
		$(".question").show();
		
		next();
		
	});
	
});

$(function () {
	
	$("#A").click(function () {
		
		var type = $("#type").val();
	
		var preVal = $("#" + type).val();
		
		$("#" + type).val((parseInt)(preVal) + 1);
		
		next();
		
	});	
	
	$("#B").click(function () {
		
		next();
		
	})
	
});


