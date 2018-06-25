// 자바스크립트 함수를 모아 놓은 라이브러리
var bitcamp = new Object();

bitcamp.ajax = (url, settings) => {
	// AJAX 실행 정보를 초기화시킨다.
	if (settings == undefined || settings == null) {
		settings = {};
	}
	
	if (settings.method == undefined) settings.method = "GET";
		// 메소드가 없다면 기본값으로 GET 을 세팅한다.
	
	if (settings.dataType == undefined) settings.dataType= "text";
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
	    if (xhr.readyState == 4) {
	        if (xhr.status == 200) {
	        	if (settings.success == undefined)
	        		return;
	        	
	        	// 서버에서 받은 데이터를 호출자가 원하는대로 변환해서 준다.
	        	// success()를 호출할 때 파라미터로 넘겨준다.
	        	if (settings.dataType == "text")
	        		settings.success(xhr.responseText);
	        	else if (settings.dataType == "json")
	        		settings.success(JSON.parse(xhr.responseText));
	        } else {
	        	if (settings.error)
	        		settings.error();
	        }
	    }
	};
	xhr.open(settings.method, url, true);
	if (settings.method == "POST") {
		// 콘텐츠 타입 설정 후 데이터를 주는데 줄 데이터가 없으면 빈문자열을 준다.
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        var qs = "";
        if (settings.data) { // settings 라는 폴더에 data 폴더가 있는가? 
        	for (var key in settings.data) { 
        		// 있다면 데이터들을 하나씩 꺼내서 기존의  한 줄로 표현해서 넘겨주자!
        		if (qs.length > 0) qs += "&";
        		qs += key + "=" + encodeURIComponent(settings.data[key]);
        		// 한글은 encoding 해서 보내자!
        		// 한글이 아닌 값을 encoding하면 바뀌는거 없이 그대로 들어가서 영향받지 않음
        	}
        }
        xhr.send(qs); // 최종적으로 send 로 넘겨준다.
	} else { // GET
		xhr.send();
	}
};

// 껍데기를 하나 더 만들어서 사용하기 편하게 한다.
bitcamp.getJSON = (url, p1, p2) => {
	// 호출 예:
	if (p1 == undefined || typeof p1 != "function") {
		// => getJSON("board/list");
		// => getJSON("board/list", {pageNo:1, pageSize:5});
		// => getJSON("board/list", {pageNo:1, pageSize:5}, function(data) {...});
		bitcamp.ajax(url, {
			"data": p1,
			"dataType" : "json",
			"success": p2
		});
	} else if (typeof p1 == "function") {
		// => getJSON("board/list", function() {});
		bitcamp.ajax(url, {
			"dataType" : "json",
			"success": p1
		});
	}
};

// 자바에서는 안되지만 자바스크립트 세계에서는 $가 그냥 변수이름으로 사용될 수 있다.
var $ = bitcamp;















