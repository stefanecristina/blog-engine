package blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import blog.model.AuthorModel;
import blog.repository.AuthorRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

  @Autowired
  private AuthorRepository authorRepository;

  @GetMapping @ApiOperation(value = "List all authors.")
  public List<AuthorModel> all() {
    return this.authorRepository.findAll();
  }

  @PostMapping @ApiOperation(value = "Update or creates new author.")
  public ResponseEntity<AuthorModel> save(@RequestBody AuthorModel author) {
    boolean isEditing = false;
    if(author != null && author.getIdAuthor() != null) {
      isEditing = true;
      if(!this.authorRepository.existsById(author.getIdAuthor()))
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      else author.setProfileImage(this.authorRepository.findById(
        author.getIdAuthor()).get().getProfileImage());
    }
    return new ResponseEntity<>(this.authorRepository.save(author),
      isEditing ? HttpStatus.OK : HttpStatus.CREATED);
  }

  @PutMapping(value = "/{idAuthor}")
  @ApiOperation(value = "Upload author profile picture.")
  public ResponseEntity<Boolean> upload(@PathVariable Long idAuthor,
      @RequestParam MultipartFile profileImage) throws IOException {
    Optional<AuthorModel> optAuthor = this.authorRepository.findById(idAuthor);
    if(!optAuthor.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    AuthorModel author = optAuthor.get();
    author.setProfileImage(profileImage.getBytes());
    this.authorRepository.save(author);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  private AuthorModel getAuthorFromId(Long idAuthor) {
    Optional<AuthorModel> optAuthor = this.authorRepository.findById(idAuthor);
    return optAuthor.isPresent() ? optAuthor.get() : null;
  }

  @GetMapping(value = "/{idAuthor}/profile.png", produces = MediaType.IMAGE_PNG_VALUE)
  @ApiOperation(value = "Get author's profile picture.")
  public ResponseEntity<byte[]> profileImage(@PathVariable Long idAuthor) {
    AuthorModel author = this.getAuthorFromId(idAuthor);
    return author == null || author.getProfileImage() == null ?
      new ResponseEntity<>(HttpStatus.NOT_FOUND) :
      new ResponseEntity<>(author.getProfileImage(), HttpStatus.OK);
  }

  @GetMapping(value = "/{idAuthor}")
  @ApiOperation(value = "Get author's profile information.")
  public ResponseEntity<AuthorModel> info(@PathVariable Long idAuthor) {
    AuthorModel author = this.getAuthorFromId(idAuthor);
    return author == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :
      new ResponseEntity<>(author, HttpStatus.OK);
  }

}
