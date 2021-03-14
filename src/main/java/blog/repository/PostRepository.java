package blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
