<template>
  <div class="drugInfosC">
    <!-- 搜索条件 -->
    <div class="filter-container">
      <el-input placeholder="药品名（支持模糊查询）" v-model="searchValue" @keyup.enter.native="nextInput"></el-input>
      <el-button id='psw' type="primary" icon="search" @click="search()">搜索</el-button>

      <el-button type="primary" icon="document" @click="handleDownload">导出</el-button>
      <el-button type="primary" icon="view" @click="showAll">显示全部</el-button>
    </div>
    <!-- 药物信息列表 -->
    <el-table :data="tableData" border style="width: 100%; text-align:left">
      <el-table-column type="index" label="序号" width="80" align="center"></el-table-column>
      <el-table-column prop="type" label="类别" width="80" align="center"></el-table-column>
      <el-table-column prop="drugname" label="药品名称" width="170" align="center"></el-table-column>
      <el-table-column prop="otc" label="OTC标志" width="80" align="center"></el-table-column>
      <el-table-column prop="specification" label="规格" width="130" align="center"></el-table-column>
      <el-table-column prop="form" label="剂型" width="100" align="center"></el-table-column>
      <el-table-column prop="expiryDate" label="有效期至" width="130" align="center"></el-table-column>
      <el-table-column prop="vender" label="厂家" width="238" align="center"></el-table-column>
      <el-table-column prop="quantity" label="库存（件/克）" width="110" align="center"></el-table-column>
      <el-table-column prop="price" label="单价（元）" width="110" align="center"></el-table-column>
      <el-table-column label="操作" align="center">
        <template scope="scope">
          <el-button type="primary" @click="checkDetail(scope.$index)">查看</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 点击查看药物详细信息 -->
    <el-dialog title="产品参数" :visible.sync="dialogVisible">
      <ul class="drugdetail">
        <li><h5>产品名称：</h5><span>{{drugdetails.productname}}</span></li>
        <li><h5>产品剂型:</h5><span>{{drugdetails.form}}</span></li>
        <li><h5>使用剂量:</h5><span>{{drugdetails.useQuantity}}</span></li>
        <li><h5>品牌:</h5><span>{{drugdetails.brand}}</span></li>
        <li><h5>套餐类型:</h5><span>{{drugdetails.plantype}}</span></li>
        <li><h5>有效期:</h5><span>{{drugdetails.expiry}}</span></li>
        <li><h5>用法:</h5><span>{{drugdetails.useEat}}</span></li>
        <li><h5>药品分类:</h5><span>{{drugdetails.otc}}</span></li>
        <li><h5>药品名称:</h5><span>{{drugdetails.drugname}}</span></li>
        <li><h5>药品通用名:</h5><span>{{drugdetails.genericname}}</span></li>
        <li><h5>批准文号:</h5><span>{{drugdetails.certificate}}</span></li>
        <li><h5>生产企业:</h5><span>{{drugdetails.vender}}</span></li>
        <li><h5>规格: </h5><span>{{drugdetails.specification}}</span></li>
        <li><h5>类别: </h5><span>{{drugdetails.type}}</span></li>
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
        tableData: [],
        assistanttableData: [],
        dialogVisible: false,
        drugdetails: '',
        searchValue: ''
      };
    },
    created () {
      let druginfosThis = this;

      druginfosThis.$axios.get('his/drug/c').then((response) => {
        // 测试语句，测试是否能获取response
        // console.log(druginfosThis.tableData, response);
        // 把json接口获取的数据赋给当前对象
        druginfosThis.tableData = response.data;
        druginfosThis.assistanttableData = response.data;
      }, response => {
        // error callback
        druginfosThis.$notify.error({
          message: '数据请求失败'
        });
      });
    },
    methods: {
      // 查看药品详情参数
      checkDetail (index) {
        // console.log(index);
        this.dialogVisible = true;
        this.drugdetails = this.tableData[index];
      },
      // 搜索
      search () {
        let intendedSearch = this;
        intendedSearch.$axios.post('his/drug/c/search?name=' + intendedSearch.searchValue).then((response) => {
          // 遍历接口里的所有信息，查找drugname为搜索框里输入的内容的数据，然后把所有找到的数据push进this.tableData里
          // 在把查找到的数据存进this.tableData里之前，需要把它置为空
          intendedSearch.tableData = [];
          for (let i = 0; i < response.data.length; i++) {
            intendedSearch.tableData.push(response.data[i]);
          };
        }, response => {
          // error callback
          intendedSearch.$notify.error({
            message: '数据请求失败'
          });
        });
      },
      // 显示全部数据
      showAll () {
        this.tableData = this.assistanttableData;
        this.searchValue = '';
      },
      nextInput () {
        document.querySelector('#psw').focus();
      },
      // 把数据表格导出到excel表
      handleDownload () {
        var vm = this;

        require.ensure([], () => {
          const { export_json_to_excel } = require('vendor/Export2Excel');
          const tHeader = ['序号', '类别', '药品名称', 'OTC标志', '规格', '剂型', '厂家', '库存（件）', '单价（元）'];
          const filterVal = ['index', 'type', 'drugname', 'OTC', 'specification', 'form', 'vender', 'quantity', 'price'];
          const tableData = vm.tableData;
          const data = vm.formatJson(filterVal, tableData);
          export_json_to_excel(tHeader, data, '药房药物信息列表excel');
        });
      },
      formatJson (filterVal, jsonData) {
        return jsonData.map(v => filterVal.map(j => v[j]));
      }
    }
};
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  .drugInfosC .filter-container
    padding-bottom:30px
    .el-input
      width: 400px
  .drugInfosC .el-table-column
    font-weight: bold
  .drugInfosC .drugdetail
    h5
      display: inline-block
      width: 100px
      line-height: 30px
      font-weight: bold
</style>
