'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');

var stompClient = null;
var username = null;
var room = null;

function connect(event) {
    username = document.querySelector('#name').value.trim();
    room = document.querySelector('#room').value.trim();
    if (username) {
        stompClient = null;
        var socket = new SockJS('/chatroom/wss');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }
}


function onConnected() {
    var names = 'messUser' + username + document.getElementById('userInRoomDirect').value;
    console.log(names)
    document.getElementsByName(names)[0].className = 'me-auto mb-0';
    document.getElementsByName(names)[1].className = 'text-muted extra-small ms-2';
    document.getElementsByName(names)[2].className = 'line-clamp me-auto';
    document.getElementsByName(names)[3].innerText = 0;
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/' + room, onMessageReceived);
    // Tell your username to the server
    stompClient.send("/app/chat.addUser/" + room,
        {},
        JSON.stringify({sender: username, room: room, type: 'JOIN'})
    )
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

        $.ajax({
            url: window.location.pathname + '/save',
            data: {
                content: messageContent,
                room: room,
                sendto: document.getElementById('userInRoomDirect').value
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
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    var messageArea = document.getElementById('messageArea');
    var date = new Date();
    var timeChat = moment(date).format('DD-MM-YYYY HH:mm:ss');
    // var timeChat = day + "-" + month + "-" + year + " " + hour + ":" + minutes + ":" + seconds;
    console.log(timeChat)
    var userInRoom = document.getElementById('userInRoomDirect').value;
    if (message.type === 'JOINRETURN') {
        if (document.querySelector('#name').value.trim() != message.sender) {
            document.getElementById('statusOn').innerText = "Đang hoạt động";
        }
    }
    if (message.type === 'JOIN') {
        console.log(document.querySelector('#name').value.trim())
        if (document.querySelector('#name').value.trim() != message.sender) {
            document.getElementById('statusOn').innerText = "Đang hoạt động";

            stompClient.send("/app/chat.addUser/" + document.querySelector('#room').value.trim(),
                {},
                JSON.stringify({
                    sender: document.querySelector('#name').value.trim(),
                    room: document.querySelector('#room').value.trim(),
                    type: 'JOINRETURN'
                })
            )
        }
        messageArea.innerHTML += "<div class='on-conect'><p>" + message.sender + " đang hoạt động!</p></div>";
    } else if (message.type === 'LEAVE') {
        messageArea.innerHTML += "<div class='close-conect'><p>" + message.sender + " đã thoát!</p></div>";
    } else if (message.type === 'CHAT') {
        var username = document.querySelector('#name').value.trim();
        var names = 'messUser' + username + userInRoom;
        if (username == message.sender) {
            var elem = document.getElementById('statusMessageSend');
            elem.parentNode.removeChild(elem);
            messageArea.innerHTML +=
                "<div class='message message-out'><a href='#' data-bs-toggle='modal' data-bs-target='#modal-profile' class='avatar avatar-responsive'>" +
                "<img class='avatar-img' src='assets/image/" + document.getElementById("imageUserLogin").value + "'" + " alt=''>" +
                "</a>" +
                "<div class='message-inner'>" +
                "<div class='message-body'>" +
                "<div class='message-content'>" +
                "<div class='message-text'>" +
                "<p>" + message.content + "</p>" +
                "</div>" +
                "<div class='message-action'>" +
                "<div class='dropdown'>" +
                "<a class='icon text-muted' href='#' role='button' data-bs-toggle='dropdown'" +
                "aria-expanded='false'>" +
                "<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round' class='feather feather-more-vertical'><circle cx='12' cy='12' r='1'></circle><circle cx='12' cy='5' r='1'></circle><circle cx='12' cy='19' r='1'></circle></svg>" +
                "</a>" +
                "<ul class='dropdown-menu'>" +
                "<li>" +
                "<a class='dropdown-item d-flex align-items-center' href='#'>" +
                "<span class='me-auto'>Edit</span>" +
                "<div class='icon'>" +
                "<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round' class='feather feather-edit-3'><path d='M12 20h9'></path><path d='M16.5 3.5a2.121 2.121 0 0 1 3 3L7 19l-4 1 1-4L16.5 3.5z'></path>" +
                "</svg>" +
                "</div>" +
                "</a> </li> <li>" +
                "<a class='dropdown-item d-flex align-items-center' href='#'>" +
                "<span class='me-auto'>Reply</span>" +
                "<div class='icon'>" +
                "<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round' class='feather feather-corner-up-left'><polyline points='9 14 4 9 9 4'></polyline><path d='M20 20v-7a4 4 0 0 0-4-4H4'></path>" +
                "</svg>" +
                "</div>" +
                "</a>" +
                "</li>" +
                "<li><hr class='dropdown-divider'></li>" +
                "<li>" +
                "<a class='dropdown-item d-flex align-items-center text-danger' href='#'>" +
                "<span class='me-auto'>Delete</span>" +
                "<div class='icon'>" +
                "<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round' class='feather feather-trash-2'><polyline points='3 6 5 6 21 6'></polyline><path d='M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2'></path>" +
                "<line x1='10' y1='11' x2='10' y2='17'></line><line x1='14' y1='11' x2='14' y2='17'></line>" +
                "</svg>" +
                "</div>" +
                "</a>" +
                "</li>" +
                "</ul>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "<div class='message-footer'>" +
                "<span class='extra-small text-muted'>" + timeChat + "</span>" +
                "</div>" +
                "</div>" +
                "</div>";


            messageArea.innerHTML +=
                "<div class='message message-out' style='margin: 0px' id='statusMessageSend'>" +
                "<a data-bs-toggle='modal' data-bs-target='#modal-profile' style='height: 0px'" +
                "class='avatar avatar-responsive'>" +
                "</a>" +
                "<div class='message-inner'>" +
                "<div class='message-body'>" +
                "</div>" +
                "<div class='message-footer'>" +
                "<span class='extra-small text-muted'>" + message.statusMessage + "</span><br/>" +
                "</div>" +
                "</div>" +
                "</div>";
            var classRe = document.getElementsByName(names);
            if (classRe != null) {
                document.getElementsByName(names)[2].innerText = message.content.substring(0, 100);
            }
            if (message.statusMessage == 'Đã gửi') {
                stompClientMessageListen.send("/app/system.onmessage/" + userInRoom,
                    {},
                    JSON.stringify({sender: username, reader: userInRoom, content: message.content})
                )
            }
        } else {
            messageArea.innerHTML +=
                "<div class='message'>" +
                "<a data-bs-toggle='modal' data-bs-target='#modal-user-profile'" +
                "class='avatar avatar-responsive'>" +
                "<img class='avatar-img' src='assets/image/" + document.getElementById("imageUserInRoom").value + "'" + " alt=''>" +
                "</a>" +
                "<div class='message-inner'>" +
                "<div class='message-body'>" +
                "<div class='message-content'>" +
                "<div class='message-text'>" +
                "<p>" + message.content + "</p>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "<div class='message-footer'>" +
                "<span class='extra-small text-muted'>" + timeChat + "</span>" +
                "</div>" +
                "</div>" +
                "</div>";

            var classRe = document.getElementsByName(names);
            if (classRe != null) {
                console.log(document.getElementsByName(names)[2].innerText)
                document.getElementsByName(names)[2].innerText = message.content.substring(0, 100);
            }
        }
    }

    var messForm = document.getElementById('messForm');
    messForm.scrollTop = messForm.scrollHeight;
    console.log(messForm.scrollTop)
    console.log(messForm.scrollHeight)
}

// usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)
