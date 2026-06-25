<template>
  <div class="dashboard">
    <Topbar />

    <HeroStatus />

    <section class="metrics">
      <MetricCard icon="🌡" title="Temperature" value="24.8°C" />
      <MetricCard icon="💧" title="Humidity" value="61%" />
      <MetricCard icon="☀️" title="Light" value="850 lux" />
      <MetricCard icon="🌿" title="Growth" value="Excellent" />
    </section>

    <section class="main-grid">
      <ZoneOverview />

      <section class="panel demo">
        <h2>Customer Demo</h2>
        <p>Run guided scenarios for visitors and customer experience sessions.</p>
        <button class="primary" @click="runDemo">Start Visitor Demo</button>
      </section>

      <AutomationPanel />

      <ActivityPanel />
    </section>
  </div>
</template>

<script setup>
import Topbar from '../components/Topbar.vue'
import HeroStatus from '../components/HeroStatus.vue'
import MetricCard from '../components/MetricCard.vue'
import ZoneOverview from '../components/ZoneOverview.vue'
import AutomationPanel from '../components/AutomationPanel.vue'
import ActivityPanel from '../components/ActivityPanel.vue'

function runDemo() {
  alert('Visitor Demo scenario will be connected to backend API later.')
}
</script>

<style scoped>
.dashboard {
  flex: 1;
  padding: 32px;
}

.metrics {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 18px;
  margin-bottom: 24px;
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
</style>