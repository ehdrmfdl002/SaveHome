import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import AppMain from '@/views/AppMain'
import AppHouse from "@/views/AppHouse";
import store from "@/store";

Vue.use(VueRouter)

const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const checkToken = store.getters["memberStore/checkToken"];
  let token = sessionStorage.getItem("access-token");
  console.log("로그인 처리 전", checkUserInfo, token);

  if (checkUserInfo != null && token) {
    console.log("토큰 유효성 체크하러 가자!!!!");
    await store.dispatch("memberStore/getUserInfo", token);
  }
  if (!checkToken || checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "login" });
    router.push({ name: "memberlogin" });
  } else {
    console.log("로그인 했다!!!!!!!!!!!!!.");
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/member",
    name: "member",
    component: () => import("@/views/AppUser"),
    redirect: "/member",
    children: [
      {
        path: "/member/allInfo",
        name: "memberlist",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/member/MemberList"),
      },
      {
        path: "/member/signup",
        name: "membersignup",
        component: () => import("@/components/member/MemberSignUp"),
      },
      {
        path: "/member/login",
        name: "memberlogin",
        component: () => import("@/components/member/MemberLogin"),
      },
      {
        path: "/member/findform",
        name: "memberfindform",
        component: () => import("@/components/member/MemberFindForm"),
      },
      {
        path: "/member/:id",
        name: "memberinfo",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/member/MemberInfo"),
      },
      {
        path: "/member/changePass/:id",
        name: "memberchangePass",
        component: () => import("@/components/member/MemberChagePassForm"),
      },
      {
        path: "/member/changeinfo/:id",
        name: "memberupdate",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/member/MemberChangeForm"),
      },
      {
        path: "/member/:id",
        name: "memberdelete",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/member/MemberDelete"),
      },
    ],
  },
  {
    path: "/house",
    name: "house",
    component: AppHouse,
  },
  {
    path: "/board",
    name: "board",
    component: () => import("@/views/AppBoard"),
    redirect: "/board",
    children: [
      {
        path: "/",
        name: "boardlist",
        component: () => import("@/components/board/BoardList"),
      },
      {
        path: "write",
        name: "boardwrite",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/BoardWrite"),
      },
      {
        path: ":articleNo",
        name: "boardview",
        component: () => import("@/components/board/BoardView"),
      },
      {
        path: ":articleNo",
        name: "boardmodify",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/BoardModify"),
      },
      {
        path: ":articleNo",
        name: "boarddelete",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/BoardDelete"),
      },
    ],
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import("@/views/AppNotice"),
    redirect: "/notice",
    children: [
      {
        path: "/",
        name: "noticelist",
        component: () => import("@/components/notice/NoticeList"),
      },
      {
        path: "/",
        name: "noticewrite",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/notice/NoticeWrite"),
      },
      {
        path: ":articleNo",
        name: "noticeview",
        component: () => import("@/components/notice/NoticeView"),
      },
      {
        path: ":articleNo",
        name: "noticemodify",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/notice/NoticeModify"),
      },
      {
        path: ":articleNo",
        name: "noticedelete",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/notice/NoticeDelete"),
      },
    ],
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
