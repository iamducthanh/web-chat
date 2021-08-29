function showi(text){
    document.getElementById("showI").style.display = 'unset';
    document.getElementById("showitext").innerHTML = text;
}
function closei(){
    document.getElementById("showI").style.display = 'none';
}

function showWaitCall(){
    document.getElementById("avtCall").src = document.getElementById("userImageRoom").src;
    document.getElementById("nameCall").innerText = "Đang gọi " + document.getElementById("userNameRoom").innerText;
    document.getElementById("call").style.display = 'unset'
    document.getElementById("createMeet").click();
    setTimeout(konghe, 3000)
}
function closeWaitCall(){
    document.getElementById("waitcall").style.display = 'none';
}
function konghe(){
    let status = document.getElementById("statusCall").value;
    if(status == 'wait'){
        closeCall();
    }
}
function closeCall(){
    document.getElementById("call").style.display = 'none';

}