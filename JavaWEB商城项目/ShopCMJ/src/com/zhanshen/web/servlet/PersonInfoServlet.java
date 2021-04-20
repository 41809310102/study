package com.zhanshen.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.zhanshen.entity.User;
import com.zhanshen.service.PersonInfoService;
import com.zhanshen.service.impl.PersonInfoServiceImpl;

public class PersonInfoServlet extends BaseServlet {
   private PersonInfoService service=new PersonInfoServiceImpl();
	public  void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         User user = (User) req.getSession().getAttribute("user");
         user.setName(req.getParameter("name"));
         user.setSex(req.getParameter("sex"));
         service.update(user);
         req.getSession().setAttribute("user",user);
         resp.sendRedirect(req.getContextPath()+"/myhome.jsp");
	}
}
