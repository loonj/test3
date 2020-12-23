package cn.zhanx.test3.service;


import cn.zhanx.test3.entity.Student;
import cn.zhanx.test3.mapper.StudentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper mapper;


    public int insert(Student model){
        return mapper.insert(model);
    }

    public int delete(int id){
        return mapper.deleteById(id);
    }

    public int update(Student model){
        return mapper.updateById(model);
    }

    public Student find(int id){
        return mapper.selectById(id);
    }

    public List<Student> list(){
        QueryWrapper<Student> qw=new QueryWrapper<>();
        qw.ge("1","1");
        return  mapper.selectList(qw);
    }

    public int listCount(){
        return mapper.listCount(); //自定义的
    }

    public int listCount2(){
        QueryWrapper<Student> qw=new QueryWrapper<>();
        qw.ge("1","1");
        return mapper.selectCount(qw); //从BaseMapper那里继承下来的
    }

    public IPage<Student> listPage(int i){

        IPage<Student> stus = mapper.selectPage(new Page<Student>(i, 10),
                new QueryWrapper<Student>().between("id", 1, 60).eq("gender", 1)
        );
        System.out.println(stus); //com.baomidou.mybatisplus.extension.plugins.pagination.Page@6c9ee53b
        return stus;
    }

    public List<Student>  selectByName(String name) {
        List<Student> stus =  mapper.selectByName(name);
        stus.forEach(System.out::println);
        return stus;

    }



}
