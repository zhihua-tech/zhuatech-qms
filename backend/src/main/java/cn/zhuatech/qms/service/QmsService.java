/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.service;

import cn.zhuatech.qms.common.BusinessException;
import cn.zhuatech.qms.dto.QmsDto.*;
import cn.zhuatech.qms.model.InspectionLot;
import cn.zhuatech.qms.model.Nonconformance;
import cn.zhuatech.qms.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional(readOnly=true)
public class QmsService {
    private final InspectionLotRepository lots; private final NonconformanceRepository ncs; private final CapaActionRepository capas;
    public QmsService(InspectionLotRepository lots,NonconformanceRepository ncs,CapaActionRepository capas){this.lots=lots;this.ncs=ncs;this.capas=capas;}
    public Dashboard dashboard(){
        var all=lots.findAllByOrderByPlannedDateDesc(); long completed=all.stream().filter(l->"已完成".equals(l.getStatus())).count();
        long passed=all.stream().filter(l->"合格".equals(l.getResult())).count(); double fpy=completed==0?0:Math.round(passed*1000.0/completed)/10.0;
        long overdue=capas.findAll().stream().filter(c->c.getDueDate().isBefore(LocalDate.now())&&!"已关闭".equals(c.getStatus())).count();
        return new Dashboard(lots.countByStatus("待检验"),lots.countByResult("不合格"),ncs.countByStatusNot("已关闭"),overdue,fpy,96.8,
                all.stream().filter(l->"待检验".equals(l.getStatus())).limit(5).map(InspectionView::from).toList(),
                ncs.findAllByOrderByDueDateAsc().stream().filter(n->!"已关闭".equals(n.getStatus())).limit(5).map(NcView::from).toList());
    }
    public List<InspectionView> inspections(){return lots.findAllByOrderByPlannedDateDesc().stream().map(InspectionView::from).toList();}
    public List<NcView> nonconformances(){return ncs.findAllByOrderByDueDateAsc().stream().map(NcView::from).toList();}
    public List<CapaView> capaActions(){return capas.findAllByOrderByDueDateAsc().stream().map(CapaView::from).toList();}
    @Transactional public InspectionView createLot(CreateLotRequest r){String no="IQC-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));return InspectionView.from(lots.save(new InspectionLot(no,r.materialCode(),r.materialName(),r.sourceType(),r.sourceRef(),r.supplierName(),r.batchQty(),r.sampleQty(),r.plannedDate(),r.inspector(),"待检验")));}
    @Transactional public InspectionView completeInspection(Long id,CompleteInspectionRequest r){var lot=lots.findById(id).orElseThrow(()->new BusinessException("检验批不存在"));if("已完成".equals(lot.getStatus()))throw new BusinessException("检验批已完成，不能重复提交");if(!List.of("合格","不合格","让步接收").contains(r.result()))throw new BusinessException("检验结果不合法");lot.complete(r.result(),r.defectQty(),r.remarks());return InspectionView.from(lot);}
    @Transactional public NcView createNonconformance(CreateNcRequest r){String no="NCR-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));return NcView.from(ncs.save(new Nonconformance(no,r.lotNo(),r.defectType(),r.severity(),r.description(),r.quantity(),r.owner(),"待评审",r.dueDate())));}
    @Transactional public CapaView updateProgress(Long id,UpdateProgressRequest r){var action=capas.findById(id).orElseThrow(()->new BusinessException("CAPA 措施不存在"));action.updateProgress(r.progress());return CapaView.from(action);}
}
