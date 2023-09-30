import React from 'react';
import { Form, Input, Button } from 'react-bootstrap';
import io from "socket.io-client";
import { useEffect, useState } from "react";

const socket = io.connect("http://localhost:3001");

function App() {
  const [room, setRoom] = useState("");

  const [message, setMessage] = useState("");
  const [messageReceived, setMessageReceived] = useState("");

  const joinRoom = () => {
    if (room !== "") {
      socket.emit("join_room", room);
    }
  };

  const sendMessage = () => {
    socket.emit("send_message", { message, room });
  };

  useEffect(() => {
    socket.on("receive_message", (data) => {
      setMessageReceived(data.message);
    });
  }, [socket]);
  return (
    <Form>
       <Form.Group className="mb-3">
      <Form.Control type="text" placeholder="Room Number..." value={room} onChange={(event) => { setRoom(event.target.value); }} />
      <Button type="button" onClick={joinRoom}>Join Room</Button>
      </Form.Group>
      <Form.Group className="mb-3">
      <Form.Control type="text" placeholder="Message..." value={message} onChange={(event) => { setMessage(event.target.value); }} />
      <Button type="button" onClick={sendMessage}>Send Message</Button>
      </Form.Group>
      <h1> Message:</h1>
      {messageReceived}
    </Form>
  );
}

export default App;