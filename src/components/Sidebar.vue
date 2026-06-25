<template>
  <aside class="sidebar">
    <div class="logo">
      <div class="icon">🌱</div>

      <div>
        <h2>Smart Farm</h2>
        <small>Experience Portal</small>
      </div>
    </div>

    <nav>

      <a class="active">Dashboard</a>

      <a>Farm Zones</a>

      <a>Environment</a>

      <a>Automation</a>

      <a>Demo Center</a>

      <a>Activity</a>

      <a>Settings</a>

    </nav>
  </aside>
</template>

<style scoped>

.sidebar{
    width:260px;
    background:white;
    padding:25px;
    border-right:1px solid #eee;
}

.logo{
    display:flex;
    gap:15px;
    margin-bottom:40px;
}

.icon{
    width:50px;
    height:50px;
    border-radius:15px;
    background:#E8F5E9;
    display:flex;
    justify-content:center;
    align-items:center;
    font-size:24px;
}

.logo h2{
    margin:0;
    color:#2E7D32;
}

.logo small{
    color:#888;
}

nav a{
    display:block;
    padding:14px;
    border-radius:12px;
    color:#444;
    margin-bottom:8px;
    cursor:pointer;
}

.active{
    background:#E8F5E9;
    color:#2E7D32;
    font-weight:bold;
}

</style>