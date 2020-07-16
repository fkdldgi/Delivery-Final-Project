<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<style>
/*
아이디
비밀번호
이름
이메일
전화번호
건물관리번호
상세주소
성별
생년월일

로그인 되면 메인화면으로 넘어가고 로그인 버튼이 회원이름이 되어야함"000님", 회원가입 버튼이 로그아웃버튼이 되어야하고

*/
        /* .help-block 을 일단 보이지 않게 설정 */
        #myForm .help-block{
            display: none;
        }
        /* glyphicon 을 일단 보이지 않게 설정 */
        #myForm .glyphicon{
            display: none;
        }
    </style>

<div class="container" style="border: 2px solid orange; margin-top: 100px;margin-bottom: 100px">
    <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/delivery/resources/images/join_logo.jpg" alt="" width="500" height="200">
    </div>		
	<br>
    <h3>회원가입</h3>
    <br>
    <hr style="border: solid 1px orange;">
    <form action="/delivery/member/joinOk.do" method="post" id="myForm">
        <div class="form-group has-feedback">
            <label class="control-label" for="id">아이디</label>
            <input class="form-control" type="text" name="id" id="id"/>
            <span id="overlapErr" class="help-block">사용할 수 없는 아이디 입니다.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="pwd">비밀번호</label>
            <input class="form-control" type="password" name="pwd" id="pwd"/>
            <span id="pwdRegErr" class="help-block">4글자 이상 입력하세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="rePwd">비밀번호 재확인</label>
            <input class="form-control" type="password" id="rePwd"/>
            <span id="rePwdErr" class="help-block">비밀번호와 일치하지 않습니다. 다시 입력해 주세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
            <div class="form-group has-feedback">
            <label class="control-label" for="name">이름*</label>
            <input class="form-control" type="text" name="name" id="name"/>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="email">이메일</label>
            <input class="form-control" type="text" name="email" id="email"/>
            <span id="emailErr" class="help-block">올바른 이메일 형식이 아닙니다. 다시 입력해 주세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <label class="control-label" for="tel">전화번호</label>
            <input class="form-control" type="text" name="tel" id="tel"/>
            <span id="telErr" class="help-block">올바른 전화번호 형식이 아닙니다. 다시 입력해 주세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div id="findaddr">
	   		 <span>주소를 입력해주세요.</span>
		     <button class="btn btn-outline-success" onclick="sample5_execDaumPostcode()" type="button">주소 검색</button>
		     <input class="form-control mr-sm-2" type="text" placeholder="주소를 입력해주세요" id="building_nanagement_number" readonly="readonly">
		     <input class="form-control mr-sm-2" type="text" placeholder="상세주소를 입력해주세요" id="address_detail">
    	</div>
        
         <div class="mb-3">
                    <label for="gender">성별</label><br> 
                  	<input type="radio" name="gender" value="성별무관" checked="checked" /> 성별무관 &nbsp
					<input type="radio" name="gender" value="여자"/> 여자 &nbsp
					<input type="radio" name="gender" value="남자"/> 남자 &nbsp
		 </div>
		 
		 <div class="form-group has-feedback">
            <label class="control-label" for="birth">생년월일</label>
            <input class="form-control" type="text" name="birth" id="birth" placeholder="ex)1997년 4월 16일 = 19970416"/>
            <span id="birthErr" class="help-block">올바른 생년월일 형식이 아닙니다. 다시 입력해 주세요.</span>
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        
        <br>
        <input class="btn btn-success" type="submit" value="가입" >
        <br>
    </form>
    <hr style="border: solid 1px orange;">
   		<br>
            <img class="d-block mx-auto mb-4" src="/delivery/resources/images/join_footer.png" alt="" width="1100" height="180">
