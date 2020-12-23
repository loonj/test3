package cn.zhanx.test3.controller;


import cn.zhanx.test3.entity.Student;
import cn.zhanx.test3.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("student")
@Api(tags = "学生Controller")
public class StudentController {

 public static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService service;

    @ResponseBody
    @RequestMapping("insert")
    public int insert(){
        Student model=new Student();
        model.setBk("http://www.zhanx.cn");
        model.setClassx("高100班");
        model.setGender(1);
        model.setInsertTime(new Date());
        model.setName("张霞想");
        model.setPwd("121212");
        model.setStatus(1);
        model.setUid("Richard Li");
        logger.info("插入成功info");
        logger.debug("插入成功debug");
        return service.insert(model);
    }

    @ResponseBody
    @RequestMapping("delete")
    public int delete(int id) {
        return service.delete(id);
    }

    @ResponseBody
    @RequestMapping(value="update",method=RequestMethod.POST)
    public int update(@RequestBody JSONObject jsonObject){
        Student model = service.find(jsonObject.getInteger("id"));
        model.setName(jsonObject.getString("name"));
        model.setBk(jsonObject.getString("bk"));
        model.setInsertTime(new Date());
        return service.update(model);
    }

    @ResponseBody
    @RequestMapping(value = "find", method=RequestMethod.GET)
    public Object find(@RequestParam("id") int id) {  //可以省略 @RequestParam("id")
        //http://localhost:8080/student/find?id=23
        Student model=service.find(id);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","OK");
        jsonObject.put("data",model);
        logger.info("查询一个info");
        logger.debug("查询一个debug");
        return jsonObject;
    }


    @ResponseBody
    @RequestMapping(value = "list", method=RequestMethod.GET)
    @ApiOperation(value = "查询所有的学生value",notes="所有的学生notes",httpMethod ="GET")
    public List<Student> list() {
        List<Student> list = service.list();
        logger.info("查询所有info");
        logger.debug("查询所有debug");
        return list;
    }

    @ResponseBody
    @RequestMapping("listCount")
    public int listCount() {
        return service.listCount();
    }

    @ResponseBody
    @RequestMapping("listCount2")
    public int listCount2() {
        return service.listCount2();
    }

    @ResponseBody
    @RequestMapping("listPage")
    public IPage<Student> listPage(int i){
        return service.listPage(i);
    }

    @ResponseBody
    @RequestMapping("selectByName")
    public List<Student> selectByName(String name) {
        List<Student> list = service.selectByName(name);
        logger.info("查询所有info");
        logger.debug("查询所有debug");
        return list;
    }


}
