import os
from socket import socket, AF_INET, SOCK_STREAM
import random
import sqlite3
def echo_server(my_port):

	sock = socket(AF_INET, SOCK_STREAM)
	sock.bind(('', my_port))
	sock.listen(5)
	print('Server started')
	while True:
		conn, cli_addr = sock.accept()
		print('Connected by', cli_addr)
		while True:
			data = conn.recv(1024)
			if not data: break
			print('Server received', data.decode())
			r_msg = data.decode()
			handler(r_msg, conn)
			#if r_msg[0] == 'type:identify':
			#	if checkID(r_msg[2]):
			#		sock.send("input phone".encode())
			#	else :
			#		sock.send("not verified".encode())
			#if r_msg[0] == 'type:phone':
			#	end_boxnum(conn)
			#	if conn.recv
			#	myfunc.sms(r_msg[1][6:])
			#conn.send(data)
		#conn.send(data)
	print('Client closed', cli_addr)
	conn.close()

def handler(msg, sock):
	#알아서 쪼개든
	#길이로 판단하든
	msg_list = msg.split()
	"""택배기사가 전화번호를 입력하여 보내줬을 때"""
	if msg_list[0] == 'type:phone':
	#STATUS,전화번호를 DB에 저장하고 비밀번호 만들어서 DB에 저장하고 전화본호에 문자를 주기
		pswd=makepasswd(1)
		print(pswd)
		sms(msg_list[2],str(pswd))
		sock.send('phoneok'.encode())
	"""택배기사가 id를 입력하여 보내 줬을 때"""
	if msg_list[0] == 'type:identify':
		if CheckID(msg_list[2]) :
			sock.send(('IDOK '+str(send_boxnum())).encode())
		else :
			sock.send("NOTOK".encode())
	"""사용자가 비밀번호를 입력하여 보내줫을 때"""
	if msg_list[0] == 'type:passwd':
		temp = CheckWhichBox(msg_list[2])
		sock.send(("{}".format(temp)).encode())

def makepasswd(boxindex) : # 비밀번호 만드는 함수
	count=0
	dbconn=sqlite3.connect('example.db')
	c=dbconn.cursor()
	passwd = random.randrange(1000,10000)
	loop = True
	while loop:
		for row in c.execute('SELECT * FROM DELIVER'):
			if passwd == row[2]:
				count += 1
				print(passwd)
			if count == 0 :
				loop = False
		count = 0
		passwd = random.randrange(1000,10000)
	c.execute("UPDATE DELIVER SET PASSWD={0} WHERE BOXINDEX={1}".format(passwd,boxindex))
	dbconn.commit()
	dbconn.close()
	return  passwd

def send_boxnum(): # 라즈베리파이가 기사님일 때 open msg날리때 빈칸 알려주는 함수
	dbconn = sqlite3.connect('example.db')
	c = dbconn.cursor()
	start = True
	for row in c.execute("SELECT * FROM DELIVER"):
		if row[1] == 'EMPTY' and start == True:
			status = 'FULL'
			start = False
			c.execute("UPDATE DELIVER SET STATUS=? WHERE BOXINDEX=?", (status, row[0]))
			dbconn.commit()
			return row[0]
	else:
		return "FULL"

def CheckWhichBox(passwd): # 사용자가 비밀번호 입력하면 확인하는 함수
	dbconn = sqlite3.connect('example.db')
	c = dbconn.cursor()
	passwd = int(passwd)
	for row in c.execute('SELECT * FROM DELIVER'):
		if row[2] == passwd:
			return row[0]
	return 0

def CheckID(id):
	dbconn = sqlite3.connect('example.db')
	c = dbconn.cursor()
	for row in c.execute('SELECT * FROM IDENTY') :
		if row[0] == id: return True
	return False

def sms(phonenumber, pswd):
	#print(phonenumber)
	os.system("python sendsms.py {0} {1}".format(phonenumber,pswd))

if __name__ == '__main__':
	echo_server(50026) #일반적으로 만 이하의 숫자는 다 쓰고 있으므로 사용하면 곤란하다
