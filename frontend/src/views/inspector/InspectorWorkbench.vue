<!-- Copyright 2026 上海如静知华信息科技有限公司 -->
<script setup>import {todayTasks} from '../../api/mock';</script>
<template><div class="mobile-app">
  <header class="mobile-head"><div class="mobile-brand"><span>ZH</span><div><b>质量检验工作台</b><small>ZhuaTech QMS</small></div></div><button class="mobile-avatar">陈</button></header>
  <main class="mobile-content"><section class="mobile-greeting"><p>7月30日 · 周四</p><h1>下午好，陈静</h1><span>今日还有 3 个检验任务需要完成</span></section>
    <section class="quick-cards"><article><span>今日任务</span><b>6</b><small>已完成 3</small></article><article><span>加急任务</span><b>1</b><small>请优先处理</small></article><article><span>本月合格率</span><b>98.5%</b><small>高于团队 0.3%</small></article></section>
    <section class="mobile-section"><header><div><h2>待处理任务</h2><p>按计划时间排序</p></div><button>全部 6 ›</button></header><article v-for="(t,i) in todayTasks" :key="t.no" class="mobile-task"><div class="time-rail"><b>{{t.date.split(' ')[1]}}</b><i :class="{hot:t.priority==='加急'}"></i><small>{{i===0?'即将开始':i===1?'今天':'昨天'}}</small></div><div class="task-body"><header><span>{{t.type}}</span><em v-if="t.priority==='加急'">加急</em></header><h3>{{t.material}}</h3><p>{{t.no}} · {{t.source}}</p><dl><div><dt>批次数量</dt><dd>{{t.batch}}</dd></div><div><dt>抽样数量</dt><dd>{{t.sample}}</dd></div></dl><button>{{i===0?'开始检验':'查看任务'}} <b>→</b></button></div></article></section>
    <section class="scan-card"><span>⌗</span><div><b>扫描批次条码</b><small>快速调出检验任务与检验标准</small></div><button>开始扫码</button></section>
  </main>
  <nav class="mobile-nav"><a class="active"><i>⌂</i><span>工作台</span></a><a><i>✓</i><span>检验</span></a><button><i>⌗</i></button><a><i>◇</i><span>异常</span></a><a><i>○</i><span>我的</span></a></nav>
</div></template>
