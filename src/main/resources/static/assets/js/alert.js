function showi(text){
    document.getElementById("showI").style.display = 'unset';
    document.getElementById("showitext").innerHTML = text;
}
function closei(){
    document.getElementById("showI").style.display = 'none';
}

function closeWaitCall(){
    document.getElementById("waitcall").style.display = 'none';
}
function nghe(){
    document.getElementById("joinMeet").click();
    document.getElementById("call").style.display = 'unset'
    document.getElementById("container2call").style.width = '90%'
    document.getElementById("container2call").style.height = '90%'
    document.getElementsByClassName("waitCall1")[0].style.display = 'none';
    document.getElementById("containerCall").style.display = 'unset';
    closeWaitCall();
    stompClientCall.send("/app/call/" + document.getElementById("caller1").value,
        {},
        JSON.stringify({
            status: 'CALLRETURN'
        })
    );
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