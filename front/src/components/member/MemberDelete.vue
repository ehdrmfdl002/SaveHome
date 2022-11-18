<template>
  <div class="regist">
    <h1>SSAFY 회원 탈퇴</h1>
    <div>삭제중....</div>
  </div>
</template>

<script>
import { memberdelete } from "@/api/member";
import store from "@/store";

const memberStore = "memberStore";
export default {
name: "MemberDelete",
created() {
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  let param = checkUserInfo.id;
  console.log(param);
  memberdelete(
    param,
    ({ data }) => {
      let msg = "탈퇴 시 문제가 발생했습니다.";
      if (data === "success") {
        msg = "탈퇴가 완료되었습니다.";
      }
      alert(msg);
      // 현재 route를 /list로 변경.
      this.$router.push({ name: "main" });
    },
    (error) => {
      console.log(error);
    }
  );
},
};
</script>

<style></style>