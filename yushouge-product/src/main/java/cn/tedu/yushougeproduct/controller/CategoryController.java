package cn.tedu.yushougeproduct.controller;

import cn.tedu.yushougeproduct.pojo.param.CategoryAddNewParam;
import cn.tedu.yushougeproduct.service.ICategoryService;
import cn.tedu.yushougeproduct.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/category/")
@Slf4j
@Api(tags = "01：商品分类管理模块")
@Validated
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;


    @PostMapping("add-new")
    @ApiOperation("添加商品分类")
    @ApiOperationSupport(order = 100)
    public JsonResult addNew(@Valid CategoryAddNewParam categoryAddNewParam) {
        log.debug("开始处理【添加商品分类】的请求，参数：{}", categoryAddNewParam);
        iCategoryService.addNew(categoryAddNewParam);
        return JsonResult.ok();
    }
}
