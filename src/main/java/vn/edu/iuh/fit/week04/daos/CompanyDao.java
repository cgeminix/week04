package vn.edu.iuh.fit.week04.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import vn.edu.iuh.fit.week04.entities.Company;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CompanyDao extends AbstractDao<Company, UUID>{
    public CompanyDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Company company) {
        String sql = "INSERT company VALUES (?,?,?,?,?,?,?)";
        int inserted = jdbcTemplate.update(sql, company.getId(), company.getAbout(), company.getEmail(), company.getCompanyName(), company.getPhone(), company.getWebUrl(), company.getAddress());

        return inserted > 0;
    }

    @Override
    public List<Company> getAll() {
        String sql = "SELECT * FROM company";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Company.class));
    }

    @Override
    public Optional<Company> findById(UUID uuid) {
        String sql = "SELECT * from company where comp_id = ?";
        Company company = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Company.class));

        return company==null?Optional.empty():Optional.of(company);
    }

    @Override
    public boolean update(Company company) {
        String sql = "UPDATE company SET about = ?, email = ?, comp_name = ?, phone = ?, web_url = ?, address = ? WHERE comp_id = ?";
        int updated = jdbcTemplate.update(sql, company.getAbout(), company.getEmail(), company.getCompanyName(), company.getPhone(), company.getWebUrl(), company.getAddress().getId(), company.getId());

        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM company WHERE comp_id = ?";

        return jdbcTemplate.update(sql, uuid) > 0;
    }
}
