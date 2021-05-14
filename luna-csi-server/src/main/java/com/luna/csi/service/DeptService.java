package com.luna.csi.service;

import com.luna.csi.mapper.DeptMapper;
import com.luna.csi.entity.Dept;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:46:45
 */
public interface DeptService {

    /**
     * 通过主键查询数据
     *
     * @param id 主键
     * @return 对象
     */
    Dept getById(Long id);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个
     *
     * @param dept 条件
     * @return 对象
     */
    Dept getByEntity(Dept dept);

    /**
     * 通过实体不为空的属性作为筛选条件查询列表
     *
     * @param dept 条件
     * @return 对象列表
     */
    List<Dept> listByEntity(Dept dept);

    /**
     * 条件分页查询
     *
     * @param dept 查询条件
     * @param page 起始标号
     * @param pageSize 查询条目
     * @return 对象列表
     */
    PageInfo<Dept> listPageByEntity(int page, int pageSize, Dept dept);

    /**
     * 条件分页查询
     *
     * @param page 起始标号
     * @param pageSize 查询条目
     * @return 对象列表
     */
    PageInfo<Dept> listPage(int page, int pageSize);

    /**
     * Id列表查询对象列表
     *
     * @param ids Id列表
     * @return 对象列表
     */
    List<Dept> listByIds(List<Long> ids);

    /**
     * 插入
     *
     * @param dept 对象
     * @return 影响行数
     */
    int insert(Dept dept);

    /**
     * 列表插入
     *
     * @param list 列表对象
     * @return 影响行数
     */
    int insertBatch(List<Dept> list);

    /**
     * 更新
     *
     * @param dept 对象
     * @return 影响行数
     */
    int update(Dept dept);

    /**
     * 列表更新
     *
     * @param list 列表对象
     * @return 影响行数
     */
    int updateBatch(List<Dept> list);

    /**
     * 删除
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 条件删除
     *
     * @param dept 对象
     * @return 影响行数
     */
    int deleteByEntity(Dept dept);

    /**
     * 主键列表删除
     *
     * @param list 主键列表
     * @return 影响行数
     */
    int deleteByIds(List<Long> list);

    /**
     * 数据条目
     *
     * @return 影响行数
     */
    int countAll();

    /**
     * 条件查询数目
     *
     * @param dept 对象
     * @return 影响行数
     */
    int countByEntity(Dept dept);
}
