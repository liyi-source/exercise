<template>
    <div>
        <el-form :inline="true" class="demo-form-inline" label-width="60px">
            <!-- <el-form-item label="名称">
                <el-input></el-input>
            </el-form-item>
            <el-form-item label="活动区域">
                <el-input></el-input>
            </el-form-item>
            <el-form-item label="活动形式">
                <el-input></el-input>
            </el-form-item> -->
            <el-form-item label="密码">
                <el-input type="password"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password"></el-input>
            </el-form-item>
            属性方式：
            <el-input
                placeholder="请选择日期"
                suffix-icon="el-icon-date">
            </el-input>
        </el-form>
    </div>
</template>