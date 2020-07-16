<template>
    <div style="height:100%;display:flex;flex-direction:column;">
        <div style="width:100%;text-align:center;height:40px;line-height:40px;border-bottom:1px solid #cccccc;">
            {{toUser.name}}
        </div>
        
        <div style="flex:1;border-bottom:1px solid #cccccc;overflow:auto;background-color:#eeeeee;">
            <div class="chatBox" v-for="(msg,index) in messageList" :key='index'>
                <div v-bind:class="[msg.fromUserId==userData.userId?'rightBox':'leftBox']">
                    {{msg.msg}}
                </div>
                <div style="clear:both;"></div>
            </div>
        </div>
        <div style="height:50px;line-height:50px;">
            <el-input v-model="sendMessage" placeholder="请输入内容" style="width:70%;margin-left:10px;"></el-input>
            <el-button type="primary" size="small" round style="margin-left:10px;" @click="send()">发送</el-button>
        </div>
    </div>
</template>

<script>
    import SockJS from  'sockjs-client';
    import  Stomp from 'stompjs';
    export default {
        data() {
            return {
                userData:{},
                messageList:[
                ],
                // messageRecord:"", 
                sendMessage:"", 
                toUser:{},
            };
        },
        created(){
            let toUserId=this.$route.params.id
            let toUserName=this.$route.params.data
            this.toUser={
                "id":toUserId,
                "name":toUserName
            }
            let userDataStr=sessionStorage.getItem("userData");
            this.userData=JSON.parse(userDataStr);
        },
        mounted(){
            //查询聊天记录
            this.getChatRrcord();
            this.initChat();
        },
        methods:{
            initChat(){
                let that=this
                var sock=new SockJS("http://47.110.93.6:18010/socket");
                // var sock=new SockJS("http://localhost:18010/socket");
                var stompClient=Stomp.over(sock);
                stompClient.connect({},function(data){
                    stompClient.subscribe("/user/"+that.toUser.id+"="+that.userData.userId+"/sendMessage",function(response){
                        let jsonObj = JSON.parse(response.body);//将json字符串转换成json对象
                        that.messageList.push(jsonObj);
                    })
                })
            },
            send(){
                if(this.sendMessage.trim()==""){
                    this.$message.warning("发送内容不能为空。");
                    return;
                }
                let param={
                    "toUserId":this.toUser.id,
                    "msg":this.sendMessage,
                    "fromUserId":this.userData.userId
                }
                // this.$axios.post("/sendMessage").then((res)=>{
                this.$axios.post("/sendMessage",this.$qs.stringify(param)).then((res)=>{
                    let result = res.data;
                    if(result.code=="200"){
                        if(this.toUser.id!=this.userData.userId){
                            this.messageList.push({"toUserId":this.toUser.id,"fromUserId":this.userData.userId,"msg":this.sendMessage});
                        }
                        this.sendMessage="";
                        console.log("ok")
                    }else{
                        console.log("error")
                    }
                    console.log("获取结果==",result);
                })
            },
            getChatRrcord(){
                let param={
                    "toUserId":this.toUser.id,
                    "fromUserId":this.userData.userId
                }
                this.$axios.post("/queryChatRecord",this.$qs.stringify(param)).then((res)=>{
                    let result = res.data;
                    if(result.code=="200"){
                        let data=result.data;
                        for(let i=0;i<data.length;i++){
                            this.messageList.push({"toUserId":data[i].toUserId,"fromUserId":data[i].fromUserId,"msg":data[i].msg});
                        }
                        console.log("ok")
                    }else{
                        console.log("error")
                    }
                    console.log("获取结果==",result);
                })
            }
        }
    }
</script>
<style scoped>
    .chatBox{
        width:100%;
        height:auto;

    }
    .leftBox{
        max-width:60%;
        margin-left:5px;
        margin-top:10px;
        padding:8px;
        float:left;
        word-break: break-all;
        text-align:left;
        background-color:#ffffff;
        border-radius:5px;
    }
    .rightBox{
        max-width:60%;
        margin-right:5px;
        margin-top:10px;
        padding:8px;
        float:right;
        word-break: break-all;
        text-align:left;
        background-color:#9eea6a;
        border-radius:5px;
    }
</style>