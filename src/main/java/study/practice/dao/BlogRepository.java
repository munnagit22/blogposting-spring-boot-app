package study.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import study.practice.enity.Blog;
@Component
public interface BlogRepository extends CrudRepository<Blog, Integer> {

}
