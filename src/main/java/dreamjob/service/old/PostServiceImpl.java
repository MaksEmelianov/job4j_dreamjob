package dreamjob.service.old;

import dreamjob.model.old.Post;
import dreamjob.repository.old.PostStore;

import java.util.List;

public class PostServiceImpl implements PostService {

    private final PostStore postStore = PostStore.INST;

    @Override
    public List<Post> findAll() {
        return (List<Post>) postStore.findAll();
    }

    @Override
    public Post findById(int id) {
        return postStore.findById(id);
    }

    @Override
    public void add(Post post) {
        postStore.add(post);
    }

    @Override
    public void update(Post post) {
        postStore.update(post);
    }
}
