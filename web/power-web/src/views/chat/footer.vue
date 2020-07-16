<template>
    <div style="height:100%;width:100%;">
        <div class="footerMain">
            <div v-for="(tab,index) in tabs" :key="index" @click="clickTab(index)" style="flex:1">
                <div style="width:100%;height:100%;" v-if="thatNum!=index">
                    <img :src="tab.img" class="iconStyle"/>
                    <div>{{tab.text}}</div>
                </div>
                <div style="width:100%;height:100%;" v-else>
                    <img :src="tab.active" class="iconStyle"/>
                    <div style="color:#1afa29;">{{tab.text}}</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                thatNum: 0,
                tabs:[
                    // {text:"首页",url:'/',img:"../../../static/img/tabs/shoye.png",active:'../../../static/img/tabs/shoye1.png'},
                    // {text:"客服",url:'/index_CustomerService',img:"../../../static/img/tabs/kefu.png",active:'../../../static/img/tabs/kefu1.png'},
                    {text:"消息",url:'/nearList',img:"static/images/icon_img/msg_0.png",active:'static/images/icon_img/msg_1.png'},
                    {text:"联系人",url:'/friends',img:"static/images/icon_img/friend_0.png",active:'static/images/icon_img/friend_1.png'},
                    {text:"我的",url:'/mySelf',img:"static/images/icon_img/user_0.png",active:'static/images/icon_img/user_1.png'}
                ],
            };
        },
        created(){
        },
        mounted(){
            
        },
        methods:{
            clickTab: function(index) {
                this.thatNum = index;
                //传递到父页面
                this.$emit('changeTab', index);
            },

        }
    }
</script>
    
<style scoped>
    .footerMain{
        height:50px;
        background-color:#eeeeee;
        display:flex;
        flex-direction:row;
    }
    .iconStyle{
        width:20px;
        height:20px;
        margin-top:5px;
    }
</style>
    
