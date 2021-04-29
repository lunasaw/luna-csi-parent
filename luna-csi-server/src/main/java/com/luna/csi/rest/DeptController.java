package com.luna.csi.rest;

import com.github.pagehelper.PageInfo;
import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.entity.Dept;
import com.luna.csi.service.DeptService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:46:45
 */
@RestController
@RequestMapping("/dept/api")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/get/{id}")
    public ResultDTO<Dept> getById(@PathVariable(value = "id") Long id) {
        Dept dept = deptService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, dept);
    }

    @GetMapping("/get")
    public ResultDTO<Dept> getByEntity(Dept dept) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, deptService.getByEntity(dept));
    }

    @GetMapping("/list")
    public ResultDTO<List<Dept>> list(Dept dept) {
        List<Dept> deptList = deptService.listByEntity(dept);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, deptList);
    }

    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, Dept dept) {
        PageInfo pageInfo = deptService.listPageByEntity(page, size, dept);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = deptService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @PostMapping("/insert")
    public ResultDTO<Dept> insert(@RequestBody Dept dept) {
        deptService.insert(dept);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, dept);
    }

    @PostMapping("/insertBatch")
    public ResultDTO<List<Dept>> insert(@RequestBody List<Dept> list) {
        deptService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody Dept dept) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, deptService.update(dept) == 1);
    }

    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<Dept> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            deptService.updateBatch(list) == list.size());
    }

    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable(value = "id") Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, deptService.deleteById(id) == 1);
    }

    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody Dept dept) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, deptService.deleteByEntity(dept) == 1);
    }

    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = deptService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, deptService.countAll());
    }

    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(Dept dept) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            deptService.countByEntity(dept));
    }
}
