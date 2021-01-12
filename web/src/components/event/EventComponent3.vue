<template>
    <v-flex class="edu03 pa-10" style="position: relative;">
        <v-carousel class="fill-height" height="auto" v-model="crsIdx"
            hide-delimiter-background :show-arrows="false" hide-delimiters>
            <v-carousel-item>            
                <v-img src="@/assets/images/edu/section3_2_1.jpg" width="100%" />
            </v-carousel-item>
            <v-carousel-item>
                <v-img src="@/assets/images/edu/section3_2_2.jpg" width="100%" />
            </v-carousel-item>
            <v-carousel-item>
                <v-img src="@/assets/images/edu/section3_2_3.jpg" width="100%" />
            </v-carousel-item>
        </v-carousel>
        <div class="d-flex justify-lg-space-between">
            <a style="width:50%;height: 100%; position: absolute;z-index: 999;top:0px;left:0px;" @click="crsIdx = ((crsIdx - 1) < 0 ? 2 : (crsIdx - 1))"></a>
            <a style="width:50%;height: 100%; position: absolute;z-index: 999;top:0px;right:0px;"  @click="crsIdx = ((crsIdx + 1) > 2 ? 0 : (crsIdx + 1))"></a>
        </div>
    </v-flex>
</template>

<script>

    export default {
        name: "EventComponent3",
        data () {
            return {
                crsIdx: 2
            };
        }
    }
</script>

<style scoped>

</style>
