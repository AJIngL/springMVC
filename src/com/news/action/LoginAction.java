package com.news.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.entity.Page;
import com.news.entity.User;
import com.news.util.BaseDao;

@Controller
public class LoginAction {
	
	BaseDao dao = new BaseDao();
	Page page = new Page();

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		
		System.out.println("用户名："+username+",密码："+userpwd);
		String sql = "SELECT * FROM userinfo WHERE user_name=? AND user_pwd=?";
		Object[] obj = {username,userpwd};
		List<User> user = dao.executeQuery(sql, obj, User.class);
		
		if(user.size()>0) {
			System.out.println("---登录成功---");
			session.setAttribute("username", username);
			
			return "newspages/admin";
		}
		return "redirect:/index.jsp";
		
	}
}
