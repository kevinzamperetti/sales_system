package kzs.com.br.sales_system.domain.repository;

import kzs.com.br.sales_system.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepository {

    private static String INSERT = "insert into client(name) values (?)";
    private static String UPDATE = "update client set name = ? where id = ?";
    private static String DELETE = "delete from client where id = ?";
    private static String SELECT_ALL = "select * from client";
    private static String SELECT_BY_NAME = "select * from client where name like ?";

    private final JdbcTemplate jdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Client save(Client client) {
        jdbcTemplate.update(INSERT, new Object[]{client.getName()});
        return client;
    }

    public Client update(Client client) {
        jdbcTemplate.update(UPDATE, new Object[]{client.getName(), client.getId()});
        return client;
    }

    public void delete(Client client) {
        deleteById(client.getId());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<Client> getClients() {
        return jdbcTemplate.query(SELECT_ALL, getClientMapper());
    }

    public List<Client> getClientByName(String name) {
        return jdbcTemplate.query(SELECT_BY_NAME, new Object[]{"%" + name + "%"}, getClientMapper());
    }

    private RowMapper<Client> getClientMapper() {
        return new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                return new Client(id, name);
            }
        };
    }

}

