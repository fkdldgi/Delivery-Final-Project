<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.form-control {
	width: 500px;
	height: 35px;
}
#find{
display:flex
}
#mainlogo{
	margin-left:550px;
	width: 100px;
	height: 100px;
}
#login{
  position: absolute;
  left: 1400px;

}
</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3d85ff3401d499d8c4830a9da98833bd&libraries=services"></script>		
<script>
		
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    function sample5_execDaumPostcode() {
        new daum.Postcode({ 
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수
                sessionStorage.setItem('addr', addr); //세션에 선택한 주소값 넣기 -> 페이지가 바뀌어도 값이 유지되도록 하기 위해
                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = sessionStorage.getItem('addr');
                console.log('session : ' + sessionStorage.getItem('addr'));
                console.log('roadAddress : ' + data.roadAddress + ", jibunAddress : " + data.jibunAddress);
            }
        }).open();
    }
</script>
<div id="login">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" >로그인</button>
<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/member/join'" >회원가입</button>
</div>
<div id="mainlogo">
	<a href="/delivery/member/main"><img
			src="/delivery/resources/images/logo_main.png" ></a>
</div>
    <!-- 상단바1 -->
 <nav class="navbar navbar-dark bg-dark">
     <div id="find">
   		 <a class="navbar-brand" href="#" id="headername">어디로 배달해드릴까요?</a>
	     <input class="form-control mr-sm-2" type="text" placeholder="주소를 입력해주세요" id="sample5_address" readonly="readonly">
	     <button class="btn btn-outline-success" onclick="sample5_execDaumPostcode()" type="button">검색</button>
     </div>
 </nav>
    <!-- 상단바2 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          	카테고리
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">한식</a>
          <a class="dropdown-item" href="#">중식</a>
          <a class="dropdown-item" href="#">양식</a>
          <a class="dropdown-item" href="#">어쩌구</a>
          <a class="dropdown-item" href="#">저쩌구</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">혹시쓸수도있자나</a>
        </div>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/delivery/member/main">메인으로<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/member/notice">공지사항</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/member/event_main">이벤트</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">마이페이지</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">고객센터</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">맛나푸드</a>
      </li>
    </ul>
 
  </div>
</nav>
		<form class="form-inline" method="post">
			<div class="modal fade in" id="myModal" tabindex="-1" aria-labelledby="mySmallModalLabel">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">로그인</h4>
							<button type="button" class="close" data-dismiss="modal" aria-label="close">
								<span aria-hidden="true">x</span>
							</button>
						</div>
						<!-- 로그인 내용 입력(모달) -->
						<div class="modal-body">
							<div class="row">
								<label for="inputId" class="col-xs-6 col-md-4">아이디</label>
								<input type="text" name="login_id" id="inputId" class="form-control" placeholder="아이디" required autofocus>
							</div>
							<div class="row">
								<label for="inputPwd" class="col-xs-6 col-md-4">비밀번호</label>
								<input type="text" name="login_pwd" id="inputPwd" class="form-control" placeholder="비밀번호" required>
							</div>
						</div>
						<!-- 모달 footer -->
						<div class="modal-fotter">
			                <button type="button" id="join_user" class="btn btn-link float-right" onclick="return check_form()">로그인</button>
						</div>
					</div>
				</div>
			</div>
		</form>

<script>
console.log('세션값 보기 : ' + sessionStorage.getItem('addr'));
if(sessionStorage.getItem('addr')!=null){
	document.getElementById("sample5_address").value = sessionStorage.getItem('addr');
}
$(document).ready(function(){
   $('#logo').click(function(){
	   location.href="/delivery/member/main";
   });
});
function check_form(){
	var id=$('#inputId').val();
	var pwd=$('#inputPwd').val();
	$.ajax({
		url: "${pageContext.request.contextPath}/member/login",
		data: {id:id,pwd:pwd},
		dataType: "text",
		success:function(data){
			console.log(data);
			if(data==1){
				location.reload(); //로그인 성공 후 헤더 새로고침
			}else{
				alert("아이디 또는 비밀번호를 확인해주세요");
			}
		}
	});
}
function logout(){
	$.ajax({
		url:"${pageContext.request.contextPath}/member/logout",
		success:function(data){
			location.reload();
		}
	});
}
</script>