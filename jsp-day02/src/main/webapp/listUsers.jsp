<%@ page contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@ page import="java.util.*,entity.*,util.*" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>用戶列表</title>
</head>
<body>
	
	<div style="padding: 90px 90px 10px;">
		<h4>用戶列表</h4>
		<table class="table table-striped">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">刪除</th>
		      <th scope="col">ID</th>
		      <th scope="col">用戶名</th>
		      <th scope="col">密碼</th>
		      <th scope="col">電話</th>
		      <th scope="col">電子信箱</th>
		    </tr>
		  </thead>
		  <%
			List<User> users = (List<User>)request.getAttribute("users");
			for(int i=0;i<users.size();i++){
			User user = users.get(i);
		  %>
		  <tbody>
		    <tr class="row<%= i%2+1%>">
		      <td>
				<a href="del?id=<%=user.getId() %>" onclick="return confirm('確定刪除<%=user.getUname()%>嗎');">刪除</a>&nbsp;
			  </td>
		      <th scope="row"><%=user.getId() %></th>
		      <td><%=user.getUname() %></td>
		      <td><%=user.getPwd() %>
		      <td><%=user.getPhone() %></td>
		      <td><%=user.getEmail() %></td>
		    </tr>
		    
		  </tbody>
		<%
		 }
		%>
		</table>	
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>