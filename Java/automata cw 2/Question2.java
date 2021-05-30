import java.util.*;

public class Question2
{
    public static void main(String[] args) 
    {
        // DEMO code, using CFG of Question 1(c)
        CFG G0=generateCFG0();
        
        // Check if G0 accepts some words
        System.out.println("accepts 20: "+isAccepted(G0,new String[]{"2","0"}));
        System.out.println("accepts 1201: "+isAccepted(G0,new String[]{"1","2","0","1"}));
        System.out.println("accepts 1203: "+isAccepted(G0,new String[]{"1","2","0","3"}));
        System.out.println("accepts epsilon: "+isAccepted(G0,new String[]{ }));

        // Check if G0 is in CNF -- the method needs to be implemented
        System.out.println("in CNF: "+isInCNF(G0));

        // Part (b)
        System.out.println("Printout(b)");
        runThem();

        // Part (c)
        System.out.println("Printout(c)");
        testIsInCNF();

    }

    public static CFG generateCFG0()
    {
        String[] alphabet = new String[]{ "0", "1", "2", "3" };
        String[] vars = new String[]{ "S", "Y" };
        Rule[] R = new Rule[] { 
            new Rule("S",new String[]{"1","S","1"}), 
            new Rule("S",new String[]{"3","S","3"}), 
            new Rule("S",new String[]{"Y"}), 
            new Rule("Y",new String[]{"2","0"}),
            new Rule("Y",new String[]{"2","0","Y"})
        };
        return new CFG(alphabet,vars,R,"S");
    }

    public static CFG generateCFG1() {
        // TODO construct CFG of part (a)i
    	String[] alphabet = new String[] {"0","1","2"};
    	String[] vars = new String[] {"S","X"};
    	Rule[] R = new Rule[] {
    		new Rule("S",new String[] {"X","2"}),
    		new Rule("S",new String[] {"S","1"}),	
    		new Rule("X",new String[] {"0","X","S","0"}),	
    		new Rule("X",new String[] {"0","1"}),	
    		new Rule("X",new String[] {})
    	};
        // and return it

        return new CFG(alphabet,vars,R,"S");
    }

    public static CFG generateCFG2() {
        // TODO construct CFG of part (a)ii
    	String[] alphabet = new String[] {"(",")","[","]"};
    	String[] vars = new String[] {"S","X"};
    	Rule[] R = new Rule[] {
    		new Rule("S",new String[] {"[","X","]"}),
    		new Rule("X",new String[] {}),	
    		new Rule("X",new String[] {"X","(","X",")"})	
    	};
        // and return it

        return new CFG(alphabet,vars,R,"S");
    }

    public static CFG generateCFG3() {
        // TODO construct CFG of part (a)iii
    	String[] alphabet = new String[] {"0","1","2","3","4","5","6","7","8","9","+","*"};
    	String[] vars = new String[] {"S","N"};
    	Rule[] R = new Rule[] {
    		new Rule("S",new String[] {"N"}),
    		new Rule("S",new String[] {"S","+","S"}),	
    		new Rule("S",new String[] {"S","*","S"}),	
    		new Rule("N",new String[] {"0"}),	
    		new Rule("N",new String[] {"1"}),		
    		new Rule("N",new String[] {"2"}),	
    		new Rule("N",new String[] {"3"}),	
    		new Rule("N",new String[] {"4"}),	
    		new Rule("N",new String[] {"5"}),	
    		new Rule("N",new String[] {"6"}),	
    		new Rule("N",new String[] {"7"}),
    		new Rule("N",new String[] {"8"}),	
    		new Rule("N",new String[] {"9"})
    	};
        // and return it

        return new CFG(alphabet,vars,R,"S");
    }
    
    public static void runThem() {
        // TODO generate the 3 CFGs above and run them
        // on given inputs and print the acceptance results
    	generateCFG1();
    	generateCFG1();
    	generateCFG1();
    	boolean[] a0 = {
    			isAccepted(generateCFG0(), new String[] {"2","0","2","0"}), 
    			isAccepted(generateCFG0(), new String[] {"1","2","0","2","0","1"}),
    			isAccepted(generateCFG0(), new String[] {"2","0","2","1"})
    	};
    	boolean[] a1 = {
    			isAccepted(generateCFG1(), new String[] {}), 
    			isAccepted(generateCFG1(), new String[] {"0","1","2","1"}),
    			isAccepted(generateCFG1(), new String[] {"2","1","0","0","1","0"})
    	};
    	boolean[] a2 = {
    			isAccepted(generateCFG2(), new String[] {"(","(",")",")"}), 
    			isAccepted(generateCFG2(), new String[] {"[","(",")","(","(",")",")","]"}),
    			isAccepted(generateCFG2(), new String[] {"[","(","(","(",")",")",")","(","]"})
    	};
    	boolean[] a3 = {
    			isAccepted(generateCFG3(), new String[] {"1","+","1"}), 
    			isAccepted(generateCFG3(), new String[] {"4","2","+","2"}),
    			isAccepted(generateCFG3(), new String[] {"1","+","2","+","3","*","4"})
    	};
    	String temp1 = "no";
    	String temp2 = "no";
    	String temp3 = "no";
    	if (a0[0] == true) {
    		temp1 = "yes";
    	}
    	if (a0[1] == true) {
    		temp2 = "yes";
    	}
    	if (a0[2] == true) {
    		temp3 = "yes";
    	}
    	System.out.println("G0 accepts: 2020 [" + temp1 + "], 120201 [" + temp2 + "], 2021 ["+temp3+"]");
    	temp1 = "no";
    	temp2 = "no";
    	temp3 = "no";
    	if (a1[0] == true) {
    		temp1 = "yes";
    	}
    	if (a1[1] == true) {
    		temp2 = "yes";
    	}
    	if (a1[2] == true) {
    		temp3 = "yes";
    	}
    	System.out.println("G1 accepts: epsilon [" + temp1 + "], 0121 [" + temp2 + "], 210010 ["+temp3+"]");
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
    	System.out.println("G2 accepts: (()) [" + temp1 + "], [()(())] [" + temp2 + "], [((()))(] ["+temp3+"]");
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
    	System.out.println("G3 accepts: 1+1 [" + temp1 + "], 42+2 [" + temp2 + "], 1+2+3*4 ["+temp3+"]");
    }

