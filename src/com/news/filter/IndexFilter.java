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
import javax.servlet.http.HttpSession;

import com.news.entity.News;
import com.news.entity.Page;
import com.news.util.BaseDao;

/**
 * Servlet Filter implementation class IndexFilter
 */
@WebFilter(filterName = "NewsIndexFilter", urlPatterns = { "/NewsIndex" })
public class IndexFilter implements Filter {
	Page page = new Page();
	BaseDao dao = new BaseDao();
    /**
     * Default constructor. 
     */
    public IndexFilter() {
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
		/*BaseDao dao = new BaseDao();
		System.out.println("index过滤器");
		String sql1 = "SELECT * FROM news WHERE ntid=1;";//国内
		String sql2 = "SELECT * FROM news WHERE ntid=2;";//国际
		String sql5 = "SELECT * FROM news WHERE ntid=5;";//娱乐
		String sqlAll = "SELECT * FROM news;";//所有
		Object[] obj = {};
		List<News> newsList1 = dao.executeQuery(sql1, obj, News.class);
		List<News> newsList2 = dao.executeQuery(sql2, obj, News.class);
		List<News> newsList5 = dao.executeQuery(sql5, obj, News.class);
		List<News> newsListAll = dao.executeQuery(sqlAll, obj, News.class);
		
		request.setAttribute("DomesticList", newsList1);
		request.setAttribute("ForeignList", newsList2);
		request.setAttribute("EntertainmentList", newsList5);
		request.setAttribute("allNews", newsListAll);*/
		
		
		
		String currPage = request.getParameter("currPage");
		int pageIndex;
		
		System.out.println(currPage);
		if(currPage==null||Integer.valueOf(currPage)<1) {
			page.setCurrPageNo(1);
			
		}else if(Integer.valueOf(currPage)>page.getTotalPageCount()){
			page.setCurrPageNo(page.getTotalPageCount());
		}else {
			page.setCurrPageNo(Integer.valueOf(currPage));
		}
		
		//pageIndex =Integer.parseInt(currPage);
		pageIndex=page.getCurrPageNo();
		
		System.out.println(pageIndex);
		//page.setCurrPageNo(pageIndex);
		
		String sql = "SELECT * FROM NEWS LIMIT ?,?;";
		System.out.println("从第"+(pageIndex-1)*page.getPageSize()+"条数据开始");
		
		Object[] obj = {(pageIndex-1)*page.getPageSize(),page.getPageSize()};

		
		List<News> pageNewsList = (List<News>)dao.executeQuery(sql, obj, News.class);
			
		
		request.setAttribute("currPage", pageIndex);
		request.setAttribute("allNews", pageNewsList);
		
		request.getRequestDispatcher("newlist?pageIndex="+pageIndex).forward(request, response);
		
		
		
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
