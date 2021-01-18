import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';
import axios from 'vue-axios'

Vue.use(Vuetify, axios);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: '#3f51b5',
                secondary: '#ff7f00',
                accent: '#8c9eff',
                error: '#b71c1c',
            },
        },
    },
    icons: {
        iconfont: 'mdiSvg'
    }
});
