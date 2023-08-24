$(document).ready(function (){
    // 고정 확장자 목록 가져오기
    getFixedExtList();
    // 커스텀 확장자 목록 가져오기
    getCustomExtCount();
    getCustomExtList();

    // 고정 확장자를 check or uncheck 할 경우 db에 저장된다.
    $("input[name=fixed_item]").change(function(){
        // updateFixedExt();
    });

    // 커스텀 확장자를 입력한 후 추가 버튼을 누르면 db에 저장된다.
    $(".custom_input_btn").on('click', function (){
        saveCustomExt();
    });

})
function getCustomExtCount(){
    $.ajax({
        url: "/api/custom/ext-count",
        type:"GET",
        contentType : false,
        processData : false,
        dataType:"json",
        success:function(obj) {
            setCustomExtCount(obj);
        },
        error:function(XMLHttpRequest) {
            alert(XMLHttpRequest.responseText);
        }
    });
}

function setCustomExtCount(obj){
    let table = $(".custom_count");
    let html = obj+"/200";
    table.append(html);
}

function getFixedExtList(){
    $.ajax({
        url: "/api/fixed/ext",
        type:"GET",
        contentType : false,
        processData : false,
        success:function(obj) {
            setFixedExtList(obj);
        },
        error:function(XMLHttpRequest) {
            alert(XMLHttpRequest.responseText);
        }
    });
}

function setFixedExtList(obj){
    console.log(obj);
    let table = $(".fixed_exts");
    let html = [];

    for(let i = 0; i < obj.length; i++){
        let useYn = obj[i].useYn === 'Y' ? "checked" : "";
        html[i] = '<label th:for='+obj[i].id+'>';
        // html[i] += '<input type=checkbox th:id="'+obj[i].id+'" th:name=fixed_item th:value="'+obj[i].id+'" th:checked="'+useYn+'" onclick=updateFixedExt("'+obj[i].id+'")>'
        html[i] += '<input type=checkbox th:id="'+obj[i].id+'" th:name=fixed_item th:value="'+obj[i].id+'" onclick=updateFixedExt('+obj[i].id+') '+useYn+'>'
        html[i] += '<span th:text="'+obj[i].ext+'">'+obj[i].ext+'</span>';
        html[i] += '</label>';
    }
    table.html(html);

}

function getCustomExtList(){
    $.ajax({
        url: "/api/custom/ext",
        type:"GET",
        contentType : false,
        processData : false,
        dataType:"json",
        success:function(obj) {
            setCustomExtList(obj);
        },
        error:function(XMLHttpRequest) {
            alert(XMLHttpRequest.responseText);
        }
    });
}
function setCustomExtList(obj){
    console.log(obj);
    let table = $(".custom_ext_table");
    let html = [];
    for(let i = 0; i < obj.length; i++){
        html[i] = '<span>'+obj[i].ext+'  <img src="/images/x-logo.png" style="width: 15px" height="15px" id=id_'+obj[i].id+' onclick="deleteCustomExt('+obj[i].id+')">';
    }
    table.html(html);
}
function updateFixedExt(id){
    $.ajax({
        url: "/api/fixed/ext/"+id,
        type:"PUT",
        contentType : false,
        processData : false,
        success:function() {
            location.reload();
        },
        error:function(XMLHttpRequest) {
            alert(XMLHttpRequest.responseText);
        }
    });
}
function saveCustomExt(){
    let str = $("#custom_input_box").val();
    let body = {
        "ext" : str
    };

    if(!isValidation()) {
        return false;
    }

    $.ajax({
        url: "/api/custom/ext",
        type:"POST",
        contentType : "application/json; charset=utf-8",
        processData : false,
        data : JSON.stringify(body),
        dataType:"json",
        success:function() {
            location.reload();
        },
        error:function(XMLHttpRequest) {
            alert(XMLHttpRequest.responseText);
        }
    });
}
function deleteCustomExt(id){
    $.ajax({
        url: "/api/custom/ext/"+id,
        type:"DELETE",
        contentType : false,
        processData : false,
        success:function() {
            location.reload();
        },
        error:function(XMLHttpRequest) {
            alert(XMLHttpRequest.responseText);
        }
    });
}
function isValidation(){
    let str = $("#custom_input_box").val();
    if(str === '' || str.length === 0 || str === 'undefined'){
        alert("한 글자 이상의 확장자 명이 필요합니다.");
        return false;
    }
    if(str.length > 20){
        alert("20 글자 이상은 불가능합니다.");
        return false;
    }
    return true;
}