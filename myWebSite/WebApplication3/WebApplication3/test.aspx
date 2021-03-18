<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="test.aspx.cs" Inherits="WebApplication3.test" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>JQuery获取HTML元素的内容</title>
    <script src="js/jquery-3.4.1.js"></script>
    <style>
   	body{background-image:url(./img/zhuche1.jpg) ;
             width:100%;
             height:100%
            }
    </style>
    <style>
        .botton {
            color:orangered;
            background:#00ffff;

        }
           .botton1{
            color:orangered;
            background:#00ffff;

        }
        .botton2 {
            color: orangered;
            background: #00ffff;
        }
        
        .box {
            margin-left:40%;
            margin-top:278px;
        }
        .winndow {
            height:522px;
            width:600px;

        }
    </style>
    <script type="text/javascript" class="winndow">
        $(document).ready(function () {
            $("#btn1").click(function () {
                alert("文档:" + $("#test").text());
            });
            $("#btn2").click(function () {
                alert("网站:" + $("#test").html() );
            });
            $("#btn3").click(function () {
                alert("姓名:" + $("#test2").val());
            });
        })
    </script>
    
</head>
<body class="box">
    <p id="test">这是段落中的<b>粗体</b>文字</p>
    <button  class="botton"  id="btn1">显示文本</button>
    <button class="botton1" id="btn2">显示HTML</button>
    <p>姓名：<input type="text" id="test2" value="米老鼠" /></p>
    <button class="botton1"  id="btn3">显示值</button>
</body>
</html>
