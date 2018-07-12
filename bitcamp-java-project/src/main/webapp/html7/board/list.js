// 템플릿 엔진이 사용할 데이터 가져오기
var trTemplateSrc = $("#tr-template").html();

// 위에서 준비한 템플릿 데이터를 가지고 HTML을 생성할 템플릿 엔진 준비
var templateFn = Handlebars.compile(trTemplateSrc);

$.getJSON(serverRoot + "/json/board/list", (data) => {
	// data배열을 list라는 이름으로 넘겨주고, 핸들바스에서 each로 반복적인 값을 처리한다.(=for문)
	$(tableBody).html(templateFn({list:data}));
});