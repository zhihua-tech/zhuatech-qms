/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.repository;
import cn.zhuatech.qms.model.Nonconformance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface NonconformanceRepository extends JpaRepository<Nonconformance,Long>{
    List<Nonconformance> findAllByOrderByDueDateAsc(); long countByStatusNot(String status);
}
