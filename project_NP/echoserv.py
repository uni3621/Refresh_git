import sys
from socket import socket, AF_INET, SOCK_STREAM
import sqlite3

def echo_server(my_port):   
    """Echo Server -iterative"""

    sock = socket(AF_INET, SOCK_STREAM) # make listening socket
    sock.bind(('10.10.0.235', my_port))        # bind it to server port number 클라이언트와 연결하기 위해서는 bind를 꼭 해야한다. 그래야 client인지 아닌지를 알 수 있다.
                                    # '' = all available interfaces on host 내 컴퓨터에 있는 ip주소 아무거나 다 연결을 받겠다.
    sock.listen(5)                  # listen, allow 5 pending connects
    print('Server started')
    while True:                     # do forever (until process killed)
        conn, cli_addr = sock.accept()  # wait for next client connect
                                    # conn: new socket, addr: client addr
        print('Connected by', cli_addr)
        while True:
            data = conn.recv(1024)  # recv next message on connected socket
            if not data: break      # eof when the socket closed
            print('Server received', data.decode())
            dbconn = sqlite3.connect('example.db')
            c = dbconn.cursor()
            c.execute("INSERT INTO delivery VALUES(1,'YES',1234,'2004')")
            dbconn.commit()
            conn.send(data)  # send a reply to the client
        print('Client closed', cli_addr)
        conn.close()                # close the connected socket
        
if __name__ == '__main__':
    echo_server(50007) # 일반적으로 만 이하의 숫자는 다 쓰고 있으므로 사용하면 곤란하다

