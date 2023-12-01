package vn.edu.iuh.fit.week04.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import vn.edu.iuh.fit.week04.entities.JobSkill;
import vn.edu.iuh.fit.week04.ids.JobSkillId;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JobSkillDao extends AbstractDao<JobSkill, JobSkillId>{
    public JobSkillDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(JobSkill jobSkill) {
        String sql = "INSERT job_skill VALUES (?,?,?,?)";
        int updated = jdbcTemplate.update(sql, jobSkill.getMoreInformation(), jobSkill.getSkillLevel().getValue(), jobSkill.getJob().getId(), jobSkill.getSkill().getId());

        return updated > 0;
    }

    @Override
    public List<JobSkill> getAll() {
        String sql = "SELECT * FROM job_skill";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JobSkill.class));
    }

    @Override
    public Optional<JobSkill> findById(JobSkillId jobSkillID) {
//        String sql = "SELECT * FROM job_skill WHERE skill_id = ? and job_id = ?";

        return null;
    }

    @Override
    public boolean update(JobSkill jobSkill) {
        String sql = "UPDATE job_skill SET more_infos = ?, skill_level = ? WHERE skill_id = ? and job_id = ?";
        int updated = jdbcTemplate.update(sql, jobSkill.getMoreInformation(), jobSkill.getSkillLevel().getValue(), jobSkill.getSkill().getId(), jobSkill.getJob().getId());

        return updated > 0;
    }

    @Override
    public boolean delete(JobSkillId jobSkillID) {
        String sql = "DELETE FROM job_skill WHERE skill_id = ? and job_id = ?";
        int updated = jdbcTemplate.update(sql, jobSkillID.getSkill().getId(), jobSkillID.getJob().getId());

        return updated > 0;
    }
}
