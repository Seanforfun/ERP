<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#supplier").change(function(){
			var supplierUuid = $(this).val();
			$.post("order_ajaxGetGtmAndGm.action",{"supplierUuid":supplierUuid}, function(data){
				$(".goodsType").empty();
				$(".goods").empty();
				var gtmList = data.gtmList;
				var goodsList = data.goodsList;
				for(var i = 0; i < gtmList.length; i++){
					var gtm = gtmList[i];
					$op = $("<option value='"+gtm.uuid+"'>"+gtm.name+"</option>");
					$(".goodsType").append($op);
				}
				for(var i = 0; i < goodsList.length; i++){
					var gm = goodsList[i];
					$op = $("<option value='"+gm.uuid+"'>"+gm.name+"</option>");
					$(".goods").append($op);
				}
				$(".num_order_num").attr("value","1");
				$(".prices_order_num").attr("value", goodsList[0].inpriceView);
				$(".total").html(""+goodsList[0].inpriceView+"&nbsp;元");
				$(".all").html(""+goodsList[0].inpriceView+"&nbsp;元");
			});
		});		
	});
	
	$(function(){
		$(".goodsType").change(function(){
			var gtmUuid = $(this).val()
			$.post("order_ajaxGetGm.action", {'gtmUuid': gtmUuid}, function(data){
				var goodsList = data.goodsList;
				$(".goods").empty();
				for(var i = 0; i < goodsList.length; i++){
					var gm = goodsList[i];
					$op = $("<option value='"+gm.uuid+"'>"+gm.name+"</option>");
					$(".goods").append($op);
				}
				$(".num_order_num").attr("value","1");
				$(".prices_order_num").attr("value", goodsList[0].inpriceView);
				$(".total").html(""+goodsList[0].inpriceView+"&nbsp;元");
				$(".all").html(""+goodsList[0].inpriceView+"&nbsp;元");
			});
		});
	});
	
	$(function(){
		$(".goods").change(function(){
			var gmUuid = $(this).val();
			$.post("order_ajaxGetPrice.action",{"gmUuid":gmUuid}, function(data){
				var inprice = data.inpriceView;
				$(".num_order_num").attr("value","1");
				$(".prices_order_num").attr("value", inprice);
				$(".total").html(""+inprice+"&nbsp;元");
				$(".all").html(""+inprice+"&nbsp;元");
			});
		});
		
		$("#add").click(function(){
			var supplierUuid = $("#supplier").val();
			var goodsList = $(".goods")
			var used = "";
			for(var i = 0; i < goodsList.length; i++){
				used = used + "'" + goodsList[i].value + "',";
			}
			$.post("order_ajaxGetGtmAndGm2.action", {'supplierUuid' : supplierUuid, 'used':used}, function(data){
				var gtmList = data.gtmList;
				var goodsList = data.goodsList;
				$tr = $('<tr bgcolor="#FFFFFF" align="center"></tr>');
				$td1 = $('<td height="30"></td>');
				$gtmSelect = $('<select class="goodsType" style="width:200px"></select>');
				
				for(var i = 0; i < gtmList.length; i++){
					$op = $('<option value="'+gtmList[i].uuid+'">'+gtmList[i].name+'</option>')
					$gtmSelect.append($op)
				}
				$td1.append($gtmSelect);
				$tr.append($td1);
				
				$td2 = $('<td></td>');
				$goodsSelect = $('<select class="goods" style="width:200px"></select>')
				for(var i = 0; i < goodsList.length; i++){
					$op = $('<option value="'+goodsList[i].uuid+'">'+goodsList[i].name+'</option>')
					$goodsSelect.append($op);
				}
				$td2.append($goodsSelect);
				$tr.append($td2);
				
				$td3 = $('<td></td>');
				$input = $('<input name="nums" class="num_order_num" style="width:67px;border:1px solid black;text-align:right;padding:2px" value="1" type="text">');
				$td3.append($input);
				$tr.append($td3);
				
				$td4 = $('<td><input name="prices" class="prices_order_num" style="width:93px;border:1px solid black;text-align:right;padding:2px" value="'+goodsList[0].inpriceView+'" type="text"> 元</td>');
				$tr.append($td4);
				
				$td5 = $('<td class="total" align="right">'+goodsList[0].inpriceView+'&nbsp;元</td>');
				$tr.append($td5);
				
				$td6 = $('<td><a class="deleteBtn delete xiu" value="'+goodsList[0].uuid+'"><img src="/E/images/icon_04.gif"> 删除</a></td>');
				$tr.append($td6);
				$("#finalTr").before($tr);
				
				if(gtmList.length == 1 && goodsList.length == 1){
					$("#add").css("display", "none");
				}
			});
		});
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">订单管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="inList.jsp" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68px" height="30">供应商：</td>
						<td width="648px">
							<s:select id="supplier" name="" list="#supplierList" cssClass="kuan" cssStyle="width:190px" listKey="uuid" listValue="name"></s:select>
						</td>
						<td height="30">
							<a id="add"><img src="${pageContext.request.contextPath}/images/can_b_02.gif" border="0" /> </a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table id="order" width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(${pageContext.request.contextPath}/images/table_bg.gif) repeat-x;">
						<td width="25%" height="30">商品类别</td>
						<td width="25%">商品名称</td>
						<td width="10%">采购数量</td>
						<td width="15%">单价</td>
						<td width="15%">合计</td>
						<td width="10%">操作</td>
					</tr>
					<tr align="center" bgcolor="#FFFFFF">
						<td height="30">
							<s:select class="goodsType" name="" list="goodsTypeList" cssClass="goodsType" cssStyle="width:200px" listKey="uuid" listValue="name"/>
						</td>
						<td>
							<s:select class="goods" name="" list="goodsList" cssClass="goods" cssStyle="width:200px" listKey="uuid" listValue="name"/>
						</td>
						<td><input name="nums" class="num_order_num" style="width:67px;border:1px solid black;text-align:right;padding:2px" type="text" value="1"/></td>
						<td><input name="prices" class="prices_order_num" style="width:93px;border:1px solid black;text-align:right;padding:2px" type="text" value="${goodsList[0].inpriceView}"/> 元</td>
						<td class="total" align="right">${goodsList[0].inpriceView}&nbsp;元</td>
						<td>
							<a class="deleteBtn delete xiu" value="4"><img src="${pageContext.request.contextPath}/images/icon_04.gif" /> 删除</a>
						</td>
					</tr>
					<tr id="finalTr" align="center"
						style="background:url(${pageContext.request.contextPath}/images/table_bg.gif) repeat-x;">
						<td height="30" colspan="4" align="right">总&nbsp;计:&nbsp;</td>
						<td class="all" width="16%" align="right">${goodsList[0].inpriceView}&nbsp;元</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				<div class="order-botton">
				<div style="margin:1px auto auto 1px;">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td>
					    	<a href="javascript:void(0)" id="submitOrder"><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a>
					    </td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a></td>
					    <td>&nbsp;</td>
					    <td><a href="#"><img src="${pageContext.request.contextPath}/images/order_tuo.gif" border="0" /></a></td>
					  </tr>
					</table>
				</div>
			</div>
			</div>
		</form>
	</div>
	
	<div class="content-bbg"></div>
</div>
