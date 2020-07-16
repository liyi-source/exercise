<template>
    <div style="height:100%;display:flex;flex-direction:column;">
        <div style="flex:1;overflow:auto;background-color:#ffffff;">
            <router-view/>
        </div>
        <div style="height:50px;background-color:#eeeeee;display:flex;flex-direction:row;">
            <router-link tag="div" :to="tab.url" v-for="(tab,index) in tabs" :key="index" :class="{active:index == thatnum}" @click="addClassName(index)">
                <img v-if="thatMum!=index" :src="tab.img" style="width:20px;width:20px;margin-top:5px;"/>
                <img :src="tab.active" style="width:20px;width:20px;margin-top:5px;" v-else/>
                <div>{{tab.text}}</div>
            </router-link>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                thatnum: 0,
                props:['tabName'],
                tabs:[
                    // {text:"首页",url:'/',img:"../../../static/img/tabs/shoye.png",active:'../../../static/img/tabs/shoye1.png'},
                    // {text:"客服",url:'/index_CustomerService',img:"../../../static/img/tabs/kefu.png",active:'../../../static/img/tabs/kefu1.png'},
                    {text:"消息",url:'/nearList',img:"static/images/icon_img/msg_1.png",active:'static/images/icon_img/msg_0.png'},
                    {text:"我的",url:'/mySelf',img:"static/images/icon_img/user_0.png",active:'static/images/icon_img/user_1.png'}
                ],
            };
        },
        created(){
        },
        mounted(){
            
        },
        methods:{
            addClassName: function(index) {
                this.thatnum = index;
            },
        }
    }
</script>
    

<style scoped>

</style>>
    
