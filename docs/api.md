# API 摘要

所有业务接口使用 `Authorization: Bearer <token>`。

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 登录并获取 JWT |
| GET | `/api/auth/me` | 获取当前用户 |
| GET | `/api/qms/dashboard` | 质量驾驶舱指标与风险 |
| GET/POST | `/api/qms/inspections` | 查询或创建检验批 |
| PATCH | `/api/qms/inspections/{id}/complete` | 提交检验结果 |
| GET/POST | `/api/qms/nonconformances` | 查询或登记不合格事项 |
| GET | `/api/qms/capa-actions` | 查询 CAPA 措施 |
| PATCH | `/api/qms/capa-actions/{id}/progress` | 更新措施进度 |

接口统一返回 `ApiResponse<T>`。生产集成建议补充 OpenAPI、幂等键、审计日志与细粒度数据权限。

© 2026 上海如静知华信息科技有限公司
