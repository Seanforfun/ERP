<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script type="text/javascript">
	$(function(){
		$("#all").click(function(){
			/* $("[name=resUuids]").attr("checked","checked"); */
			flag = $(this).attr("checked");
			$("[name=resUuids]").attr("checked",flag == 'checked');
		});
	})
	
	$(function(){
		$("#reverse").click(function(){
			/* $("[name=resUuids]").attr("checked",!($("[name=resUuids]").attr("checked") == "checked")); */
			var flag = true;
			$("[name=resUuids]").each(function(){
				$(this).attr("checked", !($(this).attr("checked") == "checked"));
				flag = flag && ($(this).attr("checked")=="checked")
			});
			$("#all").attr("checked", flag);
		});
	});
	
	$(function(){
		$("[name=resUuids]").click(function(){
			var flag = true;
			$("[name=resUuids]").each(function(){
				flag = flag && ($(this).attr("checked") == "checked");
			});
			$("#all").attr("checked", flag);
		});
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">角色管理</span>
		</div>
	</div>
	<div class="content-text">
		<div class="square-order">
			<s:form action="role_save" method="post">
			<s:hidden name="rm.uuid"/>
  			<div style="border:1px solid #cecece;">
				<table width="100%"  border="0" cellpadding="0" cellspacing="0">
				  <tr bgcolor="#FFFFFF">
				    <td>&nbsp;</td>
				  </tr>
				</table>
				<table width="100%"  border="0" cellpadding="0" cellspacing="0">
				    <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">角色名称</td>
				      <td width="32%">
				      	<s:textfield name="rm.name" size="25"/>
				      </td>
				      <td width="18%" align="center">角色编码</td>
				      <td width="32%">
				      	<s:textfield name="rm.code" size="25"/>
				      </td>
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td colspan="4">&nbsp;</td>
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">资源名称</td>
				      <td width="82%" colspan="3">
				      	<input type="checkbox" id="all">全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      	<input type="checkbox" id="reverse">反选
				      </td>
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">&nbsp;</td>
				      <td width="82%" colspan="3">
				      	<s:checkboxlist list="resList" name="resUuids" listKey="uuid" listValue="name"/>
				      </td>
				    </tr>
				     <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">菜单名称</td>
				      <td width="82%" colspan="3">
				      	<input type="checkbox" id="all1">全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      	<input type="checkbox" id="reverse1">反选
				      </td>
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td width="18%" height="30" align="center">&nbsp;</td>
				      <td width="82%" colspan="3">
				      	<s:checkboxlist list="menuList" name="menuUuids" listKey="uuid" listValue="name"/>
				      </td>
				    </tr>
				    <tr  bgcolor="#FFFFFF">
				      <td colspan="4">&nbsp;</td>
				    </tr>
				</table>
			</div>
			<div class="order-botton">
				<div style="margin:1px auto auto 1px;">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td>
					    	<a href="javascript:document.forms[0].submit()">
					    		<img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" />
					    	</a>
					    </td>
					    <td>&nbsp;</td>
					    <td><a href=""><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a></td>
					    <td>&nbsp;</td>
					    <td><a href=""><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a></td>
					  </tr>
					</table>
				</div>
			</div>
			</s:form>
		</div><!--"square-order"end-->
	</div><!--"content-text"end-->
	<div class="content-bbg">
		<img src="${pageContext.request.contextPath}/images/content_bbg.jpg" />
	</div>
</div>
