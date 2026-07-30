/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.repository;
import cn.zhuatech.qms.model.InspectionLot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface InspectionLotRepository extends JpaRepository<InspectionLot,Long>{
    List<InspectionLot> findAllByOrderByPlannedDateDesc(); long countByStatus(String status); long countByResult(String result);
}
