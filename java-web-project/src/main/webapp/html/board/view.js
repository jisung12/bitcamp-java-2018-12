var header = document.querySelector('body > header');

//헤더 가져오기
(function () {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    header.innerHTML = xhr.responseText
    
    // body 태그 쪽에 헤더 로딩 완료 이벤트를 보낸다.
    var e = new Event("loaded.header");
    document.body.dispatchEvent(e);
  };
  xhr.open('GET', '../header.html', true)
  xhr.send()
})();

var param = location.href.split('?')[1];
if (param) {
  document.querySelector('h1').innerHTML = "게시물 조회"
  loadData(param.split('=')[1])
  for (e of el) {
    e.style.display = 'none';
  }
} else {
  document.querySelector('h1').innerHTML = "새 글"
  var el = document.querySelectorAll('.bit-view-item');
  for (e of el) {
    e.style.display = 'none';
  }
}

document.querySelector('#add-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    
    if (data.status == 'success') {
      location.href = "index.html";
    } else {
      alert('등록 실패입니다!')
    }
  };
  xhr.open('POST', '../../app/json/board/add', true)
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
  var contents = document.querySelector('#contents').value;
  
  xhr.send("contents=" + encodeURIComponent(contents));
}

function loadData(no) {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    console.log(data);
    document.querySelector('#no').value = data.no;
    document.querySelector('#contents').value = data.contents;
    document.querySelector('#createdDate').value = data.createdDate;
    document.querySelector('#viewCount').value = data.viewCount;
  };
  xhr.open('GET', '../../app/json/board/detail?no=' + no, true)
  
  
  xhr.send()
}





