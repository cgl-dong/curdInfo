<template>
    <header class="header">
      <el-dropdown>
        <el-button>
          <div class="wapper">
            <span>{{easeHis}}</span>
            <img id="userPic"src="../../global/user.jpg" alt="user" height="40">
            <i class="el-icon-caret-bottom"></i>
          </div>
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item><router-link to="addPersonalDate" tag="h3">个人信息</router-link></el-dropdown-item>
          <el-dropdown-item><router-link to="absenceRequest" tag="h3">申请休假</router-link></el-dropdown-item>
          <el-dropdown-item><router-link to="departure" tag="h3">申请离职</router-link></el-dropdown-item>
          <el-dropdown-item><router-link to="hasComplaints" tag="h3">投诉信息</router-link></el-dropdown-item>
          <el-dropdown-item><h3 @click="pass">修改密码</h3></el-dropdown-item>
          <el-dropdown-item><el-button type="info" @click="dia_show">登出</el-button></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </header>
</template>

<script type="text/ecmascript-6">
  import {mapGetters, mapActions} from 'vuex';
  // 引入vuex中各个模块的actions
  export default {
    data () {
      return {
        isShow: false,
        dialogVisible: false
      };
    },
    // 获取vuex数据
    computed: mapGetters([
      'easeHis'
    ]),
    created: function () {
      // 路由拦截
      if (!sessionStorage.getItem('easeHis')) {
        this.$router.push({path: 'login'});
      }
    },
    methods: {
      // 本组件注册VUEX输出的actions中的setSignOut方法
      ...mapActions({setUserInfo: 'setSignOut'}),
      // 退出登录
      userLog () {
        this.setUserInfo(this.form);
        this.$router.push('login');
      },
      // 个人主页下拉菜单切换
      personalShow () {
        this.isShow = !this.isShow;
      },
      dia_show () {
        let _this = this;
        this.$alert('确定登出？\n 登出后个人记录将不会保存！', '提示', {
          confirmButtonText: '确定',
          callback: () => {
            _this.userLog();
            this.$message({
              message: '登出成功！',
              type: 'success'
            });
          }
        });
      },
      pass () {
        this.$notify({
          title: '钩子',
          message: '暂未开通',
          duration: 0,
          position: 'top-left',
          type: 'info'
        });
      }
    }
  };
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  .header
    height:50px
    background-color: #eef1f6
    line-height:  50px
    text-align: right
    padding: 0 20px
    color: #48576a
    font-size:12px
    .el-dropdown-menu__item.personalDropdown
      overflow:hidden
      height:20px
      .isShow
        height:60px
    .el-button
      border-color:transparent
      padding:0
      background: #eef1f6
      .wapper
        display:block
        cursor: pointer
        #userPic
          border-radius:50%
          vertical-align: middle
   .el-dropdown-menu
     a .el-dropdown-menu__item
      padding: 5px 20px
      color:#1f2d3d
      &::hover
       color: #48576a
    .el-dropdown-menu__item:not(.is-disabled):hover
      background-color:#fff
    .el-dropdown-menu__item
       a:hover,.el-icon--right:hover
        color:#20a0ff
      .el-icon--right
        font-size:12px
</style>
