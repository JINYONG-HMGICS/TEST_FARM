import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8080'
})

export async function getDashboardData() {
  const response = await api.get('/api/dashboard')
  return response.data
}

export async function runAutomation(taskName) {
  const response = await api.post('/api/automation/run', {
    taskName
  })

  return response.data
}

export async function createSensorReading(sensorData) {
  const response = await api.post('/api/sensors/readings', sensorData)
  return response.data
}