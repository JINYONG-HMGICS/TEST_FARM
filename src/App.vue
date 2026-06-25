<template>
  <div class="app">
    <Sidebar />
    <Dashboard />
  </div>
</template>

<script setup>
import Sidebar from './components/Sidebar.vue'
import Dashboard from './pages/Dashboard.vue'
</script>

<style>
body {
  margin: 0;
  background: #f5f7f5;
  font-family: "Segoe UI", Arial, sans-serif;
  color: #1f2937;
}

.app {
  min-height: 100vh;
  display: flex;
}
</style>