<template>
    <div class="home" v-if="home.title">
       <h3 class="tips">前台部分组件来自Github开源项目</h3><div class="homeHead">
        <h2>简易His</h2>
        <h3>Hospital information system</h3>
      </div>
      <div>
        <strong>公告</strong>  <el-button @click="info_show" type="info">{{infoButton}}</el-button>
        <div v-show="i_show">
          <p>一套简易的his内部后台管理系统，前后分离，前台负责展示，后台只负责数据处理与返回，使用Ajax进行json格式的交互。</p>
          <p>增改查功能基本实现与后台交互，删除功能为前端假操作，刷新后会恢复。</p>
          <p>关于部署：1、前台页面打包后部署到Nginx中，由Nginx处理转发到后台。
            2、前台打包部署到后台下，和后台使用一个服务器</p>
        </div>
      </div>
      <strong>信息可视化</strong> <el-button @click="chart_Show" type="info">{{echartButton}}</el-button>
      <br>
      <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
      <div id="main" style="width: 600px;height:400px; float: right"></div>

      <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
      <div id="main1" style="width: 600px;height:400px;"></div>

      <div v-show="e_show">
        <br>
        <br>
        <div id="main2" style="width: 1300px;height:400px"></div>
        <br>
        <br>
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main3" style="width: 1300px;height:400px;"></div>
        <br>
        <br>

        <div id="main4" style="width: 600px;height:400px;"></div>
      </div>
      <br>

      <br>
      <strong>医院系统部分功能块介绍</strong> <el-button @click="sys_show" type="info">{{sysButton}}</el-button>
      <div class="nurse">
        <h4>一、护士系统</h4>
        <ul v-show="s_show">
          <li v-for="item in home.introduce.nurse" :key='item'>
            {{item}}
          </li>
        </ul>
      </div>

      <div class="doctor">
        <h4>二、医生系统</h4>
        <ul v-show="s_show">
          <li v-for="item in home.introduce.doctor" :key='item'>
            {{item}}
          </li>
        </ul>
      </div>

      <h4>三、前台收银系统</h4>
      <ul v-show="s_show">
        <li v-for="item in home.introduce.cashier" :key='item'>
          {{item}}
        </li>
      </ul>

      <h4>四、药房系统</h4>
      <ul v-show="s_show">
        <h5>中药房、西药房</h5>
        <li v-for="item in home.introduce.pharmacy" :key='item'>
          {{item}}
        </li>
      </ul>

      <h4>五、药库系统</h4>
      <ul v-show="s_show">
        <li v-for="item in home.introduce.drugStorage" :key='item'>
          {{item}}
        </li>
      </ul>
      <h4>六、患者模块</h4>
      <ul v-show="s_show">
        <li v-for="item in home.introduce.patient" :key='item'>
          {{item}}
        </li>
      </ul>

      <h4>七、医院基本信息</h4>
      <ul v-show="s_show">
        <li v-for="item in home.introduce.hospital" :key='item'>
          {{item}}
        </li>
      </ul>



      <h4>八、登录模块</h4>
      <ul v-show="s_show">
        <li v-for="item in home.introduce.register" :key='item'>
          {{item}}
        </li>
      </ul>


      <h4>九、个人主页</h4>
      <ul v-show="s_show">
        <li v-for="item in home.introduce.personalHomepage" :key='item'>
          {{item}}
        </li>
      </ul>

      <br>
      <strong>项目技术信息</strong> <el-button @click="show" type="info">{{techButton}}</el-button>
      <table v-if="!table_show">
        <tr>
          <th>后台开发</th>
          <th>前台开发</th>
          <th>开发工具</th>
        </tr>
        <tr>
          <td>Java、SpringBoot、Mysql、Mybatis-plus等</td>
          <td>Vue(全家桶)、elementUI、Axios等</td>
          <td>IDEA、VSCode、FireFox、PostMan、Swagger等</td>
        </tr>
      </table> 
      <br>
      <table v-if="table_show">
        <tr>
          <th v-for="item in Tech">{{item}}</th>
        </tr>
        <tr>
          <td v-for="item in Version">{{item}}</td>
        </tr>
        <tr>
          <td v-for="item in use">{{item}}</td>
        </tr>
      </table> 
    <br>


    </div>
