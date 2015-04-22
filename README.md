# UDP

The goal of this coursework assignment is to write a simple client-server application where
multiple clients connect to a server. The first client to connect will send a looping audio
recording (in chunks) to the server. The server will relay the audio stream to all the
clients who connect after this.

The first client to connect to the server sends audio the audio. Clients that connect to
the server after this will receive the audio and play it back.

Architecture/program flow

Server main
1. Server starts listening for clients (TCP)
2. Client connects to server
3. Server places client connection and further handling of client in a separate thread
4. go back to 1

Client

1. Client connects to server (TCP)
2. Asks for Unique ID
3. Asks if its the first to connect
4. Open UDP connection to server
(a) If first client: send audio (in chunks) to server
(b) If not first client: listen for audio chunks coming in on UDP and play audio

Server Client handling

1. Send unique ID
2. Indicate to client if it is a sender or receiver process
3. Listen for UDP connection
4. Tell client to connect over UDP
5. Relay Audio data
In the case where the sender client stops its execution the server has to decide which of
the other clients has to take over the sending task.
