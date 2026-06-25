<template>
  <div class="app">
    <aside class="sidebar">
      <h2>TEST FARM</h2>
      <nav>
        <a class="active">Dashboard</a>
        <a>Batch Jobs</a>
        <a>PLC Status</a>
        <a>Logs</a>
      </nav>
    </aside>

    <main class="main">
      <header class="header">
        <div>
          <h1>Industrial Control Dashboard</h1>
          <p>Phase 1 - Batch job execution monitoring</p>
        </div>
        <span class="status">● Industrial PC Connected</span>
      </header>

      <section class="cards">
        <div class="card">
          <h3>PLC Status</h3>
          <p class="value online">ONLINE</p>
        </div>

        <div class="card">
          <h3>Last Batch Result</h3>
          <p class="value">SUCCESS</p>
        </div>

        <div class="card">
          <h3>Today Executions</h3>
          <p class="value">12</p>
        </div>
      </section>

      <section class="panel">
        <h2>Batch Jobs</h2>
        <div class="job">
          <span>Recipe Download Batch</span>
          <button @click="runBatch">Execute</button>
        </div>
        <div class="job">
          <span>MES Synchronization Batch</span>
          <button @click="runBatch">Execute</button>
        </div>
        <div class="job">
          <span>PLC Data Backup Batch</span>
          <button @click="runBatch">Execute</button>
        </div>
      </section>

      <section class="panel">
        <h2>Execution History</h2>
        <table>
          <thead>
            <tr>
              <th>Time</th>
              <th>Job</th>
              <th>Status</th>
              <th>Executed By</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>09:15</td>
              <td>Recipe Download Batch</td>
              <td class="success">SUCCESS</td>
              <td>Admin</td>
            </tr>
            <tr>
              <td>08:42</td>
              <td>MES Synchronization Batch</td>
              <td class="failed">FAILED</td>
              <td>Admin</td>
            </tr>
          </tbody>
        </table>
      </section>
    </main>
  </div>
</template>

<script setup>
function runBatch() {
  alert('Phase 1: Backend API will be connected later.')
}
</script>

<style>
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background: #f4f6f8;
}

.app {
  display: flex;
  min-height: 100vh;
}

.sidebar {
  width: 240px;
  background: #111827;
  color: white;
  padding: 24px;
}

.sidebar h2 {
  margin-bottom: 32px;
}

.sidebar nav a {
  display: block;
  padding: 12px;
  margin-bottom: 8px;
  color: #cbd5e1;
  text-decoration: none;
  border-radius: 8px;
}

.sidebar nav a.active,
.sidebar nav a:hover {
  background: #2563eb;
  color: white;
}

.main {
  flex: 1;
  padding: 32px;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 24px;
}

.header h1 {
  margin: 0;
}

.header p {
  color: #64748b;
}

.status {
  color: #16a34a;
  font-weight: bold;
}

.cards {
  display: flex;
  gap: 16px;
  margin-bottom: 24px;
}

.card,
.panel {
  background: white;
  padding: 24px;
  border-radius: 12px;
  box-shadow: 0 1px 4px rgba(0,0,0,0.08);
}

.card {
  flex: 1;
}

.value {
  font-size: 28px;
  font-weight: bold;
}

.online,
.success {
  color: #16a34a;
}

.failed {
  color: #dc2626;
  font-weight: bold;
}

.panel {
  margin-bottom: 24px;
}

.job {
  display: flex;
  justify-content: space-between;
  padding: 14px 0;
  border-bottom: 1px solid #e5e7eb;
}

button {
  background: #2563eb;
  color: white;
  border: none;
  padding: 8px 18px;
  border-radius: 8px;
  cursor: pointer;
}

button:hover {
  background: #1d4ed8;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th,
td {
  text-align: left;
  padding: 12px;
  border-bottom: 1px solid #e5e7eb;
}
</style>