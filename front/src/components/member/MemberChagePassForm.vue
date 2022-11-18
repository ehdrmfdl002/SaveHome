<template>
    <b-container fluid class="SignInClass">
        <h3>비밀번호 수정</h3>
        <br /><br /><br />
        <b-row class="my-1">
            <b-col sm="2" style="margin">
                <label for="input-default" style="margin-top : 7px">Password</label>
            </b-col>
            <b-col sm="10">
                <b-form-input input id="password" v-model="password" ref="password" type="password"></b-form-input>
            </b-col>
        </b-row>
        <b-row class="btn float-right">
            <b-button variant="outline-info" @click="modifyInfo" class="m-1"> 변경 </b-button>
            <b-button variant="outline-info" @click="moveList"> 메인 </b-button>
        </b-row>
    </b-container>
</template>
  
<script>
import http from "@/api/http";
export default {
    name: "MemberChagePassForm",
    data() {
        return {
            id : localStorage.getItem('userid'),
            password : null
        };
    },
    // created() {
    //     console.log(this.$route.params.id);
    //     http.get(`/member/changePass/${this.$route.params.id}`).then(({ data }) => {
    //         this.member = data;
    //     });
    // },
    methods: {
        modifyInfo() {
            let err = true;
            let msg = "";
            err && !this.password && ((msg = "비밀번호 입력해주세요"), (err = false), this.$refs.password.focus());

            if (!err) alert(msg);
            else this.changeInformation();
        },
        changeInformation() {
            let member = {
                password : this.password
            }
            console.log(this.id, this.password)
            http.put(`/member/changePass/${this.id}`, member).then(({ data }) => {
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
            localStorage.removeItem('userid');
            this.$router.push({ name: "main" });
        },
    },
}
</script>
  
<style></style>