# ZhuaTech QMS · 知华科技质量管理系统

> 一套面向制造企业的质量管理系统社区源码版，把 **检验任务、质量判定、不合格品、CAPA 与质量分析** 串成可追踪的业务闭环。

[![Java](https://img.shields.io/badge/Java-21-274b4b?logo=openjdk)](backend/pom.xml)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0-39736a?logo=springboot)](backend/pom.xml)
[![Vue](https://img.shields.io/badge/Vue-3.5-4f8178?logo=vuedotjs)](frontend/package.json)
[![MySQL](https://img.shields.io/badge/MySQL-8.4-b67b39?logo=mysql)](compose.yaml)
[![License](https://img.shields.io/badge/License-Non--Commercial-a34d40)](LICENSE)

**出品方：上海如静知华信息科技有限公司（知华科技）**<br>
官方网站：[https://www.zhuatech.cn/](https://www.zhuatech.cn/)

> [!CAUTION]
> 本工程仅能用于个人学习、技术研究和非商业交流，不得商用。企业内部生产经营、收费交付、SaaS 服务、项目投标、培训收费、咨询实施、二次销售及其他经营性使用，均须提前取得上海如静知华信息科技有限公司书面授权。详细条款见 [LICENSE](LICENSE)。该许可含非商业限制，因此本项目属于“社区源码版”，不属于 OSI 认定的开源软件。

---

## 这套 QMS 解决什么问题

质量团队经常需要在纸质检验单、Excel、即时消息和多个业务系统之间反复核对。ZhuaTech QMS 将关键质量活动放到统一工作流中：

```text
采购到货 / 生产工单 / 成品入库
               │
               ▼
        IQC / IPQC / FQC 检验任务
               │
        ┌──────┴──────┐
        ▼             ▼
      合格放行      不合格判定
                        │
                        ▼
              NCR → 评审 → 原因分析
                        │
                        ▼
                CAPA → 效果验证 → 关闭
```

它适合作为 **QMS 开源项目、Java 质量管理系统、质量检验系统、不合格品管理、CAPA 管理、供应商质量管理、Vue 企业后台** 的学习和二次研究样例。

## 产品现场

这里的图片均由本仓库前端实际运行后截取，不是概念效果图。

### 管理端 · 质量运行总览

质量平台主管可以查看一次检验合格率、待检批次、未关闭 NCR、来料合格率、缺陷分布和重点风险，先处理异常，再进入日常任务。

![知华科技 QMS 质量驾驶舱](docs/images/qms-quality-dashboard.png)

### 管理端 · 检验任务中心

以检验批为中心管理 IQC、IPQC、FQC 和委外检验，展示物料、来源、供应商、批量、抽样数、计划时间、检验员和判定结果。

![知华科技 QMS 检验任务中心](docs/images/qms-inspection-center.png)

### 管理端 · 不合格与 CAPA 闭环

从问题登记、评审处置、原因分析、措施执行到效果验证和关闭归档，突出严重度、责任人、截止日期及 CAPA 执行进度。

![知华科技 QMS 不合格与 CAPA 中心](docs/images/qms-ncr-capa-center.png)

### 用户端 · 检验员 H5 工作台

检验员在手机或手持终端上查看当日任务、加急批次、抽样数量和质量标准，也可以通过批次条码快速进入现场检验。

<p align="center"><img src="docs/images/qms-inspector-workbench.png" width="430" alt="知华科技 QMS 检验员 H5 工作台"></p>

## 社区版已经包含

| 业务域 | 已实现能力 | 主要使用者 |
| --- | --- | --- |
| 质量驾驶舱 | 一次合格率、来料合格率、缺陷分布、任务与风险看板 | 质量平台主管 |
| 检验任务 | IQC、IPQC、FQC、批次来源、抽样数、检验员、计划时间 | 质量工程师 |
| 现场检验 | 待办、加急任务、检验判定、缺陷数量、备注 | 检验员 |
| 不合格管理 | NCR 编号、缺陷类型、严重度、责任人、处理期限与状态 | 质量工程师 |
| CAPA | 纠正预防措施、负责人、进度、截止日期和待验证状态 | 质量负责人 |
| 身份与权限 | JWT 登录；管理员、质量工程师、检验员角色 | 系统管理员 |
| 工程能力 | Flyway、H2 集成测试、Docker Compose、CI、协作与安全规范 | 开发者 |

## 工程视图

```text
zhuatech-qms/
├── backend/
│   └── src/main/java/cn/zhuatech/qms/
│       ├── controller       # 认证、检验、不合格与 CAPA API
│       ├── service          # 质量业务规则和事务
│       ├── model            # 检验批、NCR、CAPA、用户实体
│       ├── repository       # Spring Data JPA 数据访问
│       └── security         # JWT 认证与权限链路
├── frontend/
│   └── src/
│       ├── views/admin      # 质量管理后台
│       └── views/inspector  # 检验员 H5 工作台
├── docs/                    # API、架构、数据库与页面截图
├── deploy/                  # 部署说明
└── compose.yaml             # MySQL、后端、前端编排
```

- 后端：Java 21、Spring Boot 4、Spring Security、Spring Data JPA、JWT、Flyway。
- 前端：Vue 3、Vue Router、Pinia、Axios、Vite。
- 数据库：MySQL 8.4；自动化测试使用 H2 MySQL 兼容模式。
- Java 包名：`cn.zhuatech.qms`；Maven Group：`cn.zhuatech`。
- 部署方式：Docker 多阶段构建、Nginx、Docker Compose。

## 五分钟开始体验

仅查看前端演示数据：

```bash
cd frontend
npm install
npm run dev:demo
```

- 质量管理端：`http://localhost:5173/admin/dashboard`
- 检验任务中心：`http://localhost:5173/admin/inspections`
- 不合格与 CAPA：`http://localhost:5173/admin/nonconformance`
- 检验员 H5：`http://localhost:5173/inspector/workbench`

启动完整环境：

```bash
cp .env.example .env
# 请修改数据库密码和 JWT_SECRET
docker compose up --build -d
```

Web 地址为 `http://localhost:8090`，API 地址为 `http://localhost:8080`。

| 角色 | 演示账号 | 初始密码 |
| --- | --- | --- |
| 质量平台主管 | `admin` | `admin123` |
| 质量工程师 | `quality` | `quality123` |
| 检验员 | `inspector` | `inspect123` |

> 演示账号和演示数据均为虚构内容。部署前必须删除初始化数据、替换全部密码，并设置高强度随机 JWT 密钥。

## 开发质量门禁

```bash
cd backend && mvn test
cd ../frontend && npm run build:demo
```

进一步资料：

- [API 摘要](docs/api.md)
- [领域与架构](docs/architecture.md)
- [数据库说明](docs/database.md)
- [参与贡献](CONTRIBUTING.md)
- [安全报告](SECURITY.md)

## 企业版可演进方向

- 检验标准版本、AQL 抽样方案、动态检验项和电子签名。
- 量检具台账、校准计划、MSA、SPC、过程能力与控制图。
- 供应商准入、来料趋势、8D、SCAR 和供应商改善门户。
- 客诉、退货、质量成本、审核计划、体系文件和培训记录。
- 图片证据、附件、扫码、打印、移动离线与设备自动采集。
- 多工厂、多组织、数据权限、审计日志与租户隔离。
- 对接 ERP、MES、WMS、SRM、PLM、LIMS 和 IoT 设备。
- 缺陷识别、根因推荐、质量趋势预测等企业 AI 场景。

## 商业授权与深度定制

如需把本系统用于企业生产环境，或需要 QMS 实施、质量数字化咨询、业务流程梳理、私有化部署、系统集成及深度定制，请联系 **知华科技（上海如静知华信息科技有限公司）**。

- 官网：[https://www.zhuatech.cn/](https://www.zhuatech.cn/)
- 服务：技术咨询、企业信息化、软件项目外包、FDE、AI 落地、行业系统深度开发
- 微信：扫描以下任意二维码咨询

<table>
  <tr>
    <td align="center"><img src="docs/images/zhuatech-wechat-consulting.png" width="260" alt="知华科技微信咨询二维码一"></td>
    <td align="center"><img src="docs/images/zhuatech-wechat-consulting-2.png" width="260" alt="知华科技微信咨询二维码二"></td>
  </tr>
  <tr><td align="center">微信咨询一</td><td align="center">微信咨询二</td></tr>
</table>

## 参与与安全

欢迎提交 Issue 和 Pull Request。请先阅读 [CONTRIBUTING.md](CONTRIBUTING.md) 与 [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md)。安全问题请按照 [SECURITY.md](SECURITY.md) 私下反馈，禁止在公开 Issue 中发布凭据或真实生产数据。

---

<p align="center">
  <b>知华科技 · 让质量问题看得见、跟得住、关得掉</b><br/>
  © 2026 上海如静知华信息科技有限公司 · <a href="https://www.zhuatech.cn/">www.zhuatech.cn</a>
</p>

## 风险驱动抽样计划

新增 `POST /api/qms/sampling-plan`，根据批量、历史不良率、供应商风险、关键特性和近期质量逸出推荐样本量、检验级别与接收数。高风险供应商自动进入 `TIGHTENED` 加严检验，关键特性执行零接收数判定，并返回需要追加的检验动作。

万件批次、高风险供应商与关键特性组合已通过集成测试，推荐样本量可稳定复现。
