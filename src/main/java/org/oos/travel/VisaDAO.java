package org.oos.travel;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.sql.ResultSet;
import java.util.List;

@RegisterMapper(VisaMapper.class)
public interface VisaDAO {
    @SqlUpdate("create table visa (id int primary key, name varchar(100))")
    void createVisaTable();

    @SqlUpdate("insert into visa (id, name) values (:id, :name)")
    void insert(@Bind("id") long id, @Bind("name") String name);

    @SqlQuery("select name from visa where id = :id")
    String findNameById(@Bind("id") int id);

    @SqlQuery("select * from visa")
    List<Visa> findAll();
}
