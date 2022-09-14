package study.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import study.practice.enity.Blog;
import study.practice.exception.BlogAllreadyExistException;
import study.practice.exception.BlogNotFoundException;
import study.practice.service.BlogServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {
	
	@Autowired
	private BlogServiceImp blogService;
	
	@PostMapping("/addblog")
	 public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) throws BlogAllreadyExistException
	 {
		     
		    return new ResponseEntity<Blog>( blogService.saveBlog(blog),HttpStatus.OK);
	 }
    @GetMapping("/findblogbyid/{id}")
	public ResponseEntity<Blog> getBlog(@PathVariable("id") int id)throws BlogNotFoundException
	{
		 return new ResponseEntity<Blog>( blogService.getBlog(id),HttpStatus.OK);
	}
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllblogs()
    {
    	return new ResponseEntity<List<Blog>>(blogService.getAllBlogs(),HttpStatus.OK);
    }
    
    @PutMapping("/updateblog/{id}")
    public ResponseEntity<String> updateBlog(@RequestBody Blog blog ,@PathVariable("id") int id) throws BlogNotFoundException
    {
    
    	 return new ResponseEntity<String>(blogService.updateBlog(blog, id),HttpStatus.OK);
    }
    @DeleteMapping("/deleteByid/{id}")
    public ResponseEntity<Blog>deleteBlog(@PathVariable("id") int id)throws BlogNotFoundException
    {
    	return new ResponseEntity<Blog>(blogService.deleteBlog(id),HttpStatus.OK);
    }
    /*
    @ExceptionHandler(value =BlogNotFoundException.class)
    public ResponseEntity<String> BlogNotFoundException(BlogNotFoundException blogNotFoundException) {
        return new ResponseEntity<String>("Blog not exists", HttpStatus.CONFLICT);
    } */
}
