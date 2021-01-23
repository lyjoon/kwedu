<template>
    <v-flex class="edu03 pa-10" id="edu-third" style="position: relative;">
        <v-container style="max-width: 1180px !important;padding:0px;">
            <v-carousel class="fill-height" height="auto" cycle hide-delimiters hide-delimiter-background show-arrows>
                <!--
                <template v-slot:prev="{ on, attrs }">
                      <v-btn
                        color="success"
                        v-bind="attrs"
                        v-on="on"
                      >Previous slide</v-btn>
                    </template>
                <template v-slot:next="{ on, attrs }">
                      <v-btn
                        color="info"
                        v-bind="attrs"
                        v-on="on"
                      >Next slide</v-btn>
                </template>
                -->
                <v-container>
                    <v-carousel-item
                        v-for="(item, i) in images" :key="i"
                        :eager="true" height="auto">
                        <img :src="item" width="100%" :alt="i" :id="'edu03_img_'+i" />
                    </v-carousel-item>
                </v-container>
            </v-carousel>
        </v-container>
    </v-flex>
</template>

<script>

    export default {
        name: "EventComponent3",
        data () {
            return {
                images:[
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
