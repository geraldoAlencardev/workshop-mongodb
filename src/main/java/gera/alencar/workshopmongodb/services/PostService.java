package gera.alencar.workshopmongodb.services;

import gera.alencar.workshopmongodb.domain.Post;
import gera.alencar.workshopmongodb.repository.PostRepository;
import gera.alencar.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
}
