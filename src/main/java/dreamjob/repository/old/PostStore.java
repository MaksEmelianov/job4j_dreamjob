package dreamjob.repository.old;

import dreamjob.model.old.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {

    public static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final AtomicInteger nextId = new AtomicInteger(1);

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
        post.setId(nextId.getAndIncrement());
        posts.put(post.getId(), post);
    }

    public void update(Post post) {
        posts.replace(post.getId() - 1, post);
    }

    public Post findById(int id) {
        return findAll().stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
