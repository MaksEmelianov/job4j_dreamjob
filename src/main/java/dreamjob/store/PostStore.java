package dreamjob.store;

import dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostStore {

    public static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Integer count = 0;

/*    private PostStore() {
        add(new Post(1, "Junior Java Job", "Desc Junior Java Dev", LocalDateTime.now()));
        add(new Post(2, "Middle Java Job", "Desc Middle Java Dev", LocalDateTime.now()));
        add(new Post(3, "Senior Java Job", "Desc Senior Java Dev", LocalDateTime.now()));
    }*/

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        posts.put(count++, post);
    }
}
