package blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
