package dreamjob.store;

import dreamjob.model.Candidate;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Java Candidate 1", "Junior", LocalDateTime.now()));
        candidates.put(2, new Candidate(2, "Java Candidate 2", "Middle", LocalDateTime.now()));
        candidates.put(3, new Candidate(3, "Java Candidate 3", "Senior", LocalDateTime.now()));
        candidates.put(4, new Candidate(4, "Java Candidate 4", "Guru", LocalDateTime.now()));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }
}
