<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>qna</title>
</head>
<body>
<br>
<div style=" text-align:center">
	 <img class="d-block mx-auto mb-4" src="/delivery/resources/images/logo_qna.png" width="500" height="150">
</div>
<div class="row" style="width: 70%; margin: auto; margin-bottom: 100px; margin-top: 100px">
	<!--자주 묻는 질문 -->
	<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3" id="oftenqna">
		<a href="/delivery/member/qna" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_01.png"></a>
	</div>
	<!-- 회원가입 질문 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
	<a href="#" onclick="alldivchange2()" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_02.png"></a>
	</div>
	<!-- 결제 질문 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3">
		<a href="#" onclick="alldivchange3()" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_03.png"></a>
	</div>
	<!-- 리뷰관리 질문 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3">
	<a href="#" onclick="alldivchange4()" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_04.png"></a>
	</div>
	<!--이용문의 질문 -->
	<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3"  style="margin-top: 20px">
		<a href="#" onclick="alldivchange5()" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_05.png"></a>
	</div>
	<!-- 불편사항 질문 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3" style="margin-top: 20px">
		<a href="#"onclick="alldivchange6()" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_06.png"></a>
	</div>
	<!--기타 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
			<a href="#" onclick="alldivchange7()" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_07.png"></a>
	</div>
	<!-- 1대1 질문 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px" >
			<a href="/delivery/member/personalQna" class="thumbnail"> <img
			src="/delivery/resources/images/QNA_08.png"></a>
	</div>
</div>
<div class="container" style=" text-align:center; margin-bottom: 100px" >
	<h1 id="maintext">자주 묻는 질문 top5</h1>
	<br>
	<br>
	<div class="accordion" id="accordionExample">
	  <div class="card">
	    <div class="card-header" id="headingOne">
	      <h2 class="mb-0">
	        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" id="btn1">
	        - 환불한 금액이 들어오지 않아요.</button>
	      </h2>
	    </div>
	
	    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
	      <div class="card-body" id="detail1">
	        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	      </div>
	    </div>
	  </div>
	  <div class="card">
	    <div class="card-header" id="headingTwo">
	      <h2 class="mb-0">
	        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" id="btn2">
	        - 주문한 음식이 배달되지 않아요
	        </button>
	      </h2>
	    </div>
	    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
	      <div class="card-body" id="detail2">
	        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	      </div>
	    </div>
	  </div>
	  <div class="card">
	    <div class="card-header" id="headingThree">
	      <h2 class="mb-0">
	        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree" id="btn3">
	          - 주문한 음식에 문제가 있어요.
	        </button>
	      </h2>
	    </div>
	    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
	      <div class="card-body" id="detail3">
	        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	      </div>
	    </div>
	  </div>
	   <div class="card">
	    <div class="card-header" id="headingFour">
	      <h2 class="mb-0">
	        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseTwo" id="btn4">
	       	-  사장님으로 회원가입을 하고싶어요
	        </button>
	      </h2>
	    </div>
	    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
	      <div class="card-body" id="detail4">
	        4번 Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	      </div>
	    </div>
	  </div>
	   <div class="card">
	    <div class="card-header" id="headingFive">
	      <h2 class="mb-0">
	        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseTwo" id="btn5">
	        - 리뷰를 수정하고싶어요."
	        </button>
	      </h2>
	    </div>
	    <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
	      <div class="card-body" id="detail5">
	        5번 Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	      </div>
	    </div>
	  </div>
	</div>
</div>	
</body>
<script type="text/javascript">
	//자주묻는 질문
