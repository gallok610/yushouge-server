package cn.tedu.yushougeproduct.service.impl;

import cn.tedu.yushougeproduct.ex.ServiceException;
import cn.tedu.yushougeproduct.mapper.CategoryMapper;
import cn.tedu.yushougeproduct.pojo.entity.Category;
import cn.tedu.yushougeproduct.pojo.param.CategoryAddNewParam;
import cn.tedu.yushougeproduct.service.ICategoryService;
import cn.tedu.yushougeproduct.web.ServiceCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addNew(CategoryAddNewParam categoryAddNewParam) {
        log.debug("开始处理【添加商品分类】的业务，参数：{}", categoryAddNewParam);

        // 检查商品分类名称是否被占用，如果被占用，则抛出异常
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_name", categoryAddNewParam.getCategoryName());
        int countByName = categoryMapper.selectCount(queryWrapper);
        log.debug("根据商品分类名称统计匹配的商品分类数量，结果：{}", countByName);
        if (countByName > 0) {
            String message = "添加商品分类失败，商品分类名称已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        // 将商品分类数据写入到数据库中
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewParam, category);
        category.setGmtCreate(LocalDateTime.now());
        category.setGmtModified(LocalDateTime.now());
        categoryMapper.insert(category);
        log.debug("将新的相册数据插入到数据库，完成！");
    }
}
