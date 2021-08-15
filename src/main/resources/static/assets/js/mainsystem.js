'use strict';

var stompClientSystem = null;
var userOnline = null;

function online(event) {
    userOnline = document.querySelector('#userOnline').value.trim();
    if (userOnline) {
        var socket = new SockJS('/system');
        stompClientSystem = Stomp.over(socket);
        stompClientSystem.connect({}, onOnlined, onError1);
    }
}


function onOnlined() {
    // Subscribe to the Public Topic
    stompClientSystem.subscribe('/topic/system.adduser', onMessageReceivedOnline);
    // Tell your username to the server
    stompClientSystem.send("/app/system.adduser",
        {},
        JSON.stringify({username: userOnline, type: 'ONLINE'})
    )
}

function onMessageReceivedOnline(payload){
    var user = JSON.parse(payload.body);
    console.log(user.username)
    var userClass = document.getElementById(user.username);
    console.log(userClass)
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


