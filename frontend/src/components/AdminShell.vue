<!-- Copyright 2026 上海如静知华信息科技有限公司 -->
<script setup>
const groups=[
  {label:'质量运营',items:[['/admin/dashboard','质量驾驶舱','▦'],['/admin/inspections','检验任务','✓'],['/admin/nonconformance','不合格与 CAPA','◇']]},
  {label:'质量基础',items:[['/admin/standards','检验标准','≡'],['/admin/records','质量档案','▤'],['/admin/supplier-quality','供应商质量','◎']]},
  {label:'系统配置',items:[['/admin/access','组织与权限','♙'],['/admin/audit','审计记录','↻']]}
]
</script>
<template>
  <div class="app-shell">
    <aside class="sidebar">
      <div class="brand"><span>ZH</span><div><b>ZhuaTech QMS</b><small>质量管理系统</small></div></div>
      <div class="site-switch"><i></i><div><b>华东制造中心</b><small>质量管理部</small></div><em>⌄</em></div>
      <div v-for="group in groups" :key="group.label" class="nav-group">
        <p>{{group.label}}</p>
        <nav><RouterLink v-for="item in group.items" :key="item[1]" :to="item[0]"><span>{{item[2]}}</span>{{item[1]}}<b v-if="item[1]==='不合格与 CAPA'">7</b></RouterLink></nav>
      </div>
      <div class="side-user"><span>陈</span><div><b>陈静</b><small>质量平台主管</small></div><button>•••</button></div>
    </aside>
    <main class="workspace">
      <header class="topbar"><div><small>质量运营 /</small><b><slot name="title"/></b></div><div class="top-actions"><label>⌕ <input placeholder="搜索批次、物料或 NCR"/><kbd>⌘ K</kbd></label><button>?</button><button class="bell">♢<i></i></button><span>2026年7月30日 周四</span></div></header>
      <div class="page"><slot/></div>
      <footer>© 2026 上海如静知华信息科技有限公司 · <a href="https://www.zhuatech.cn/">www.zhuatech.cn</a></footer>
    </main>
  </div>
</template>
