package vn.edu.iuh.fit.week04.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week04.entities.Skill;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SkillDao extends AbstractDao<Skill, UUID>{
    public SkillDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Skill skill) {
        String sql = "INSERT skill VALUES (?,?,?,?)";
        int updated = jdbcTemplate.update(sql, skill.getId(), skill.getSkillName(), skill.getSkillDescription(), skill.getType().getValue());

        return updated > 0;
    }

    @Override
    public List<Skill> getAll() {
        String sql = "SELECT * FROM skill";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Skill.class));
    }

    @Override
    public Optional<Skill> findById(UUID uuid) {
        String sql = "SELECT * FROM skill WHERE skill_id = ?";
        Skill skill = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Skill.class), uuid);

        return skill == null ? Optional.empty() : Optional.of(skill);
    }

    @Override
    public boolean update(Skill skill) {
        String sql = "UPDATE skill SET skill_description = ?, skill_name = ?, type = ? WHERE skill_id = ?";
        int updated = jdbcTemplate.update(sql, skill.getSkillDescription(), skill.getSkillName(), skill.getType().getValue(), skill.getId());

        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM skill WHERE skill_id = ?";
        int updated = jdbcTemplate.update(sql, uuid);

        return updated > 0;
    }
}
