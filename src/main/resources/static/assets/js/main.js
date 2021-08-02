'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
// var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var room = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    username = document.querySelector('#name').value.trim();
    room = document.querySelector('#room').value.trim();
    if (username) {
        // usernamePage.classList.add('hidden');
        // chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
}


function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/' + room, onMessageReceived);
    // Tell your username to the server
    stompClient.send("/app/chat.addUser/" + room,
        {},
        JSON.stringify({sender: username, room: room, type: 'JOIN'})
    )
    // connectingElement.classList.add('hidden');
}

connect();

function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    console.log(messageContent)
    if (messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT',
            room: room
        };
        stompClient.send("/app/chat.sendMessage/" + room, {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    var messageArea = document.getElementById('messageArea');
    var date = new Date(message.timeChat);
    var year = date.getFullYear();
    var month = date.getMonth();
    var day = date.getDay();
    var hour = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    var timeChat = day +"-"+ month +"-"+ year +" "+ hour +":"+ minutes +":"+ seconds;
    if (message.type === 'JOIN') {
        messageArea.innerHTML += "<div class='on-conect'><p>"+message.sender+" đang hoạt động!</p></div>";
    } else if (message.type === 'LEAVE') {
        messageArea.innerHTML += "<div class='close-conect'><p>"+message.sender+" đã thoát!</p></div>";
    } else {
        var username = document.querySelector('#name').value.trim();
        if(username == message.sender){
            messageArea.innerHTML +=
                "<div class='message message-out'>" +
                    "<a data-bs-toggle='modal' data-bs-target='#modal-profile'" +
                       "class='avatar avatar-responsive'>"+
                        "<img class='avatar-img' src='assets/img/avatars/1.jpg' alt=''>"+
                    "</a>"+
                    "<div class='message-inner'>"+
                        "<div class='message-body'>"+
                            "<div class='message-content'>"+
                                "<div class='message-text'>"+
                                    "<p>"+message.content+"</p>"+
                                "</div>"+
                            "</div>"+
                        "</div>"+
                        "<div class='message-footer'>"+
                            "<span class='extra-small text-muted'>"+timeChat+"</span>"+
                        "</div>"+
                    "</div>"+
                "</div>";
        } else {
            messageArea.innerHTML +=
                "<div class='message'>"+
                    "<a data-bs-toggle='modal' data-bs-target='#modal-user-profile'"+
                       "class='avatar avatar-responsive'>"+
                        "<img class='avatar-img' src='assets/img/avatars/11.jpg' alt=''>"+
                    "</a>"+
                    "<div class='message-inner'>"+
                        "<div class='message-body'>"+
                            "<p>" + message.sender+ "</p>" +
                            "<div class='message-content'>"+
                                "<div class='message-text'>"+
                                    "<p>"+message.content+"</p>"+
                                "</div>"+
                            "</div>"+
                        "</div>"+
                        "<div class='message-footer'>"+
                            "<span class='extra-small text-muted'>"+timeChat+"</span>"+
                        "</div>"+
                    "</div>"+
                "</div>"
        }
        // messageElement.classList.add('chat-message');
        // var avatarElement = document.createElement('i');
        // var avatarText = document.createTextNode(message.sender[0]);
        // avatarElement.appendChild(avatarText);
        // avatarElement.style['background-color'] = getAvatarColor(message.sender);
        // messageElement.appendChild(avatarElement);
        // var usernameElement = document.createElement('span');
        // var usernameText = document.createTextNode(message.sender);
        // usernameElement.appendChild(usernameText);
        // messageElement.appendChild(usernameElement);
    }

    // var textElement = document.createElement('p');
    // var messageText = document.createTextNode(message.content);
    // textElement.appendChild(messageText);
    //
    // messageElement.appendChild(textElement);
    //
    // messageArea.appendChild(messageElement);
    var messForm = document.getElementById('messForm');
    messForm.scrollTop = messForm.scrollHeight;
    console.log(messForm.scrollTop)
    console.log(messForm.scrollHeight)
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}

// usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)
