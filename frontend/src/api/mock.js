/* Copyright 2026 上海如静知华信息科技有限公司 */
export const metrics=[
  {label:'一次检验合格率',value:'98.2%',delta:'较上月 +0.6%',tone:'good'},
  {label:'今日待检批次',value:'18',delta:'其中加急 3 批',tone:'plain'},
  {label:'未关闭 NCR',value:'7',delta:'1 项已超期',tone:'warn'},
  {label:'供应商来料合格率',value:'96.8%',delta:'目标值 97.0%',tone:'alert'}
]
export const inspections=[
  {no:'IQC-20260730-018',type:'来料检验',material:'工业控制芯片 X48',code:'MAT-IC-1048',source:'GRN-260730-032',supplier:'苏州恒微电子科技有限公司',batch:'12,000 片',sample:'125 片',date:'07-30 14:30',owner:'陈静',status:'待检验',priority:'加急'},
  {no:'IPQC-20260730-026',type:'过程检验',material:'控制器主板组件',code:'ASM-CTRL-207',source:'WO-260729-116',supplier:'电子装配一线',batch:'480 件',sample:'32 件',date:'07-30 15:00',owner:'周敏',status:'检验中',priority:'正常'},
  {no:'FQC-20260729-041',type:'成品检验',material:'伺服驱动器 750W',code:'FG-SERVO-75',source:'WO-260728-089',supplier:'驱动器装配线',batch:'240 台',sample:'50 台',date:'07-29 16:20',owner:'陈静',status:'已完成',result:'合格'},
  {no:'IQC-20260729-012',type:'来料检验',material:'6061 铝型材 40×40',code:'MAT-AL-3026',source:'GRN-260729-018',supplier:'无锡拓新材料有限公司',batch:'3,600 米',sample:'80 米',date:'07-29 10:10',owner:'赵凯',status:'已完成',result:'不合格'},
  {no:'IQC-20260728-033',type:'来料检验',material:'伺服电机 750W',code:'MAT-MT-2071',source:'GRN-260728-066',supplier:'宁波东港精密制造有限公司',batch:'260 台',sample:'32 台',date:'07-28 13:40',owner:'周敏',status:'已完成',result:'合格'}
]
export const risks=[
  {level:'严重',title:'老化测试通讯中断',no:'NCR-20260724-003',detail:'2 台伺服驱动器在 36h 老化阶段出现间歇通讯中断',owner:'孙工',due:'已逾期 1 天'},
  {level:'重大',title:'铝型材表面连续划伤',no:'NCR-20260729-008',detail:'来料样本 5 件超出外观封样限度，等待供应商原因分析',owner:'李工',due:'剩余 2 天'},
  {level:'一般',title:'连接器焊点润湿不足',no:'NCR-20260728-015',detail:'J14 工位检出 3 件，已调整回流焊温区参数',owner:'王工',due:'剩余 4 天'}
]
export const capa=[
  {no:'CAPA-20260729-006',nc:'NCR-20260729-008',title:'优化供应商包装隔离与装卸规范',owner:'李工',due:'08-04',progress:35,status:'执行中'},
  {no:'CAPA-20260728-011',nc:'NCR-20260728-015',title:'调整回流焊温区参数并追加首件确认',owner:'王工',due:'08-02',progress:70,status:'执行中'},
  {no:'CAPA-20260724-002',nc:'NCR-20260724-003',title:'更换通信器件批次并开展 48h 验证',owner:'孙工',due:'07-29',progress:100,status:'待验证'}
]
export const trend=[97.1,97.4,96.9,97.8,98.0,97.6,98.3,98.2]
export const categories=[['外观缺陷',38,'#a75a44'],['尺寸偏差',27,'#c68a45'],['功能异常',19,'#476e73'],['包装标识',10,'#7d8f8b'],['其他',6,'#b8b2a5']]
export const todayTasks=inspections.slice(0,3)