    public static Boolean isInCNF(CFG G) {
        // TODO return true if G is in Chomsky-Normal Form
        // and false otherwise
    	Boolean ans = true;
    	String temp1;
    	String temp2;
    	boolean cont1 = false;
    	boolean cont2 = false;
    	for (int i = 0; i < G.rules.length; i++) {
    		for(int j = 0; j < G.rules[i].rhs.length; j++) {
    			if (G.rules[i].rhs[j].equals(G.startVar)) {
    				ans = false; //Checks if any variables point to the start variable
    			}
    		}
    		if (G.rules[i].rhs.length > 2) {
    			ans = false; //Checks if any of the words are greater than two
    		}
    		if (!G.rules[i].var.equals(G.startVar)) {
    			if (G.rules[i].rhs.length == 0){
    				ans = false; //Checks if any variables point of epsilon
    			}
    		}
    		if (G.rules[i].rhs.length == 1) {
				temp1 = G.rules[i].rhs[0];
				for (int k = 0; k < G.vars.length; k++) {
					if (temp1.equals(G.vars[k])) {
						ans = false; //Checks if any variables point to another single variable
					}
				}
			}
			if (G.rules[i].rhs.length == 2) {
				temp1 = G.rules[i].rhs[0];
				temp2 = G.rules[i].rhs[1];
				cont1 = false;
				cont2 = false;
				for (int k = 0; k < G.vars.length; k++) {
					if(temp1.equals(G.vars[k])) {
						cont1 = true;
					}
					if(temp2.equals(G.vars[k])) {
						cont2 = true;
					}
				}
				if (!(cont1 && cont2)) {
					ans = false; //Checks if both characters are variables
				}
    		}
    	}
        return ans;
    }

    // DO NOT CHANGE THE REMAINING CODE
    
    /* Print CFG G, after checking it is valid. */
    public static void checkPrintCFG(CFG G, String name) {
        if(G==null) return;
        String s = G.check();
        if(s!="") System.out.println("Error found in "+name+":\n"+s);
        else System.out.println(name+" = "+G.toString());
    }
    
    /* Check if CFG G accepts word w -- naive implementation. */
    public static Boolean isAccepted(CFG G, String[] w) {
        ArrayDeque<String> s = new ArrayDeque<>();
        s.addFirst(G.startVar);
        return isAcceptedRec(G,w,s,0,2*w.length+1);
    }
        
    /* Test the isInCNF method on 10 CFGs. */
    public static void testIsInCNF() {
        int j, marks = 0;
        Object[] X = CFG.getSamples();
        CFG[] tests = (CFG[])X[0];
        Boolean[] res = (Boolean[])X[1];
        for(int i=0; i<tests.length; i++) {
            System.out.println("Test "+(i+1)+": "+tests[i].toString());
            j = (res[i]==isInCNF(tests[i])) ? 1 : 0;
            System.out.println("Result: "+j);
            marks += j;
        }
        System.out.println("Total: "+marks);
    }

    private static Boolean isAcceptedRec(CFG G, String[] w, ArrayDeque<String> s, int i, int bound) {
        if(bound<0) return false;
        if(s.isEmpty()) return (i==w.length);
        if(i==w.length) return false;
        String next = s.removeFirst();
        if(G.checkLetter(next)) {
            if(i==w.length || !next.equals(w[i])) return false;
            return isAcceptedRec(G,w,s,i+1,bound);
        }
        for(Rule r : G.rules)
            if(next.equals(r.var)) {
                ArrayDeque<String> s2= new ArrayDeque<String>(s);
                for(int j=r.rhs.length-1; j>=0; j--) s2.addFirst(r.rhs[j]);
                if(isAcceptedRec(G,w,s2,i,bound-1)) return true;
            }
        return false;
    }

}

