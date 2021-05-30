import random
names=[[],[]]
repeat=True
while repeat == True:
    players=int(input("Enter number of players: "))
    mafia=int(input("Enter number of mafia: "))
    civilian=int(input("Enter number of civilians: "))
    if (mafia+civilian+2) == players:
        repeat=False
    else:
        print("Try again\n")
taken=True
count=0
for i in range(0,players):
    name=input("Enter name: ")
    names[0].append(name)
    while taken == True:
        count=0
        role=random.randint(1,4)
        for j in range(0,i):
            if role == names[1][j]:
                count=count+1
        if role == 1 and count != mafia:
            names[1].append(role)
            taken=False
        if role == 2 and count != civilian:
            names[1].append(role)
            taken=False
        if role == 3 and count != 1:
            names[1].append(role)
            taken=False
        if role == 4 and count != 1:
            names[1].append(role)
            taken=False
    taken=True
print("---------------------")
for i in range(0,players):
    if names[1][i] == 1:
        roleName="mafia"
    if names[1][i] == 2:
        roleName="civilian"
    if names[1][i] == 3:
        roleName="doctor"
    if names[1][i] == 4:
        roleName="detective"
    print(names[0][i]+" is the "+roleName)
