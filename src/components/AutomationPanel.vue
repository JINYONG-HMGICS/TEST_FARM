<template>
  <section class="panel">
    <h2>Today’s Automation</h2>

    <div class="task" v-for="task in tasks" :key="task.name">
      <div>
        <strong>{{ task.icon }} {{ task.name }}</strong>
        <p>{{ task.description }}</p>
      </div>
      <button @click="runTask(task.name)">Run</button>
    </div>
  </section>
</template>

<script setup>
const tasks = [
  { icon: '💧', name: 'Irrigation', description: 'Run short watering cycle' },
  { icon: '☀️', name: 'LED Lighting', description: 'Adjust light intensity for demo' },
  { icon: '🌬', name: 'Ventilation', description: 'Refresh airflow in growing zones' }
]

function runTask(taskName) {
  alert(`${taskName} automation request created.`)
}
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

.task {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px 0;
  border-bottom: 1px solid #edf0ed;
}

.task p {
  margin: 6px 0 0;
  color: #6b7280;
}

button {
  border: none;
  background: #e8f5e9;
  color: #2e7d32;
  padding: 10px 16px;
  border-radius: 999px;
  cursor: pointer;
  font-weight: 800;
}
</style>