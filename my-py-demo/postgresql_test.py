import psycopg2

conn = psycopg2.connect(database="pgsql", user="pgsql", password="Dpp-pgsql123##", host="10.192.30.175", port="5432")

print("connection success!")

cur = conn.cursor()

cur.execute("SELECT * FROM USERS")
rows = cur.fetchall()
for r in rows:
    print(r)
print("operation done")
# conn.commit()
