<template>
  <div class="hasPatient">
    <div class="filter-container">
    <el-table :data="tableData" border style="width:100%;" @selection-change="handleSelectionChange">
      <el-table-column type="selection"></el-table-column>
      <el-table-column align="center" label='序号'>
        <template scope="scope">
          {{scope.$index}}
        </template>
      </el-table-column>
      <el-table-column label="名字" prop="name" align="center"></el-table-column>
      <el-table-column label="权限" prop="type" align="center"></el-table-column>
      <el-table-column label="描述" align="center">{{desc}}</el-table-column>
    </el-table>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'sys_user',
    data(){
      return{
        tableData:'',
        desc:'ooo'
      }
    },
    created () {
      this.$axios.get('/his/sys_user').then(res=>{
        this.tableData=res.data;
      }).catch(()=>{
        this.$message({
          message:"服务端出错",
          type:'error'
        })
      })
    }
  };
</script>

<style scoped>

</style>
