package dreamjob.store;

import dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostStore {

    public static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Desc Junior Java Dev", LocalDateTime.now()));
        posts.put(2, new Post(2, "Middle Java Job", "Desc Middle Java Dev", LocalDateTime.now()));
        posts.put(3, new Post(3, "Senior Java Job", "Desc Senior Java Dev", LocalDateTime.now()));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

}