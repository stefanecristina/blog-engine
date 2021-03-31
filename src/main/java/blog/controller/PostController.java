package blog.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.controller.request.PostRequest;
import blog.model.PostModel;
import blog.repository.AuthorRepository;
import blog.repository.PostRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @GetMapping
  @ApiOperation(value = "List all posts with given category.")
  public List<PostModel> listAllPosts() {
    return this.postRepository.findAll();
  }

  @GetMapping("/categories")
  @ApiOperation(value = "List all posts categories.")
  public List<String> categories() {
    List<String> output = new java.util.ArrayList<String>();
    output.add("primeiro");
    output.add("segundo");
    output.add("terceiro");
    output.add("quarto");
    output.add("quinto");
    output.add("sexto");
    output.add("sétimo");
    output.add("oitavo");
    output.add("nono");
    return output;
  }

  @GetMapping("/{idPost}")
  @ApiOperation(value = "Details about the post with given identifier.")
  public ResponseEntity<PostModel> findPost(@PathVariable Long idPost) {
    Optional<PostModel> optModel = this.postRepository.findById(idPost);
    if(optModel.isPresent()) {
      return new ResponseEntity<>(optModel.get(), HttpStatus.OK);
    }
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  @ApiOperation(value = "Create or update post.")
  public ResponseEntity<PostModel> save(@RequestBody PostRequest postReq) {
    if(postReq.getIdAuthor() == null ||
        !this.authorRepository.existsById(postReq.getIdAuthor())) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final PostModel newPost = new PostModel();
    newPost.setDateTime(LocalDateTime.now());
    newPost.setAuthor(this.authorRepository.findById(postReq.getIdAuthor()).get());

    newPost.setContent(postReq.getContent());
    newPost.setIntro(postReq.getIntro());
    newPost.setTitle(postReq.getTitle());

    return new ResponseEntity<>(
      this.postRepository.save(newPost),
      HttpStatus.CREATED);
  }

}
