/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.dashboard;

import com.heroku.web.dao.SkillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RAJESH
 */
@Controller
@RequestMapping(value = "/admin/skills")
public class SkillController {
    
    @Autowired
    private SkillDao skillDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        map.addAttribute("skills", skillDao.getAll());
        return "/admin/dashboard/index";
    }
     @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        
        return "/admin/dashboard/add";
    }
    
     @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")int id, ModelMap map){
        map.addAttribute("skill", skillDao.getById(id));
        
        return "/admin/dashboard/edit";
    }
    
}
