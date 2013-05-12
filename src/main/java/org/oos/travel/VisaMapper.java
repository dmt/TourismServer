package org.oos.travel;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisaMapper implements ResultSetMapper<Visa> {
    @Override
    public Visa map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Visa(r.getInt("id"), r.getString("name"), "");
    }
}
