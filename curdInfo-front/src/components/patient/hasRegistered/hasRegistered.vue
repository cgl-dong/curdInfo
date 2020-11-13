<template>
  <div class="registerManage">
    <!-- 搜索条件 -->
    <div class="filter-container">
      <el-input placeholder="挂号序号" v-model="searchNumber"></el-input>
      <el-input placeholder="患者姓名" v-model="searchName"></el-input>
      <el-button type="primary" icon="search" @click="search">搜索</el-button>
      <el-button type="primary" icon="view" @click="showAll">显示全部</el-button>

      <el-button type="primary" icon="document" @click="handleDownload">导出</el-button>
    </div>
    <!-- 患者挂号信息列表 -->
    <el-table :data="patients" border style="width: 100%; text-align:left">
      <el-table-column prop="number" label="挂号序号"></el-table-column>
      <el-table-column prop="patientName" label="患者姓名"></el-table-column>
      <el-table-column prop="certificateValue" label="挂号凭证"></el-table-column>
      <el-table-column prop="cardNumber" label="凭证号"></el-table-column>
      <el-table-column prop="departmentValue" label="科室"></el-table-column>
      <el-table-column prop="doctorName" label="就诊医生"></el-table-column>
      <el-table-column prop="visitDate" label="就诊时间"></el-table-column>
      <el-table-column prop="no" label="候诊号"></el-table-column>
      <el-table-column prop="expense" label="挂号费"></el-table-column>
      <el-table-column label="操作" width="180">
        <template scope="scope">
          <el-button type="primary" class="btn" @click="checkDetail(scope.$index)">查看</el-button>
          <el-button type="danger" class="btn" @click="deleteDetail(scope.$index,patients)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 点击查看患者挂号详细信息 -->
    <el-dialog title="患者挂号信息" :visible.sync="dialogVisible" :before-close="handleClose">
      <ul class="patientsdetail">
        <li><h5>挂号序号：</h5><span>{{patientsdetails.number}}</span></li>
        <li><h5>患者姓名:</h5><span>{{patientsdetails.patientName}}</span></li>
        <li><h5>挂号凭证:</h5><span>{{patientsdetails.certificateValue}}</span></li>
        <li><h5>凭证号：</h5><span>{{patientsdetails.cardNumber}}</span></li>
        <li><h5>科室:</h5><span>{{patientsdetails.departmentValue}}</span></li>
        <li><h5>就诊医生:</h5><span>{{patientsdetails.doctorName}}</span></li>
        <li><h5>就诊时间:</h5><span>{{patientsdetails.visitDate}}</span></li>
        <li><h5>候诊号:</h5><span>{{patientsdetails.no}}</span></li>
        <li><h5>挂号费:</h5><span>{{patientsdetails.expense}}</span></li>
      </ul>
      <h5 slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </h5>
    </el-dialog>

  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data () {
      return {
        patients: [],
        intendedpatients: [],
        dialogVisible: false,
        patientsdetails: '',
        searchNumber: '',
        searchName: ''
      };
    },
    mounted () {
      this.$axios.get('his/register/list').then((response) => {
        // 测试语句，测试是否能获取response
        // console.log(registerThis.patients, response);
        // 把json接口获取的数据赋给当前对象
        this.patients = response.data;
        this.intendedpatients = response.data;
      }, response => {
        // error callback
        this.$message({
          message: '数据请求失败',
          type: 'error'
        });
      });
    },
    methods: {
      // 搜索
      search () {
        let search = this;
        if (search.searchNumber && search.searchName) {
          this.$axios.post('his/register/query?name=' + search.searchName + '&number=' + search.searchNumber).then(res => {
            this.patients = res.data;
            this.$notify({
              title: '没有数据?',
              message: '查看格式是否匹配哦！！',
              position: 'top-left',
              type: 'info'
            });
          });
        } else {
          if (search.searchNumber && search.searchName === '') {
            this.$axios.post('his/register/query/number?number=' + this.searchNumber).then(res => {
              this.patients = res.data;
              this.$notify({
                title: '没有数据?',
                message: '查看格式是否匹配哦！！',
                position: 'top-left',
                type: 'info'
              });
            });
          } else if (search.searchName && search.searchNumber === '') {
            this.$axios.post('his/register/query/name?name=' + this.searchName).then(res => {
              this.patients = res.data;
              this.$notify({
                title: '没有数据?',
                message: '查看格式是否匹配哦！！',
                position: 'top-left',
                type: 'info'
              });
            });
          }
        }
      },
      // 显示全部数据
      showAll () {
        this.patients = this.intendedpatients;
        this.searchNumber = '';
        this.searchName = '';
      },
      // 确认是否要关闭dialog
      handleClose (done) {
        this.$confirm('确认关闭？').then(_ => {
          done();
        }).catch(_ => {});
      },
      // 查看患者信息详情
      checkDetail (index) {
        this.dialogVisible = true;
        this.patientsdetails = this.patients[index];
      },
      deleteDetail (index, rows) {
        rows.splice(index, 1);
      },
      // 把数据表格导出到excel表
      handleDownload () {
        var vm = this;

        require.ensure([], () => {
          const { export_json_to_excel } = require('vendor/Export2Excel');
          const tHeader = ['挂号序号', '患者姓名', '挂号凭证', '凭证号', '科室', '就诊医生', '就诊时间', '候诊号', '挂号费'];
          const filterVal = ['number', 'name', '', '', 'disease', 'doctor', 'date', '', ''];
          const patients = vm.patients;
          const data = vm.formatJson(filterVal, patients);
          export_json_to_excel(tHeader, data, '患者挂号信息列表excel');
        });
      },
      formatJson (filterVal, jsonData) {
        return jsonData.map(v => filterVal.map(j => v[j]));
      }
    }
};
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  .registerManage .filter-container
    padding-bottom:30px
    .el-input
      width: 200px
  .registerManage .el-table-column
    font-weight: bold
  .registerManage .patientsdetail
    h5
      display: inline-block
      width: 100px
      line-height: 30px
      font-weight: bold
  .registerManage .btn
      display: inline-block
</style>