</div>
<script src="/js/jquery-3.2.1.js"></script>
<script>
    //아이디 입력란에 keyup 이벤트가 일어 났을때 실행할 함수 등록 
    $("#id").keyup(function(){
        //입력한 문자열을 읽어온다.
        var id=$(this).val();
        //ajax 요청을 해서 서버에 전송한다.
        $.ajax({
            url:"${pageContext.request.contextPath}/member/idCheck",
            data:{id:id},
            success:function(data){
                if(data==1){//사용 가능한 아이디 라면 
                    $("#overlapErr").hide();
                    // 성공한 상태로 바꾸는 함수 호출
                    successState("#id");
                    
                }else{//사용 가능한 아이디가 아니라면 
                    $("#overlapErr").show();
                    errorState("#id");
                }
            }
        });
    });
    $("#pwd").keyup(function(){
        var pwd=$(this).val();
        // 비밀번호 검증할 정규 표현식
        var reg=/^.{4,}$/;
        if(reg.test(pwd)){//정규표현식을 통과 한다면
                    $("#pwdRegErr").hide();
                    successState("#pwd");
        }else{//정규표현식을 통과하지 못하면
                    $("#pwdRegErr").show();
                    errorState("#pwd");
        }
    });
    $("#rePwd").keyup(function(){
        var rePwd=$(this).val();
        var pwd=$("#pwd").val();
        // 비밀번호 같은지 확인
        if(rePwd==pwd){//비밀번호 같다면
            $("#rePwdErr").hide();
            successState("#rePwd");
        }else{//비밀번호 다르다면
            $("#rePwdErr").show();
            errorState("#rePwd");
        }
    });
    $("#email").keyup(function(){
        var email=$(this).val();
        // 이메일 검증할 정규 표현식
        var reg=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(reg.test(email)){//정규표현식을 통과 한다면
                    $("#emailErr").hide();
                    successState("#email");
        }else{//정규표현식을 통과하지 못하면
                    $("#emailErr").show();
                    errorState("#email");
        }
    });
    $("#tel").keyup(function(){
        var tel=$(this).val();
        // 전화번호 검증할 정규 표현식
        var reg=/^\d{3}-\d{3,4}-\d{4}$/;
        if(reg.test(tel)){//정규표현식을 통과 한다면
                    $("#telErr").hide();
                    successState("#tel");
        }else{//정규표현식을 통과하지 못하면
                    $("#telErr").show();
                    errorState("#tel");
        }
    });
    $("#birth").keyup(function(){
        var birth=$(this).val();
        //생년월일 검증할 정규 표현식
        var reg=/^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/
        if(reg.test(birth)){//정규표현식을 통과 한다면
                    $("#birthErr").hide();
                    successState("#birth");
        }else{//정규표현식을 통과하지 못하면
                    $("#birthErr").show();
                    errorState("#birth");
        }
    });
    // 성공 상태로 바꾸는 함수
    function successState(sel){
        $(sel)
        .parent()
        .removeClass("has-error")
        .addClass("has-success")
        .find(".glyphicon")
        .removeClass("glyphicon-remove")
        .addClass("glyphicon-ok")
        .show();
 
        $("#myForm button[type=submit]")
                    .removeAttr("disabled");
    };
    // 에러 상태로 바꾸는 함수
    function errorState(sel){
        $(sel)
        .parent()
        .removeClass("has-success")
        .addClass("has-error")
        .find(".glyphicon")
        .removeClass("glyphicon-ok")
        .addClass("glyphicon-remove")
        .show();
 
        $("#myForm button[type=submit]")
                    .attr("disabled","disabled");
    }; 
    
    if(sessionStorage.getItem('addr')!=null){
    	document.getElementById("sample5_address").value = sessionStorage.getItem('addr');
    }
    
    </script>
    
      
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
		            document.getElementById("building_nanagement_number").value = sessionStorage.getItem('addr');
		            console.log('session : ' + sessionStorage.getItem('addr'));
		            console.log('roadAddress : ' + data.roadAddress + ", jibunAddress : " + data.jibunAddress);
		        }
		    }).open();
		}
		</script>     
</script> 
