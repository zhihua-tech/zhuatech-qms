/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "qms_inspection_lot")
public class InspectionLot extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String lotNo;
    @Column(nullable = false, length = 32) private String materialCode;
    @Column(nullable = false, length = 80) private String materialName;
    @Column(nullable = false, length = 24) private String sourceType;
    @Column(nullable = false, length = 40) private String sourceRef;
    @Column(length = 80) private String supplierName;
    @Column(nullable = false) private int batchQty;
    @Column(nullable = false) private int sampleQty;
    @Column(nullable = false) private LocalDate plannedDate;
    @Column(length = 40) private String inspector;
    @Column(nullable = false, length = 24) private String status;
    @Column(length = 24) private String result;
    @Column(nullable = false) private int defectQty;
    @Column(length = 300) private String remarks;

    protected InspectionLot() {}
    public InspectionLot(String lotNo, String materialCode, String materialName, String sourceType,
                         String sourceRef, String supplierName, int batchQty, int sampleQty,
                         LocalDate plannedDate, String inspector, String status) {
        this.lotNo = lotNo; this.materialCode = materialCode; this.materialName = materialName;
        this.sourceType = sourceType; this.sourceRef = sourceRef; this.supplierName = supplierName;
        this.batchQty = batchQty; this.sampleQty = sampleQty; this.plannedDate = plannedDate;
        this.inspector = inspector; this.status = status;
    }
    public void complete(String result, int defectQty, String remarks) {
        this.result = result; this.defectQty = defectQty; this.remarks = remarks; this.status = "已完成";
    }
    public String getLotNo(){return lotNo;} public String getMaterialCode(){return materialCode;}
    public String getMaterialName(){return materialName;} public String getSourceType(){return sourceType;}
    public String getSourceRef(){return sourceRef;} public String getSupplierName(){return supplierName;}
    public int getBatchQty(){return batchQty;} public int getSampleQty(){return sampleQty;}
    public LocalDate getPlannedDate(){return plannedDate;} public String getInspector(){return inspector;}
    public String getStatus(){return status;} public String getResult(){return result;}
    public int getDefectQty(){return defectQty;} public String getRemarks(){return remarks;}
}
