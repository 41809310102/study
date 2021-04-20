<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<script type="text/javascript">
  $(function(){
	  $.post(
		"${pageContext.request.contextPath}/admincategory?method=adminCategoryList","",function(data){
			var content="";
			$.each( data, function(i, n){
				  content+="<option value='"+n.cid+"'>"+n.cname+"</option>";
				});
			$("#cid").html(content)
		
		},"json"	  
	  ) 
  })
</script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" action="${pageContext.request.contextPath}/adminproduct?method=adminProductAdd"  method="post" enctype="multipart/form-data">
	    <table cellpadding="5">
	        <tr>
	            <td>商品类目:</td>
	            <td>
	         <select id="cid" name="cid" style="width:200px;">
			</select>
	            </td>
	        </tr>
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="pname" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品价格:</td>
	              <td><input class="easyui-textbox" type="text" name="price" data-options="required:true" style="width: 180px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>库存数量:</td>
	             <td><input class="easyui-textbox" type="text" name="pnumber" data-options="required:true" style="width: 180px;"></input></td>
	        </tr>
	        <tr>
	            <td>是否热门:</td>
	            <td>
	              <select id="is_hot" name="is_hot" style="width:200px;">
	               <option value='1'>是</option>
	               <option value='0'>否</option>
			</select>
	            </td>
	        </tr>
	        <tr>
	            <td>商品图片:</td>
	            <td>
	            <input  name="pimage" type="file" />
	            </td>
	        </tr>
	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="pdesc"></textarea>
	            </td>
	        </tr>
	        <tr class="params hide">
	        	<td>商品规格:</td>
	        	<td>
	        		
	        	</td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = E3.createEditor("#itemAddForm [name=pdesc]");
		//初始化类目选择和图片上传器
		E3.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//E3.changeItemParam(node, "itemAddForm");
		}});
	});
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		//同步文本框中的商品描述
		itemAddEditor.sync();

		$("#itemAddForm").submit();
	
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
