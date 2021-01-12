<template>
    <v-app-bar app fixed dense>
        <v-container>
            <div class="d-flex justify-space-between">
                <v-chip filter-icon="mdi-home"><v-icon>mdi-home</v-icon></v-chip>
                <v-spacer />
                <v-chip filter-icon="mdi-home"><v-icon>mdi-share</v-icon></v-chip>
            </div>
        </v-container>
    </v-app-bar>
</template>

<script>

    export default {
        name: "EventFooter"
    }
</script>

<style scoped>

</style>
