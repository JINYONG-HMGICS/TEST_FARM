<template>
  <section class="panel">
    <h2>Sensor Control</h2>
    <p class="description">Update smart farm sensor values manually.</p>

    <div class="form-grid">
      <label>
        Zone
        <input v-model="form.zoneName" type="text" />
      </label>

      <label>
        Temperature
        <input v-model.number="form.temperature" type="number" step="0.1" />
      </label>

      <label>
        Humidity
        <input v-model.number="form.humidity" type="number" step="0.1" />
      </label>

      <label>
        Light
        <input v-model.number="form.light" type="number" />
      </label>

      <label>
        Growth
        <input v-model="form.growthStatus" type="text" />
      </label>
    </div>

    <button class="primary" @click="submitSensorReading">Save Sensor Reading</button>
  </section>
</template>

<script setup>
import { reactive } from 'vue'
import { createSensorReading } from '../services/api'

const emit = defineEmits(['sensor-updated'])

const form = reactive({
  zoneName: 'Zone A',
  temperature: 25.6,
  humidity: 58.0,
  light: 910,
  growthStatus: 'Good'
})

async function submitSensorReading() {
  const result = await createSensorReading({
    zoneName: form.zoneName,
    temperature: form.temperature,
    humidity: form.humidity,
    light: form.light,
    growthStatus: form.growthStatus
  })

  emit('sensor-updated', result)
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

.description {
  color: #6b7280;
  margin-bottom: 18px;
}

.form-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 14px;
}

label {
  display: flex;
  flex-direction: column;
  gap: 6px;
  color: #374151;
  font-weight: 700;
  font-size: 13px;
}

input {
  border: 1px solid #d1d5db;
  border-radius: 12px;
  padding: 10px 12px;
  font-size: 14px;
}

.primary {
  margin-top: 18px;
  border: none;
  background: #2e7d32;
  color: white;
  padding: 12px 18px;
  border-radius: 999px;
  cursor: pointer;
  font-weight: 800;
}

.primary:hover {
  background: #256b2a;
}
</style>