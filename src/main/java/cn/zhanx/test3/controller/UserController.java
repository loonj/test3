package cn.zhanx.test3.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户Controller")
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("/index")
    @ApiOperation(value = "首页",notes="首页",httpMethod ="GET")
    public String index() {
        return "index";
    }


}
