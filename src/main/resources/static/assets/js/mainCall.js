function showWaitCall(){
    document.getElementById("avtCall").src = document.getElementById("userImageRoom").src;
    document.getElementById("nameCall").innerText = "Đang gọi " + document.getElementById("userNameRoom").innerText;
    document.getElementById("call").style.display = 'unset'
    document.getElementById("createMeet").click();
}

function onCallVideo(){
    let listener = document.getElementById("userInRoomDirect").value;
    let caller = document.getElementById("name").value;
    let imageCaller = document.getElementById("avtMyUser").src;
    let fullnameCaller = document.getElementById("fullname").value;
    let rooomId = document.getElementById('idRoomMeet').value;

    setTimeout(konghe, 60000);
    stompClientCall.send("/app/call/" + listener,
        {},
        JSON.stringify({
            caller: caller,
            listener: listener,
            imageCaller: imageCaller,
            fullnameCaller: fullnameCaller,
            rooomId: rooomId,
            status: 'SENDCALL'
        })
    );
}