<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
          <h3>글보기</h3>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="moveList">목록</b-button>
      </b-col>
      <b-col class="text-right">
        <b-button variant="outline-info"  @click="moveModifyArticle" class="mr-2">글수정</b-button>
        <b-button variant="outline-danger"  @click="deleteArticle">글삭제</b-button>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <br/>
        <b-card :header-html="`<h3>${article.articleNo}.
          ${article.subject} [${article.hit}]</h3><div><h6>${article.userId}</div><div>${article.registerTime}</h6></div>`"
          class="mb-2" border-variant="dark" no-body>
          <b-card-body>
            <div v-html="`${article.content}`"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";
import { mapState, mapGetters} from "vuex";
const memberStore = "memberStore";

export default {
  name: "NoticeView",
  data() {
    return {
      article: Object,
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  created() {
    http.get(`/notice/${this.$route.params.articleNo}`).then((data) => {
      this.article = data.data;
    });
  },
  methods:{
    moveList() {
      console.log("글 목록");
      this.$router.push({ name: "noticelist" });
    },
    moveModifyArticle(){
      console.log("글 수정");
      let msg = "관리자만 수정가능합니다."
      if (this.userInfo === null) {
        alert(msg);
      }
      else {
        if(this.userInfo.id === this.article.userId)
        this.$router.push({ name: "noticemodify" });
        else {
          alert(msg);
        }
      }
    },
    deleteArticle(){
      console.log("글 삭제");
      let msg = "관리자만 삭제가능합니다."
      if (this.userInfo === null) {
        alert(msg);
      }
      else {
        if (this.userInfo.id === this.article.userId || this.userInfo.id === 'admin')
          this.$router.push({ name: "noticedelete" });
        else {
          alert(msg);
        }
      }
    },
  }
};
</script>

<style>

</style>