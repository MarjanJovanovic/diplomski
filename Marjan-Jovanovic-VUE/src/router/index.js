import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import Subject from "../components/subject/index.vue"
import City from "../components/city/index.vue"
import Student from "../components/student/index.vue"
import Professor from "../components/professor/index.vue"
import ExamPeriod from "../components/exam-period/index.vue"
import Exam from "../components/exam/index.vue"

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/subject",
    name: "Subject",
    component: Subject,
  },
  {
    path: "/city",
    name: "City",
    component: City,
  },
  {
    path: "/student",
    name: "Student",
    component: Student,
  },
  {
    path: "/professor",
    name: "Professor",
    component: Professor,
  },
  {
    path: "/exam-period",
    name: "Exam Period",
    component: ExamPeriod,
  },
  {
    path: "/exam",
    name: "Exam",
    component: Exam,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
