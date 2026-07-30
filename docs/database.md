# 数据库说明

| 表 | 用途 |
| --- | --- |
| `sys_user` | 管理员、质量工程师和检验员账号 |
| `qms_inspection_lot` | 来料、过程、成品检验批次及结果 |
| `qms_nonconformance` | 不合格品报告与处置状态 |
| `qms_capa_action` | 纠正预防措施、责任人和进度 |

建表脚本位于 `backend/src/main/resources/db/migration/V1__init.sql`。演示数据由 `DataInitializer` 写入，均为虚构信息，不应替换为生产数据后直接提交。

© 2026 上海如静知华信息科技有限公司
