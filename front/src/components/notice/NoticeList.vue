
<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h3>글목록</h3>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <!-- <b-button v-if="userInfo.id === `admin`" variant="outline-info" @click="moveWrite()">글쓰기</b-button> -->
        <b-button variant="outline-info" @click="moveWrite()">글쓰기</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table hover :items="articles" :fields="fields" @row-clicked="viewArticle">
          <template #cell(subject)="data">
            <router-link :to="{ name: 'noticeview', params: { articleNo: data.item.articleNo } }">
              {{ data.item.subject }}
            </router-link>
          </template>
        </b-table>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { listArticle } from "@/api/notice";

import { mapState, mapGetters} from "vuex";
const memberStore = "memberStore";

export default {
  name: "NoticeList",
  data() {
    return {
      articles: [],
      fields: [
        { key: "articleNo", label: "글번호", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userId", label: "작성자", tdClass: "tdClass" },
        { key: "registerTime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo", "isLogin"]),
    ...mapGetters(["checkUserInfo"]),
  },
  created() {
    let param = {
      pg: 1,
      spp: 5,
      key: null,
      word: null,
    };
    listArticle(
      param,
      ({ data }) => {
        this.articles = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveWrite() {
      let msg = "관리자만 작성 가능합니다."
      if (this.userInfo === null) {
        this.$router.push({ name: "noticewrite" });
      }
      else {
        console.dir(this.userInfo)
        console.log(this.userInfo.id)
        if (this.userInfo.id === 'admin') {
          this.$router.push({ name: "noticewrite" });
        }
        else {
          alert(msg);
          this.moveList();
        }
      }
      
    },
    viewArticle(article) {
      this.$router.push({
        name: "noticeview",
        params: { articleNo: article.articleNo },
      });
    },
    moveList() {
     console.log("글목록 보러가자!!!");
     this.$router.push({ name: "noticelist" });
   },
  },
};

</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}

</style>
