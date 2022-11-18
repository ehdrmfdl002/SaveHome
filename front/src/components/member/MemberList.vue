<template>
	<b-container class="bv-example-row mt-3">
	  <b-row>
		<b-col>
		  <h3>회원 목록</h3>
		</b-col>
	  </b-row>
	  <b-row class="mb-1">
	  </b-row>
	  <b-row>
		<b-col>
		  <b-table hover :items="member" :fields="fields">
		  </b-table>
		</b-col>
	  </b-row>
	</b-container>
</template>
  
  <script>
  import http from "@/api/http";
  
  export default {
	name: "MemberList",
	data() {
	  return {
		member: [],
		fields: [
		  { key: "id", label: "아이디", tdClass: "tdClass" },
		  { key: "name", label: "이름", tdClass: "tdClass" },
		  { key: "email", label: "이메일", tdClass: "tdClass" },
		  { key: "age", label: "나이", tdClass: "tdClass" },
		],
	  };
	},
	created() {
	  http.get(`/member/allInfo`).then(({ data }) => {

		this.member = data;
	  });
	},
  };
  
  </script>
  
  <style scope>
  .tdClass {
	width: 50px;
	text-align: center;
  }
  </style>
  