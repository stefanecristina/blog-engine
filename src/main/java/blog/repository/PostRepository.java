package blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.model.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Long> {

}
