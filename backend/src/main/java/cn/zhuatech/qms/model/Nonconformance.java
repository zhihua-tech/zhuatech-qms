/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "qms_nonconformance")
public class Nonconformance extends BaseEntity {
    @Column(nullable = false, unique = true, length = 32) private String ncNo;
    @Column(nullable = false, length = 32) private String lotNo;
    @Column(nullable = false, length = 40) private String defectType;
    @Column(nullable = false, length = 16) private String severity;
    @Column(nullable = false, length = 300) private String description;
    @Column(nullable = false) private int quantity;
    @Column(nullable = false, length = 40) private String owner;
    @Column(nullable = false, length = 24) private String status;
    @Column(nullable = false) private LocalDate dueDate;

    protected Nonconformance() {}
    public Nonconformance(String ncNo, String lotNo, String defectType, String severity,
                          String description, int quantity, String owner, String status, LocalDate dueDate) {
        this.ncNo=ncNo; this.lotNo=lotNo; this.defectType=defectType; this.severity=severity;
        this.description=description; this.quantity=quantity; this.owner=owner; this.status=status; this.dueDate=dueDate;
    }
    public void moveTo(String status){this.status=status;}
    public String getNcNo(){return ncNo;} public String getLotNo(){return lotNo;}
    public String getDefectType(){return defectType;} public String getSeverity(){return severity;}
    public String getDescription(){return description;} public int getQuantity(){return quantity;}
    public String getOwner(){return owner;} public String getStatus(){return status;}
    public LocalDate getDueDate(){return dueDate;}
}
