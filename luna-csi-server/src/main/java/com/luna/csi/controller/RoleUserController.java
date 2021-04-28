package com.luna.csi.controller;

import com.github.pagehelper.PageInfo;
import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.entity.RoleUser;
import com.luna.csi.service.RoleUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:45:58
 */
@RestController
@RequestMapping("/roleUser/api")
public class RoleUserController {

    @Autowired
    private RoleUserService roleUserService;

    @GetMapping("/get/{id}")
    public ResultDTO<RoleUser> getById(@PathVariable(value = "Long id") Long id) {
        RoleUser roleUser = roleUserService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roleUser);
    }

    @GetMapping("/get")
    public ResultDTO<RoleUser> getByEntity(RoleUser roleUser) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roleUserService.getByEntity(roleUser));
    }

    @GetMapping("/list")
    public ResultDTO<List<RoleUser>> list(RoleUser roleUser) {
        List<RoleUser> roleUserList = roleUserService.listByEntity(roleUser);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roleUserList);
    }

    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, RoleUser roleUser) {
        PageInfo pageInfo = roleUserService.listPageByEntity(page, size, roleUser);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = roleUserService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @PostMapping("/insert")
    public ResultDTO<RoleUser> insert(@RequestBody RoleUser roleUser) {
        roleUserService.insert(roleUser);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roleUser);
    }

    @PostMapping("/insertBatch")
    public ResultDTO<List<RoleUser>> insert(@RequestBody List<RoleUser> list) {
        roleUserService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody RoleUser roleUser) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roleUserService.update(roleUser) == 1);
    }

    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<RoleUser> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            roleUserService.updateBatch(list) == list.size());
    }

    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable(value = "Long id") Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roleUserService.deleteById(id) == 1);
    }

    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody RoleUser roleUser) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            roleUserService.deleteByEntity(roleUser) == 1);
    }

    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = roleUserService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, roleUserService.countAll());
    }

    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(RoleUser roleUser) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            roleUserService.countByEntity(roleUser));
    }
}
