package blog.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import blog.model.Author;
import blog.model.Image;
import blog.model.Post;

@Repository
public class PostRepository {

  public List<Post> listAll() {
    List<Post> listinha = new ArrayList<Post>();

    Post arcanista = new Post();
    arcanista.setTitle("Arcanistas s\u00e3o fodas");
    arcanista.setIntro("Desta maneira, o entendimento das metas propostas ainda n\u00e3o demonstrou convincentemente que vai participar na mudan\u00e7a das dire\u00e7\u00f5es preferenciais no sentido do progresso.");
    arcanista.setDateTime(LocalDateTime.of(2020, 9, 28, 21, 32));
    arcanista.setImg(new Image("/images/wizard.jpg", "Arcanista"));
    arcanista.setAuthor(new Author("Maia", "https://fb.com/lipemaia"));
    listinha.add(arcanista);

    Post necromante = new Post();
    necromante.setTitle("Necromantes tamb\u00e9m s\u00e3o fodas");
    necromante.setIntro("Ainda assim, existem d\u00favidas a respeito de como o fen\u00f4meno da Internet garante a contribui\u00e7\u00e3o de um grupo importante na determina\\u00e7\\u00e3o dos \u00edndices pretendidos.");
    necromante.setDateTime(LocalDateTime.of(2020, 9, 27, 19, 45));
    necromante.setImg(new Image("/images/necro.jpg", "Necromante"));
    necromante.setAuthor(new Author("Maia", "https://fb.com/lipemaia"));
    listinha.add(necromante);

    Post feiticeira = new Post();
    feiticeira.setTitle("Feiticeiras são muito mais fodas");
    feiticeira.setIntro("Suas habilidades são extremamente inteligentes e ágeis.");
    feiticeira.setDateTime(LocalDateTime.of(2020, 9, 26, 20, 28));
    feiticeira.setImg(new Image("/images/witch-doctor.jpg", "Feiticeira."));
    feiticeira.setAuthor(new Author("Stéfane Cristina", "https://www.facebook.com/stefane.cristina.566148"));
    listinha.add(feiticeira);

    return listinha;
  }

}
