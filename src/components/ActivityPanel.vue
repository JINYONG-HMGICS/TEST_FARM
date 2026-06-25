<template>
  <section class="panel">
    <h2>Recent Activity</h2>

    <ul>
      <li v-for="item in activities" :key="item">{{ item }}</li>
    </ul>
  </section>
</template>

<script setup>
const activities = [
  '✅ Irrigation completed in Zone A',
  '✅ Customer demo mode started',
  '⚠️ Zone B humidity slightly low',
  '✅ LED intensity adjusted'
]
</script>

<style scoped>
.panel {
  background: white;
  padding: 24px;
  border-radius: 26px;
  box-shadow: 0 8px 24px rgba(31, 41, 55, 0.06);
}

.panel h2 {
  margin-top: 0;
}

ul {
  padding-left: 20px;
  line-height: 2;
}
</style>