<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
          <h3>회원 정보</h3>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-info"  @click="moveModifyMember" class="mr-2">회원 정보 수정</b-button>
        <b-button variant="outline-danger"  @click="deleteMember">탈퇴</b-button>
      </b-col>
    </b-row>

    <b-row class="mb-1">
      <b-col>
        <br/>
        <b-card :header-html="`<h3>
          ID : ${userInfo.id}</h3>
          <h3>이름 : ${userInfo.name}</h3>
          <h3>e-mail : ${userInfo.email}</h3>
          <h3>나이 : ${userInfo.age}</h3>`"
          class="mb-2" border-variant="dark" no-body>
        </b-card>
      </b-col>
    </b-row>

    <!-- <table>
      <tbody>
        <tr>
          <th scope="col" colspan="2" class="t">
            <div>기본정보</div>
          </th>
        </tr>
        <tr>
          <th scope="row">
            <div>아이디</div>
          </th>
          <td class="w100">${{userInfo.id}}</td>
        </tr>
        <tr>
          <th scope="row">
            <div>이름</div>
          </th>
          <td class="w100">${{userInfo.name}}</td>
        </tr>
        <tr>
          <th scope="row">
            <div>이메일</div>
          </th>
          <td class="w100">${{userInfo.email}}</td>
        </tr>
        <tr>
          <th scope="row">
            <div>나이</div>
          </th>
          <td class="w100">${{userInfo.age}}</td>
        </tr>
      </tbody>
    </table> -->

  </b-container>
</template>

<script>

import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "UserMyPage",
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods:{
    moveModifyMember(){
      console.log("수정");
      this.$router.push({ name: "memberupdate" });
    },
    deleteMember(){
      console.log("삭제");
      this.$router.push({ name: "memberdelete" });
    },
  }
};
</script>

<style></style>