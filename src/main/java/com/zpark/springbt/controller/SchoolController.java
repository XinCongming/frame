package com.zpark.springbt.controller;

import com.zpark.springbt.common.QueryParam;
import com.zpark.springbt.dao.SchoolMapper;
import com.zpark.springbt.model.BootStraptable;
import com.zpark.springbt.model.School;
import com.zpark.springbt.model.SchoolExample;
import com.zpark.springbt.service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/school")
public class SchoolController {

    @Resource
    private ISchoolService schoolService;

    @RequestMapping("/index.html")
    public String testModel() {
        return "school_index";
    }
    @RequestMapping("/dash")
    public String testModel22() {
        return "school_dashboard";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delette(int id) {
        int deletenum = schoolService.delete(id);
        if(deletenum==1){
            return "yes";
        }
        return "none";
    }

    @RequestMapping("/submitEdit")
    @ResponseBody
    public String edit(@RequestBody School school) {
        int num = schoolService.update(school);
        return "edit1";
    }

    @RequestMapping("/{id}/edit2")
    public String edit2(Model model,@PathVariable int id) {
        School school = schoolService.queryById(id);
        model.addAttribute("school", school);
        return "school_new";
    }

    @RequestMapping("/bootstrap")
    @ResponseBody
    public BootStraptable model(@RequestBody(required = false) final QueryParam queryParam) {
        String search;
        if(queryParam.getSearch() ==null){
            search="";
        }else {
            //json数据形式，获取seracher（map）的searhlike k值对应value
            search = String.valueOf(queryParam.getSearch().get("searchLike"));
        }
        System.out.println("---------------------------------------------"+search);
        //根据页码计算开始记录索引
        Integer pageIndex = queryParam.getPageNumber();

        //根据当前查询条件，查询符合条件的记录数
        Integer total = this.schoolService.countByName(search);

        List<School> schools = this.schoolService.queryByName(search, pageIndex, queryParam.getPageSize());
        return new BootStraptable(total,schools);
    }


}
