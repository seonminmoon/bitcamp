$("#loginBtn").click(() => {
   var data = {
      id: $("#fId").val(),
      password: $("#fPassword").val()
   };
   if($(document.body).is("#fSaveId:checked")) { // 부모노드 중(body)에서 fSaved:checked라는 조건에 해당되는 태그가 있냐? 라고 물은 것. 한 개라도 있으면 true, 없으면 false.
      //data.saveId = "true";
      document.cookie += "userid=" + $("#fId").val() + ";"; 
   }
   $.post(serverRoot + "/json/auth/login", data, (result) => {
      if (result.state == "success")
         location.href = "../board/list.html";
      else 
         window.alert("로그인 실패!");
   }, "json");
});

