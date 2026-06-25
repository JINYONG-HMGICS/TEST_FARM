<template>
  <section class="panel">
    <div class="panel-header">
      <h2>Farm Zone Overview</h2>
      <button>View All</button>
    </div>

    <div class="zone-grid">
      <div class="zone-card" v-for="zone in zones" :key="zone.name">
        <div class="zone-icon">{{ zone.icon }}</div>
        <h3>{{ zone.name }}</h3>
        <p>{{ zone.status }}</p>
        <small>{{ zone.description }}</small>
      </div>
    </div>
  </section>
</template>

<script setup>
const zones = [
  { icon: '🌱', name: 'Zone A', status: 'Healthy', description: 'Leafy greens / Stable' },
  { icon: '🌿', name: 'Zone B', status: 'Growing', description: 'Herbs / Humidity low' },
  { icon: '🌾', name: 'Zone C', status: 'Harvest Ready', description: 'Premium showcase zone' }
]
</script>

<style scoped>
.panel {
  background: white;
  padding: 24px;
  border-radius: 26px;
  box-shadow: 0 8px 24px rgba(31, 41, 55, 0.06);
}

.panel-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.panel h2 {
  margin-top: 0;
}

.zone-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 18px;
}

.zone-card {
  background: #f5f7f5;
  padding: 22px;
  border-radius: 22px;
}

.zone-icon {
  font-size: 28px;
}

.zone-card p {
  color: #2e7d32;
  font-weight: 800;
}

.zone-card small {
  color: #6b7280;
}

button {
  border: none;
  background: #e8f5e9;
  color: #2e7d32;
  padding: 10px 16px;
  border-radius: 999px;
  font-weight: 800;
}
</style>