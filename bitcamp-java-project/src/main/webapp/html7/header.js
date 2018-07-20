//div#header 태그에 /html/header.html 내용을 삽입한다.
$.get(serverRoot + "/html7/header.html", (data) => {
   $("#header").html(data);
   loadLoginUser();
});

function loadLoginUser() {   
   // 로그인 정보를 가져와서 span#username 태그에 사용자 아이디를 삽입한다.
   $.getJSON(serverRoot +"/json/auth/loginUser", (data) => {
      if (data == "")
         location.href = serverRoot + "/html7/auth/login.html";
      else {
         $("#username").text(data.id);
         $("#logoutBtn").click((e) => {
            e.preventDefault(); // 클릭했을 때 원래 하던 일이 있는데 그것을 하지 말라!
            $.get(serverRoot + "/json/auth/logout", () => {
               location.href = serverRoot + "/html7/auth/login.html";
            });
         });
      }
   }). fail(() => {
       location.href = serverRoot + "/html7/auth/login.html";
   });
}