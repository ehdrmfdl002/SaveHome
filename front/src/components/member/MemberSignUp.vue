<template>
    <b-container fluid class="SignInClass">
        <h3>회원 가입</h3>
        <br/><br/><br/>
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">ID</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="id" v-model="id" ref="id" type="text" placeholder="ID"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2">
                <label for="input-default" style="margin-top : 7px">Password</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="password" v-model="password" ref="password" type="password" placeholder="password"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2">
                <label for="input-default" style="margin-top : 7px">Email</label>
            </b-col>
            <b-col sm="10">
                <b-form-input id="email" v-model="email" ref="email" type="text" placeholder="email"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2">
                <label for="input-default" style="margin-top : 7px">Name</label>
            </b-col>
            <b-col sm="10">
                <b-form-input id="name" v-model="name" ref="name" type="text" placeholder="name"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2">
                <label for="input-default" style="margin-top : 7px">Age</label>
            </b-col>
            <b-col sm="10">
                <b-form-input id="age" v-model="age" ref="age" type="number" placeholder="age"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="btn float-right">
            <b-button variant="outline-info"  @click="signIn"> 회원 가입 </b-button>
        </b-row>
    </b-container>
</template>
  

<script>
import http from "@/api/http";

export default {
    name: "MemberSignUp",
    data() {
        return {
            id: null,
            password: null,
            email: null,
            name: null,
            age: null,
        };
    },
    methods: {
        signIn() {
            let err = true;
            let msg = "";
            // !this.userid && ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userid.focus());
            err && !this.id && ((msg = "ID 입력해주세요"), (err = false), this.$refs.id.focus());
            err && !this.password && ((msg = "비밀번호 입력해주세요"), (err = false), this.$refs.password.focus());
            err && !this.email && ((msg = "이메일 입력해주세요"), (err = false), this.$refs.email.focus());
            err && !this.name && ((msg = "이름 입력해주세요"), (err = false), this.$refs.name.focus());
            err && !this.age && ((msg = "나이 입력해주세요"), (err = false), this.$refs.age.focus());

        if (!err) alert(msg);
        else this.registMember();
    },
    registMember() {
        console.log("회원가입 하러가자!!!!");
        let member = {
            id: this.id,
            password: this.password,
            email: this.email,
            name: this.name,
            age: this.age,
        };
        http.post("/member/signup", member).then(({ data }) => {
            let msg = "등록 처리 중 문제 발생!!!";
            if (data === 1) msg = "등록 성공!!!";
            alert(msg);
            this.moveList();
        });
    },
    moveList() {
        console.log("메인 가자!!!");
        this.$router.push({ name: "main" });
    },
}
}
</script>
  

<style>
.SignInClass{
    width: 60%;
}
</style>

