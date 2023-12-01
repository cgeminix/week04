package vn.edu.iuh.fit.week04.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week04.entities.Job;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JobDao extends AbstractDao<Job, UUID>{
    public JobDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Job job) {
        String sql = "INSERT job VALUES (?,?,?,?)";
        int updated = jdbcTemplate.update(sql, job.getId(), job.getDescription(), job.getName(), job.getCompany().getId());
        ;

        return updated > 0;
    }

    @Override
    public List<Job> getAll() {
        String sql = "SELECT * FROM job";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Job.class));
    }

    @Override
    public Optional<Job> findById(UUID uuid) {
        String sql = "SELECT * FROM JOB WHERE job_id = ?";
        Job job = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Job.class), uuid);

        return job == null ? Optional.empty() : Optional.of(job);
    }

    @Override
    public boolean update(Job job) {
        String sql = "UPDATE JOB SET job_desc = ?, job_name = ?, company = ? WHERE job_id = ?";
        int updated = jdbcTemplate.update(sql, job.getDescription(), job.getName(), job.getCompany().getId(), job.getId());

        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM job WHERE job_id = ?";
        int updated = jdbcTemplate.update(sql, uuid);

        return updated > 0;
    }
}
