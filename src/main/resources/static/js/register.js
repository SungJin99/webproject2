function fn_idCheck(obj) {
    if(obj.username.value === "") {
        alert("아이디를 입력하세요.");
        return false
    }
    const form = {
        username: obj.username.value
    }
    $.ajax({
        url : "/register/check_id",
        type : "POST",
        dataType: 'json',
        data : form,
        success : function(data){
            if(data) {
                obj.idChk.setAttribute("value", "true")
                obj.inputUsername.readOnly = true;
                obj.idChk.disabled = true;
                alert("사용가능한 아이디입니다.");
            } else {
                alert("중복된 아이디입니다.");
            }
        }
    })
}

function isValidate(obj) {
    if(obj.idChk.getAttribute("value") === "N") {
        alert("아이디 중복 확인을 수행하세요.")
        return false;
    }

    if(obj.password.value !== obj.password_re.value) {
        obj.password.focus()
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
        return false;
    }

    return true;
}

// 영문, 숫자 외에는 입력되지 않도록 설정
function usernameCheck(obj) {
    obj.value = obj.value.replace(/[^0-9a-z]/, '');
}

// 한글 외에는 입력되지 않도록 설정
function nameCheck(obj) {
    obj.value = obj.value.replace(/[^가-힣]/, '');
}