/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "qms_capa_action")
public class CapaAction extends BaseEntity {
    @Column(nullable=false, unique=true, length=32) private String actionNo;
    @Column(nullable=false, length=32) private String ncNo;
    @Column(nullable=false, length=120) private String title;
    @Column(nullable=false, length=40) private String owner;
    @Column(nullable=false) private LocalDate dueDate;
    @Column(nullable=false) private int progress;
    @Column(nullable=false, length=24) private String status;

    protected CapaAction() {}
    public CapaAction(String actionNo, String ncNo, String title, String owner,
                      LocalDate dueDate, int progress, String status) {
        this.actionNo=actionNo; this.ncNo=ncNo; this.title=title; this.owner=owner;
        this.dueDate=dueDate; this.progress=progress; this.status=status;
    }
    public void updateProgress(int progress){this.progress=Math.max(0,Math.min(progress,100));this.status=this.progress>=100?"待验证":"执行中";}
    public String getActionNo(){return actionNo;} public String getNcNo(){return ncNo;}
    public String getTitle(){return title;} public String getOwner(){return owner;}
    public LocalDate getDueDate(){return dueDate;} public int getProgress(){return progress;}
    public String getStatus(){return status;}
}
