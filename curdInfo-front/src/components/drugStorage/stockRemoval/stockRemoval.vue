<template>
  <div class="stockRemoval">
    <el-table :data="drug">
      <el-table-column prop="name" label="药品名称"></el-table-column>
      <el-table-column prop="amount" label="数量"></el-table-column>
      <el-table-column prop="handlers" label="配送人员"></el-table-column>
      <el-table-column prop="timeApplication" label="申请时间"></el-table-column>
      <el-table-column prop="outOfTime" label="配送时间"></el-table-column>
      <el-table-column prop="manufacturers" label="厂家"></el-table-column>
      <el-table-column label="操作">
        <template prop="outOfTime" scope="scope">
          <el-button v-if="!drug[scope.$index].outOfTime" size="small" @click="handleChange(scope.$index, scope.row)" type="danger">配送</el-button>
          <el-button class="handleOut" v-else="drug[scope.$index].outOfTime" size="small">已配送</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data () {
      return {
        drug: []
      };
    },
    created () {
      // 获取所有配送信息
      this.$axios.get('his/drugpop/list').then((response) => {             // mark
        this.drug = response.data;
        console.log(response.data[0]);
      }, response => {
      // error callback
        this.$message({
          message: '数据请求失败',
          type: 'error'
        });
      });
    },
    methods: {
      // 点击标记已经配送
      handleChange (index, row) {
        // 获取当前时间，并且转换时间格式
        let time = new Date();
        this.drug[index].outOfTime = time.getFullYear() + '-' + time.getMonth() + '-' + time.getDay() + ' ' + time.getHours() + ':' + time.getMinutes() + ':' + time.getSeconds();
        console.log(index, this.drug, this.drug[index].id, this.drug[index].outOfTime);
        this.$message({
          message: '信息添加成功',
          type: 'success'
        });
      }
    }
  };
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
.stockRemoval
  .handleOut
    cursor:no-drop
    &:hover,&:focus
      color:#1f2d3d
      border-color:#c4c4c4
</style>
