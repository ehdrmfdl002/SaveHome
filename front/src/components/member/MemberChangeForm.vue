<template>
    <b-container fluid class="SignInClass">
        <h3>회원 정보 수정</h3>
        <br /><br /><br />
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">Password</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="password" v-model="password" ref="password" type="password"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">Email</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="email" v-model="member.email" ref="email" type="text"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">Name</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="name" v-model="member.name" ref="email" type="text"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col sm="2">
                <label for="input-default" style="margin-top : 7px">Age</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="age" v-model="member.age" ref="age" type="text">
                </b-form-input>
            </b-col>
        </b-row>
        <b-row class="btn float-right">
            <b-button variant="outline-info" @click="modifyInfo" class="m-1"> 수정 </b-button>
            <b-button variant="outline-info" @click="moveList"> 메인 </b-button>
        </b-row>
    </b-container>
</template>
  
<script>
import http from "@/api/http";
import store from "@/store";

export default {
    name: "MemberChangeForm",
    data(){
        return{
            member: Object,
        };
    },
    created() {
     const checkUserInfo = store.getters["memberStore/checkUserInfo"];
     this.member = checkUserInfo
    },
    methods: {
        modifyInfo() {
            let err = true;
            let msg = "";
            err && !this.password && ((msg = "비밀번호 입력해주세요"), (err = false), this.$refs.password.focus());
            err && !this.email && ((msg = "이메일 입력해주세요"), (err = false), this.$refs.email.focus());
            err && !this.name && ((msg = "이름 입력해주세요"), (err = false), this.$refs.name.focus());
            err && !this.age && ((msg = "나이 입력해주세요"), (err = false), this.$refs.age.focus());

            if (!err) alert(msg);
            else this.changeInformation();
        },
        changeInformation() {
            let member = {
                password : this.password,
                email : this.email,
                name : this.name,
                age : this.age,
            }
            http.put(`/member/changeinfo/${userInfo.id}`, member).then(({ data }) => {
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
            this.$router.push({ name: "main" });
        },
    },
}
</script>
  
<style></style>