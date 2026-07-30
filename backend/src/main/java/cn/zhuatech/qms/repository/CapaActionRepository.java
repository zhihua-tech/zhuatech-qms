/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.repository;
import cn.zhuatech.qms.model.CapaAction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CapaActionRepository extends JpaRepository<CapaAction,Long>{List<CapaAction> findAllByOrderByDueDateAsc();}
