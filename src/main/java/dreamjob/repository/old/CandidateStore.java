package dreamjob.repository.old;

import dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final AtomicInteger mapKey = new AtomicInteger(0);

    private final AtomicInteger cid = new AtomicInteger(1);

    private CandidateStore() {
        add(new Candidate("Java Candidate 1", "Junior"));
        add(new Candidate("Java Candidate 2", "Middle"));
        add(new Candidate("Java Candidate 3", "Senior"));
        add(new Candidate("Java Candidate 4", "Guru"));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidate.setId(cid.getAndIncrement());
        candidates.put(mapKey.getAndIncrement(), candidate);
    }

    public void update(Candidate candidate) {
        candidates.replace(candidate.getId() - 1, candidate);
    }

    public Candidate findById(int id) {
        return findAll().stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
