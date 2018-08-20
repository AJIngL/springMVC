package com.news.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.entity.Topic;
import com.news.util.BaseDao;

@Controller
public class topicAction {
	BaseDao dao = new BaseDao();
	/*private List<Topic> topicList;
	
	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}*/

	@RequestMapping("/AllTopic")
	public String findAllTopic(HttpServletRequest request) {
		String sql = "SELECT * FROM topic";
		Object[] obj = {};
		List<Topic> topicList = dao.executeQuery(sql, obj, Topic.class);
		request.setAttribute("topicList", topicList);
		//return "newspages/admin";
		return "forward:/newlist";
	}
	
	@RequestMapping("/addTopic")
	public String addTopic(String tname) {
			
			String sql = "INSERT INTO topic (topic_name) VALUE (?);";
			Object[] obj = {tname};
			//try {
				Boolean val = dao.executeUpdate(sql, obj);
				
			if(val) {
				return "redirect:/newspages/admin.jsp";
			}else {
				return "redirect:/newspages/topic_add.jsp";
			}
	}
	
	@RequestMapping("/updateTopic")
	public String updateTopic(HttpServletRequest request) {
		String tid = request.getParameter("tid");
		System.out.println(tid);
		String tname = request.getParameter("tname");
		System.out.println(tname);
		String sql = "UPDATE topic SET topic_name=? WHERE tid=?; ";
		Object[] obj = {tname,tid};
		Boolean val = dao.executeUpdate(sql, obj);
		
		if(val) {
			return "redirect:/newspages/admin.jsp";
		}else {
			return "redirect:/newspages/topic_update.jsp?tid="+tid;
		}
		
	}
	
	@RequestMapping("/deleteTopic")
	public String deleteTopic(String tid) {
			
			String sql1 = "DELETE FROM news WHERE ntid=?;";
			String sql2 = "DELETE FROM topic WHERE tid = ?;";
			Object[] obj = {tid};
			//try {
			dao.executeUpdate(sql1, obj);
				//Boolean val = (dao.executeUpdate(sql1, obj)&&dao.executeUpdate(sql2, obj));
			Boolean val = dao.executeUpdate(sql2, obj);
			//return "forward:/TopicList";
			return "redirect:/newspages/admin.jsp";
			//return "newspages/admin";
			/*if(val) {
				//return "newspages/topic_list";
				return "forward:/TopicList";
			}else {
				//return "forward:/AllTopic";
				return "newspages/admin";
			}*/
				
			
	}
	@RequestMapping("/TopicList")
	public String findTopicList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sql = "SELECT * FROM topic";
		Object[] obj = {};
		List<Topic> topicList = dao.executeQuery(sql, obj, Topic.class);
		for (Topic topic : topicList) {
			System.out.println(topic.getTopicName());
		}
		session.setAttribute("topicList", topicList);
		return "newspages/admin";
	}
}
