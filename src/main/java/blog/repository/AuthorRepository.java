package blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.model.AuthorModel;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {

}
