package com.zhanshen.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.zhanshen.entity.Cart;
import com.zhanshen.entity.CartItem;
import com.zhanshen.entity.Product;
import com.zhanshen.entity.User;
import com.zhanshen.service.ProductService;
import com.zhanshen.service.impl.ProductServiceImpl;

public class ProductServlet extends BaseServlet{
  
	private ProductService service=new ProductServiceImpl();
	
	public void tipProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		 String name = req.getParameter("message");
		 List<Object> list= service.findProductListByName(name);
		 resp.setContentType("application/json;charset=utf-8");
		 Gson gson=new Gson();
		 String json = gson.toJson(list);
		 System.out.println(json);
	    resp.getWriter().write(json);
	}
	public void priceAreaOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
	       String min = req.getParameter("min");
	       String max=req.getParameter("max");
	       List<Product> list=service.priceAreaOrder(min,max);
	       req.setAttribute("list", list);
		   req.getRequestDispatcher("/list.jsp").forward(req, resp);
		
	}
	public void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		 String title=req.getParameter("search_content");
		List<Product> list=service.searchProduct(title);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
		
	}
	
	public void carttoremove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
	
		String pid = req.getParameter("pid");
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		Map<String, CartItem> map = cart.getMap();
		CartItem cartItem = map.get(pid);
		double subtotal = cartItem.getSubtotal();
		cart.setTotal(cart.getTotal()-subtotal);
		map.remove(pid);
		
		resp.sendRedirect(req.getContextPath()+"/flow.jsp");
		
		
	
	}
	@SuppressWarnings("unused")
	public void cartAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		HttpSession session = req.getSession();
		String pid = req.getParameter("pid");
		String count = req.getParameter("buynum");
	     Product product = service.findProductById(pid);
	     
	     CartItem cartItem=new CartItem();
	     cartItem.setProduct(product);
	     cartItem.setCount(Integer.parseInt(count));
	     double subtotal=product.getPrice()*Integer.parseInt(count);
	     cartItem.setSubtotal(subtotal);
	     
	     Cart cart = (Cart) session.getAttribute("cart");
	     if(cart==null){
	    	 cart=new Cart();
	     }
	     Map<String, CartItem> map = cart.getMap();
	     if(map.containsKey(pid)){
	    	 CartItem item = map.get(pid);
	    	 Integer oldCount = item.getCount();
	    	 Integer newCount = oldCount+Integer.parseInt(count);
	    	 item.setCount(newCount);
	    	 double oldsubtotal = item.getSubtotal();
	    	 double newsubtotal =oldsubtotal+subtotal;
	    	 item.setSubtotal(newsubtotal);
	     }else{
	    	 map.put(pid, cartItem) ;
	     }
	     double oldtotal = cart.getTotal();
	     double newtotal=subtotal+oldtotal;
	     cart.setTotal(newtotal);
	     cart.setMap(map);
	     session.setAttribute("cart", cart);
	 
	    
	     
	     resp.sendRedirect(req.getContextPath()+"/flow.jsp");
	     
	     
	}
	public void productInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
	  String cid = req.getParameter("cid");
	  String pid = req.getParameter("pid");
	  Product product = service.findProductById(pid);
     req.setAttribute("product", product);
	 req.getRequestDispatcher("/product_info.jsp").forward(req, resp);
	}
	
	/**
	 * 分类列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void cateProductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String cid = req.getParameter("cid");
	List<Product> list=null;
	try {
		list = service.cateProductList(cid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("cid", cid);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
		
	}
	public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("user");
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
	}
	
	
	/**
	 * 注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		HttpSession session = req.getSession();
		Map<String, String[]> map = req.getParameterMap();
		String repassword = req.getParameter("repassword");
	  String code = req.getParameter("code");
		String checkcode = (String) session.getAttribute("checkcode_session");
	  if(code.equals(checkcode)){
		  
		  User user=new User();
		  BeanUtils.populate(user, map);
		  user.setUid(UUID.randomUUID().toString());
		  String password = user.getPassword();
		  if(password.equals(repassword)){
			  
			  service.register(user);
			  resp.sendRedirect(req.getContextPath()+"/login.jsp");
		  }else{
			  req.setAttribute("info", "两次密码不一致,请重新输入");
			  req.getRequestDispatcher("/register.jsp").forward(req, resp);
		  }
	  }else{
		  req.setAttribute("info", "验证码错误");
		  req.getRequestDispatcher("/register.jsp").forward(req, resp);
	  }
	}
	
	
	/**
	 * 前台登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		String checkcode = (String) session.getAttribute("checkcode_session");
		if(code.equals(checkcode)){
			User user=null;
			try {
				user = service.login(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user==null){
				req.setAttribute("info", "用户名或密码错误!!!");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
			}else{
				session.setAttribute("user", user);
				resp.sendRedirect(req.getContextPath()+"/");
			}
		}else{
			req.setAttribute("info", "验证码错误!!!");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}
}
