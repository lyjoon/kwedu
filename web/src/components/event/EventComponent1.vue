<template>
    <v-flex class="edu01 pb-6" id="edu-first">
        <v-container>
            <v-img src="@/assets/images/edu/_1.png" width="100%" style="position;relative">
                <a style="position:absolute; top: 80.5%; left: 39.6%; height:3.7%; width: 22.95%;" @click="$vuetify.goTo('#edu-third')"></a>
            </v-img>

        </v-container>
    </v-flex>
</template>

<script>

    export default {
        name: "EventComponent1"
    }
</script>

<style scoped>

</style>
