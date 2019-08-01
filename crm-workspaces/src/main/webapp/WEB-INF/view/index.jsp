<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<script src="http://how2j.cn/study/jquery.min.js"></script>
<body>
hello
<select id="test">

</select>
<input type="button" value="测试按钮" onclick="test();">

</body>
<script type="text/javascript">
	function test(){
		alert("进入test（）");
		$.ajax({
			url:"http://localhost:8888/crm/customer/findtest",
			type:"post",
			dataType:"json",
			success:function(result){
				alert(result);
				var a = JSON.parse(result);
				alert(a);
				//var test = result.fromType;
				for(var i =0;i<result.length;i++){
					//$("#test").append('<option id="'+i+'">'+test[i].dict_item_name+'</option>')
					$("#test").append('<option id="'+i+'">'+a[i].dict_item_name+'</option>')
				}

			}
		});
	}

</script>
</html>