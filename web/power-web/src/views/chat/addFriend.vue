<template>
    <div class="friendsMain">
        <div class="title">
            添加好友
        </div>
        <div class="userList">
            <div class="searchBox" >
                <el-input placeholder="请输入账号" prefix-icon="el-icon-search" v-model="queryId"></el-input>
            </div>
            <div v-for="(user,index) in userList" :key="index" style="">
                <div class="user">
                    <div class="imgBox" @click="toChat(user.userId,user.userName)">
                        <img :src="user.headImg"/>
                    </div>
                    <div class="nameStyle" @click="toChat(user.userId,user.userName)">
                        {{user.userName}}
                    </div>
                    <div class="iconSty" @click="addFriend(user.userId,user.userName)">
                        <i class="el-icon-circle-plus-outline"></i>
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
            userList: [],
            userData:{},
            queryId:""
        };
    },
    created(){
    },
    mounted(){
        let userDataStr=sessionStorage.getItem("userData");
        this.userData=JSON.parse(userDataStr);
        // this.queryUser();
    },
    methods:{
        //查询好友
        queryUser(){
            let param={
                userId:this.queryId
            }
            this.$axios.post("/queryUser",this.$qs.stringify(param)).then((res)=>{
                let result = res.data;
                if(result.code=="200"){
                    this.userList=result.data;
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
        },
        addFriend(userId,userName){
            let param={
                userId:this.userData.userId,
                friendUserId:userId
            }
            this.$axios.post("/addFriend",this.$qs.stringify(param)).then((res)=>{
                let result = res.data;
                if(result.code=="200"){
                    console.log("添加成功==",result);
                    this.$router.push("/chat/"+userId+"/"+userName);
                }else{
                    console.log("添加失败");
                    this.$message.error(result.msg);
                }
                
            }).catch((err)=>{
                console.log("异常信息",err);
            })
        }
    },
    watch:{
        queryId(val){
            console.log("---"+val)
            if(val!=""){
                this.queryUser();
            }else{
                console.log("==");
                this.userList=[];
            }
            
        }
    }

}
</script>

<style scoped>
    .addUserMain{
        width:100%;
        height:100%;
        display:flex;
        flex-direction: column;
    }
    .userList{
        flex:1;
    }
    .nameStyle{
        flex:1;
        height:60px;
        line-height:60px;
        text-align:left;
        padding-left:10px;
        border-bottom:1px solid #cccccc;
    }
    .iconSty{
        width:60px;
        height:60px;
        line-height:60px;
        border-bottom:1px solid #cccccc;
    }
    .user{
        display:flex;
        flex-direction:row;
        height:60px;
    }
    .user img{
        height:42px;
        width:42px;
        margin:9px auto auto 9px;
    }
    .imgBox{
        width:60px;
        height:100%;
    }
    .searchBox{
       margin:5px auto; 
       width:90%;
    }
    .title{
        height:40px;
        line-height:40px;
        background-color:#eeeeee;
    }
</style>