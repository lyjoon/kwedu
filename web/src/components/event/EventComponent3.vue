<template>
    <v-flex class="edu03 pa-10" style="position: relative;">
        <v-container>
            <v-carousel class="fill-height" height="auto" v-model="selected"
                hide-delimiters show-arrows>
                <v-carousel-item v-for="item in imgs"
                               :key="item" :eager="true" height="auto">            
                    <img :src="item" width="100%" />
                </v-carousel-item>
            </v-carousel>
        </v-container>
    </v-flex>
</template>

<script>

    export default {
        name: "EventComponent3",
        data () {
            return {
                selected: 0,
                imgs:[
                    require('@/assets/images/edu/section3_2_1.jpg'),
                    require('@/assets/images/edu/section3_2_2.jpg'),
                    require('@/assets/images/edu/section3_2_3.jpg'),
                ]
            };
        }
    }
</script>

<style scoped>

</style>
