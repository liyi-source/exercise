<template>
    <div class="friendsMain">
        <div class="title">
            <div style="width:40px;">
                <!-- <img :src="friend.headImg"/> -->
            </div>
            <div style="flex:1">好友列表</div>
            <div style="width:40px;">
                <img src="static/images/icon_img/add_user.png" @click="addUser"/>
            </div>
        </div>
        <div class="friendsList">
            <div class="searchBox" >
                <el-input placeholder="搜索" prefix-icon="el-icon-search" v-model="queryName"></el-input>
                <!-- <el-input v-model="queryName" placeholder="搜索" style="width:80%;"></el-input> -->
                <!-- <el-button type="primary" size="small" round style="margin-left:10px;" @click="query()">搜索</el-button> -->
            </div>

            <div v-for="(friend,index) in friendsList" :key="index" style="margin-top:5px;">
                <div class="friend" @click="toChat(friend.userId,friend.userName)">
                    <div class="imgBox">
                        <img :src="friend.headImg"/>
                    </div>
                    <div class="nameStyle">
                        {{friend.userName}}
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
            friendsList: [],
            userData:{},
            queryName:""
        };
    },
    created(){
    },
    mounted(){
        let userDataStr=sessionStorage.getItem("userData");
        this.userData=JSON.parse(userDataStr);
        this.query();
    },
    methods:{
        //查询好友
        queryAllFriendsById(param){
            this.$axios.post("/getAllFriendById",this.$qs.stringify(param)).then((res)=>{
                let result = res.data;
                if(result.code=="200"){
                    this.friendsList=result.data;
                }else{
                    this.$message.error(result.msg);
                }
                console.log("获取结果==",result);
            }).catch((err)=>{
                console.log("异常信息",err);
            })
        },
        query(){
            console.log(this.queryName)
            let param={
                userId:this.userData.userId,
                userName:this.queryName
            }
            this.queryAllFriendsById(param);
        },
        toChat(userId,userName){
            console.log("跳转到聊天页面");
            //跳转到聊天页面
            this.$router.push("/chat/"+userId+"/"+userName);
        },
        addUser(){
            console.log("跳转到添加好友页面");
            this.$router.push("/addFriend");
        }
    },
    watch:{
        queryName(val){
            this.query();
        }
    }

}
</script>

<style scoped>
    .friendsMain{
        width:100%;
        height:100%;
        display:flex;
        flex-direction: column;
    }
    .title{
        height:40px;
        line-height:40px;
        background-color:#eeeeee;
        display:flex;
        flex-direction: row;
    }
    .title img{
        width:20px;
        height:20px;
        margin:10px;
    }
    .friendsList{
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
    .friend{
        display:flex;
        flex-direction:row;
        height:60px;
    }
    .friend img{
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
       /* margin-left:10%; */
    }
    
</style>