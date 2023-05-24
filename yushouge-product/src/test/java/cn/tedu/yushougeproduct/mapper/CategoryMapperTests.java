package cn.tedu.yushougeproduct.mapper;

import cn.tedu.yushougeproduct.pojo.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class CategoryMapperTests {
    @Autowired
    private CategoryMapper mapper;

    @Test
    void addNew(){
        Category data = new Category();
        data.setCategoryName("测试数据01");
        data.setGmtCreate(LocalDateTime.now());
        data.setGmtModified(LocalDateTime.now());

        int rows = mapper.insert(data);
        System.out.println("插入数据完成，受影响的行数：" + rows);
        System.out.println("插入数据之后，参数：" + data);
    }
}
