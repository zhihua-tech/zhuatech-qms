/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.qms.config;

import cn.zhuatech.qms.model.*;
import cn.zhuatech.qms.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(UserRepository users,InspectionLotRepository lots,NonconformanceRepository ncs,
                           CapaActionRepository capas,PasswordEncoder encoder){return args->{if(users.count()>0)return;
        users.save(new UserAccount("admin",encoder.encode("admin123"),"质量平台主管",UserAccount.Role.ADMIN));
        users.save(new UserAccount("quality",encoder.encode("quality123"),"质量工程师",UserAccount.Role.QUALITY_ENGINEER));
        users.save(new UserAccount("inspector",encoder.encode("inspect123"),"检验员",UserAccount.Role.INSPECTOR));
        lots.save(new InspectionLot("IQC-20260730-018","MAT-IC-1048","工业控制芯片 X48","来料检验","GRN-260730-032","苏州恒微电子科技有限公司",12000,125,LocalDate.now(),"陈静","待检验"));
        lots.save(new InspectionLot("IPQC-20260730-026","ASM-CTRL-207","控制器主板组件","过程检验","WO-260729-116",null,480,32,LocalDate.now(),"周敏","待检验"));
        lots.save(new InspectionLot("FQC-20260729-041","FG-SERVO-75","伺服驱动器 750W","成品检验","WO-260728-089",null,240,50,LocalDate.now().minusDays(1),"陈静","已完成"));
        var failed=lots.save(new InspectionLot("IQC-20260729-012","MAT-AL-3026","6061 铝型材 40×40","来料检验","GRN-260729-018","无锡拓新材料有限公司",3600,80,LocalDate.now().minusDays(1),"赵凯","待检验"));
        failed.complete("不合格",7,"表面划伤超出限度样本 5 件，尺寸偏差 2 件");
        lots.save(failed);
        var passed=lots.save(new InspectionLot("IQC-20260728-033","MAT-MT-2071","伺服电机 750W","来料检验","GRN-260728-066","宁波东港精密制造有限公司",260,32,LocalDate.now().minusDays(2),"周敏","待检验"));
        passed.complete("合格",0,"关键尺寸与绝缘性能均符合规范");
        lots.save(passed);
        ncs.save(new Nonconformance("NCR-20260729-008","IQC-20260729-012","外观缺陷","重大","铝型材表面连续划伤，超出封样限度",5,"李工","原因分析",LocalDate.now().plusDays(2)));
        ncs.save(new Nonconformance("NCR-20260728-015","IPQC-20260728-073","焊接缺陷","一般","连接器 J14 焊点润湿不足",3,"王工","措施执行",LocalDate.now().plusDays(4)));
        ncs.save(new Nonconformance("NCR-20260724-003","FQC-20260724-021","功能异常","严重","老化测试出现间歇性通讯中断",2,"孙工","效果验证",LocalDate.now().minusDays(1)));
        capas.save(new CapaAction("CAPA-20260729-006","NCR-20260729-008","优化供应商包装隔离与装卸规范","李工",LocalDate.now().plusDays(5),35,"执行中"));
        capas.save(new CapaAction("CAPA-20260728-011","NCR-20260728-015","调整回流焊温区参数并追加首件确认","王工",LocalDate.now().plusDays(3),70,"执行中"));
        capas.save(new CapaAction("CAPA-20260724-002","NCR-20260724-003","更换通信器件批次并开展 48h 验证","孙工",LocalDate.now().minusDays(1),100,"待验证"));
    };}
}
