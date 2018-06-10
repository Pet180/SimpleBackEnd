<%@ page contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@ page import="java.util.*,entity.*,util.*" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>新增用戶</title>
</head>
<body>
	<div style="padding: 100px 100px 10px;">
		<h4>新增用戶</h4><br/>
		<form action="add" method="POST">
		  <div class="form-group">
		    <label for="exampleInputEmail1">用戶名</label>
		    <input type="text" class="form-control" name="username" aria-describedby="emailHelp" placeholder="請輸入您的用戶名">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">密碼</label>
		    <input type="password" class="form-control" name="pwd" placeholder="請輸入您的密碼">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">電話</label>
		    <input type="text" class="form-control" name="telephone" aria-describedby="emailHelp" placeholder="請輸入您的電話號碼">
		  </div>
        <div class="form-group">
		    <label for="exampleInputEmail1">電子信箱</label>
		    <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="請輸入您的電子信箱">
		  </div>
		  <button type="submit" class="btn btn-primary">確定</button>
		</form>	
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>