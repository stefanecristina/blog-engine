package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import blog.model.PostModel;
import blog.repository.PostRepository;

@RestController
@ResponseBody
@RequestMapping("/posts")
public class PostsController {

  @Autowired
  private PostRepository postRepository;

  @GetMapping
  public List<PostModel> listPosts() {
    return this.postRepository.findAll();
  }

}
