<template>
    <div style="height:100%;display:flex;flex-direction:column;">
        <div style="flex:1;overflow:auto;background-color:#ffffff;">
            <router-view/>
        </div>
        <div style="height:50px;background-color:#eeeeee;display:flex;flex-direction:row;">
            <router-link tag="div" to="/chatList" style="width:50%;">
                <img src="static/images/icon_img/msg_1.png" style="width:20px;width:20px;margin-top:5px;"/>
                <div style="font-size:14px;color:#1afa29;">消息</div>
            </router-link>
            <router-link tag="div" to="/login"  style="width:50%;">
                <img src="static/images/icon_img/user_0.png" style="width:20px;width:20px;margin-top:5px;"/>
                <div>我的</div>
            </router-link>

            <!-- <div style="height:100%;width:auto;">
                <img src="static/images/icon_img/msg_1.png" style="width:20px;width:20px;margin-top:5px;"/>
                <div style="font-size:14px;color:#1afa29;">消息</div>
            </div>
            <div style="height:100%;width:auto;">
                <img src="static/images/icon_img/msg_1.png" style="width:20px;width:20px;margin-top:5px;"/>
                <div style="font-size:14px;color:#1afa29;">好友</div>
            </div>
            <div style="height:100%;width:auto;">
                <img src="static/images/icon_img/user_0.png" style="width:20px;width:20px;margin-top:5px;"/>
                <div>我的</div>
            </div> -->
        </div>
        
        
    </div>
</template>

<script>
    export default {
        data() {
            return {
                chatList:[
                    {"name":"测试1","userId":"1"},
                    {"name":"测试2","userId":"2"},
                    {"name":"测试3","userId":"3"}
                ],
                userData:{},
                unreadMsg:""
            };
        },
        created(){
        },
        mounted(){
            let userDataStr=sessionStorage.getItem("userData");
            this.userData=JSON.parse(userDataStr);
            this.getAllFriend();
        },
        methods:{
            //获取所有好友信息
            getAllFriend(){
                this.$axios.post("/getAllFriendById",this.$qs.stringify(this.userData)).then((res)=>{
                    let result = res.data;
                    if(result.code=="200"){
                        // this.$message.success(result.msg);
                        this.chatList=result.data;
                        console.log("333",this.chatList);
                    }else{
                        this.$message.error(result.msg);
                    }
                    console.log("获取结果==",result);
                }).catch((err)=>{
                    console.log("异常信息",err);
                })
                    
            },
            toChat(userId,userName){
                console.log("===",event);
                // let id=event.target.getAttribute("userId");
                // let id=event;
                // let name=event.target.innerHTML;
                //跳转到聊天页面
                this.$router.push("/chat/"+userId+"/"+userName);
            }
        }
    }
</script>
<style scoped>

</style>>
    
</style>
<style>
    .msgTip .el-badge__content.is-fixed {
        position: absolute;
        top: 10px;
        right:12px;
    }
</style>