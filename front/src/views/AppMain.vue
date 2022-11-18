<template>
  <main>
    <div class="main-container">
      <b-card overlay img-src="https://picsum.photos/900/250/?image=3" img-alt="Card Image" text-variant="white"
        title="Where Is MyHome?" sub-title="Let's find the house you want" ><br />
        <b-card-text>
        </b-card-text>
        <b-button variant="outline-light" router-link to="/house">동별 실거래가 조회</b-button>
      </b-card>
      <b-card></b-card>
    </div>
  </main>
</template>

<script>

export default {
  name: 'IndexView',
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

a {
  text-decoration: none;
}
</style>