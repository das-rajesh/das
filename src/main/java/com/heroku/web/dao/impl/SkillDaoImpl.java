/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.dao.impl;

import com.heroku.web.dao.SkillDao;
import com.heroku.web.entity.Skill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RAJESH
 */
@Repository(value = "skillDAOImpl")
public class SkillDaoImpl implements SkillDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Skill> getAll()  {
    
        return jdbcTemplate.query("select * from mst_skills", new RowMapper<Skill>() {
            @Override
            public Skill mapRow(ResultSet rs, int i) throws SQLException {
          
                return new Skill(rs.getInt("id"),rs.getString("name"));
            }
        });
    }

    @Override
    public int insert(Skill model) {
      String sql="insert into mst_skills(name) values(?)";
      return jdbcTemplate.update(sql, new Object[]{model.getName()});
    }

    @Override
    public int update(Skill model) {
      String sql="update mst_skills set name=? where id=?";
      return jdbcTemplate.update(sql
              , new Object[]{model.getName()
              ,model.getId()});
    }

    @Override
    public int delete(int id) {
            String sql="delete from mst_skills where id =?";
            return jdbcTemplate.update(sql,new Object[]{id});
     }

    @Override
    public Skill getById(int id) {

        String sql="select * from mst_skills where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Skill>() {
            @Override
            public Skill mapRow(ResultSet rs, int i) throws SQLException {
                 return new Skill(rs.getInt("id"), rs.getString("name"));
            }
        });
    }
    
}
