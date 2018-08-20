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

import com.news.entity.News;
import com.news.util.BaseDao;

/**
 * Servlet Filter implementation class newsList
 */
@WebFilter("/newsList")
public class newsList implements Filter {
	BaseDao dao = new BaseDao();
    /**
     * Default constructor. 
     */
    public newsList() {
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
		System.out.println("已進入newListFilter");
		String sql1 = "SELECT * FROM news WHERE ntid=1;";//国内
		String sql2 = "SELECT * FROM news WHERE ntid=2;";//国际
		String sql5 = "SELECT * FROM news WHERE ntid=5;";//娱乐
		//String sqlAll = "SELECT * FROM news;";//所有
		Object[] obj = {};
		List<News> newsList1 = dao.executeQuery(sql1, obj, News.class);
		List<News> newsList2 = dao.executeQuery(sql2, obj, News.class);
		List<News> newsList5 = dao.executeQuery(sql5, obj, News.class);
		//List<News> newsListAll = dao.executeQuery(sqlAll, obj, News.class);
		
		request.setAttribute("DomesticList", newsList1);
		request.setAttribute("ForeignList", newsList2);
		request.setAttribute("EntertainmentList", newsList5);

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
