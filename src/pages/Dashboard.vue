<template>
  <div class="dashboard">
    <Topbar :farmStatus="farmStatus" />

    <HeroStatus :farmStatus="farmStatus" />

    <section class="metrics">
      <MetricCard
        v-for="metric in metrics"
        :key="metric.title"
        :icon="metric.icon"
        :title="metric.title"
        :value="metric.value"
      />
    </section>

    <section class="main-grid">
      <ZoneOverview :zones="zones" />

      <section class="panel demo">
        <h2>Customer Demo</h2>
        <p>Run guided scenarios for visitors and customer experience sessions.</p>
        <button class="primary" @click="runDemo">Start Visitor Demo</button>
      </section>

      <AutomationPanel
        :tasks="automationTasks"
        @activity-added="addActivity"
      />

      <ActivityPanel :activities="activities" />

      <SensorControlPanel @sensor-updated="handleSensorUpdated" />
    </section>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getDashboardData } from '../services/api'

import {
  farmStatus as mockFarmStatus,
  metrics as mockMetrics,
  zones as mockZones,
  automationTasks as mockAutomationTasks,
  activities as mockActivities
} from '../data/farmMockData'

import Topbar from '../components/Topbar.vue'
import HeroStatus from '../components/HeroStatus.vue'
import MetricCard from '../components/MetricCard.vue'
import ZoneOverview from '../components/ZoneOverview.vue'
import AutomationPanel from '../components/AutomationPanel.vue'
import ActivityPanel from '../components/ActivityPanel.vue'
import SensorControlPanel from '../components/SensorControlPanel.vue'

const farmStatus = ref(mockFarmStatus)
const metrics = ref(mockMetrics)
const zones = ref(mockZones)
const automationTasks = ref(mockAutomationTasks)
const activities = ref([...mockActivities])

onMounted(async () => {
  await loadDashboard()
})

async function loadDashboard() {
  try {
    const data = await getDashboardData()

    farmStatus.value = data.farmStatus
    metrics.value = data.metrics
    zones.value = data.zones
    automationTasks.value = data.automationTasks
    activities.value = data.activities
  } catch (error) {
    console.warn('Backend API not available. Using mock dashboard data.', error)

    farmStatus.value = mockFarmStatus
    metrics.value = mockMetrics
    zones.value = mockZones
    automationTasks.value = mockAutomationTasks
    activities.value = [...mockActivities]
  }
}

function runDemo() {
  addActivity('✅ Visitor Demo scenario started.')
}

function addActivity(message) {
  activities.value.unshift(message)
}

async function handleSensorUpdated() {
  await loadDashboard()
  addActivity('✅ Sensor reading updated from control panel.')
}
</script>

<style scoped>
.dashboard {
  flex: 1;
  padding: 32px;
}

.metrics {
  display: grid;
  grid-template-columns: repeat(4, minmax(180px, 1fr));
  gap: 18px;
  margin: 24px 0;
}

.main-grid {
  display: grid;
  grid-template-columns: 1.5fr 1fr;
  gap: 22px;
}

.panel {
  background: white;
  padding: 24px;
  border-radius: 26px;
  box-shadow: 0 8px 24px rgba(31, 41, 55, 0.06);
}

.panel h2 {
  margin-top: 0;
}

.demo {
  min-height: 180px;
}

.primary {
  border: none;
  background: #2e7d32;
  color: white;
  padding: 12px 18px;
  border-radius: 999px;
  cursor: pointer;
  font-weight: 800;
  margin-top: 18px;
}

.primary:hover {
  background: #256b2a;
}
</style>