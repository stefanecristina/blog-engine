package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.model.Post;
import blog.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostsController {

  @Autowired
  private PostRepository postRepository;

  @GetMapping
  public List<Post> listPosts() {
    List<Post> posts = postRepository.findAll();
    return posts;
  }

}
