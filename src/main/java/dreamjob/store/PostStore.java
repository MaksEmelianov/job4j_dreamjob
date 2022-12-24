package dreamjob.store;

import dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {

    public static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final AtomicInteger mapKey = new AtomicInteger(0);

    private final AtomicInteger pid = new AtomicInteger(1);

    private PostStore() {
        add(new Post("Junior Java Job", "Desc Junior Java Dev"));
        add(new Post("Middle Java Job", "Desc Middle Java Dev"));
        add(new Post("Senior Java Job", "Desc Senior Java Dev"));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        post.setId(pid.getAndIncrement());
        post.setCreated(LocalDateTime.now());
        posts.put(mapKey.getAndIncrement(), post);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }

    public Post findById(int id) {
        return findAll().stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
