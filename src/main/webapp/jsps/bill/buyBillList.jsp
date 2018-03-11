<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		
		$(".info").click(function(){
			$nowTr = $(this).parent().parent();
			var jsonParam = {"bqm.goodsUuid":$(this).attr("gm")};
			jsonParam["bqm.type"] = $("[name='bqm.type']").val();
			jsonParam["bqm.supplierUuid"] = $("[name='bqm.supplierUuid']").val();
			$.post("bill_ajaxGetBillByGood.action", jsonParam, function(data){
				$(".ajaxMsg").remove();
				$headTr = $('<tr align="center" style="background:url(images/table_bg.gif) repeat-x;" class="ajaxMsg"><td height="30">订单号</td><td>订单时间</td><td>数量</td><td>单价</td><td>合计</td></tr>');
				$nowTr.after($headTr);
				var odmList = data;
				var sum = 0;
				for(var i = 0; i < odmList.length; i++){
					var odm = odmList[i];
					var om = odm.om;
					sum += odm.totalPriceView * 1;
					$dataTr = $("<tr align='center' class='ajaxMsg'></tr>")
					
					$td1 = $('<td height="30">'+om.orderNum+'</td>');
					$dataTr.append($td1);
					
					$td2 = $('<td>'+om.createTimeView+'</td>');
					$dataTr.append($td2);
					
					$td3 = $('<td>'+odm.num+'</td>');
					$dataTr.append($td3);
					
					$td4 = $('<td align="right">'+odm.priceView+' 元</td>');
					$dataTr.append($td4);
					
					$td5 = $('<td align="right">'+odm.totalPriceView+' 元</td>');
					$dataTr.append($td5);
					
					$headTr.after($dataTr);
					$headTr = $dataTr;
				}
				
				$tailTr = $('<tr align="center" class="ajaxMsg"><td height="30" align="right" colspan="4">总计：</td><td align="right">'+intToFloat(sum)+' 元</td></tr>');
				$headTr.after($tailTr);
			});
		});
		
		function intToFloat(val){
			return new Number(val).toFixed(2);
		}
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">进货报表</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="bill_buyBillList.action" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="70" height="30">报表类别:</td>
						<td width="140">
							<input type="radio" name="all" checked="checked">商品名称
						</td>
						<td width="70">订单类别:</td>
						<td width="190">
							<s:select list="@ca.mcmaster.erp.invoice.order.model.OrderModel@buyOrderMap" name="bqm.type" headerKey="-1" headerValue="----请-选-择----" cssClass="kuan"/>
						</td>
						<td width="70">开始日期:</td>
						<td width="190">
							<input type="text" size="18" onfocus="c.showMoreDay=false;c.show(this);" />
						<td ><a id="query">
							<img src="${pageContext.request.contextPath}/images/can_b_01.gif" border="0" /> </a></td>
					</tr>
					<tr>
						<td height="30">&nbsp;</td>
						<td>
							<input type="radio" name="all">销售人员
						</td>
						<td>厂商名称:</td>
						<td>
							<s:select list="supplierList" name="bqm.supplierUuid" headerKey="-1" headerValue="----请-选-择----" listKey="uuid" listValue="name" cssClass="kuan"/>
						</td>
						<td>结束日期:</td>
						<td width="190">
							<input type="text" size="18" onfocus="c.showMoreDay=false;c.show(this);" />
						<td>
							<a href="bill_downloadBillReport.action?bqm.type=${param['bqm.type']}&bqm.supplierUuid=${param['bqm.supplierUuid']}">
								<img src="${pageContext.request.contextPath}/images/can_b_03.gif" border="0" />
							</a>
					</tr>
				</table>
			</div>
			</s:form>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="70%" border="1" cellpadding="0" cellspacing="0" style="float:left;">
					<tr align="center"
						style="background:url(images/table_bg.gif) repeat-x;">
						<td colspan="2" width="49%" height="30">商品名称</td>
						<td colspan="2" width="28%">总数量</td>
						<td width="23%">详情</td>
					</tr>
					<s:iterator value="billList" var="objs">
						<tr align="center" bgcolor="#FFFFFF">
							<td colspan="2" width="30%" height="30">${objs[1].name }</td>
							<td colspan="2">${objs[0] }</td>
							<td>
								<a href="javascript:void(0)" class="xiu info" gm="${objs[1].uuid }">
									详情
								</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<div style="float:right;"> 
					<a href="bill_pieBill.action?bqm.type=${param['bqm.type']}&bqm.supplierUuid=${param['bqm.supplierUuid']}">
						<img id="pei" src="bill_pieBill.action?bqm.type=${param['bqm.type']}&bqm.supplierUuid=${param['bqm.supplierUuid']}" width="228px" height="180px">
					</a>
				</div>
			</div>
	</div>
	<div class="content-bbg"></div>
</div>
