import time
import random
a=list("                                                                                                                                                                                             ")
f=list("                                                                                                                                                                                             ")
c=list("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")
t=1
while t > 0:
    t=t+1
    r=random.randint(0,188)
    n=random.randint(60,126)
    a[r]=chr(n)
    f[r]="1"
    print("".join(a))
    time.sleep(0.03)
    for i in range(0,189):
        if f[i] == "1":
            c[i]=str(int(c[i])+1)
            n=random.randint(60,126)
            a[i]=chr(n)
            if int(c[i]) > 35:
                a[i]=" "
                f[i]=" "
                c[i]="0"
    if t % 7 == 0:
        r=random.randint(0,188)
        a[r]=" "
        f[r]=" "
        c[r]="0"    
