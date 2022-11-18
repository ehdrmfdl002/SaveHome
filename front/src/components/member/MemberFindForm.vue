
<template>
   <b-container fluid class="SignInClass">
        <h3>비밀번호 수정</h3>
        <br /><br /><br />
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">ID</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="id" v-model="id" ref="id" type="text"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">Name</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="name" v-model="name" ref="name" type="text"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">Email</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="email" v-model="email" ref="email" type="text"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="btn float-right">
            <b-button variant="outline-info" @click="checkValue" class="m-1"> 입력 </b-button>
        </b-row>
    </b-container>
</template>


  <script>
import http from "@/api/http";

export default {
    name:"MemberFindForm",
    data(){
        return{
            id: null,
            name : null,
            email: null
        };
    },
      methods: {
    checkValue() {
      let err = true;
      let msg = "";
      // !this.article.userId && ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userId.focus());
        err && !this.id && ((msg = "ID 입력해주세요"), (err = false), this.$refs.id.focus());
        err && !this.name && ((msg = "이름 입력해주세요"), (err = false), this.$refs.name.focus());
        err && !this.email && ((msg = "이메일 입력해주세요"), (err = false), this.$refs.email.focus());

      if (!err) alert(msg);
      else this.postInfo();
    },
    postInfo() {
      let member = {
        id: this.id,
        name: this.name,
        email: this.email
      }
      console.dir(member)
      localStorage.setItem('userid',this.id);
      http.post("/member/findPass", member).then(({ data }) => {
        console.log(data);
        let msg = "수정 처리시 문제가 발생했습니다.";
        if (data === 1) {
          msg = "수정이 완료되었습니다.";
        }
        alert(msg);
        this.moveList();
      });
    },
    moveList() {
      this.$router.push({ name: "memberchangePass" });
    },
  },
}
</script>


<style></style>

