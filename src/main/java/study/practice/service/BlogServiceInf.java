package study.practice.service;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import study.practice.enity.Blog;
import study.practice.exception.BlogAllreadyExistException;
import study.practice.exception.BlogNotFoundException;

public interface BlogServiceInf {
	
	
	public Blog saveBlog(Blog blog) throws BlogAllreadyExistException;
	public Blog getBlog(int id) throws BlogNotFoundException;
	public List<Blog> getAllBlogs();
	public String updateBlog(Blog blog,int id)throws BlogNotFoundException;
	public Blog deleteBlog(int id)throws BlogNotFoundException;
	
	
}
