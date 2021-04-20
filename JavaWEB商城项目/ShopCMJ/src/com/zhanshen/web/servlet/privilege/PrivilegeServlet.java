package com.zhanshen.web.servlet.privilege;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.mysql.fabric.xmlrpc.base.Array;
import com.zhanshen.entity.Address;
import com.zhanshen.entity.Cart;
import com.zhanshen.entity.CartItem;
import com.zhanshen.entity.Order;
import com.zhanshen.entity.OrderItem;
import com.zhanshen.entity.Product;
import com.zhanshen.entity.User;
import com.zhanshen.service.PrivilegeService;
import com.zhanshen.service.ProductService;
import com.zhanshen.service.impl.PrivilegeServiceImpl;
import com.zhanshen.service.impl.ProductServiceImpl;
import com.zhanshen.web.servlet.BaseServlet;

public class PrivilegeServlet extends BaseServlet {
	private ProductService service=new ProductServiceImpl();
	private PrivilegeService privilegeService=new PrivilegeServiceImpl();
	
	public void myOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
	     
		  HttpSession session = req.getSession();
		  User user = (User) session.getAttribute("user");
		List<Order> list = privilegeService.myOrder(user.getUid());
		for (Order order : list) {
			List<Map<String, Object>> itemList = privilegeService.myOrderItemList(order.getOid());
			for (Map<String, Object> map : itemList) {
				Product product=new Product();
				product.setPname(map.get("pname").toString());
				product.setPrice(Double.parseDouble(map.get("price").toString()));
				product.setPimage(map.get("pimage").toString());
				OrderItem item=new OrderItem();
				item.setCount(Integer.parseInt(map.get("count").toString()));
				item.setSubtotal(Double.parseDouble(map.get("subtotal").toString()));
				item.setProduct(product);
				order.getList().add(item);
			}
		}
		req.setAttribute("list", list);
		System.out.println(list);
	 req.getRequestDispatcher("/order.jsp").forward(req, resp);
		
		
}
	
	
	
	public void myhome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/myhome.jsp").forward(req, resp);
	}
	public  void confirmOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, IllegalAccessException, InvocationTargetException {
           HttpSession session = req.getSession();
           User user = (User) session.getAttribute("user");
          String did= (String) req.getParameter("did");
          Address address=null;
          if(did!=null&&!did.equals("")){
			address = service.findAddressByDid(did);
          }
           Cart cart = (Cart) session.getAttribute("cart");
           if(cart!=null&&cart.getMap().size()>0){
        	   Order order=new Order();
        	   String oid = UUID.randomUUID().toString();
        	   order.setOid(oid);
        	   order.setState(0);
        	   double total = cart.getTotal();
        	   order.setTotal(total);
        	   order.setAddress(address.getAddress());
        	   order.setTelephone(address.getTelephone());
        	   order.setUser(user);
        	   order.setName(address.getName());
        	   Map<String, CartItem> map = cart.getMap();
        	   Set<Entry<String, CartItem>> set = map.entrySet();
        	   List<OrderItem> list=new ArrayList<>();
	          for (Entry<String, CartItem> entry : set) {
					OrderItem orderItem=new OrderItem();
					orderItem.setItem_id(UUID.randomUUID().toString());
					orderItem.setProduct(entry.getValue().getProduct());
					orderItem.setSubtotal(entry.getValue().getSubtotal());
					orderItem.setCount(entry.getValue().getCount());
					orderItem.setOrder(order);
					list.add(orderItem);
			      }
	          privilegeService.saveOrder(order);
	          privilegeService.saveOrderItem(list);
	          
	          String url=req.getContextPath()+"/PayServlet?orderid="+oid+"&money="+total;
	          resp.sendRedirect(url);
           }
        	   
		   
		
	}
	public  void addressDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, IllegalAccessException, InvocationTargetException {
		String did = req.getParameter("did");
		privilegeService.deleteAddress(did);
		resp.sendRedirect(req.getContextPath()+"/privilege/privilegeServlet?method=manageAddress");
		
		
	}
	public  void addressUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, IllegalAccessException, InvocationTargetException {
	Map<String, String[]> map = req.getParameterMap();
		Address address=new Address();
		BeanUtils.populate(address, map);
		privilegeService.updateAddress(address);
		
		resp.sendRedirect(req.getContextPath()+"/privilege/privilegeServlet?method=manageAddress");
		
		
	}
	public  void manageAddressEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		Address address = privilegeService.findAddressById(req.getParameter("did"));
		req.setAttribute("address",address);
		req.getRequestDispatcher("/address_edit.jsp").forward(req, resp);
	}
	public  void manageAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		List<Address> list = privilegeService.addressList();
		req.setAttribute("list",list);
		req.getRequestDispatcher("/address.jsp").forward(req, resp);
	}
	
	public  void addressList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		List<Address> list = privilegeService.addressList();
		Gson gson =new Gson();
		String json = gson.toJson(list);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(json);
		System.out.println(json);
	}
	@SuppressWarnings("static-access")
	public  void addressAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> map = req.getParameterMap();
		Address address=new Address();
		BeanUtils beanUtils=new BeanUtils();
		try {
			beanUtils.populate(address, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			address.setDid(UUID.randomUUID().toString());
			service.saveAddress(address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void mycollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("pids")){
					String value = cookie.getValue();
					String[] pids = value.split(",");
					List<Product> list=new ArrayList<>();
					for (String pid : pids) {
						Product product = service.findProductById(pid);
						list.add(product);
					}
					req.setAttribute("list",list);
					
				}
			}
		}
		req.getRequestDispatcher("/favorite.jsp").forward(req, resp);
	}
	

	public void collectProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String pid = req.getParameter("pid");
		Cookie[] cookies = req.getCookies();
		
		String pids=pid;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("pids")){
					String value = cookie.getValue();
					String[] split = value.split(",");
				
					LinkedList<String> linkedList=new LinkedList<>(Arrays.asList(split));
					if(linkedList.contains(pid)){
						linkedList.remove(pid);
					}
					linkedList.addFirst(pids);
					
					StringBuilder builder=new StringBuilder();
					for (int i = 0; i < linkedList.size(); i++) {
						builder.append(linkedList.get(i));
						builder.append(",");
					}
					pids = builder.substring(0, builder.length()-1);

				}
			}
		}
		Cookie cookie=new Cookie("pids", pids);
		cookie.setMaxAge(60*60*12);
		cookie.setPath(req.getContextPath());
		resp.addCookie(cookie);
		resp.sendRedirect(req.getContextPath()+"/flow.jsp");
		
	}

}
