<template>
  <div>

        <div>
          <textarea id="messageArea" cols="180" rows="25" style="float:right" readonly></textarea>
          <br>
          <label for="messageArea"><h3>聊天信息:</h3></label>
          <br><br>
          <el-button type="success" id="joinRoomBtn">进入聊天室</el-button>
          <br><br>
          <el-button type="info" id="leaveRoomBtn">离开聊天室</el-button>
        </div>


        <div>

        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <label for="sendMessage">输入消息:</label><textarea id="sendMessage"  cols="180" rows="5" style="float:right" ></textarea>
        <br>
        <br>
        <el-button type="primary" id="sendBtn">发送消息</el-button>

    </div>
</template>

<script>
  import $ from 'jquery'
  export default{
data(){
  return{

  }
},
    watch:{
      userList:function () {
        console.log("okok")
      }
    },
  mounted () {
      console.log("his "+this.$store.state.user.easeHis);
      var _this=this;
      $(function(){
        var username=_this.$store.state.user.easeHis;
        var webSocket;
        var url = 'ws://localhost:8099/his/chat/';

        var flag=0;
        //进入聊天室
        $('#joinRoomBtn').click(function(){
          if(flag!==0){
            return;
          }
          flag=1;
          webSocket = new WebSocket(url+username);
          webSocket.onopen = function (event){
            console.log('webSocket连接创建。。。'+JSON.stringify(event));
          };
          webSocket.onclose = function(){
            flag=0;
            $('#messageArea').append('['+username +']离开了聊天室\n');
          };
          webSocket.onmessage = function(event){
            $('#messageArea').append(event.data + '\n');
          };
          webSocket.onerror = function (event) {
            console.log('webSocket连接异常。。。');
          }
        });
        //退出聊天室
        $('#leaveRoomBtn').click(function(){
          if(webSocket){
            //关闭连接
            webSocket.close();
          }
        });
        //发送消息
        $('#sendBtn').click(function(){
          if(flag===0){
            _this.$message({
              type:"error",
              message:"还没进入聊天室！"
            });
            return;
          }
          var msg = $('#sendMessage').val();
          webSocket.send(msg);
          $('#sendMessage').val('');
        });
      });
    }
  }
</script>
