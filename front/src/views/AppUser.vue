<template>
  <b-container class="bv-example-row mt-3 text-center">
    <h3 class="underline-orange">
      <b-icon icon="house-fill"></b-icon> Sign In</h3>
    <router-view></router-view>
  </b-container>
</template>
  
<script>
import MemberSignUp from "@/components/member/MemberSignUp";

export default {
  name: "AppUser",
  components: {
    MemberSignUp,
  },
};
</script>
  
<style>

.AppUserHeight{
  height:10%;
}

.underline-orange {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%,rgba(27, 129, 231, 0.3) 30%);
}
</style>
  