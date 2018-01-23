<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<title>Seanforfun-ERP</title>
<script>
	$(function() {
		$("#login_ok").click(function() {
			$("#loginform").submit();
		});
	});
	function MM_swapImage(srcObj,image_src){
		srcObj.src=image_src;
	}
</script>
</head>
<body>
	<s:actionerror />
	<div class="container-login">
		<div class="login-pic">
			<div class="login-text">
				<s:form action="emp_login" method="post" namespace="/" id="loginform">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="40%" height="28">Username:</td>
							<td colspan="2">
								<s:textfield name="username" value="admin"/>
							</td>
						</tr>
						<tr>
							<td height="31">Password:</td>
							<td colspan="2">
								<s:textfield name="password" value="admin"/>
							</td>
						</tr>
						<tr>
							<td height="30">Verify Code</td>
							<td width="43%">
								<input type="text" size="9" />
							</td>
							<td width="32%"><img src="${pageContext.request.contextPath}/images/test.gif" />
							</td>
						</tr>
						<tr>
							<td height="30">&nbsp;</td>
							<td colspan="2">
								<a href="javascript:void(0)" id="login_ok">
									<img src="${pageContext.request.contextPath}/images/denglu_bg_03.gif" 
										 name="Image1" width="40"	
										 height="22" border="0"  
										 onmouseover="MM_swapImage(this,'${pageContext.request.contextPath}/images/denglu_h_03.gif')" 
										 onmouseout="MM_swapImage(this,'${pageContext.request.contextPath}/images/denglu_bg_03.gif')" /></a>
								<a href="#">
									<img src="${pageContext.request.contextPath}/images/giveup_bg_03.gif" 
										 name="Image2" width="42" 
										 height="22" border="0"  
										 onmouseover="MM_swapImage(this,'${pageContext.request.contextPath}/images/giveup_h_03.gif')" 
										 onmouseout="MM_swapImage(this,'${pageContext.request.contextPath}/images/giveup_bg_03.gif')" /></a>
							</td>
						</tr>
					</table>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