function alldivchange2() {
  	 	document.getElementById("maintext").innerText = "회원가입"
		btn1.textContent="회원가입이 불가능해요."
		document.all('detail1').innerHTML="이전에 가입된 회원인 경우 가입이 불가능 하며 탈퇴후 30일 동안을 회원가입이 제한됩니다.위의 두 사항에 포합되지 않는 고객님의 경우 1대1 상담을 통해 상담사와 분제해결을 해주세요."
		btn2.textContent="누군가 제 아이디를 쓰고 있어요."
		document.all('detail2').innerHTML="배달이요!의 경우 원활한 서비스제공을 위해 아이디 중복이 불가능한 점을 양해 부탁드립니다."
		btn3.textContent="탈퇴하고싶어요."
		document.all('detail3').innerHTML="회원탈퇴 방법은 마이페이지 - 개인정보 수정 - 하단의 탈퇴하기 버튼을 클릭하시면 탈퇴절차가 진행됩니다"
		btn4.textContent="사장님으로 회원가입을 하고싶어요."
		document.all('detail4').innerHTML="사장님 회원가입의 경우 배달이요! 사장님 사이트를 사용하여 회원가입을 진행해주시면 됩니다."
		btn5.textContent="회원가입시 사용했던 개인정보를 변경하고 싶어요."
		document.all('detail5').innerHTML="개인정보 변경은 마이페이지에서 비밀번호 확인후에 변경이 가능합니다.(변경 불가능한 사항 존재)"
		
}	//바로결제
	function alldivchange3() {
	 	document.getElementById("maintext").innerText = "바로결제"
		btn1.textContent="회원가입이 불가능해요."
		document.all('detail1').innerHTML="이전에 가입된 회원인 경우 가입이 불가능 하며 탈퇴후 30일 동안을 회원가입이 제한됩니다.위의 두 사항에 포합되지 않는 고객님의 경우 1대1 상담을 통해 상담사와 분제해결을 해주세요."
		btn2.textContent="누군가 제 아이디를 쓰고 있어요."
		document.all('detail2').innerHTML="배달이요!의 경우 원활한 서비스제공을 위해 아이디 중복이 불가능한 점을 양해 부탁드립니다."
		btn3.textContent="탈퇴하고싶어요."
		document.all('detail3').innerHTML="회원탈퇴 방법은 마이페이지 - 개인정보 수정 - 하단의 탈퇴하기 버튼을 클릭하시면 탈퇴절차가 진행됩니다"
		btn4.textContent="사장님으로 회원가입을 하고싶어요."
		document.all('detail4').innerHTML="사장님 회원가입의 경우 배달이요! 사장님 사이트를 사용하여 회원가입을 진행해주시면 됩니다."
		btn5.textContent="회원가입시 사용했던 개인정보를 변경하고 싶어요."
		document.all('detail5').innerHTML="개인정보 변경은 마이페이지에서 비밀번호 확인후에 변경이 가능합니다.(변경 불가능한 사항 존재)"
	
}	

	function alldivchange4() {
  	 	document.getElementById("maintext").innerText = "리뷰관리"
		btn1.textContent="리뷰를 작성하고 싶어요."
		document.all('detail1').innerHTML="이전에 가입된 회원인 경우 가입이 불가능 하며 탈퇴후 30일 동안을 회원가입이 제한됩니다.위의 두 사항에 포합되지 않는 고객님의 경우 1대1 상담을 통해 상담사와 분제해결을 해주세요."
		btn2.textContent="리뷰가 삭제되었어요."
		document.all('detail2').innerHTML="배달이요!의 경우 원활한 서비스제공을 위해 아이디 중복이 불가능한 점을 양해 부탁드립니다."
		btn3.textContent="리뷰를 수정하고싶어요."
		document.all('detail3').innerHTML="회원탈퇴 방법은 마이페이지 - 개인정보 수정 - 하단의 탈퇴하기 버튼을 클릭하시면 탈퇴절차가 진행됩니다"
		btn4.textContent="리뷰작성으로 얻는 혜택이 있나요?."
		document.all('detail4').innerHTML="사장님 회원가입의 경우 배달이요! 사장님 사이트를 사용하여 회원가입을 진행해주시면 됩니다."
		btn5.textContent="리뷰작성을 강요하는 매장이 있어요."
		document.all('detail5').innerHTML="개인정보 변경은 마이페이지에서 비밀번호 확인후에 변경이 가능합니다.(변경 불가능한 사항 존재)"
		
}	
	//이용문의
	function alldivchange5() {
		document.getElementById("maintext").innerText = "이용문의"
			btn1.textContent="리뷰를 작성하고 싶어요."
			document.all('detail1').innerHTML="이전에 가입된 회원인 경우 가입이 불가능 하며 탈퇴후 30일 동안을 회원가입이 제한됩니다.위의 두 사항에 포합되지 않는 고객님의 경우 1대1 상담을 통해 상담사와 분제해결을 해주세요."
			btn2.textContent="리뷰가 삭제되었어요."
			document.all('detail2').innerHTML="배달이요!의 경우 원활한 서비스제공을 위해 아이디 중복이 불가능한 점을 양해 부탁드립니다."
			btn3.textContent="리뷰를 수정하고싶어요."
			document.all('detail3').innerHTML="회원탈퇴 방법은 마이페이지 - 개인정보 수정 - 하단의 탈퇴하기 버튼을 클릭하시면 탈퇴절차가 진행됩니다"
			btn4.textContent="리뷰작성으로 얻는 혜택이 있나요?."
			document.all('detail4').innerHTML="사장님 회원가입의 경우 배달이요! 사장님 사이트를 사용하여 회원가입을 진행해주시면 됩니다."
			btn5.textContent="리뷰작성을 강요하는 매장이 있어요."
			document.all('detail5').innerHTML="개인정보 변경은 마이페이지에서 비밀번호 확인후에 변경이 가능합니다.(변경 불가능한 사항 존재)"
				
	}
	//불편문의
	function alldivchange6() {
		document.getElementById("maintext").innerText = "불편문의"
			btn1.textContent="리뷰를 작성하고 싶어요."
			document.all('detail1').innerHTML="이전에 가입된 회원인 경우 가입이 불가능 하며 탈퇴후 30일 동안을 회원가입이 제한됩니다.위의 두 사항에 포합되지 않는 고객님의 경우 1대1 상담을 통해 상담사와 분제해결을 해주세요."
			btn2.textContent="리뷰가 삭제되었어요."
			document.all('detail2').innerHTML="배달이요!의 경우 원활한 서비스제공을 위해 아이디 중복이 불가능한 점을 양해 부탁드립니다."
			btn3.textContent="리뷰를 수정하고싶어요."
			document.all('detail3').innerHTML="회원탈퇴 방법은 마이페이지 - 개인정보 수정 - 하단의 탈퇴하기 버튼을 클릭하시면 탈퇴절차가 진행됩니다"
			btn4.textContent="리뷰작성으로 얻는 혜택이 있나요?."
			document.all('detail4').innerHTML="사장님 회원가입의 경우 배달이요! 사장님 사이트를 사용하여 회원가입을 진행해주시면 됩니다."
			btn5.textContent="리뷰작성을 강요하는 매장이 있어요."
			document.all('detail5').innerHTML="개인정보 변경은 마이페이지에서 비밀번호 확인후에 변경이 가능합니다.(변경 불가능한 사항 존재)"
	}
	//기타문의
	function alldivchange7() {
		document.getElementById("maintext").innerText = "기타문의"
			btn1.textContent="리뷰를 작성하고 싶어요."
			document.all('detail1').innerHTML="이전에 가입된 회원인 경우 가입이 불가능 하며 탈퇴후 30일 동안을 회원가입이 제한됩니다.위의 두 사항에 포합되지 않는 고객님의 경우 1대1 상담을 통해 상담사와 분제해결을 해주세요."
			btn2.textContent="리뷰가 삭제되었어요."
			document.all('detail2').innerHTML="배달이요!의 경우 원활한 서비스제공을 위해 아이디 중복이 불가능한 점을 양해 부탁드립니다."
			btn3.textContent="리뷰를 수정하고싶어요."
			document.all('detail3').innerHTML="회원탈퇴 방법은 마이페이지 - 개인정보 수정 - 하단의 탈퇴하기 버튼을 클릭하시면 탈퇴절차가 진행됩니다"
			btn4.textContent="리뷰작성으로 얻는 혜택이 있나요?."
			document.all('detail4').innerHTML="사장님 회원가입의 경우 배달이요! 사장님 사이트를 사용하여 회원가입을 진행해주시면 됩니다."
			btn5.textContent="리뷰작성을 강요하는 매장이 있어요."
			document.all('detail5').innerHTML="개인정보 변경은 마이페이지에서 비밀번호 확인후에 변경이 가능합니다.(변경 불가능한 사항 존재)"
	}
	
</script>
</html>