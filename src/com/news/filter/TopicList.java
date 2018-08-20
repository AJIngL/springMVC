package com.news.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.news.entity.Topic;
import com.news.util.BaseDao;

/**
 * Servlet Filter implementation class TopicList
 */
@WebFilter("/TopicList")
public class TopicList implements Filter {

    /**
     * Default constructor. 
     */
    public TopicList() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("topic过滤器");
		BaseDao dao = new BaseDao();
		String sql = "SELECT * FROM topic";
		Object[] obj = {};
		List<Topic> topicList = (List<Topic>)dao.executeQuery(sql, obj, Topic.class);
		request.setAttribute("topicList" , topicList);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
