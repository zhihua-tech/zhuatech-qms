/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.service;
import cn.zhuatech.qms.common.BusinessException;import cn.zhuatech.qms.model.UserAccount;import cn.zhuatech.qms.repository.UserRepository;import org.springframework.security.core.context.SecurityContextHolder;import org.springframework.stereotype.Service;
@Service public class CurrentUserService {private final UserRepository users;public CurrentUserService(UserRepository users){this.users=users;}public UserAccount get(){String username=SecurityContextHolder.getContext().getAuthentication().getName();return users.findByUsername(username).orElseThrow(()->new BusinessException("当前用户不存在"));}}
