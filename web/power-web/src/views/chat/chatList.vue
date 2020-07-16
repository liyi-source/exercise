<template>
    <div style="height:100%;display:flex;flex-direction:column;">
        <div style="height:40px;background-color:#eeeeee;line-height:40px;">{{userData.userName}}</div>
        <div style="flex:1;overflow:auto;background-color:#ffffff;">
            <div v-for="(chatOne,index) in chatList" :key="index">
                <div @click="toChat(chatOne.userId,chatOne.userName)" style="display:flex;flex-direction:row;height:60px;">
                    <div style="width:60px;height:100%;" class="msgTip">
                        <el-badge :value="chatOne.count" v-if="chatOne.count!=0">
                            <img :src="chatOne.headImg" style="height:42px;width:42px;margin:9px auto auto 9px;"/>
                        </el-badge>
                        <el-badge value="" v-else>
                            <img :src="chatOne.headImg" style="height:42px;width:42px;margin:9px auto auto 9px;"/>
                        </el-badge>
                    </div>
                    <div style="flex:1;height:100%;border-bottom:1px solid #cccccc;">
                        <div style="width:100%;height:50%;text-align:left;margin-left:5px;line-height:40px;">{{chatOne.userName}}</div>
                        <div style="width:100%;height:50%;text-align:left;margin-left:5px;font-size:12px;color:#bbbbbb;">{{chatOne.msg}}</div>
                    </div>
                    <div style="width:80px;height:100%;font-size:14px;border-bottom:1px solid #cccccc;">
                        <div style="width:100%;margin-top:10px;color:#cccccc">
                            {{chatOne.createTime}}
                        </div>
                    </div>
                </div>
            </div>
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
                this.$axios.post("/getAllRecordById",this.$qs.stringify(this.userData)).then((res)=>{
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