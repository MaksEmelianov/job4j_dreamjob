package dreamjob.repository.interfaces;

import dreamjob.model.City;

import java.util.Collection;

public interface CityRepository {

    Collection<City> findAll();
}
