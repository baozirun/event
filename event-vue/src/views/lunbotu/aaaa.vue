<template>
    <div id="WBAQPage" class="WBAQPage">
        <carousel :slides="slides" :inv="invTime"></carousel>
    </div>
</template>
<script>
import carousel from './Carousel.vue'
    export default {
        data () {
            return {
                invTime: 2000,
                slides: [
                    {
                        src:require('./img/OIP-C (1).jpg'),
                        title:'xxx1', 
                    },
                    {
                        src:require('./img/OIP-C (2).jpg'),
                        title:'xxx2'
                    },
                    {
                        src:require('./img/OIP-C (3).jpg'),
                        title:'xxx3'
                    },
                    {
                        src:require('./img/OIP-C.jpg'),
                        title:'xxx4'
                    }
                ]
            }
        },
        components: {
            carousel
        }
    }
</script>
<style scoped>

</style>