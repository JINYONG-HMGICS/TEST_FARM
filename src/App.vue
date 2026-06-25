<template>
  <div class="layout">
    <aside class="sidebar">
      <div class="logo">
        <div class="logo-mark">TF</div>
        <div>
          <h2>TEST FARM</h2>
          <p>Industrial Portal</p>
        </div>
      </div>

      <nav>
        <a class="active">Dashboard</a>
        <a>Production</a>
        <a>Equipment</a>
        <a>Batch Center</a>
        <a>Alarm Center</a>
        <a>History</a>
        <a>Administration</a>
      </nav>
    </aside>

    <main class="content">
      <header class="topbar">
        <div>
          <h1>Factory Operation Dashboard</h1>
          <p>Control, monitor, and execute industrial batch operations</p>
        </div>
        <div class="user-box">
          <span class="dot"></span>
          <span>System Online</span>
          <strong>Admin</strong>
        </div>
      </header>

      <section class="overview">
        <div class="card">
          <p>PLC Status</p>
          <h2 class="green">ONLINE</h2>
          <span>Beckhoff PLC connected</span>
        </div>

        <div class="card">
          <p>Industrial PC</p>
          <h2 class="green">CONNECTED</h2>
          <span>Edge agent ready</span>
        </div>

        <div class="card">
          <p>Last Batch Result</p>
          <h2 class="blue">SUCCESS</h2>
          <span>Recipe Download completed</span>
        </div>

        <div class="card">
          <p>Today Executions</p>
          <h2>12</h2>
          <span>2 failed / 10 success</span>
        </div>
      </section>

      <section class="grid">
        <div class="panel large">
          <div class="panel-header">
            <h2>Batch Center</h2>
            <button>Refresh</button>
          </div>

          <div class="job">
            <div>
              <strong>Recipe Download Batch</strong>
              <p>Send recipe file to Industrial PC</p>
            </div>
            <button class="primary" @click="runBatch('Recipe Download Batch')">Execute</button>
          </div>

          <div class="job">
            <div>
              <strong>MES Synchronization Batch</strong>
              <p>Synchronize production order data</p>
            </div>
            <button class="primary" @click="runBatch('MES Synchronization Batch')">Execute</button>
          </div>

          <div class="job">
            <div>
              <strong>PLC Data Backup Batch</strong>
              <p>Backup PLC parameter snapshot</p>
            </div>
            <button class="primary" @click="runBatch('PLC Data Backup Batch')">Execute</button>
          </div>
        </div>

        <div class="panel">
          <h2>Alarm Summary</h2>
          <div class="alarm warning">Warning: Batch retry count exceeded</div>
          <div class="alarm normal">Normal: PLC communication stable</div>
          <div class="alarm normal">Normal: Agent heartbeat received</div>
        </div>
      </section>

      <section class="panel">
        <h2>Recent Execution History</h2>
        <table>
          <thead>
            <tr>
              <th>Time</th>
              <th>Job</th>
              <th>Status</th>
              <th>Duration</th>
              <th>Executed By</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>09:15</td>
              <td>Recipe Download Batch</td>
              <td class="green">SUCCESS</td>
              <td>12 sec</td>
              <td>Admin</td>
            </tr>
            <tr>
              <td>08:42</td>
              <td>MES Synchronization Batch</td>
              <td class="red">FAILED</td>
              <td>34 sec</td>
              <td>Admin</td>
            </tr>
          </tbody>
        </table>
      </section>
    </main>
  </div>
</template>

<script setup>
function runBatch(jobName) {
  alert(`${jobName} execution request created. Backend API will be connected next.`)
}
</script>

<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: "Segoe UI", Arial, sans-serif;
  background: #f3f5f8;
  color: #111827;
}

.layout {
  display: flex;
  min-height: 100vh;
}

.sidebar {
  width: 280px;
  background: #0f172a;
  color: white;
  padding: 28px 22px;
}

.logo {
  display: flex;
  align-items: center;
  gap: 14px;
  margin-bottom: 36px;
}

.logo-mark {
  width: 44px;
  height: 44px;
  border-radius: 12px;
  background: #2563eb;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 800;
}

.logo h2 {
  margin: 0;
  font-size: 20px;
}

.logo p {
  margin: 4px 0 0;
  color: #94a3b8;
  font-size: 13px;
}

nav a {
  display: block;
  padding: 14px 16px;
  margin-bottom: 8px;
  border-radius: 10px;
  color: #cbd5e1;
  text-decoration: none;
  font-size: 15px;
}

nav a.active,
nav a:hover {
  background: #2563eb;
  color: white;
}

.content {
  flex: 1;
  padding: 30px;
}

.topbar {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 26px;
}

.topbar h1 {
  margin: 0;
  font-size: 32px;
}

.topbar p {
  margin: 8px 0 0;
  color: #64748b;
}

.user-box {
  display: flex;
  align-items: center;
  gap: 10px;
  background: white;
  padding: 12px 16px;
  border-radius: 12px;
  box-shadow: 0 1px 4px rgba(15, 23, 42, 0.08);
}

.dot {
  width: 10px;
  height: 10px;
  background: #16a34a;
  border-radius: 50%;
}

.overview {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 18px;
  margin-bottom: 22px;
}

.card,
.panel {
  background: white;
  border-radius: 16px;
  padding: 22px;
  box-shadow: 0 1px 5px rgba(15, 23, 42, 0.08);
}

.card p {
  margin: 0;
  color: #64748b;
  font-weight: 600;
}

.card h2 {
  margin: 14px 0 8px;
  font-size: 28px;
}

.card span {
  color: #94a3b8;
  font-size: 13px;
}

.green {
  color: #16a34a;
  font-weight: 700;
}

.blue {
  color: #2563eb;
  font-weight: 700;
}

.red {
  color: #dc2626;
  font-weight: 700;
}

.grid {
  display: grid;
  grid-template-columns: 2fr 1fr;
  gap: 22px;
  margin-bottom: 22px;
}

.panel-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.job {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 18px 0;
  border-bottom: 1px solid #e5e7eb;
}

.job p {
  margin: 6px 0 0;
  color: #64748b;
}

button {
  border: none;
  border-radius: 10px;
  padding: 10px 16px;
  cursor: pointer;
  background: #e5e7eb;
}

button.primary {
  background: #2563eb;
  color: white;
}

.alarm {
  padding: 14px;
  border-radius: 10px;
  margin-bottom: 12px;
}

.alarm.warning {
  background: #fff7ed;
  color: #c2410c;
}

.alarm.normal {
  background: #ecfdf5;
  color: #15803d;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 12px;
}

th,
td {
  text-align: left;
  padding: 14px;
  border-bottom: 1px solid #e5e7eb;
}
</style>