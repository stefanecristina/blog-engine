package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import blog.controller.request.PostRequest;
import blog.model.PostModel;
import blog.repository.AuthorRepository;
import blog.repository.PostRepository;

@RestController
@ResponseBody
@RequestMapping("/post")
public class PostController {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @PostMapping
  public ResponseEntity<PostModel> newPost(@RequestBody PostRequest postReq) {

    final PostModel newPost = new PostModel();
    newPost.setAuthor(this.authorRepository.findById(postReq.getIdAuthor()).get());

    //...

    return new ResponseEntity<PostModel>(
      this.postRepository.save(newPost),
      HttpStatus.CREATED);
  }

}
