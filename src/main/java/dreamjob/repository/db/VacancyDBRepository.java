package dreamjob.repository.db;

import dreamjob.model.Vacancy;
import dreamjob.repository.interfaces.VacancyRepository;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VacancyDBRepository implements VacancyRepository {

    private final BasicDataSource pool;

    public VacancyDBRepository(BasicDataSource pool) {
        this.pool = pool;
    }

    @Override
    public List<Vacancy> findAll() {
        List<Vacancy> vacancies = new ArrayList<>();
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT * FROM vacancy")) {
            try (ResultSet query = ps.executeQuery()) {
                while (query.next()) {
                    vacancies.add(new Vacancy(
                            query.getInt("id"),
                            query.getString("title"),
                            query.getString("description"),
                            query.getBoolean("visible"),
                            query.getInt("cityId"))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement(
                     "INSERT INTO vacancy(title, description, createDate, visible, cityId) "
                             + "VALUES (?, ?, ?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, vacancy.getTitle());
            ps.setString(2, vacancy.getDescription());
            ps.setTimestamp(3, Timestamp.valueOf(vacancy.getCreateDate()));
            ps.setBoolean(4, vacancy.getVisible());
            ps.setInt(5, vacancy.getCityId());
            ps.execute();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    vacancy.setId(keys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vacancy;
    }

    @Override
    public boolean update(Vacancy vacancy) {
        boolean result = false;
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement(
                     "update vacancy set title = ?, description = ?, "
                             + "createDate = ?, visible = ?, cityId = ?"
                             + "where id = ?")) {
            ps.setString(1, vacancy.getTitle());
            ps.setString(2, vacancy.getDescription());
            ps.setTimestamp(3, Timestamp.valueOf(vacancy.getCreateDate()));
            ps.setBoolean(4, vacancy.getVisible());
            ps.setInt(5, vacancy.getCityId());
            ps.setInt(6, vacancy.getId());
            result = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteById(int id) {
        var vacancy = findById(id).orElseThrow();
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement("delete from vacancy where id = ?")) {
            ps.setInt(1, vacancy.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        Optional<Vacancy> result = Optional.empty();
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT * FROM vacancy WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet query = ps.executeQuery()) {
                if (query.next()) {
                    result = Optional.of(new Vacancy(
                            query.getInt("id"),
                            query.getString("title"),
                            query.getString("description"),
                            query.getBoolean("visible"),
                            query.getInt("cityId")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
