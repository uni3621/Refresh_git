import sqlite3
conn = sqlite3.connect('example.db')

c = conn.cursor()

c.execute('''CREATE TABLE delivery
    (number integer, locked text, passwd integer, gettime text)

''')

conn.commit()

conn.close()
