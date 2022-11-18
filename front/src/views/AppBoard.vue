<template>
  <b-container class="bv-example-row mt-3 text-center">
    <h3 class="underline-orange">
    <b-icon icon="house-fill"></b-icon>Board</h3>
    <router-view></router-view>
  </b-container>
</template>

<script>
import BoardList from "@/components/board/BoardList";
import BoardWrite from "@/components/board/BoardWrite";

export default {
  name: "AppBoard",
  components: {
      BoardList,
      BoardWrite,
  },
};
</script>

<style>
.underline-orange {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%,rgba(27, 129, 231, 0.3) 30%);
}
</style>
