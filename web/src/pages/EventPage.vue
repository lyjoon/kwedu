<template>
    <v-app>
        <v-main tag="div" class="event_main mb-0 pb-0">
            <event-app-bar />
            <event-component-1 />
            <event-component-2 />
            <event-component-3 />
            <event-component-4 />
            <event-component-5 />
            <event-component-6 />
        </v-main>
        <v-footer app fixed inset padless color="transparent">
            <event-footer />
        </v-footer>
    </v-app>
</template>

<script>
import EventAppBar from '../components/event/EventAppBar.vue'
    import EventComponent1 from '../components/event/EventComponent1.vue'
    import EventComponent2 from '../components/event/EventComponent2.vue'
    import EventComponent3 from '../components/event/EventComponent3.vue'
    import EventComponent4 from '../components/event/EventComponent4.vue'
    import EventComponent5 from '../components/event/EventComponent5.vue'
    import EventComponent6 from '../components/event/EventComponent6.vue'
    import EventFooter from '../components/event/EventFooter.vue'
    
    export default {
        components: { EventComponent1, EventComponent2, EventComponent3, EventComponent4, EventComponent5, EventComponent6, EventFooter, EventAppBar },
        name: "EventPage"
    }
</script>

<style scoped>
</style>
