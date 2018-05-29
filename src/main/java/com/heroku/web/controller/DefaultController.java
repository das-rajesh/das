/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.controller;

import com.heroku.web.entity.Skill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author RAJESH
 */
@Controller
@RequestMapping(value = "/home")
public class DefaultController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
      
        //model.addAttribute("name", "Zayan malik");
        
        String sql="select * from mst_skills";
         List<Skill> skills=jdbcTemplate.query(sql, new RowMapper<Skill>() {
            @Override
            public Skill mapRow(ResultSet rs, int i) throws SQLException {
                return new Skill(rs.getInt("id"),rs.getString("name"));
             }
        });
         model.addAttribute("skills", skills);
        return "index";
    }
    
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    @ResponseBody
    public String about(){
        return "<h1>About us</h1>";
    }
    
    
    @RequestMapping(value = "/table",method = RequestMethod.GET)
    @ResponseBody
    public String table(){
        String sql="create table mst_skills(id serial primary key,"
                + "name varchar(50) not null)";
        int result=jdbcTemplate.update(sql);
        return result+"";
    }
   
    
   /* @Override
    public ModelAndView handleRequest(HttpServletRequest request
            , HttpServletResponse response) throws Exception {
        ModelAndView mav=new ModelAndView();
        mav.addObject("name", "rajesh");
        mav.setViewName("/WEB-INF/views/index.jsp");
          return mav;
    }*/
    
}
