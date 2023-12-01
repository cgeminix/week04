package vn.edu.iuh.fit.week04.daos;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<A, ID> {
    private final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;
    public AbstractDao(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public abstract boolean create(A a);

    public abstract List<A> getAll();

    public abstract Optional<A> findById(ID id);

    public abstract boolean update(A a);

    public abstract boolean delete(ID id);
}
