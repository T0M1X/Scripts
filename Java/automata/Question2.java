public class Question2
{
    public static void main(String[] args) 
    {
        // DEMO code, using automaton of Figure 1

        FSA A0=generateFSA0();

        // Check and print the automaton A0
        checkPrintFSA(A0,"A0");

        // Check if A0 accepts some words
        System.out.println("accepts 001: "+isAccepted(A0,new String[]{"0","0","1"}));
        System.out.println("accepts 112: "+isAccepted(A0,new String[]{"1","1","2"}));
        System.out.println("accepts 201: "+isAccepted(A0,new String[]{"2","0","1"}));
        System.out.println("accepts epsilon: "+isAccepted(A0,new String[]{ }));

        // Check if A0 is deterministic -- the method needs to be implemented
        System.out.println("deterministic: "+isDeterministic(A0));

        // Part (b)
        System.out.println("Printout(b)");
        printThem();

        // Part (c)
        System.out.println("Printout(c)");
        runThem();

        // Part (d)
        System.out.println("Printout(d)");
        testIsDeterministic();

    }

    public static FSA generateFSA0() {
        String[] alphabet = new String[]{ "0", "1", "2" };
        Transition[] delta = new Transition[] { 
            new Transition(0,"0",0), 
            new Transition(0,"0",1),
            new Transition(0,"2",2),
            new Transition(1,"1",2),
            new Transition(2,"0",2),
            new Transition(2,"1",2)
        };
        int[] finals = new int[] { 2 };
        FSA A = new FSA(3,alphabet,delta,finals);
        return A;
    }

    public static FSA generateFSA1() {
        // TODO construct FSA of part (a)i
    	String[] alphabet = new String[] {"0","2"};
    	Transition[] delta = new Transition[] {
    		new Transition(0,"2",0),
    		new Transition(0,"2",1),
    		new Transition(1,"0",2),
    		new Transition(1,"2",3),
    		new Transition(3,"0",5),
    		new Transition(5,"2",4),
    		new Transition(4,"2",6),
    		new Transition(6,"2",5)
    	};
    	int [] finals = new int[] {6};
    	FSA A = new FSA(7,alphabet,delta,finals);
        // and return it

        return A;
    }

    public static FSA generateFSA2() {
        // TODO construct FSA of part (a)ii
    	String[] alphabet = new String[] {"0","2","4"};
    	Transition[] delta = new Transition[] {
    		new Transition(0,"4",0),
    		new Transition(0,"2",1),
    		new Transition(1,"2",2),
    		new Transition(2,"0",3),
    		new Transition(3,"2",0),
    		new Transition(0,"0",4),
    		new Transition(4,"2",5),
    		new Transition(5,"4",0)
    	};
    	int [] finals = new int[] {0,4};
    	FSA A = new FSA(6,alphabet,delta,finals);
        // and return it

        return A;
    }

    public static FSA generateFSA3() {
        // TODO construct FSA of part (a)iii
    	String[] alphabet = new String[] {"0","2","4"};
    	Transition[] delta = new Transition[] {
    		new Transition(0,"0",1),
    		new Transition(0,"2",1),
    		new Transition(1,"4",0),
    		new Transition(1,"2",2),
    		new Transition(2,"0",1),
    		new Transition(2,"4",1)
    	};
    	int [] finals = new int[] {1,2};
    	FSA A = new FSA(3,alphabet,delta,finals);
        // and return it

        return A; 
    }
    
    public static void printThem() {
        // TODO generate the 3 FSAs above
    	checkPrintFSA(generateFSA1(),"A1");
    	checkPrintFSA(generateFSA2(),"A2");
    	checkPrintFSA(generateFSA3(),"A3");
        // and check and print them
    }

    public static void runThem() {
        // TODO generate the 3 FSAs above
    	boolean[] a1 = {
    			isAccepted(generateFSA1(), new String[] {"0","0","2","0","0"}), 
    			isAccepted(generateFSA1(), new String[] {"0","2","0","2","0"}),
    			isAccepted(generateFSA1(), new String[] {"2","0","2","0","2"})
    	};
    	boolean[] a2 = {
    			isAccepted(generateFSA2(), new String[] {"4","2","4","2","0"}), 
    			isAccepted(generateFSA2(), new String[] {"0","4","2","0","4"}),
    			isAccepted(generateFSA2(), new String[] {"2","4","0","2","4"})
    	};
    	boolean[] a3 = {
    			isAccepted(generateFSA3(), new String[] {"4","2","4","2","0"}), 
    			isAccepted(generateFSA3(), new String[] {"0","4","2","0","4"}),
    			isAccepted(generateFSA3(), new String[] {"2","4","0","2","4"})
    	};
    	String temp1 = "no";
    	String temp2 = "no";
    	String temp3 = "no";
    	if (a1[0] == true) {
    		temp1 = "yes";
    	}
    	if (a1[1] == true) {
    		temp2 = "yes";
    	}
    	if (a1[2] == true) {
    		temp3 = "yes";
    	}
    	System.out.println("A1 accepts: 00200 [" + temp1 + "], 02020 [" + temp2 + "], 20202 ["+temp3+"]");
    	temp1 = "no";
    	temp2 = "no";
    	temp3 = "no";
    	if (a2[0] == true) {
    		temp1 = "yes";
    	}
    	if (a2[1] == true) {
    		temp2 = "yes";
    	}
    	if (a2[2] == true) {
    		temp3 = "yes";
    	}
    	System.out.println("A2 accepts: 42420 [" + temp1 + "], 04204 [" + temp2 + "], 24024 ["+temp3+"]");
    	temp1 = "no";
    	temp2 = "no";
    	temp3 = "no";
    	if (a3[0] == true) {
    		temp1 = "yes";
    	}
    	if (a3[1] == true) {
    		temp2 = "yes";
    	}
    	if (a3[2] == true) {
    		temp3 = "yes";
    	}
    	System.out.println("A3 accepts: 42420 [" + temp1 + "], 04204 [" + temp2 + "], 24024 ["+temp3+"]");
        // and check if they accept given words
        // and print the results
    }

    public static Boolean isDeterministic(FSA A) {
        // TODO return true if A is deterministic
        // and false otherwise
    	int current = 0;
    	int temp;
    	String found = "";
    	boolean ans = true;
    	for (int i = 0; i < (A.delta).length; i++) {
    		temp =  A.delta[i].from;
    		if (current == temp) {
    			if (found.contains(A.delta[i].label)) {
    				ans = false;
    			}
    			found = found + A.delta[i].label;
    		} else {
    			current = temp;
    			found = "";
    			found = found + A.delta[i].label;
    		}
    	}

        return ans; 
    }

    // DO NOT CHANGE THE REMAINING CODE
    
    // print FSA A, after checking it is valid
    public static void checkPrintFSA(FSA A, String name) {
        if(A==null) return;
        String s = A.check();
        if(s!="") System.out.println("Error found in "+name+":\n"+s);
        else System.out.println(name+" = "+A.toString());
    }

    // check if FSA A accepts word w -- naive implementation
    public static Boolean isAccepted(FSA A, String[] w) {
        return isAcceptedRec(A,w,0,0);
    }
    
    // test the isDeterministic method on 10 FSAs
    public static void testIsDeterministic() {
        int j, marks = 0;
        Object[] X = FSA.getSamples();
        FSA[] tests = (FSA[])X[0];
        Boolean[] res = (Boolean[])X[1];
        for(int i=0; i<tests.length; i++) {
            System.out.println("Test "+(i+1)+": "+tests[i].toString());
            j = (res[i]==isDeterministic(tests[i])) ? 1 : 0;
            System.out.println("Result: "+j);
            marks += j;
        }
        System.out.println("Total: "+marks);
    }

    private static Boolean isAcceptedRec(FSA A, String[] w, int q, int i) {
        if(i==w.length) {
            for(int qF : A.finalStates)
                if(q==qF) return true;
            return false;
        }
        for(Transition t : A.delta) 
            if(t.from==q && t.label==w[i])
                if(isAcceptedRec(A,w,t.to,i+1)) return true;
        return false;
    }

    
}
