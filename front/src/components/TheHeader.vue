<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand router-link to="/">WhereIsMyHome</b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <!-- after login -->
        <!-- <div v-if="userInfo">
        <div class="header-top">
          <b-navbar-nav>
            <b-nav-item class="align-self-center link" @click.prevent="onClickLogout">Logout</b-nav-item>
            <b-nav-item router-link to="/member/allInfo">회원조회</b-nav-item>
            <b-nav-item router-link to="/member/memberinfo">회원정보</b-nav-item>
          </b-navbar-nav>
        </div>
      </div> -->
      <!-- cnter aligned nav items -->
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-navbar-nav class="ml">
        <b-navbar-nav>
            <b-nav-item router-link to="/notice">공지사항</b-nav-item>
            <b-nav-item router-link to="/board">자유게시판</b-nav-item>
          </b-navbar-nav>
      </b-navbar-nav>
    

      <b-navbar-nav class="ml-auto" v-if="userInfo">
            <b-nav-item variant="primary">{{ userInfo.name }}({{ userInfo.id }})님 환영합니다.</b-nav-item>
            <b-nav-item v-if="userInfo.id === 'admin'" router-link to="/member/allInfo">회원목록</b-nav-item>
            <b-nav-item class="align-self-center link" @click.prevent="onClickLogout">로그아웃</b-nav-item>
            <b-nav-item router-link to="/member/memberinfo">회원정보</b-nav-item>
          </b-navbar-nav>


      <!-- before login -->
          <b-navbar-nav  class="ml-auto" v-else>
            <b-nav-item router-link to="/member/login">로그인</b-nav-item>
            <b-nav-item router-link to="/member/signup">회원가입</b-nav-item>
          </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
import { mapState, mapGetters, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
name: "TheHeader",
data() {
  return {
    user: {
      userid: null,
      userpwd: null,
    },
  };
},
computed: {
  ...mapState(memberStore, ["isLogin", "userInfo"]),
  ...mapGetters(["checkUserInfo"]),
},
methods: {
  ...mapActions(memberStore, ["userLogout"]),
  // ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
  onClickLogout() {
    // this.SET_IS_LOGIN(false);
    // this.SET_USER_INFO(null);
    // sessionStorage.removeItem("access-token");
    // if (this.$route.path != "/") this.$router.push({ name: "main" });
    console.log(this.userInfo.id);
    //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
    //+ satate에 isLogin, userInfo 정보 변경)
    // this.$store.dispatch("userLogout", this.userInfo.userid);
    this.userLogout(this.userInfo.id);
    sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
    sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
    let msg = "로그아웃 되었습니다."
    if (this.$route.path != "/") this.$router.push({ name: "main" });
    alert(msg);
  },
},
};
</script>

<style>
</style>