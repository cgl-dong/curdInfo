<template>
  <div class="patientCount">
    <div class="title">
      <p>患者数量周统计表</p>
    </div>
    <br><br>
    <div id="main2" style="width: 100%;height:400px;"></div>

    <br><br>
    <div class="tableCount">
      <el-table :data="table1" height="327" show-summary :summary-method="getSummaries" border style="width:330px">
        <el-table-column label="星期一">
          <el-table-column prop="department"  :summary-method="getSummaries"label="科室" width="120"></el-table-column>
          <el-table-column prop="date" label="就诊日期" width="120"></el-table-column>
          <el-table-column prop="number" label="就诊人数" width="120"></el-table-column>
        </el-table-column>
      </el-table>
    </div>
    <div class="tableCount">
      <el-table :data="table2" height="327" show-summary :summary-method="getSummaries" border style="width:330px">
        <el-table-column label="星期二">
          <el-table-column prop="department" label="科室" width="120"></el-table-column>
          <el-table-column prop="date" label="就诊日期" width="120"></el-table-column>
          <el-table-column prop="number" label="就诊人数" width="120"></el-table-column>
        </el-table-column>
      </el-table>
    </div>
    <div class="tableCount">
      <el-table :data="table3" height="327" show-summary :summary-method="getSummaries" border style="width:330px">
        <el-table-column label="星期三">
          <el-table-column prop="department" label="科室" width="120"></el-table-column>
          <el-table-column prop="date" label="就诊日期" width="120"></el-table-column>
          <el-table-column prop="number" label="就诊人数" width="120"></el-table-column>
        </el-table-column>
      </el-table>
    </div>
    <div class="tableCount">
      <el-table :data="table4" height="327" show-summary :summary-method="getSummaries" border style="width:330px">
        <el-table-column label="星期四">
          <el-table-column prop="department" label="科室" width="120"></el-table-column>
          <el-table-column prop="date" label="就诊日期" width="120"></el-table-column>
          <el-table-column prop="number" label="就诊人数" width="120"></el-table-column>
        </el-table-column>
      </el-table>
    </div>
    <div class="tableCount">
      <el-table :data="table5" height="327" show-summary :summary-method="getSummaries" border style="width:330px">
        <el-table-column label="星期五">
          <el-table-column prop="department" label="科室" width="120"></el-table-column>
          <el-table-column prop="date" label="就诊日期" width="120"></el-table-column>
          <el-table-column prop="number" label="就诊人数" width="120"></el-table-column>
        </el-table-column>
      </el-table>
    </div>
    <div class="tableCount">
      <el-table :data="table6" height="327" show-summary :summary-method="getSummaries" border style="width:330px">
        <el-table-column label="星期六日">
          <el-table-column prop="department" label="科室" width="120"></el-table-column>
          <el-table-column prop="date" label="就诊日期" width="120"></el-table-column>
          <el-table-column prop="number" label="就诊人数" width="120"></el-table-column>
        </el-table-column>
      </el-table>
    </div>

   <!--  <div class="button">
      <el-button type="primary" size="big" @click="amount">查看总人数</el-button>
    </div> -->
  </div>
</template>

<script type="text/ecmascript-6">
  import patCount from '../../../global/patientCount';
  export default {
    data () {
      return {
        table1: [],
        table2: [],
        table3: [],
        table4: [],
        table5: [],
        table6: [],
        table7: [],
        personSum: []
      };
    },
    methods: {
      getSummaries (param) {
        const { columns, data } = param;
        const sums = [];
        columns.forEach((column, index) => {
          if (index === 0) {
            sums[index] = '合计';
            return;
          }
          const values = data.map(item => Number(item[column.property]));
          if (!values.every(value => isNaN(value))) {
            sums[index] = values.reduce((prev, curr) => {
              const value = Number(curr);
              if (!isNaN(value)) {
                return prev + curr;
              } else {
                return prev;
              }
            }, 0);
            this.personSum = sums[index];
            sums[index] += ' 人';
          } else {
            sums[index] = '';
          }
        });
        return sums;
      }
      // amount () {
      //   alert(this.personSum);
      // }
    },
    created () {
      this.table1 = patCount.table1;
      this.table2 = patCount.table2;
      this.table3 = patCount.table3;
      this.table4 = patCount.table4;
      this.table5 = patCount.table5;
      this.table6 = patCount.table6;
      this.table7 = patCount.table7;
    },
    mounted () {
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('main2'));

      // 指定图表的配置项和数据
      var option = {
        title: {
          text: '一月病人数量折线图'
        },
        xAxis: {
          data: ['第一周', '第二周', '第三周', '第四周',"第五周"],
          boundaryGap: false,
          axisTick: {
            show: false
          }
        },
        grid: {
          left: 10,
          right: 10,
          bottom: 20,
          top: 30,
          containLabel: true
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          },
          padding: [5, 10]
        },
        yAxis: {
          axisTick: {
            show: false
          }
        },
        legend: {
          data: ['门诊病人', '住院病人']
        },
        series: [{
          name: '门诊病人', itemStyle: {
            normal: {
              color: '#FF005A',
              lineStyle: {
                color: '#FF005A',
                width: 2
              }
            }
          },
          smooth: true,
          type: 'line',
          data: [1823, 1532, 1440, 1544, 1590],
          animationDuration: 2800,
          animationEasing: 'cubicInOut'
        },
          {
            name: '住院病人',
            smooth: true,
            type: 'line',
            itemStyle: {
              normal: {
                color: '#3888fa',
                lineStyle: {
                  color: '#3888fa',
                  width: 2
                },
                areaStyle: {
                  color: '#f3f8ff'
                }
              }
            },
            data: [379, 452, 320, 334, 390],
            animationDuration: 2800,
            animationEasing: 'quadraticOut'
          }]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    }
  };
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  .patientCount
    height:1100px
  .patientCount .title
    p
      font-size:24px
      text-align:center
      margin-bottom:20px
 .patientCount .tableCount
    float:left
    padding-bottom:20px
    padding-left:80px
</style>