</template>

<script type="text/ecmascript-6">
  import about from '../../global/home';
  import tech from '../../global/tech';
  import  'echarts/theme/macarons.js'
  import  'echarts/theme/roma.js'
  import  'echarts/theme/royal.js'
  export default {
    data () {
      return {
        home: [],
        table_show: false,
        e_show: false,
        s_show:false,
        i_show:true,
        Tech: [],
        Version: [],
        use: [],
        techButton: '技术详情',
        echartButton: '全部图表',
        sysButton:'功能详情',
        infoButton:'关闭',
        echartDoctor: ''
      };
    },
    methods: {
      info_show () {
        this.i_show === false ? this.i_show = true : this.i_show = false;
        this.infoButton = (this.infoButton === '关闭' ? '展示' : '关闭');
      },
      sys_show () {
        this.s_show === false ? this.s_show = true : this.s_show = false;
        this.sysButton = (this.sysButton === '功能详情' ? '功能概览' : '功能详情');
      },
      show () {
        this.table_show === false ? this.table_show = true : this.table_show = false;
        this.techButton = (this.techButton === '技术详情' ? '技术概览' : '技术详情');
      },
      chart_Show(){
        this.e_show === false ? this.e_show = true : this.e_show = false;
        this.echartButton = (this.echartButton === '全部图表' ? '图表概览' : '全部图表');
      },
      hisCount(){
        this.$axios.get('/his/echarts/count').then(res=>{
          var myChart = this.$echarts.init(document.getElementById('main4'),"royal");

          // 指定图表的配置项和数据
          var option = {
            title: {
              text: '医院内部人员图表'
            },
            tooltip: {
              trigger: 'item',
              formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            legend: {
              left: 'center',
              bottom: '10',
              data: ['医生', '护士', '保安保洁', '行政', '实习生、规培生']
            },
            series: [
              {
                name: '医院内部人员图表',
                type: 'pie',
                roseType: 'radius',
                radius: [15, 95],
                center: ['50%', '38%'],
                data: [
                  { value: res.data[0].doctorCount, name: '医生' },
                  { value: res.data[0].nurseCount, name: '护士' },
                  { value: 19, name: '保安保洁' },
                  { value: 18, name: '行政' },
                  { value: 29, name: '实习生、规培生' }
                ],
                animationEasing: 'cubicInOut',
                animationDuration: 2600
              }
            ]
          };

          // 使用刚指定的配置项和数据显示图表。
          myChart.setOption(option);
        })
      },
      doctor2(){
        this.$axios.get('/his/echarts/doctor2').then(res=>{
          // 基于准备好的dom，初始化echarts实例
          var myChart2 = this.$echarts.init(document.getElementById('main1'), "dark");

          // 指定图表的配置项和数据
          var option = {
            title: {
              text: '科室医生图'
            },
            tooltip: {},
            legend: {
              data: ['数量']
            },
            xAxis: {
              axisLabel: {
                interval: 0,
                rotate: 40
              },
             // data: ["五官科", "儿科", "内科", "口腔科", "外科", "妇产科", "妇科", "男科", "精神科", "胸心外科", "骨科"]
              data: res.data[0]
            },
            yAxis: {},
            series: [{
              name: '数量',
              type: 'bar',
              // data: [1, 1, 5, 3, 8, 1, 2, 2, 1, 1, 1]
              data: res.data[1]
            }]
          };
          // 使用刚指定的配置项和数据显示图表。
          myChart2.setOption(option);
        })
      }
    },
    created () {
      this.home = about.home;
      this.Tech = tech.Tech;
      this.Version = tech.Version;
      this.use = tech.use;
      // 基于准备好的dom，初始化echarts实例
      this.$axios.get('/his/echarts/doctor').then(res => {
        this.echartDoctor=res.data;
        console.log(this.echartDoctor);
        let myChart = this.$echarts.init(document.getElementById('main'), 'macarons');
        console.log('ok? ' + this.echartDoctor.data);
        myChart.setOption({
          series: [
            {
              //"data": [{ "name": "五官科", "value": 1 }, { "name": "儿科", "value": 1 }, { "name": "内科", "value": 5 }, { "name": "口腔科", "value": 3 }, { "name": "外科", "value": 8 }, { "name": "妇产科", "value": 1 }, { "name": "妇科", "value": 2 }, { "name": "男科", "value": 2 }, { "name": "精神科", "value": 1 }, { "name": "胸心外科", "value": 1 }, { "name": "骨科", "value": 1 }],
              "data": JSON.parse(this.echartDoctor.data),
              "type": "pie",
              emphasis: {
                itemStyle: {
                  // 高亮时点的颜色
                  color: 'red'
                },

              },
              label: {
                 show: true, // 显示数值
                // textStyle: { // 文字样式
                //   color: '#333333',
                //   fontWeight: 'bold'
                // },
                formatter: '{b}:{c}: ({d}%)'
              }
            }
          ]
        });
      });
      this.doctor2();
      this.hisCount();

    },
    mounted () {

      var myChart3 = this.$echarts.init(document.getElementById('main2'));
      var option3 ={
        title: {
          text: '一周病人数量折线图'
        },
        xAxis: {
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
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
          data: [1823, 1532, 1440, 1544, 1590, 1303, 1220],
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
            data: [379, 452, 320, 334, 390, 430, 520],
            animationDuration: 2800,
            animationEasing: 'quadraticOut'
          }]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart3.setOption(option3);

      var myChart4 = this.$echarts.init(document.getElementById('main3'),"roma");
      var option4={
        title: {
          text: '一周病人缴费分类统计图'
        },
        legend: {
          data: ['自费', '医保']
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        grid: {
          top: 10,
          left: '2%',
          right: '2%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
          axisTick: {
            alignWithLabel: true
          }
        }],
        yAxis: [{
          type: 'value',
          axisTick: {
            show: false
          }
        }],
        series: [{
          name: '自费',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: [823, 532, 240, 344, 390, 1303, 1220]
        },{
          name: '医保',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: [179, 152, 200, 334, 390, 430, 320]
        }]
      }

      // 使用刚指定的配置项和数据显示图表。
      myChart4.setOption(option4);
    }
  };
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  td{
    text-align:center;
    vertical-align: middle;
  }
  .home
    padding:0 20px 0 30px
  .home h2
      font-size: 30px
      text-align: center
      line-height: 90px
      font-weight: 800
  .home .tips
    color: #f00
    text-align: left
    text-indent: 2em
    margin-bottom: 20px
  .home h3
      padding-right:20px
      text-align: right
      font-size: 14px
  .home h4
      font-size: 18px
      line-height:50px
  .home h5
      padding-bottom:20px
  .home p
      color:#475669
      text-indent: 2em
      line-height: 20px
      font-size:16px
      padding: 17px 0
  .home strong
      font-weight: 500
      font-size: 24px
      line-height:80px
  .home b
      font-weight: 500
      font-size: 24px
      line-height:80px
  .homeHead
      width:100%
      height:120px
      background-color:rgba(50,65,85,0.3)
.home table
  width:100%
.home table th
  width:auto
  padding-top:5px
  padding-bottom:5px
  border:1px solid rgba(50,65,85,0.2)
  font-size:18px
  font-weight:600
.home table td
  border:1px solid rgba(50,65,85,0.2)
  padding: 20px 30px 20px 30px
.home li
  line-height:20px
  padding:0 0 20px 10px
.nurse
  width:100%
  height:auto

</style>
