import entity.Comic;
import entity.Dictionary;
import entity.Magazine;
import repository.ComicRepository;
import repository.DictionaryRepository;
import repository.MagazineRepository;
import repository.SmartRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.inject.Named;

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
        comicRepository.save(comic);

        Dictionary dictionary = new Dictionary();
        dictionary.setTitle("広辞苑");
        dictionary.setAuthor("岩波書店");
        dictionaryRepository.save(dictionary);

        Magazine magazine = new Magazine();
        magazine.setTitle("週刊アスキー");
        magazine.setAuthor("アスキー");
        magazineRepository.save(magazine);
    }
}
