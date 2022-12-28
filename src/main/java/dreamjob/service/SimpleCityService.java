package dreamjob.service;

import dreamjob.model.City;
import dreamjob.repository.interfaces.CityRepository;
import dreamjob.service.interfaceы.CityService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SimpleCityService implements CityService {

    private final CityRepository cityRepository;

    public SimpleCityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Collection<City> findAll() {
        return cityRepository.findAll();
    }
}
