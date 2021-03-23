<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String EI = request.getParameter("EI");

if(Integer.parseInt(EI) > 2) {
	
	EI = "E";
	
} else {
	
	EI = "I";
	
}

String SN = request.getParameter("SN");

if(Integer.parseInt(SN) > 2) {
	
	SN = "S";
	
} else {
	
	SN = "N";
	
}

String TF = request.getParameter("TF");

if(Integer.parseInt(TF) > 2) {
	
	TF = "T";
	
} else {
	
	TF = "F";
	
}

String JP = request.getParameter("JP");

if(Integer.parseInt(JP) > 2) {
	
	JP = "J";
	
} else {
	
	JP = "p";
	
}

System.out.println(EI+SN+TF+JP);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나와 꼭 닮은 영화 속 케릭터는?</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <link rel="stylesheet" type="text/css" href="../css/movieMbti.css">
 <script type="text/javascript" src="../js/movieMbti.js"></script>
</head>
<body class="container">
</body>
</html>