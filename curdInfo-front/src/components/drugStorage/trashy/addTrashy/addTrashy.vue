<template>
  <div class="addTrashy">
    <el-form ref="form" :model="form" label-width="80px" :rules="rules">
      <el-form-item label="药品名称" prop="name">
        <el-input v-model.trim="form.name"></el-input>
      </el-form-item>
      <el-form-item label="数量" prop="amount">
        <el-input v-model.trim.number="form.amount" type="number"></el-input>
      </el-form-item>
      <el-form-item label="确认人员" prop="handlers">
        <el-input v-model.trim="form.handlers"></el-input>
      </el-form-item>
      <el-form-item label="原因" prop="trashy">
        <el-input v-model.trim="form.trashy" type="textarea"></el-input>
      </el-form-item>
      <el-form-item label="进货厂家"  prop="manufacturers">
        <el-input v-model.trim="form.manufacturers"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">添加</el-button>
        <el-button @click="goback">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    data () {
      return {
        id: 10,
        form: {
          name: '',
          amount: '',
          handlers: '',
          trashy: '',
          manufacturers: ''
        },
        // 定义表单验证规则
        rules: {
          name: [
            { required: true, message: '请输入药品名称', trigger: 'blur' }
          ],
          handlers: [
            { required: true, message: '请输入确认人员', trigger: 'blur' }
          ],
          manufacturers: [
            { required: true, message: '请输入进货厂家', trigger: 'blur' }
          ],
          trashy: [
            { required: true, message: '请输入报销原因', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      // 提交添加信息
      onSubmit () {
        console.log(this.form);
        this.$axios.post('his/drugtrash/add', {
          id: this.id += 1,
          name: this.form.name,
          amount: this.form.amount,
          handlers: this.form.handlers,
          trashy: this.form.trashy,
          manufacturers: this.form.manufacturers
        }).then(() => {
          this.$message({
            message: '信息添加成功',
            type: 'success'
          });
          this.$router.go(-1);
        }, function () {
          this.$message.error('后台出现错误！');
        });
      },
      // 返回
      goback () {
        history.go(-1);
      }
    }
  };
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  .addTrashy
    max-width:850px
</style>
