<template>

<div class="card">

<div class="icon">{{ icon }}</div>

<p>{{ title }}</p>

<h2>{{ value }}</h2>

</div>

</template>

<script setup>

defineProps({

icon:String,

title:String,

value:String

})

</script>

<style scoped>

.card{

background:white;

padding:25px;

border-radius:20px;

box-shadow:0 5px 15px rgba(0,0,0,.05);

}

.icon{

font-size:30px;

}

p{

color:#888;

}

h2{

margin:0;

}

</style>