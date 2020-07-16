<template>
    <div class="login_containter">
        <div class="login_box">
            <!-- <div class="head_box"></div> -->
            <el-form class="login_form" :rules="rules" :model="ruleForm" ref="ruleForm">
                <el-form-item prop="userId">
                    <el-input  placeholder="请输入账号" v-model="ruleForm.userId" prefix-icon="iconfont iconzh"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input placeholder="请输入密码" v-model="ruleForm.password" prefix-icon="iconfont iconmm" show-password></el-input>
                </el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登陆</el-button>
                <el-button type="info" @click="resetForm('ruleForm')">重置</el-button>
            </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    userId: '',
                    password: ''
                },
                rules: {
                    userId: [
                        { required: true, message: '请输入账号', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ]
                }
            };
        },
        methods:{
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post("/login",this.$qs.stringify(this.ruleForm)).then((res)=>{
                            let result = res.data;
                            if(result.code=="200"){
                                this.$message.success(result.msg);
                                sessionStorage.setItem("token",result.token);
                                sessionStorage.setItem("userData",JSON.stringify(result.data));
                                this.$router.push("/index");
                            }else{
                                this.$message.error(result.msg);
                            }
                            console.log("获取结果==",result);
                        })
                    } 
                });
            },
            resetForm(formName){
                this.$refs[formName].resetFields();
            }
        }
    }
</script>
<style scoped>
    .login_containter{
        text-align: center;
        padding-top:30%;
        box-sizing: border-box;
    }
    .login_form{
        /* margin-top:30%; */
        width:100%;
        padding:0 20px;
        box-sizing: border-box;
    }
    .login_form .el-form-item{
        height:40px;
    }
</style>