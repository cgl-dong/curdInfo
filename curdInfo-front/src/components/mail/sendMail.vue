<template>
  <div class="edit_container" >
    <!--  新增时输入 -->
    <quill-editor
      v-model="content"
      ref="myQuillEditor"
      :options="editorOption"
      @blur="onEditorBlur($event)" @focus="onEditorFocus($event)"
      @change="onEditorChange($event)" style="height: 500px">
    </quill-editor>
    <!-- 从数据库读取展示 -->
    <div v-html="str" class="ql-editor">
      {{str}}
    </div>
  </div>
</template>
<script>
  import { quillEditor } from "vue-quill-editor"; //调用编辑器
  import 'quill/dist/quill.core.css';
  import 'quill/dist/quill.snow.css';
  import 'quill/dist/quill.bubble.css';
  export default {
    components: {
      quillEditor
    },
    data() {
      return {
        content: `<p></p><p><br></p><ol><li><strong><em>Or drag/paste an image here.</em></strong></li><li><strong><em>rerew</em></strong></li><li><strong><em>rtrete</em></strong></li><li><strong><em>tytrytr</em></strong></li><li><strong><em>uytu</em></strong></li></ol>`,
        str: '',
        editorOption: {}
      }
    },
    methods: {
      onEditorReady(editor) { // 准备编辑器

      },
      onEditorBlur(){}, // 失去焦点事件
      onEditorFocus(){}, // 获得焦点事件
      onEditorChange(){}, // 内容改变事件
      // 转码
      escapeStringHTML(str) {
        str = str.replace(/&lt;/g,'<');
        str = str.replace(/&gt;/g,'>');
        return str;
      }
    },
    computed: {
      editor() {
        return this.$refs.myQuillEditor.quill;
      },
    },
    mounted() {
      let content = '';  // 请求后台返回的内容字符串
      this.str = this.escapeStringHTML(content);
    }
  }
</script>

<!--<template>-->
<!--  <div>-->
<!--    <el-card class="warp-card" dis-hover>-->
<!--      <el-form :label-width="80" :model="form" :rules="ruleInline">-->
<!--        <el-form-item class="marginBottom20" label="收件" prop="toEmails">-->
<!--          <el-input class="addressWidth" placeholder="请输入对方邮箱" v-model="form.toEmails"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item class="marginBottom20" label="标题" prop="title">-->
<!--          <el-input class="addressWidth" placeholder="请输入标题" v-model="form.title"></el-input>-->
<!--        </el-form-item>-->
<!--        <br>-->
<!--        <el-form-item label="内容" required>-->

<!--        </el-form-item>-->
<!--        <div id="editor"></div>-->
<!--        <el-form-item>-->
<!--          <br>-->
<!--          <el-button-->
<!--            :loading="isShowSaveButtonLoading"-->
<!--            @click="addOrUpdateEmail"-->
<!--            type="primary"-->
<!--            v-privilege="'email-send'"-->
<!--          >保存</el-button>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--    </el-card>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--  import WangEditor from 'wangeditor';-->
<!--  export default {-->
<!--    name: 'SendMail',-->
<!--    components: {},-->
<!--    props: {},-->
<!--    data() {-->
<!--      return {-->
<!--        // loading-->
<!--        isShowSaveButtonLoading: false,-->
<!--        // 上传-->
<!--        upload: {-->
<!--          uploadList: [],-->
<!--          data: {-->
<!--            type: 'NEWS_PIC'-->
<!--          }-->
<!--        },-->
<!--        // 富文本编辑器对象-->
<!--        editor: null,-->
<!--        // 传输内容-->
<!--        form: {-->
<!--          // 收件人-->
<!--          toEmails: '',-->
<!--          title: '',-->
<!--          content: ''-->
<!--        },-->
<!--        // 验证规则-->
<!--        ruleInline: {-->
<!--          toEmails: [-->
<!--            { required: true, message: '请输入邮箱' },-->
<!--            { type: 'email', message: '请输入正确邮箱格式', trigger: 'blur' }-->
<!--          ],-->
<!--          title: [{ required: true, message: '请输入标题', trigger: 'blur' }]-->
<!--        }-->
<!--      };-->
<!--    },-->
<!--    mounted() {-->
<!--      this.initEditor();-->
<!--    },-->
<!--    methods: {-->
<!--      // 富文本初始化-->
<!--      initEditor() {-->
<!--        let g = this;-->
<!--        g.editor = new WangEditor('#editor');-->
<!--        g.editor.customConfig = {-->
<!--          zIndex:1,-->
<!--          // 功能键-->
<!--          menus: [-->
<!--            'head', // 标题-->
<!--            'bold', // 粗体-->
<!--            'fontSize', // 字号-->
<!--            'fontName', // 字体-->
<!--            'italic', // 斜体-->
<!--            'underline', // 下划线-->
<!--            'strikeThrough', // 删除线-->
<!--            'foreColor', // 文字颜色-->
<!--            'backColor', // 背景颜色-->
<!--            'list', // 列表-->
<!--            'justify', // 对齐方式-->
<!--            'emoticon', // 表情-->
<!--            'image', // 插入图片-->
<!--            'table', // 表格-->
<!--            'undo', // 撤销-->
<!--            'redo' // 重复-->
<!--          ],-->
<!--          showLinkImg: false,-->
<!--          uploadImgShowBase64: false,-->
<!--          // 上传路径-->
<!--          uploadImgServer: '',-->
<!--          // 上传文件名key-->
<!--          uploadFileName: 'file',-->
<!--          // 参数-->
<!--          uploadImgParams: {-->
<!--            'x-access-token': ''-->
<!--          },-->
<!--          uploadImgHooks: {-->
<!--            customInsert: function(insertImg, result, editor) {-->
<!--             // insertImg(result.data.url);-->
<!--            }-->
<!--          }-->
<!--        };-->
<!--        g.editor.create();-->
<!--      }-->

<!--    }-->

<!--  };-->
<!--</script>-->
<!--<style scoped>-->
<!--  .addressWidth {-->
<!--    width: 350px;-->
<!--  }-->
<!--  .marginTop20 {-->
<!--    margin-top: 20px;-->
<!--  }-->
<!--  .marginBottom20 {-->
<!--    margin-bottom: 20px;-->
<!--  }-->
<!--</style>-->
