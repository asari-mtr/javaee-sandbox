import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by asari on 2015/04/14.
 */
@Model
public class MessageController {
    @Inject
    private MessageRepository messageRepository;
    @Inject
    private TagRepository tagRepository;
    @Inject
    private Profile profile;
    private Message newMessage = new Message();

    private String keyword;
    private long num;
    private Collection<Tag> tags;

    public long result() {
        return profile.getAge() * 123;
    }

    public String getKeyword() {
        return keyword;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String say() {
        return "hello world,,,,";
    }

    public Message getNewMessage() {
        return newMessage;
    }

    public String next() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash()
                .put("myname", "john doe");

        return "next";
    }
    public void register() {
        Message message = newMessage;
        message.setUpdateDate(new Date());
        messageRepository.save(message);

        newMessage = new Message();
    }

    public List<Message> findAll() {
        return messageRepository.findAll().stream().filter( message -> message.getTitle().contains(keyword)).collect(Collectors.toList());
    }
    public List<Tag> findTag() {
        return tagRepository.findAll();
    }

    public void addTag() {
        tagRepository.save(new Tag("hoge" + System.currentTimeMillis()));
    }
    
    public void setTags(Collection<Tag> tags) {
        for (Tag tag : tags) {
            System.out.println(tag.getId() + ":" + tag.getName());
        }
        this.tags = tags;
    }
    public Collection<Tag> getTags() {
        return this.tags;
    }
    public void refresh() {
        for (Tag tag : tags) {
            System.out.println(tag.getId() + ":" + tag.getName());
        }

    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
