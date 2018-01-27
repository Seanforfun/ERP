<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("form:last").submit();
		});
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">部门管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="dept_list" method="post" id="mainform">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68" height="30">&nbsp;&nbsp;&nbsp;</td>
						<td width="123">&nbsp;</td>
						<td width="62">部门名称:</td>
						<td width="142">
							<s:textfield name="dqm.name" size="18"/>
						</td>
						<td width="60">电话:</td>
						<td width="149">
							<s:textfield name="dqm.tele" size="18"/>
						</td>
						<td width="70">
							<a id="query">
								<img src="${pageContext.request.contextPath}/images/can_b_01.gif" border="0" />
							</a>
						</td>
						<td width="70">
							<a href="${pageContext.request.contextPath}/dept_input.action">
								<img src="${pageContext.request.contextPath}/images/can_b_02.gif" border="0" />
							</a>
						</td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<s:if test="#deptList == null || #deptList.size() == 0">
					<center>
						<span style="font-size:20px;color:#96D34A;font-weight:bold">没有查找到满足条件的数据！</span>
					</center>
				</s:if>
				<s:else>
					<table width="100%" border="1" cellpadding="0" cellspacing="0">
						<tr align="center"
							style="background:url(${pageContext.request.contextPath}/images/table_bg.gif) repeat-x;">
							<td width="13%" height="30">编号</td>
							<td width="13%">部门名称</td>
							<td width="16%">电话</td>
							<td width="16%">操作</td>
						</tr>
						<s:iterator value="#deptList">
							<tr align="center" bgcolor="#FFFFFF">
								<td width="13%" height="30">${uuid }</td>
								<td>${name}</td>
								<td>${tele }</td>
								<td>
									<img src="${pageContext.request.contextPath}/images/icon_3.gif" /> 
									<span style="line-height:12px; text-align:center;"> 
										<s:a cssClass="xiu" action="dept_input">
											<s:param name="dm.uuid" value="uuid"/>
											修改
										</s:a>
									</span> 
									<img src="${pageContext.request.contextPath}/images/icon_04.gif" /> 
									<span style="line-height:12px; text-align:center;"> 
										<s:a action="dept_delete" cssClass="xiu">
											<s:param name="dm.uuid" value="uuid"/>
											删除
										</s:a>
									</span>
								</td>
							</tr>
						</s:iterator>
					</table>
					<s:hidden name="pageNum"/>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="51%">&nbsp;</td>
							<td width="13%">共${dataTotal}条记录
							<td width="6%">
								<a id="fir" class="sye">首&nbsp;&nbsp;页</a>
							</td>
							<td width="6%">
								<a id="pre" class="sye">上一页</a>
							</td>
							<td width="6%">
								<a id="next" class="sye">下一页</a>
							</td>
							<td width="6%">
								<a id="last" class="sye">末&nbsp;&nbsp;页</a>
							</td>
							<td width="12%">当前第<span style="color:red;">${pageNum}</span>/${maxPageNum}页</td>
						</tr>
					</table>
<script type="text/javascript">
	$(function(){
		var pageNum = ${pageNum};
		var maxPageNum = ${maxPageNum};
		if(maxPageNum == 1){
			$("#fir").css("display", "none");
			$("#pre").css("display", "none");
			$("#next").css("display", "none");
			$("#last").css("display", "none");
		}else if(pageNum == 1){
			$("#fir").css("display", "none");
			$("#pre").css("display", "none");
			$("#next").css("display", "inline");
			$("#last").css("display", "inline");
		}else if(pageNum == maxPageNum){
			$("#fir").css("display", "inline");
			$("#pre").css("display", "inline");
			$("#next").css("display", "none");
			$("#last").css("display", "none");
		}
	});
	
	$(function(){
		$("#fir").click(function(){
			$("[name=pageNum]").val(1);
			$("#mainform").submit();
		});
	});
	$(function(){
		$("#next").click(function(){
			$("[name=pageNum]").val($("[name=pageNum]").val()*1 + 1);
			$("#mainform").submit();
		});
	});
	$(function(){
		$("#pre").click(function(){
			$("[name=pageNum]").val($("[name=pageNum]").val()*1 - 1);
			$("#mainform").submit();
		});
	});
	$(function(){
		$("#last").click(function(){
			$("[name=pageNum]").val(${maxPageNum});
			$("#mainform").submit();
		});
	});
</script>		
				</s:else>
			</div>
		</s:form>
	</div>
	<div class="content-bbg"></div>
</div>
