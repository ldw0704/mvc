<%@page import="domain.LoginVO"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 LoginVO vo = (LoginVO)request.getAttribute("vo");
 %> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원정보수정</title>
  <link rel="stylesheet" type="text/css" href="views/style.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>	
</head>

<body class="page07">
    <div class="jointit w100 tC"><b>회원정보수정</b></div>

    <div class="pd16">
	<form method="post" action="">
	<input type="hidden" name="uid" id="uid" value="<%=vo.getUid()%>"/>
        <div>
            <h4>이름</h4>
            <input type="text" name="uname" id="uname" value="<%=vo.getUname()%>">
        </div>

        <div>
            <h4>학교</h4>
            <input type="text" name="schoolname" id="schoolname" value="<%=vo.getSchoolname() %>">
        </div>

        <div>
            <h4>학년/반</h4>
            <input type="text" name="gradeclass" id="gradeclass" value="<%=vo.getGradeclass()%>">
        </div>
        
        <div>
            <h4>노선</h4>
            <div class="sltbox">
                <select name="route">
                	<option value="A노선" <%="A노선".equals(vo.getRoute())?"selected":"" %>>A노선</option>
                    <option value="B노선" <%="B노선".equals(vo.getRoute())?"selected":"" %>>B노선</option>
                    <option value="C노선" <%="C노선".equals(vo.getRoute())?"selected":"" %>>C노선</option>
                </select>
            </div>
        </div>
        
        <div>
            <h4 class="inline">탑승장소</h4> <span>(※노선을 먼저 선택해주세요)</span>
            <div class="sltbox">
                <select name="boardingplace">
                  <option value="A장소" <%="A장소".equals(vo.getBoardingplace())?"selected":"" %>>A장소</option>
                    <option value="B장소" <%="B장소".equals(vo.getBoardingplace())?"selected":"" %>>B장소</option>
                    <option value="C장소" <%="C장소".equals(vo.getBoardingplace())?"selected":"" %>>C장소</option>
                </select>
            </div>
        </div>
        
        <div class="jw100 tC">
            <button type="submit">수정하기</button>
        </div>
        </form>
    </div>
<script>
$(document).ready(function(){
	
	$("button").on("click",function(){
				
		if($("#uname").val() == ""){
			alert("이름 입력");
			return false;
		}
		if($("#school").val() == ""){
			alert("학교 입력");
			return false;
		}
		if($("#gradeclass").val() == ""){
			alert("학년반 입력");
			return false;
		}
		
		return true;		
	});
		
});
</script>    
</body>
</html>
