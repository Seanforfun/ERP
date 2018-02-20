<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">供应商管理</span>
		</div>
	</div>
	<div class="content-text">
		<div class="square-order">
			<s:form action="supplier_save.action" method="post">
				<s:hidden name="sm.uuid"/>
	  			<div style="border:1px solid #cecece;">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					  <tr bgcolor="#FFFFFF">
					    <td>&nbsp;</td>
					  </tr>
					</table>
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					    <tr  bgcolor="#FFFFFF">
					      <td width="18%" height="30" align="center">供应商名称</td>
					      <td width="82%" colspan="3">
					      	<s:textfield name="sm.name" size="82"/>
					      </td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td colspan="4">&nbsp;</td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td width="18%" height="30" align="center">供应商地址</td>
					      <td width="82%" colspan="3">
					      	<s:textfield name="sm.address" size="82"/>
					      </td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td colspan="4">&nbsp;</td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td width="18%" height="30" align="center">联系人</td>
					      <td width="32%">
					      	<s:textfield name="sm.contact" size="25"/>
					      </td>
					      <td width="18%" align="center">电话</td>
					      <td width="32%">
					      	<s:textfield name="sm.phone" size="25"/>
					      </td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td colspan="4">&nbsp;</td>
					    </tr>
					    <tr  bgcolor="#FFFFFF">
					      <td width="18%" height="30" align="center">送货方式</td>
					      <td width="32%">
					      	<s:select list="@ca.mcmaster.erp.invoice.supplier.model.SupplierModel@needsMap" name="sm.needs" cssStyle="width:190px" headerKey="-1" headerValue="----请-选-择----"/>
					      </td>
					      <td width="18%" align="center">&nbsp;</td>
					      <td width="32%">
					      	&nbsp;
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
