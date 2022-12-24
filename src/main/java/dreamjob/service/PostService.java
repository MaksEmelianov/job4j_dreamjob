package dreamjob.service;

import dreamjob.model.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(int id);

    void add(Post post);

    void update(Post post);
}
