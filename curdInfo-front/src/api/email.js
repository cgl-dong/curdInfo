
export const emailApi = {
  // 新增邮件
  addEmail: (data) => {
    return this.$axios.post('/email/add', data);
  },
  // 分页查询邮件
  getEmail: (data) => {
    return this.$axios.post('/email/page/query', data);
  },
  // 删除邮件
  deleteEmail: (id) => {
    return this.$axios.get('/email/delete/' + id);
  },
  // 查看邮件详情
  getEmailDetails: (id) => {
    return this.$axios.get('/email/detail/' + id);
  },
  // 发送邮件
  sendEmail: (id) => {
    return this.$axios.get('/email/send/' + id);
  },
  // 更新编辑邮件
  updateEmail: (data) => {
    return this.$axios.post('/email/update', data);
  }
};
