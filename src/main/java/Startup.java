import entity.Comic;
import entity.Dictionary;
import entity.Magazine;
import entity.Personal;
import repository.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * Created by asari on 2015/05/04.
 */
@Singleton
@javax.ejb.Startup
public class Startup {
    @Inject
    private MessageRepository repository;
    @Inject
    private ComicRepository comicRepository;
    @Inject
    private DictionaryRepository dictionaryRepository;
    @Inject
    private MagazineRepository magazineRepository;
    @Inject
    private PersonalRepository personalRepository;

    @PostConstruct
    public void startup() {
        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setTitle("title #" + i);
            message.setAuthor("author #" + i);
            message.setContext("context #" + i);
            repository.save(message);
        }
        Comic comic = new Comic();
        comic.setTitle("ワンピース");
        comic.setAuthor("おだ");
        Comic savedComic = comicRepository.save(comic);

        Dictionary dictionary = new Dictionary();
        dictionary.setTitle("広辞苑");
        dictionary.setAuthor("岩波書店");
        Dictionary savedDictionary = dictionaryRepository.save(dictionary);

        Magazine magazine = new Magazine();
        magazine.setTitle("週刊アスキー");
        magazine.setAuthor("アスキー");
        magazineRepository.save(magazine);

        Personal bob = new Personal();
        bob.setName("ボブ");
        bob.setBook(savedComic);
        personalRepository.save(bob);

        Personal alice = new Personal();
        alice.setName("アリス");
        alice.setBook(savedDictionary);
        personalRepository.save(alice);

        personalRepository.findMany("ワンピース").forEach(System.out::println);
    }
}
