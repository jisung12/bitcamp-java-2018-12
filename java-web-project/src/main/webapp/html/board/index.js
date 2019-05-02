var pageNo = 1,
    pageSize = 3,
    header = document.querySelector('body > header');
    tbody = document.querySelector('tbody'),
    prevPageLi = document.querySelector('#prevPage'),
    nextPageLi = document.querySelector('#nextPage');
    currSpan = document.querySelector('#currPage > span');
    

//헤더 가져오기
(function () {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    header.innerHTML = xhr.responseText
    
   // var e = new Event("loaded.header")
   // document.body.dispatchEvent(e);
  };
  xhr.open('GET', '../header.html', true)
  xhr.send()
})();

/*
document.body.addEventListener('loaded.header', () => {
  loadList(1);
});
*/


// JSON 형식의 데이터 목록 가져오기
function loadList(pn) {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    
    
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    // 서버에서 받은 JSON 형식의 데이터를 ==> JavaScript 객체로 변환
    var obj = JSON.parse(xhr.responseText);
    
    pageNo = obj.pageNo;
    
    tbody.innerHTML = '';
    // TR 태그를 생성
    for (data of obj.list) {
      var tr = '<tr>'
        + '<th scope="row">' + data.no + '</th>'
        //+ '<td><a href="view.html?no=' + data.no + '">' + data.contents + '</a></td>'
        + '<td><a class="bit-view-link" href="#" data-no="' + data.no + '">' + data.contents + '</a></td>'
        + '<td>' + data.createdDate + '</td>'
        + '<td>' + data.viewCount + '</td>'
        + '</tr>';
      tbody.innerHTML = tbody.innerHTML + tr;
    }
    
    document.querySelector('#currPage > span').innerHTML = String(pageNo)
    
    if (pageNo == 1) {
    prevPageLi.className = prevPageLi.className + 'disabled';
    } else {
    prevPageLi.className = prevPageLi.className.replace('disabled', '');
    }
    
    if (pageNo == obj.totalPage){
      nextPageLi.className = nextPageLi.className + ' disabled';
     } else {
       nextPageLi.className = nextPageLi.className.replace('disabled', '');
     }
    
    
    document.body.dispatchEvent(new Event('loaded-list'));
    
    };
  xhr.open('GET', '../../app/json/board/list?pageNo=' + pn + '&pageSize=' + pageSize, true)
  xhr.send()
}

document.querySelector('#prevPage > a').onclick = (e) => {
  e.preventDefault();
  loadList(pageNo - 1);
};

document.querySelector('#nextPage > a').onclick = (e) => {
  e.preventDefault();
  loadList(pageNo + 1);
};
loadList(1);


document.body.addEventListener('loaded-list', () => {
// 제목을 클릭했을 때 view.html로 전환시키기
  var alist = document.querySelectorAll('.bit-view-link');
  for (a of alist) {
    a.onclick = (e) => {
      e.preventDefault();
      window.location.href = 'view.html?no=' + 
        e.target.getAttribute('data-no');
    };
  }
});









