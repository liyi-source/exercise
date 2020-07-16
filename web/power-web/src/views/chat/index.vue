<template>
    <div class="indexMain">
        <div style="flex:1;overflow:auto;background-color:#ffffff;">
            <NearList v-if="thatNum==0"></NearList>
            <Friends v-else-if="thatNum==1"></Friends>
            <MySelf v-else-if="thatNum==2"></MySelf>
        </div>
        <div style="height:50px;background-color:#eeeeee;display:flex;flex-direction:row;">
            <Footer @changeTab="changeTab"></Footer>
        </div>
    </div>
</template>

<script>
    import NearList from '@/views/chat/chatList'
    import Footer from '@/views/chat/footer'
    import Friends from '@/views/chat/friends'
    import MySelf from '@/views/chat/wd'
    export default {
        components:{
            NearList,
            MySelf,
            Footer,
            Friends
        },
        data() {
            return {
                thatNum: 0,
            };
        },
        created(){
        },
        mounted(){
            
        },
        methods:{
            //改变不同页面
            changeTab(param){
                this.thatNum = param;
            }
        }
    }
</script>
    

<style scoped>
    .indexMain{
         height:100%;display:flex;flex-direction:column;
    }
</style>>
    
