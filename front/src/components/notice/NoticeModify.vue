<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="checkValue">
        <b-form-group id="subject-group" label="제목:" label-for="subject" description="제목을 입력하세요.">
          <b-form-input
            id="subject"
            v-model="article.subject"
            type="text"
            required
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="article.content"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
          ></b-form-textarea>
        </b-form-group>
        <b-button type="submit" variant="outline-primary" class="m-1">글 수정</b-button>
        <b-button variant="outline-success" @click="moveList" >목록으로 이동</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>


<script>
import http from "@/api/http";

export default {
    name:"NoticeModify",
    data(){
        return{
            article: Object,
        };
    },
    created(){
        console.log(this.$route.params.articleNo);
        http.get(`/notice/${this.$route.params.articleNo}`).then(({ data }) => {
        this.article = data;
    });
    },
    methods: {
      checkValue(event) {
      event.preventDefault();
      let err = true;
      let msg = "";
      // !this.article.userId && ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userId.focus());
      err && !this.article.subject && ((msg = "제목 입력해주세요"), (err = false), this.$refs.subject.focus());
      err && !this.article.content && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else this.modifyArticle();
    },
    modifyArticle() {
      http.put(`/notice/${this.$route.params.articleNo}`, this.article).then(({ data }) => {
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
      console.log("목록으로 이동")
      this.$router.push({ name: "noticelist" });
    },
  },
}
</script>


<style></style>
