package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import blog.model.Post;
import blog.repository.PostRepository;

@RestController
@ResponseBody
@RequestMapping("/post")
public class PostController {

  @Autowired
  private PostRepository postRepository;

  @PostMapping
  public Post save(@RequestBody Post post) {
    post = this.postRepository.save(post);
    return post;
  }

}
