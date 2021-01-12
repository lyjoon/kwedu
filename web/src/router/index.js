import Vue from 'vue'
import Router from 'vue-router'

import EventPage from '../pages/EventPage'
// import HomePage from '../pages/HomePage'
// import AppContainer from "../components/layout/AppContainer";
// import EventRedPen from "../components/event/EventRedPen";

Vue.use(Router)

export default new Router({
  mode: 'history', //removes # (hashtag) from url
  routes: [
    // {
    //   path: '/',
    //   component: AppContainer,
    //   children: [
    //     {
    //       path: '',
    //       component: HomePage
    //     },
    //     {
    //       path: '/event',
    //       component: EventPage,
    //       children: [
    //         {
    //           path: 'redpen',
    //           component: EventRedPen
    //         }
    //       ]
    //     }
    //   ]
    // }
    {
      path: '/event',
      component: EventPage
    }
  ]
})
