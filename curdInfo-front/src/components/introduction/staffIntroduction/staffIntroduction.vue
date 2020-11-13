<template>
  <div class="staffIntroduction">
    <el-tabs v-model="activeName2" type="card" @tab-click="handleClick">
      <el-tab-pane label="医师介绍" name="first">
        <span class="title">门诊查询</span>
        <div class="input">
          <el-input size="max" type="text" placeholder="科室查询" v-model="input" style="width:150px"></el-input>
          <el-input size="max" type="text" placeholder="医师查询" v-model="inputname" style="width:150px"></el-input>
          <el-button size="max" type="primary" @click="Onsubmit(1)">查询</el-button>
          <el-button size="max" type="primary" @click="All(1)">显示全部</el-button>
        </div>
        <div class="table">
           <el-table ref="multipleTable" :data="table" border tooltip-effect="dark"  style="width: 100%">
              <el-table-column type="expand">
                <template scope="props">
                  <el-form label-position="left" inline class="demo-table-expand">
                    <el-form-item label="详细信息:">
                      <span>{{ props.row.message }}</span>
                    </el-form-item>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column label="序号" width="50" >
                <template scope="scope">{{ scope.$index }}</template>
              </el-table-column>
              <el-table-column prop="name" label="医师姓名"  width="120" ></el-table-column>
              <el-table-column prop="sex" label="性别" show-overflow-tooltip width="70"></el-table-column>
              <el-table-column prop="age" label="年龄" sortable show-overflow-tooltip width="100"></el-table-column>
              <el-table-column prop="position" label="职称" show-overflow-tooltip width="150"></el-table-column>
              <el-table-column prop="department" label="科室" show-overflow-tooltip></el-table-column>
               <el-table-column prop="area" label="地点" show-overflow-tooltip></el-table-column>
              <el-table-column prop="special" label="特长" show-overflow-tooltip></el-table-column>
              <el-table-column align="center" label="电话预约">
                <template scope="scope">
                  <img src="../logo/phone.icon.jpg" width="20" height="20">
                  <el-button size="small" @click="handleOrder(scope.$index)">电话预约</el-button>
                </template>
              </el-table-column>
           </el-table>
        </div>
      </el-tab-pane>
      <el-tab-pane label="护士介绍" name="second">
        <span class="title"><em>门诊查询</em></span>
        <div class="input">
          <el-input type="text" placeholder="科室查询" v-model="input" style="width:150px"></el-input>
          <el-input  type="text" placeholder="护士查询" v-model="inputname" style="width:150px"></el-input>
          <el-button  type="primary" @click="Onsubmit(2)">查询</el-button>
          <el-button size="max" type="primary" @click="All(2)">显示全部</el-button>
        </div>
         <div class="table2">
           <el-table ref="multipleTable" :data="table2" border tooltip-effect="dark"  style="width: 100%">
              <el-table-column type="expand">
                <template scope="props">
                  <el-form label-position="left" inline class="demo-table-expand">
                    <el-form-item label="详细信息:">
                      <span>{{ props.row.message }}</span>
                    </el-form-item>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column label="序号" width="50" >
                <template scope="scope">{{ scope.$index }}</template>
              </el-table-column>
              <el-table-column prop="name" label="护士姓名"  width="120" ></el-table-column>
              <el-table-column prop="sex" label="性别" show-overflow-tooltip width="70"></el-table-column>
              <el-table-column prop="age" label="年龄" sortable show-overflow-tooltip width="100"></el-table-column>
              <el-table-column prop="position" label="职称" show-overflow-tooltip width="150"></el-table-column>
              <el-table-column prop="department" label="科室" show-overflow-tooltip></el-table-column>
               <el-table-column prop="area" label="地点" show-overflow-tooltip></el-table-column>
              <el-table-column prop="special" label="特长" show-overflow-tooltip></el-table-column>
              <el-table-column align="center" label="电话预约">
                <template scope="scope">
                  <img src="../logo/phone.icon.jpg" width="20" height="20">
                  <el-button size="small" @click="handleOrder(scope.$index)">电话预约</el-button>
                </template>
              </el-table-column>
           </el-table>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script type="text/ecmascript-6">
  import intro from '../../../global/DoctorAndNurseIntroduction';
  export default {
    data () {
      return {
        activeName2: 'first',
        input: '',
        inputname: '',
        table: [],
        table2: [],
        table_b1: [],
        table_b2: []
      };
    },
    methods: {
      All (no) {
        if (no === 1) {
          this.table = this.table_b1;
        } else {
          this.table2 = this.table_b2;
        }
      },
      handleClick (tab, event) {
        console.log(tab, event);
      },
      Onsubmit (no) {
        let search = this;
        if (no === 1) {
          search.table = [];
          // 遍历后台数据是否有和传入的参数相同的，有的话就找出来push进prescriptionC[]
          for (let i = 0; i < intro.table.length; i++) {
            // 两个条件都有输入值的时候，判断是否有同时符合这两个条件的数据
            if (search.inputname && search.input) {
              if (intro.table[i].department === search.input && intro.table[i].name === search.inputname) {
                search.table.push(intro.table[i]);
              }
            } else {
              if (search.input && intro.table[i].department === search.input) {
                // 只有第一个输入值的时候
                search.table.push(intro.table[i]);
              } else if (search.inputname && intro.table[i].name === search.inputname) {
                // 只有第二个输入值的时候
                search.table.push(intro.table[i]);
              }
            }
          }
        } else {
          search.table2 = [];
          // 遍历后台数据是否有和传入的参数相同的，有的话就找出来push进prescriptionC[]
          for (let i = 0; i < intro.table2.length; i++) {
            // 两个条件都有输入值的时候，判断是否有同时符合这两个条件的数据
            if (search.inputname && search.input) {
              if (intro.table2[i].department === search.input && intro.table2[i].name === search.inputname) {
                search.table2.push(intro.table2[i]);
              }
            } else {
              if (search.input && intro.table2[i].department === search.input) {
                // 只有第一个输入值的时候
                search.table2.push(intro.table2[i]);
              } else if (search.inputname && intro.table2[i].name === search.inputname) {
                // 只有第二个输入值的时候
                search.table2.push(intro.table2[i]);
              }
            }
          }
        }
      },
      handleOrder () {
        this.$message({
          message: '正在预约...',
          type: 'success'
        });
      }
    },
    created () {
      this.table = intro.table;
      this.table2 = intro.table2;
      this.table_b1 = intro.table;
      this.table_b2 = intro.table2;
      this.$message({
        message: '此处数据过大，没有和后台进行交互，单独放到配置文件中进行读取',
        type: 'info'
      });
    }
  };
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  .staffIntroduction .title
    float:left
  .staffIntroduction .input
    margin-left:100px
  .staffIntroduction .table
    margin-top:50px
  .staffIntroduction .table2
    margin-top:50px
</style>
