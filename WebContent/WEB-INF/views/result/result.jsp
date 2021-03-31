<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>${vo.type }</title>
<style>
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
/* Set the width of the sidebar to 120px */
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
/* Remove margins from "page content" on small screens */
/* @media only screen and (max-width: 600px) {#main {margin-left: 0}} */
pre {

	background:url('images/body-bg.gif');
	border:  none;
	color: #808080;
}
img {
  border-radius: 8px;
}
</style>
<script type="text/javascript">

	$(function() {
		
		$("#list").click(function() {
			
			location = "/list/list.do";
			
		});
		
	});

</script>
</head>
<body>
 
 <div class="w3-container w3-padding-32 w3-center" id="home">
    <h1 class="w3-x-large"><pre style="font-style: oblique;font-weight: bold;">${vo.title }</pre></h1>
    <p style="font-size: 1.5em; font-size: 30pt;">${vo.name}</p><br/>
    

  <div class="w3-content w3-justify w3-text-grey w3-padding-64" id="about">
    <img src="${vo.image }" class="w3-image" style="margin-left: auto;
  margin-right: auto;">
    <pre>
    </pre>
    	<h3 style="color: #b3b3b3; line-height: 150%; font-style: inherit;">
	${vo.content }
    </h3>
    <pre>
    </pre>
    <pre>
    </pre>
    <h2 class="w3-text-light-grey">Matching Type</h2>
    <hr style="width:200px" class="w3-opacity">
    <img src="${vo.gImage}" class="w3-image" style="margin-left: auto;
  margin-right: auto;">
    	<h3 style="color: #b3b3b3; line-height: 150%; font-style: inherit; ">
	${vo.gType }
    <pre>
    </pre>
    </h3>
    <h2 class="w3-text-light-grey">Mismatching Type</h2>
    <hr style="width:200px" class="w3-opacity">
    <img src="${vo.bImage}" class="w3-image" width="700" height="900">
    	<h3 style="color: #b3b3b3; line-height: 150%; font-style: inherit;">
	${vo.bType }
    <pre>
    </pre>
    </h3>
  </div>
<!-- END PAGE CONTENT -->
</div>
</body>
</html>