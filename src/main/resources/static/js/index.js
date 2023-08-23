$(document).ready(function (){
    // 고정 확장자 목록 가져오기
    getFixedExtList();
    // 커스텀 확장자 목록 가져오기
    getCustomExtList();

    // 고정 확장자를 check or uncheck 할 경우 db에 저장된다.
    $("input[name=fixed_item]").change(function(){
        updateFixedExt();
    });

    // 커스텀 확장자를 입력한 후 추가 버튼을 누르면 db에 저장된다.
    $(".custom_input_btn").on('click', function (){
        saveCustomExt();
    });

    // X 이미지를 클릭시 db에서 삭제
    $(".custom_delete").on('click', function (){
        deleteCustomExt();
    });
})

function getFixedExtList(){

}
function getCustomExtList(){

}
function updateFixedExt(){
    
}
function saveCustomExt(){
    
}
function deleteCustomExt(){
    
}