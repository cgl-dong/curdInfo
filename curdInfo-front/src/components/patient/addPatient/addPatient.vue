<template>
  <div class="addPatient">
    <el-form :model="ruleForm" class="demo-ruleForm" ref="ruleForm" :rules="rules" label-width="100px" >
      <h1 class="record">
        新建患者档案:
        <span class="demonstration">建档日期</span>
        <el-date-picker v-model="ruleForm.date" type="date" placeholder="选择日期" :picker-options="pickerOptions" prop="date"></el-date-picker>
      </h1>
      <br><br>
      <div>
        <el-form-item label="患者姓名" prop="name">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="ruleForm.idcard"></el-input>
        </el-form-item>
      </div>
      <div>
        <el-form-item label="患者年龄" prop="age">
          <el-input v-model.number="ruleForm.age"></el-input>
        </el-form-item>
        <el-form-item label="联系方式" prop="phone">
          <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="患者性别" prop="sex">
          <el-radio-group v-model="ruleForm.sex">
            <el-radio :label="1" label-width="150px">男</el-radio>
            <el-radio :label="2" label-width="150px">女</el-radio>
          </el-radio-group>
        </el-form-item>
      </div>
      <div>
        <el-form-item label="家庭地址">
          <el-input v-model="ruleForm.position"></el-input>
        </el-form-item>
      </div>
      <div>
        <el-form-item label="目前身体状况" prop="symptoms">
          <el-input type="textarea" v-model="ruleForm.symptoms"></el-input>
        </el-form-item>
      </div>
      <br>
      <h3>联系人资料</h3><br>
      <div>
        <el-form-item label="联系人姓名" prop="Name">
          <el-input v-model="ruleForm.Name"></el-input>
        </el-form-item>
        <el-form-item label="联系方式" prop="Phone">
          <el-input v-model.number="ruleForm.Phone"></el-input>
        </el-form-item>
        <el-form-item label="与患者关系" prop="relation">
          <el-select v-model="ruleForm.relation" placeholder="与患者关系">
            <el-option label="父子" value="1"></el-option>
            <el-option label="父女" value="2"></el-option>
            <el-option label="母子" value="3"></el-option>
            <el-option label="母女" value="4"></el-option>
            <el-option label="兄弟" value="5"></el-option>
            <el-option label="姐妹" value="6"></el-option>
            <el-option label="亲戚" value="7"></el-option>
            <el-option label="朋友" value="8"></el-option>
            <el-option label="监护人" value="9"></el-option>
            <el-option label="其他" value="10"></el-option>
          </el-select>
        </el-form-item>
      </div>
      <div>
        <h3>是否有病史？如果有，请简单说明</h3><br>
        <el-form-item label="病史简单说明" prop="illHistory">
          <el-input type="textarea" v-model="ruleForm.illHistory"></el-input>
        </el-form-item>
      </div>
      <div>
        <h3>医生信息</h3>
        <el-form-item label="主治医生姓名" prop="doctor">
          <el-input v-model="ruleForm.doctor"></el-input>
        </el-form-item>
        <el-form-item label="科室" prop="department">
          <el-select v-model="ruleForm.department" placeholder="选择科室">
            <el-option label="外科" value="1"></el-option>
            <el-option label="内科" value="2"></el-option>
            <el-option label="妇产科" value="3"></el-option>
            <el-option label="骨科" value="4"></el-option>
            <el-option label="儿科学" value="5"></el-option>
            <el-option label="其他" value="6"></el-option>
          </el-select>
        </el-form-item>
      </div>
      <div>
        <el-form-item class="center">
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button @click="offReset('ruleForm')">重置</el-button>
        </el-form-item>
      </div>
    </el-form>
  </div>
</template>
<script type="text/ecmascript-6">
export default {
  data () {
    let checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('年龄不能为空'));
      };
      setTimeout(() => {
        if (/^\d+$/.test(value) === false) {
          callback(new Error('请输入数字值'));
        } else {
          callback();
        }
      }, 300);
    };
    var checkName = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('姓名不能为空'));
      } else {
        callback();
      }
    };
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('电话不能为空'));
      };
      setTimeout(() => {
        if (/^\d+$/.test(value) === false) {
          callback(new Error('请输入数字值'));
        } else if (value.length > 11) {
          callback(new Error('请输入正确号码'));
        } else {
          callback();
        }
      }, 500);
    };
    var checkidCard = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('身份证号不能为空'));
      };
      setTimeout(() => {
        if (/^(\w){6,20}$/.test(value) === false) {
          callback(new Error('请输入正确身份证号码'));
        } else {
          callback();
        }
      }, 500);
    };
    return {
      ruleForm: {
        date: '',
        name: '',
        region: '',
        idCard: '',
        sex: 2,
        age: '',
        phone: '',
        Name: '',
        Phone: '',
        relation: '',
        address: '',
        provinces: [],
        citys: [],
        moreAddress: '',
        symptoms: '',
        doctor: '',
        department: ''
      },
      selectProvince1: '',
      selectCity1: '',
      pickerOptions: {
        disabledDate (time) {
          return time.getTime() < Date.now - 8.64e7;
        }
      },
      rules: {
        name: [
          { required: true, validator: checkName, trigger: 'blur' }
        ],
        age: [
          { required: true, validator: checkAge, trigger: 'blur' }
        ],
        phone: [
          { required: true, validator: checkPhone, trigger: 'blur' }
        ],
        region: [
          { required: true, trigger: 'blur' }
        ],
        idCard: [
          { required: true, validator: checkidCard, trigger: 'blur' }
        ],
        sex: [
          { required: true, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    onSubmit () {
      // let me = this;
      // this.$http.post('../../static/patient/addPatient.json').then(function (response) {
      //   console.log('这是我们需要的json数据', response.ruleForm);
      //   me.ruleForm = me.data.ruleForm;
      // }, function (response) {
      //   alert('请求失败了');
      // });
      console.log('您修改后的参数为：', JSON.stringify(this.ruleForm));
    },
    offReset (form) {
      this.$refs[form].resetFields();
      this.ruleForm.date = '';
      this.ruleForm.moreAddress = '';
      this.selectProvince1 = '';
      this.selectCity1 = '';
    }
  },
  created () {
    this.$message({
      message: '此处留钩子，暂不开放',
      type: 'error'
    });
    this.$notify({
      title: '钩子',
      message: '此处留钩子，暂不开放！',
      position: 'top-right',
      type: 'info',
      duration: 0
    });
  }
};
</script>
<!-- <script src="https://unpkg.com/vue"></script> -->
<style type="text/css">
  .addPatient .el-input, .addPatient .el-input__inner {
    display: inline-block;
    width: 192px;
  }
  .addPatient .el-form-item{
    padding-right: 30px;
  }
  .addPatient .el-form{
    padding-bottom: 20px;
  }
  .addPatient .el-textarea__inner{
    width: 500px;
  }
  .addPatient .center{
    padding-left: 200px;
  }
  .addPatient .demonstration{
    color: #333;
    font-size: 24px;
  }
  .addPatient .record{
    font-size: 28px;
  }
  .addPatient .el-form-item{
    display: inline-block;
  }
</style>
