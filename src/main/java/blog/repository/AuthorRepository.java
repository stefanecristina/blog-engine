package blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
