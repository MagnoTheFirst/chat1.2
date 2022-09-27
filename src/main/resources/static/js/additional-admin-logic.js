

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var username = "Alejandro Laneri";

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function loadChatConversations(){
    var xmlHttp = new XMLHttpRequest();
    var url = 'http://localhost:8081/api/v1/get_all_messages';
    xmlHttp.open( "GET", url, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

function showChatConversation(){
    var chatConversations = JSON.parse(loadChatConversations());

    for(var i = 0; i < chatConversations.length; i++){
        console.log(JSON.stringify(chatConversations[i].sender));

        var messageElement = document.createElement('li');
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(chatConversations[i].sender[0]);
        var datetime = document.createTextNode(chatConversations[i].localDateTime);

        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(chatConversations[i].sender);
        messageElement.appendChild(avatarElement);

        //alert(JSON.parse(datetime));

        var usernameElement = document.createElement('span');
        var dateElement = document.createElement('span');
        var usernameText = document.createTextNode(chatConversations[i].sender);

        usernameElement.appendChild(usernameText);
        usernameElement.appendChild(datetime);
        messageElement.appendChild(usernameElement);

        var textElement = document.createElement('p');
        var messageText = document.createTextNode(chatConversations[i].content);

        textElement.appendChild(messageText);
        messageElement.appendChild(textElement);

        messageArea.appendChild(messageElement);
        messageArea.scrollTop = messageArea.scrollHeight;

    }
/*
    for(var i = 0; i < chatConversations.length; i++){


    }*/
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}