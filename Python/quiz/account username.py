def access():
    myFile=open("account.txt","r")
    count=0
    while count==0:
        word=input("What is your username?\n")
        for line in myFile:
            line.strip()
            if word in line:
                password=str(line[6:])
                count=count+1
    attempt=str(input("What is your password?\n"))
    count=1
    while attempt+"\n" != password and count < 3:
        attempt=str(input("What is your password?\n"))
        count=count+1
    if attempt+"\n"!= password:
        quit()
    return(word)
    myFile.close()
def create():
    name=input("What is your name?\n")
    age=int(input("How old are you? You must be between 10 and 99.\n"))
    while age < 10 or age > 99:
        age=int(input("How old are you? You must be between 10 and 99.\n"))
    age=str(age)
    yr=str(input("What year group are you in?\n"))
    username=(name[0:3]+age)
    print("Yout username is ",username)
    password=input("Please enter a password\n")
    myFile=open("account.txt","a")
    myFile.write(username + " "+ password)
    myFile.write("\n")
    myFile.close()
account=input("Do you already have an account?\n")
while account != "yes" and account != "no":
    account=input("Do you already have an account?\n")
if account=="yes":
    word=access()
else:
    create()
topic=str(input("Enter: computing, history or music\n"))
while topic != "computing" and topic != "history" and topic != "music":
    topic=str(input("Enter: computing, history or music\n"))
level=str(input("Enter: easy, medium, or hard\n"))
while level != "easy" and level != "medium" and level != "hard":
    level=str(input("Enter: easy, medium, or hard\n"))
myfile=open(topic+"q.txt","r")
q=[]
for i in range(0,5):
    q.append(myfile.readline())
myfile.close()
myfile=open(topic+"a.txt","r")
a=[]
for i in range(0,20):
    a.append(myfile.readline())
myfile.close()
correct=0
myfile=open(topic+"correct.txt","r")
for i in range(0,5):
    print(q[i])
    if level=="easy":
        print("Options\n"+a[1+(i*4)]+a[2+(i*4)])
    elif level =="medium":
        print("Options\n"+a[0+(i*4)]+a[1+(i*4)]+a[2+(i*4)])
    elif level=="hard":
        print("Options\n"+a[0+(i*4)]+a[1+(i*4)]+a[2+(i*4)]+a[3+(i*4)])
    line=str(myfile.readline())
    response=str(input("Enter the correct answer\n"))
    if line == response+"\n":
        correct=correct+1
if correct==0:
    grade="u"
    percentage="0%"
elif correct == 1:
    grade="f"
    percentage="20%"
elif correct == 2:
    grade="d"
    percentage="40%"
elif correct == 3:
    grade="c"
    percentage="60%"
elif correct == 4:
    grade="b"
    percentage="80%"
elif correct == 5:
    grade="a*"
    percentage="100%"
print("your score is "+str(correct))
print("your grade is "+grade)
print("your percentage is "+ percentage)
myfile.close()
import sqlite3
new_db=sqlite3.connect("username.db")
cursor=new_db.cursor()
scores=[(word,topic,level,grade,correct)]
cursor.executemany("INSERT INTO scores VALUES (?,?,?,?,?)",scores)
cursor=new_db.cursor()
word=input("Whose details would you like to view?\n")
cursor.execute("SELECT subject, difficulty, outcome FROM scores WHERE person=?",(word,))
print(cursor.fetchall())
topic=input("Which topic would you like to view?\n")
level=input("What level of difficulty would you like to view?\n")
cursor.execute("SELECT person, score FROM scores WHERE difficulty=? AND subject=?",(level,topic,))
print(cursor.fetchall())
cursor.execute("SELECT avg(score) FROM scores WHERE difficulty=? AND subject=?",(level,topic,))
print("The average is: ",cursor.fetchall())
cursor.execute("SELECT person, max(score) FROM scores WHERE difficulty=? AND subject=?",(level,topic,))
print("The highest score: ",cursor.fetchall())
new_db.commit()
new_db.close()
    
