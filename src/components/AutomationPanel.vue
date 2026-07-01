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
import { runAutomation } from '../services/api'

defineProps({
  tasks: {
    type: Array,
    default: () => []
  }
})

const emit = defineEmits(['activity-added'])

async function runTask(taskName) {
  try {
    await runAutomation(taskName)

    // Do not add activity locally.
    // Parent Dashboard reloads latest 10 activities from DB.
    emit('activity-added')
  } catch (error) {
    console.error('Automation failed:', error)

    // Still reload dashboard to keep UI consistent.
    emit('activity-added')
  }
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

button:hover {
  background: #d6ecd8;
}
</style>