<!-- Copyright 2026 上海如静知华信息科技有限公司 -->
<script setup>
import AdminShell from '../../components/AdminShell.vue';import StatusBadge from '../../components/StatusBadge.vue';import {metrics,inspections,risks,trend,categories} from '../../api/mock';
</script>
<template><AdminShell><template #title>质量驾驶舱</template>
  <section class="page-heading"><div><p>QUALITY OVERVIEW</p><h1>质量运行总览</h1><span>截至 13:48，今日已完成 32 个检验批次，整体质量状态稳定。</span></div><div><button class="soft">导出质量日报</button><button class="solid">＋ 创建检验任务</button></div></section>
  <section class="metric-grid"><article v-for="m in metrics" :key="m.label" :class="m.tone"><header><span>{{m.label}}</span><i>↗</i></header><strong>{{m.value}}</strong><p>{{m.delta}}</p></article></section>
  <section class="dashboard-grid">
    <article class="card yield-card"><header class="card-title"><div><h2>一次检验合格率趋势</h2><p>最近 8 周 · 全部检验类型</p></div><button>按周 ⌄</button></header><div class="chart-area"><div class="chart-labels"><span>100%</span><span>98%</span><span>96%</span><span>94%</span></div><div class="line-chart"><svg viewBox="0 0 700 220" preserveAspectRatio="none"><defs><linearGradient id="area" x1="0" y1="0" x2="0" y2="1"><stop offset="0" stop-color="#386f69" stop-opacity=".25"/><stop offset="1" stop-color="#386f69" stop-opacity="0"/></linearGradient></defs><path d="M10,110 L105,83 L200,127 L295,48 L390,30 L485,65 L580,4 L690,13 L690,215 L10,215 Z" fill="url(#area)"/><path d="M10,110 L105,83 L200,127 L295,48 L390,30 L485,65 L580,4 L690,13" fill="none" stroke="#316e68" stroke-width="4" stroke-linecap="round" stroke-linejoin="round"/><circle v-for="(v,i) in trend" :key="v" :cx="10+i*97" :cy="[110,83,127,48,30,65,4,13][i]" r="5" fill="#fff" stroke="#316e68" stroke-width="3"/></svg><div class="weeks"><span v-for="i in 8" :key="i">W{{i+22}}</span></div></div></div>
    </article>
    <article class="card defect-card"><header class="card-title"><div><h2>缺陷类型分布</h2><p>本月已确认 126 项缺陷</p></div><button>本月 ⌄</button></header><div class="donut-wrap"><div class="donut"><b>126</b><small>缺陷总数</small></div><div class="category-list"><div v-for="c in categories" :key="c[0]"><i :style="{background:c[2]}"></i><span>{{c[0]}}</span><b>{{c[1]}}%</b></div></div></div></article>
  </section>
  <section class="dashboard-grid lower">
    <article class="card"><header class="card-title"><div><h2>待处理检验任务</h2><p>按计划时间与优先级排序</p></div><RouterLink to="/admin/inspections">查看全部 →</RouterLink></header><div class="task-list"><div v-for="i in inspections.slice(0,3)" :key="i.no"><span class="task-type">{{i.type.slice(0,1)}}</span><div><b>{{i.material}}</b><p>{{i.no}} · {{i.supplier}}</p></div><div class="task-time"><b>{{i.date}}</b><small>{{i.owner}}</small></div><StatusBadge :value="i.priority||i.status"/></div></div></article>
    <article class="card"><header class="card-title"><div><h2>重点质量风险</h2><p>严重度与关闭期限综合排序</p></div><RouterLink to="/admin/nonconformance">进入风险中心 →</RouterLink></header><div class="risk-list"><div v-for="r in risks" :key="r.no"><StatusBadge :value="r.level"/><div><b>{{r.title}}</b><p>{{r.detail}}</p><small>{{r.no}} · 负责人 {{r.owner}}</small></div><em :class="{'late':r.due.includes('逾期')}">{{r.due}}</em></div></div></article>
  </section>
</AdminShell></template>
