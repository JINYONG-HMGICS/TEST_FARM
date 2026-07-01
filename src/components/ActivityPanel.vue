<template>
  <section class="panel">
    <h2>Recent Activity</h2>

    <ul>
      <li
        v-for="(item, index) in limitedActivities"
        :key="`${index}-${item}`"
      >
        {{ item }}
      </li>
    </ul>
  </section>
</template>

<script setup>
import { computed } from 'vue'

const props = defineProps({
  activities: {
    type: Array,
    default: () => []
  }
})

const limitedActivities = computed(() => props.activities.slice(0, 10))
</script>