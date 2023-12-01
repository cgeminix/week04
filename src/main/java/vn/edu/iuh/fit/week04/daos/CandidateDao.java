package vn.edu.iuh.fit.week04.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week04.entities.Candidate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CandidateDao extends AbstractDao<Candidate, UUID>{
    public CandidateDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Candidate candidate) {
        String sql = "INSERT candidate VALUES (?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, candidate.getId(), candidate.getDob(), candidate.getEmail(), candidate.getFullName(), candidate.getPhone(), candidate.getAddress().getId());

        return update > 0;
    }

    @Override
    public List<Candidate> getAll() {
        String sql = "Select * from candidate";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Candidate.class));
    }

    @Override
    public Optional<Candidate> findById(UUID uuid) {
        String sql = "SELECT * FROM candidate where id = ?";
        Candidate candidate = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Candidate.class), uuid);
        return candidate == null ? Optional.empty() : Optional.of(candidate);
    }

    @Override
    public boolean update(Candidate candidate) {
        String sql = "UPDATE candidate SET dob = ?, email = ?, full_name = ?, phone = ?, address = ? WHERE id = ?";
        int updated = jdbcTemplate.update(sql, candidate.getDob(), candidate.getEmail(), candidate.getFullName(), candidate.getPhone(), candidate.getAddress().getId(), candidate.getId());

        return updated > 0;

    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM candidate WHERE id = ?";
        int updated = jdbcTemplate.update(sql, uuid);

        return updated > 0;
    }
}
