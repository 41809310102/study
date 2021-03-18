<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Hello.aspx.cs" Inherits="WebApplication3.Hello" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
      <title>练习</title>
    <style>
        body{background-image:url(./img/zhuche.png) ;
             width:100%;
             height:100%
            }</style>

    <script type="text/javascript">

        function Xianshi(date) {
             var now = new Date();
            var date = now.getDate();
        switch (date) {
            case 1: alert("今天是星期一"); break;
            case 2: alert("今天是星期二"); break;
            case 3: alert("今天是星期三"); break;
            case 4: alert("今天是星期四"); break;
            case 5: alert("今天是星期五"); break;
            case 6: alert("今天是星期六"); break;
            default: alert("没有");

        }


    }

</script>


    <style>
        .button {
            background-color:aqua;
            width:200px;
            
        }
        .TextBox {
           background-color:deepskyblue;
           margin-left:40%;
           margin-top:-10px;
        }
             .TextBox1 {
           background-color:deepskyblue;
           margin-left:40%;
        }
                  .TextBox2 {
           background-color:deepskyblue;
           margin-left:40%;
        
        }
                       .TextBox3 {
           background-color:deepskyblue;
           margin-left:40%;
          
        }
        .text {
              color:black;
           margin-left:30%;
           margin-top:270px; 
        }

           .text1 {
              color:black;
           margin-left:30%; 
        }


    </style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>  

    <form id="form1" runat="server" onblur="Xianshi()">
        <p class="text"> 姓名：</p>
        <p>
             <asp:TextBox ID="TextBox1"  CssClass="TextBox" runat="server"></asp:TextBox>
           </p>
          <p class="text1"> 学号：</p>
         <p>
             <asp:TextBox ID="TextBox2"  CssClass="TextBox1" runat="server"></asp:TextBox>
           </p>
          <p class="text1"> 班级：</p>
         <p>
             <asp:TextBox ID="TextBox3"  CssClass="TextBox2" runat="server"></asp:TextBox>
           </p>
          <p class="text1"> 学院：</p>
         <p >
             <asp:TextBox ID="TextBox4"  CssClass="TextBox3" runat="server"></asp:TextBox>
           </p>
       
    </form>

</body>
</html>
