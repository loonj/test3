package cn.zhanx.test3.mapper;

import cn.zhanx.test3.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentMapper extends BaseMapper<Student> {
    //自定义方法
    int listCount();

    List<Student> selectByName(String name);




}
