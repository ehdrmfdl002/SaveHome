<template>
  <b-container fluid class="SignInClass">
    <h3>로그인</h3>
    <br /><br /><br />
    <b-row class="my-1">
      <b-col sm="2" style="margin">
        <label for="input-default" style="margin-top : 7px">ID</label>
      </b-col>
      <b-col sm="10">
        <b-form-input input id="id" v-model="user.id" type="text" placeholder="ID"></b-form-input>
      </b-col>
    </b-row>
    <b-row class="my-1">
      <b-col sm="2">
        <label for="input-default" style="margin-top : 7px">Password</label>
      </b-col>
      <b-col sm="10">
        <b-form-input input id="password" v-model="user.password" type="password" placeholder="password">
        </b-form-input>
      </b-col>
    </b-row>
    <b-row class="btn float-right">
            <b-button variant="outline-info"  @click="confirm" class="m-1"> 로그인 </b-button>
            <b-button variant="outline-info"  @click="moveFindForm"> 비밀번호 찾기 </b-button>
        </b-row>
  </b-container>

</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "UserLogin",
  data() {
    return {
      // isLoginError: false,
      user: {
        id: null,
        password: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      // console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log("4. confirm() userInfo :: ", this.userInfo);
        this.$router.push({ name: "main" });
      }
      else {
        let msg = "아이디 또는 비밀번호가 틀렸습니다."
        alert(msg);
      }
    },
    movePage() {
      this.$router.push({ name: "main" });
    },
    moveFindForm(){
      this.$router.push({ name: "memberfindform" });
    }
  },
};
</script>

<style></style>