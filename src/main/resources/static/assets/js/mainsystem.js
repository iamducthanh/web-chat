'use strict';

let stompClientSystem = null;
let stompClientMessageListen = null;
let stompClientCall = null;
let userOnline = null;

function online(event) {
    userOnline = document.querySelector('#userOnline').value.trim();
    if (userOnline) {
        let socket = new SockJS('/chatroom/system');
        stompClientSystem = Stomp.over(socket);
        stompClientSystem.connect({}, onOnlined, onError1);

        let socketSystem = new SockJS('/chatroom/system');
        stompClientMessageListen = Stomp.over(socketSystem);
        stompClientMessageListen.connect({}, onOnlined, onError1);

        let socketCall = new SockJS('/chatroom/system');
        stompClientCall = Stomp.over(socketCall);
        stompClientCall.connect({}, onOnlined, onError1);
    }
}


function onOnlined() {
    userOnline = document.querySelector('#userOnline').value.trim();
    console.log("User online login " + userOnline)

    stompClientSystem.subscribe('/topic/system.adduser', onMessageReceivedOnline);

    stompClientCall.subscribe('/topic/call/' + userOnline, onCall);

    stompClientMessageListen.subscribe('/topic/system.onmessage/' + userOnline, onMessageRealtime);
    stompClientSystem.send("/app/system.adduser",
        {},
        JSON.stringify({username: userOnline, type: 'ONLINE'})
    );
}

function onCall(payload){
    let call = JSON.parse(payload.body);
    console.log(call.fullnameCaller + "  " + call.ImageCaller)
    if(call.status == 'SENDCALL'){
        document.getElementById("waitcall").style.display = "unset";
        document.getElementById("idRoomMeet").value = call.rooomId;
        document.getElementById("nameCall1").innerHTML = call.fullnameCaller + ' đang gọi cho bạn!';
        document.getElementById("avtCall1").src = call.imageCaller;
        document.getElementById("caller1").value = call.caller;
    } else if(call.status == 'CALLRETURN'){
        document.getElementById("container2call").style.width = '90%'
        document.getElementById("container2call").style.height = '90%'
        document.getElementsByClassName("waitCall1")[0].style.display = 'none';
        document.getElementById("containerCall").style.display = 'unset';
        document.getElementById("inCall").style.display = 'unset';
    }
}

function onMessageRealtime(payload){
    let messageRealtime = JSON.parse(payload.body);
    let classname = 'messUser' + messageRealtime.reader + messageRealtime.sender;
    let elms = document.getElementsByName(classname);
    if(elms != null){
        // tạo thông báo tin nhắn
        elms[0].className = 'me-auto mb-0 messageSend';
        elms[1].className = 'text-muted extra-small ms-2 messageSend';
        elms[2].className = 'line-clamp me-auto messageSend';
        elms[2].innerText = messageRealtime.content;
        console.log("count:  " + elms[3].innerText);
        elms[3].innerText = Number(elms[3].innerText) + 1;

        // tạo số lượng tin nhắn
        let countMessage = document.getElementById('countMessage');
        if(countMessage != null){
            countMessage.innerText = Number(countMessage.innerText) + 1;
        } else {
            let divCountMessage = document.getElementById("divCountMessage");
            divCountMessage.className += 'icon-badged';
            let divSpan = document.createElement('div');
            divSpan.className = 'badge badge-circle bg-primary';
            divCountMessage.appendChild(divSpan);
            let span = document.createElement("span");
            span.id = 'countMessage';
            span.innerText = '1';
            divSpan.appendChild(span);
        }
    }
}

function onMessageReceivedOnline(payload){
    let user = JSON.parse(payload.body);
    let userClass = document.getElementById(user.username);
    let userClassFriend = document.getElementById(user.username + 'Friend');
    let userStatus = document.getElementsByClassName(user.username)[0];
    let userStatusFriend = document.getElementsByClassName(user.username+'Friend')[0];
    console.log(userStatusFriend)
    if(userClass != null){
        if(user.type == 'ONLINE'){
            userClass.className = 'avatar avatar-online';
            userClassFriend.className = 'avatar avatar-online';
            if(userStatus != null){
                userStatus.innerText = 'Đang hoạt động';
            }
            if(userStatusFriend != null){
                userStatusFriend.innerText = 'Đang hoạt động';
            }
        } else if(user.type == 'OFFLINE'){
            if(userStatus != null){
                userStatus.innerText = 'Không hoạt động';
            }
            if(userStatusFriend != null){
                userStatusFriend.innerText = 'Không hoạt động';
            }
            userClass.className = 'avatar avatar-offline';
            userClassFriend.className = 'avatar avatar-offline';
        }
    }
}

online();

function onError1(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

function deleteAttack(aa){
    console.log(aa)
    $.ajax({
        url: 'removeImage',
        data: {
            fileName: aa,
            room: document.querySelector("#room").value,
        },
        error: function () {
            console.log("error")
        },
        success: function (data) {
            console.log("thanh cong")
        },
        type: 'POST'
    });
}



