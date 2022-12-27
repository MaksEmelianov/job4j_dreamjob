package dreamjob.repository.memory;

import dreamjob.model.City;
import dreamjob.repository.interfaces.CityRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemoryCityRepository implements CityRepository {

    private final AtomicInteger nextId = new AtomicInteger(1);

    private final Map<Integer, City> cities = new ConcurrentHashMap<>() {
        {
            put(1, new City(1, "Москва"));
            put(2, new City(2, "Санкт-Петербург"));
            put(3, new City(3, "Екатеринбург"));
        }
    };

    @Override
    public Collection<City> findAll() {
        return cities.values();
    }
}
