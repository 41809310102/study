<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>JAVA家园</title>
</head>
<body >
    <form id="form1" runat="server">
        <div aria-disabled="True">
            请输入：<asp:TextBox ID="TextBox1" runat="server" style="margin-top: 71px" Width="131px" BackColor="#99CCFF"></asp:TextBox>
&nbsp;
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="加入" BackColor="#6699FF" />
            <asp:Label ID="Label1" runat="server"></asp:Label>
        </div>
     
        <p>
            <asp:HyperLink ID="HyperLink1" runat="server"  ImageHeight="1000px" ImageUrl="https://img95.699pic.com/photo/50052/1073.jpg_wh860.jpg" ImageWidth="1300px">1.替换空格</asp:HyperLink>
        </p>
        <p>
            &nbsp;</p>
    </form>
</body>
</html>
