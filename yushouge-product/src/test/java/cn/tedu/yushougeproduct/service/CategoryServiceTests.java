package cn.tedu.yushougeproduct.service;

import cn.tedu.yushougeproduct.pojo.param.CategoryAddNewParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTests {
    @Autowired
    ICategoryService service;

    @Test
    void addNew(){
        CategoryAddNewParam data = new CategoryAddNewParam();
        data.setCategoryName("测试数据04");

        service.addNew(data);
        System.out.println("添加成功！");
    }
}
