<template>
  <div class="putInStorage">
    <el-form ref="form" :model="form" label-width="80px"  :rules="rules">
      <el-form-item label="药品名称" prop="name">
        <el-input v-model.trim="form.name"></el-input>
      </el-form-item>
      <el-form-item label="数目" prop="amount">
        <el-input v-model.trim.number="form.amount" type="number"></el-input>
      </el-form-item>
      <el-form-item label="进药时间">
        <el-form-item prop="date">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.date2">
          </el-date-picker>
        </el-form-item>
      </el-form-item>
      <el-form-item label="厂家" prop="manufacturers">
        <el-input v-model.trim="form.manufacturers" ></el-input>
      </el-form-item>
      <el-form-item label="种类" prop="species">
        <el-input v-model.trim="form.species"></el-input>
      </el-form-item>
      <el-form-item label="生产日期">
        <el-date-picker readOnly="true" type="date" placeholder="选择日期" v-model="form.productionData" style="width: 100%;"></el-date-picker>
      </el-form-item>
      <el-form-item label="规格"  prop="specification">
        <el-input v-model.trim="form.specification"></el-input>
      </el-form-item>
      <el-form-item label="剂型"  prop="dosageForm">
        <el-input v-model.trim="form.dosageForm"></el-input>
      </el-form-item>
      <el-form-item label="单价"  prop="unitPrice">
        <el-input v-model.trim.number="form.unitPrice" type="number"></el-input>
      </el-form-item>
      <el-form-item label="总价">
        {{form.totalPrices}}
      </el-form-item>
      <el-form-item label="储存温度"  prop="temperature">
        <el-select v-model.trim="form.temperature" placeholder="请选择储存温度">
          <el-option label="常温" value="常温"></el-option>
          <el-option label="冷藏" value="冷藏"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="经手人"  prop="handlers">
        <el-input v-model.trim="form.handlers"></el-input>
      </el-form-item>
      <el-form-item label="质管员"  prop="qualityOfficer">
        <el-input v-model.trim="form.qualityOfficer"></el-input>
      </el-form-item>
      <el-form-item label="仓库员"  prop="warehouseman">
        <el-input v-model.trim="form.warehouseman"></el-input>
      </el-form-item>
      <el-form-item label="进药方式"  prop="pattern">
        <el-select v-model.trim="form.pattern" placeholder="请选择进药方式">
          <el-option label="网上订货" value="网上订货"></el-option>
          <el-option label="到厂家进货" value="到厂家进货"></el-option>
          <el-option label="研究所、大学研究室、国外公司等进货" value="研究所、大学研究室、国外公司等进货"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('form')">进药</el-button>
        <el-button @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data () {
      return {
        id: 100,
        form: {
          name: '',
          manufacturers: '',
          amount: '',
          unitPrice: '',
          totalPrices: 0,
          temperature: '',
          handlers: '',
          qualityOfficer: '',
          warehouseman: '',
          pattern: '',
          date2: '',
          species: '',
          productionData: '',
          specification: '',
          dosageForm: ''
        },
        // 表单验证
        rules: {
          name: [
            { required: true, message: '请输入药品名称', trigger: 'blur' }
          ],
          manufacturers: [
            { required: true, message: '请输入厂家', trigger: 'blur' }
          ],
          species: [
            { required: true, message: '请输入药品种类', trigger: 'blur' }
          ],
          specification: [
            { required: true, message: '请输入药品规格', trigger: 'blur' }
          ],
          dosageForm: [
            { required: true, message: '请输入药品剂型', trigger: 'blur' }
          ],
          handlers: [
            { required: true, message: '请输入药品经手人', trigger: 'blur' }
          ],
          qualityOfficer: [
            { required: true, message: '请输入药品质管员', trigger: 'blur' }
          ],
          warehouseman: [
            { required: true, message: '请输入药品仓库员', trigger: 'blur' }
          ],
          pattern: [
            { required: true, message: '请输入药品进药方式', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      // 提交进药数据vue-resource
      submitForm () { // mark
        this.$axios.post('his/storage/add', {
          id: this.id += 1,
          name: this.form.name,
          manufacturers: this.form.manufacturers,
          amount: this.form.amount,
          unitPrice: this.form.unitPrice,
          temperature: this.form.temperature,
          handlers: this.form.handlers,
          qualityOfficer: this.form.qualityOfficer,
          warehouseman: this.form.warehouseman,
          pattern: this.form.pattern,
          date2: this.timeFormat(this.form.date2),
          species: this.form.species,
          productionData: this.timeFormat(this.form.productionData),
          specification: this.form.specification,
          dosageForm: this.form.dosageForm
        })
          .then(res => {
            this.$message({
              message: res.data,
              type: 'success'
            });
          });
      },
      // 重置输入表单
      resetForm () {
        this.form = [];
      },
      timeFormat (time) {
        let oldDate = time;
        let year = new Date(oldDate).getFullYear();
        let month = new Date(oldDate).getMonth() + 1;
        let day = new Date(oldDate).getDate();
        let dateFormat = year + '-' + month + '-' + day;
        return dateFormat;
      }
    },
    computed: {
      Amount () {
        return this.form.amount;
      },
      UnitPrice () {
        return this.form.unitPrice;
      }
    },
    watch: {
      // 单价或者数量变化--计算总价
      Amount (newValue, oldValue) {
        this.form.totalPrices = this.form.amount * this.form.unitPrice;
      },
      UnitPrice (newValue, oldValue) {
        this.form.totalPrices = this.form.amount * this.form.unitPrice;
      }
    }
  };
</script>

<style lang="stylus-loader" rel="stylesheet/stylus">
  .putInStorage
    max-width:800px
</style>
