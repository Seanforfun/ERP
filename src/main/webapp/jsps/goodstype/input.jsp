<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">商品类别管理</span>
		</div>
	</div>
	<div class="content-text">
		<div class="square-order">
			<s:form action="goodsType_save.action" method="post">
				<s:hidden name="gm.uuid"/>
	  			<div style="border:1px solid #cecece;">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					  <tr bgcolor="#FFFFFF">
					    <td>&nbsp;</td>
					  </tr>
					</table>
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					    <tr  bgcolor="#FFFFFF">
					      <td width="18%" height="30" align="center">供应商</td>
					      <td width="82%" colspan="3">
					      	<s:select list="supplierList" name="gm.sm.uuid" cssClass="kuan" cssStyle="width:190px" headerKey="-1" headerValue="----请-选-择----" listKey="uuid" listValue="name"/>
					      </td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td colspan="4">&nbsp;</td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td width="18%" height="30" align="center">商品类别名称</td>
					      <td width="82%" colspan="3">
					      	<s:textfield name="gm.name" size="25"/>
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
					    	<a href="javascript:document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a>
					    </td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a></td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a></td>
					  </tr>
					</table>
				</div>
			</div>
			</s:form>
		</div><!--"square-order"end-->
	</div><!--"content-text"end-->
	<div class="content-bbg"><img src="${pageContext.request.contextPath}/images/content_bbg.jpg" /></div>
</div>
