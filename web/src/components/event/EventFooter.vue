<template>
<v-flex class="d-flex justify-center">
    <v-btn color="pink" dark class="flex-fill title pa-9 darken-1" style="z-index: 100;" elevation="1"
     @click="$vuetify.goTo('#inquiry-form')">
        <span class="title">무료교재 신청하기</span>
    </v-btn>
</v-flex>
</template>

<script>

    export default {
        name: "EventFooter"
    }
</script>

<style scoped>

</style>
