<template>
  <b-row class="mb-1">
   <b-col style="text-align: left">
     <b-form @submit="checkValue">
       <b-form-group id="subject-group" label="제목:" label-for="subject" description="제목을 입력하세요.">
         <b-form-input
           id="subject"
           v-model="subject"
           type="text"
           required
           placeholder="제목 입력..."
         ></b-form-input>
       </b-form-group>

       <b-form-group id="content-group" label="내용:" label-for="content">
         <b-form-textarea
           id="content"
           v-model="content"
           placeholder="내용 입력..."
           rows="10"
           max-rows="15"
         ></b-form-textarea>
       </b-form-group>
       <b-button type="submit" variant="outline-primary" class="m-1">글작성</b-button>
       <b-button @click="moveList" variant="outline-success">목록으로 이동</b-button>
     </b-form>
   </b-col>
 </b-row>
</template>

<script>
import http from "@/api/http";
import store from "@/store";

export default {
name: "NoticeWrite",
 data() {
   return {
     userId: null,
     subject: null,
     content: null,
   };
 },
  methods: {
    checkValue(event) {
     event.preventDefault();
     let err = true;
     let msg = "";
     // !this.userId && ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userId.focus());
     err && !this.subject && ((msg = "제목 입력해주세요"), (err = false), this.$refs.subject.focus());
     err && !this.content && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());

     if (!err) alert(msg);
     else this.registArticle();
   },
   registArticle() {
     console.log("글작성 하러가자!!!!");
     const checkUserInfo = store.getters["memberStore/checkUserInfo"];
     console.dir(checkUserInfo);
     
     let article = {
       userId: store.getters["memberStore/checkUserInfo"].id,
       subject: this.subject,
       content: this.content,
     };
     http.post("/notice", article).then(({ data }) => {
       console.log(data);
       let msg = "등록 처리시 문제가 발생했습니다.";
       if (data === 1) msg = "글등록이 완료되었습니다.";
       alert(msg);
       this.moveList();
     });
   },

   moveList() {
     console.log("글목록 보러가자!!!");
     this.$router.push({ name: "noticelist" });
   },
 },
}
</script>

<style></style>