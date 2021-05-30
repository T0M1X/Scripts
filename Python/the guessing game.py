def numbers():
    import random
    num1 = random.randint(1,5000)
    num2=0
    count=0
    while num1 != num2:
        num2 = int(input("Please enter a number between 1 and 5000: "))
        count=count+1
        if num1 > num2:
            print("Your number is too low")
        if num2 > num1:
            print("Your number is too high")
    print("Well done you have guessed the number!!!:)")
    print(count, "is the highscore")
    return(count)
print("You are player 1 and are setting the highscore")
highscore=numbers()
highscore2=10000
count=2
please=input("Please pass the keyboard to the other players and enter 'yes' when done: ")
while please != "yes":
    please=input("Please pass the keyboard to player 2 and enter yes when done")
while highscore<highscore2 and count!=7:
    print("Your group has 5 tries to beat player 1")
    print(highscore," attempts was the score of player 1")
    highscore2=numbers()
    count=count+1
if count==7:
    print("Player1 wins")
else:
    print("Player ",count," wins") 
