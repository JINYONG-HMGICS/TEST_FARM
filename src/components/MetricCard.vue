<template>
  <div class="metric-card">
    <div class="metric-icon">{{ icon }}</div>
    <p>{{ title }}</p>
    <h3>{{ value }}</h3>
  </div>
</template>

<script setup>
defineProps({
  icon: String,
  title: String,
  value: String
})
</script>

<style scoped>
.metric-card {
  background: white;
  padding: 22px;
  border-radius: 24px;
  box-shadow: 0 8px 24px rgba(31, 41, 55, 0.06);
}

.metric-icon {
  font-size: 28px;
}

.metric-card p {
  margin: 12px 0 6px;
  color: #6b7280;
  font-weight: 700;
}

.metric-card h3 {
  margin: 0;
  font-size: 26px;
}
</style>