package study.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import study.practice.dao.BlogRepository;
import study.practice.enity.Blog;
import study.practice.exception.BlogAllreadyExistException;
import study.practice.exception.BlogNotFoundException;

@Service
public class BlogServiceImp implements BlogServiceInf {

	@Autowired
	private BlogRepository blogRepository;
	
	public Blog saveBlog(Blog blog) throws BlogAllreadyExistException
	{
	       Blog save;
	       if(blogRepository.findById(blog.getBlogId()).isPresent())
	       {
	    	   throw new BlogAllreadyExistException();
	       }
	       else {
	    		save = blogRepository.save(blog);
		}
	       
		return save;
	}
	public Blog getBlog(int id) throws BlogNotFoundException
	{
		Blog blog;
		if(!blogRepository.findById(id).isPresent())
		{
			throw new BlogNotFoundException();
		}
		else {
			blog=blogRepository.findById(id).get();
		}
		
		
		return blog;
	}
	public List<Blog> getAllBlogs()
	{
		List<Blog> blogs = (List<Blog>) blogRepository.findAll();
		return blogs;
	}
	@Override
	public String updateBlog(Blog blog, int id) throws BlogNotFoundException {

		if (!blogRepository.findById(id).isPresent()) {
			throw new BlogNotFoundException();
		} else {
			Blog blogExistBlog = blogRepository.findById(id).get();
			blogExistBlog.setBlogTitle(blog.getBlogTitle());
			blogExistBlog.setBlogCreator(blog.getBlogCreator());
			blogRepository.save(blogExistBlog);
			return "Record updated successfully";
		}
	}
	@Override
	public Blog deleteBlog(int id) throws BlogNotFoundException {

		if (!blogRepository.findById(id).isPresent())
		{
			throw new BlogNotFoundException();
		} else {
			Blog deleteBlog = blogRepository.findById(id).get();
			blogRepository.deleteById(id);
			return deleteBlog;
		}

	}
		
	
}
