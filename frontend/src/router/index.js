/* Copyright 2026 上海如静知华信息科技有限公司 */
import {createRouter,createWebHistory} from 'vue-router';
import LoginView from '../views/LoginView.vue';
import QualityDashboard from '../views/admin/QualityDashboard.vue';
import InspectionTasks from '../views/admin/InspectionTasks.vue';
import NonconformanceCenter from '../views/admin/NonconformanceCenter.vue';
import InspectorWorkbench from '../views/inspector/InspectorWorkbench.vue';
export default createRouter({history:createWebHistory(),routes:[
  {path:'/',redirect:'/admin/dashboard'},{path:'/login',component:LoginView},
  {path:'/admin/dashboard',component:QualityDashboard},{path:'/admin/inspections',component:InspectionTasks},
  {path:'/admin/nonconformance',component:NonconformanceCenter},{path:'/inspector/workbench',component:InspectorWorkbench}
  ,{path:'/admin/standards',component:InspectionTasks},{path:'/admin/records',component:InspectionTasks},
  {path:'/admin/supplier-quality',component:QualityDashboard},{path:'/admin/access',component:QualityDashboard},
  {path:'/admin/audit',component:QualityDashboard}
]})
