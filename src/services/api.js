import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8080'
})

export async function getDashboardData() {
  const response = await api.get('/api/dashboard')
  return response.data
}