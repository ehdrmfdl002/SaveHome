<template>
  <h1>글 삭제</h1>
</template>

<script>

import { deleteArticle } from "@/api/notice";

export default {
  name: "NoticeDelete",
  created() {
    let param = this.$route.params.articleNo;

    deleteArticle(
      param,
      ({ data }) => {
        let msg = "삭제 처리시 문제가 발생했습니다.";
        if (data === 1) {
          msg = "삭제가 완료되었습니다.";
        }
        alert(msg);
        this.$router.push({ name: "noticelist" });
      },
      (error) => {
        console.log(error);
      }
    );
  },
};
</script>

<style></style>