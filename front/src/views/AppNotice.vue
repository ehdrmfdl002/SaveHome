<template>
    <b-container class="bv-example-row mt-3 text-center">
      <h3 class="underline-orange">
      <b-icon icon="house-fill"></b-icon>Notice Board</h3>
      <router-view></router-view>
    </b-container>
</template>
  
  <script>
  import NoticeList from "@/components/notice/NoticeList";
  import NoticeWrite from "@/components/notice/NoticeWrite";

  export default {
    name: "AppNotice",
    components: {
        NoticeList,
        NoticeWrite,
    },
  };
  </script>
  
  <style>
  .underline-orange {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%,rgba(27, 129, 231, 0.3) 30%);
}
  </style>
  