package com.news.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.news.entity.News;
import com.news.entity.Page;
import com.news.util.BaseDao;


@Controller
public class newsAction {
	BaseDao dao = new BaseDao();
	Page page = new Page();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@RequestMapping("/addnews")
	public String addNews(int ntid,String ntitle,String nauthor,String ncontent,HttpServletRequest request) {
		
		Date date = new Date();
		News news = new News();
		news.setNtid(ntid);
		news.setTitle(ntitle);
		news.setAurthor(nauthor);
		news.setCreatedate(date);
		news.setContent(ncontent);
		String sql = "INSERT INTO news(ntid,title,author,createdate,content) VALUE (?,?,?,?,?)";
		Object[] obj = {ntid,ntitle,nauthor,date,ncontent};
		Boolean val = dao.executeUpdate(sql, obj);
		System.out.println(val);
		if(val) {
			request.setAttribute("news", news);
			return "news_read";
		}else {
			return "newspages/news_add";
		}
	}
	@RequestMapping("/readnews")
	public String readNews(HttpServletRequest request){
		String newsId = request.getParameter("nid");
		String sql = "SELECT * FROM news WHERE nid = ?;";
		Object[] obj = {newsId};
		List<News> news = dao.executeQuery(sql, obj, News.class);
		if(news.size()>0){
			request.setAttribute("news", news.get(0));
		}
		return "/news_read.jsp?nid="+newsId;
	}
	@RequestMapping("/newlist")
	public String newList(HttpServletRequest request) {
		
		String pageIndex = request.getParameter("pageIndex");
		System.out.println("newlist---pageIndex="+pageIndex);
		int currPage = Integer.valueOf(pageIndex);
		System.out.println("newlist---currPage="+currPage);
		
				request.setAttribute("currPage", currPage);
		
		return "index";
	}
	
	@RequestMapping("/page")
	public String pageNews(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("已进入pageAction");
		//Page page = new Page();
		
		int pageIndex =Integer.parseInt(request.getParameter("currPage"));
		
		page.setCurrPageNo(pageIndex);
		
		String sql = "SELECT * FROM NEWS LIMIT ?,?;";
		System.out.println("从第"+(pageIndex-1)*page.getPageSize()+"条数据开始");
		
		Object[] obj = {(pageIndex-1)*page.getPageSize(),page.getPageSize()};

		
		List<News> pageNewsList = (List<News>)dao.executeQuery(sql, obj, News.class);

			
		
		session.setAttribute("currPage", pageIndex);
		session.setAttribute("allNews", pageNewsList);
		return "forward:/newlist";
	}
	
	
	
}
