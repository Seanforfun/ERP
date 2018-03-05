<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='pageNum']").val(1);
			$("form:first").submit();
		});
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">商品运输管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="transport_taskList.action" method="post"> 
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td>下单时间:</td>
						<td>
							<input type="text" size="10" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>到&nbsp;</td>
						<td>
							<input type="text" size="10" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>供&nbsp;应&nbsp;商:</td>
						<td>
							<s:select name="oqm.sm.uuid" list="supplierList" headerKey="-1" headerValue="----请-选-择----" cssStyle="width:115px" listKey="uuid" listValue="name"/>
						</td>
						<td>下单人:</td>
						<td>
							<s:textfield name="oqm.creator.name" size="10"/>
						</td>
						<td>&nbsp;</td>
						<td><a id="query"> 
							<img src="${pageContext.request.contextPath}/images/can_b_01.gif" border="0" /> </a>
						</td>
					</tr>
					<tr>
						<td>审核时间:</td>
						<td>
							<input type="text" size="10" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>到&nbsp;</td>
						<td>
							<input type="text" size="10" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>发货方式:</td>
						<td>
							<s:select name="oqm.sm.needs" list="@ca.mcmaster.erp.invoice.supplier.model.SupplierModel@needsMap" cssStyle="width:115px" headerKey="-1" headerValue="----请-选-择----"/>
						</td>
						<td>审核人:</td>
						<td>
							<s:textfield name="oqm.checker.name" size="10"/>
						</td>
						<td>跟单人:</td>
						<td>
							<s:textfield name="oqm.completer.name" size="10"/>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${pageContext.request.contextPath}/images/table_bg.gif) repeat-x;">
						<td width="10%" height="30">订单类别</td>
						<td width="21%">下单时间</td>
						<td width="5%">制单人</td>
						<td width="21%">审核时间</td>
						<td width="5%">审核人</td>
						<td width="15%">供应商</td>
						<td width="13%">发货方式</td>
						<td width="10%">跟单人</td>
					</tr>
					<s:iterator value="#orderList">
						<tr align="center" bgcolor="#FFFFFF">
							<td height="30">${orderType}</td>
							<td>${createTimeView }</td>
							<td>${creator.name }</td>
							<td>${checkTimeView }</td>
							<td>${checker.name }</td>
							<td>${sm.name }</td>
							<td>${sm.needsView }</td>
							<td>
								<s:if test="type == @ca.mcmaster.erp.invoice.order.model.OrderModel@ORDER_TYPE_OF_BUY_CHECK_PASS">
									<img src="${pageContext.request.contextPath}/images/icon_3.gif" /> 
									<span style="line-height:12px; text-align:center;"> 
										<s:a action="transport_taskDetail.action" cssClass="xiu">
											<s:param name="om.uuid" value="uuid"/>
											任务指派
										</s:a>
									</span>
								</s:if>
								<s:else>
									${completer.name}
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</s:form>
	</div>
	<div class="content-bbg"></div>
</div>
