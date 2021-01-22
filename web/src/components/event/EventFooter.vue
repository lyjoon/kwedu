<template>
<v-flex class="d-flex justify-center">
    <a class="hidden-md-and-down" @click="$vuetify.goTo('#inquiry-form')" target="_blank">
        <v-img src="@/assets/images/edu/bottom_btn.gif" />
    </a>

    <v-btn color="red" dark class="hidden-lg-and-up flex-fill title pa-12" style="z-index: 100;" elevation="1"
     @click="$vuetify.goTo('#inquiry-form')">
        교재신청하기
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
