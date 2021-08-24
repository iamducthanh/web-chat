'use strict';

var stompClientSystem = null;
var stompClientMessageListen = null;
var userOnline = null;

function online(event) {
    userOnline = document.querySelector('#userOnline').value.trim();
    if (userOnline) {
        var socket = new SockJS('/chatroom/system');
        stompClientSystem = Stomp.over(socket);
        stompClientSystem.connect({}, onOnlined, onError1);

        var socketSystem = new SockJS('/chatroom/system');
        stompClientMessageListen = Stomp.over(socketSystem);
        stompClientMessageListen.connect({}, onOnlined, onError1);
    }
}


function onOnlined() {
    userOnline = document.querySelector('#userOnline').value.trim();
    // Subscribe to the Public Topic
    stompClientSystem.subscribe('/topic/system.adduser', onMessageReceivedOnline);

    stompClientMessageListen.subscribe('/topic/system.onmessage/' + userOnline, onMessageRealtime);
    // Tell your username to the server
    stompClientSystem.send("/app/system.adduser",
        {},
        JSON.stringify({username: userOnline, type: 'ONLINE'})
    );
}

function onMessageRealtime(payload){
    var messageRealtime = JSON.parse(payload.body);
    console.log(messageRealtime.sender)
    console.log(messageRealtime.reader)
    console.log(messageRealtime.content)
    console.log(messageRealtime.time)
    var classname = 'messUser' + messageRealtime.reader + messageRealtime.sender;
    var elms = document.getElementsByName(classname);
    if(elms != null){
        elms[0].className = 'me-auto mb-0 messageSend';
        elms[1].className = 'text-muted extra-small ms-2 messageSend';
        elms[2].className = 'line-clamp me-auto messageSend';
        elms[2].innerText = messageRealtime.content.substring(0, 100);
        elms[3].innerText = '1';
    }
}

function onMessageReceivedOnline(payload){
    var user = JSON.parse(payload.body);
    console.log(user.username)
    var userClass = document.getElementById(user.username);
    console.log("nguoi vua online: " +userClass)
    if(userClass != null){
        if(user.type == 'ONLINE'){
            userClass.className = 'avatar avatar-online';
        } else if(user.type == 'OFFLINE'){
            var userMess = document.getElementsByClassName(user.username)[0];
            if(userMess != null){
                userMess.innerText = 'Không hoạt động';
            }
            userClass.className = 'avatar avatar-offline';
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


