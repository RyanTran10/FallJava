package introJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//1. Take a string as parameter. Collect any character from the string that is alphabetically adjacent 
//(d and e are adjacent) to both of its neighbors. Print out this series of characters.  (starts with "py")

//3. Take a string as parameter. Collect all the characters from the string that occur an even number of times. 
//Print out these characters, in order from highest number of appearances to lowest. (starts with "kv")
// 
//
//4. Take two strings as parameters. Find all shared consecutive quartets in the two strings. 
//For example, "526847" and "268431" has one overlapping quartet: 2, 6, 8, 4. Sum the contents of each quartet, and print this sum. So this example would print 20. (has two strings)


public class ScavengerHunt {
	public static void prob3(String s) {
		
	}
	private static void calcFrequencies(String s) {
		
		int[] freqs = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
				freqs[s.charAt(i)-97] ++;
			} else if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
				freqs[s.charAt(i)-65] ++;
			}
		}
		for(int i = 1; i < freqs.length; i++) {
			if(freqs[i] % 2 == 0) {
				System.out.println((char)(i+97) + " " +freqs[i]);
			}
		}
		int[] evenlets = new int[13];
//		for(int i = 0; i < evenlets.length; i++) {
//			int max = i;
//			for(int j = 0; j < evenlets.length; j++) {
//				if(evenlets[j])
//			}
//			
//		}

	}
	public static void prob2(String c1, String c2) {
        String[] c1s = c1.split("");
        String[] c2s = c2.split("");

        ArrayList<Integer> c = new ArrayList<Integer>();

        for(int i=0; i<c1s.length-3; i++) {
            for(int j=0; j<c2s.length-3; j++) {
                if(Integer.parseInt(c1s[i]) == Integer.parseInt(c2s[j]) && Integer.parseInt(c1s[i+1]) == Integer.parseInt(c2s[j+1] ) 
                        &&Integer.parseInt(c1s[i+2]) == Integer.parseInt(c2s[j+2])&&Integer.parseInt(c1s[i+3]) == Integer.parseInt(c2s[j+3])) {
                    c.add(Integer.parseInt(c1s[i])+Integer.parseInt(c1s[i+1])+Integer.parseInt(c1s[i+2])+Integer.parseInt(c1s[i+3]));
                }
            }
        }
        System.out.println(c);
//        int ans = 0;
//        for(int i=0; i<c.size(); i++) {
//            ans += c.get(i);
//        }
//
//
//        System.out.println(ans);

    }
	public static void problem3(String s) {
        HashMap<Character,Integer> freqMap = new HashMap<Character,Integer>();

        for(int i=0; i<s.length(); i++) {
            if(freqMap.containsKey(s.charAt(i))) {
                int currVal = freqMap.get(s.charAt(i)) + 1;
                freqMap.put(s.charAt(i), currVal);
            }else {
                freqMap.put(s.charAt(i), 1);
            }
        }

        HashMap<Character, Integer> Even = new HashMap<Character, Integer>();
        for(char key: freqMap.keySet()) {
            if(freqMap.get(key) % 2 ==0) {
                Even.put(key,freqMap.get(key));
            }
        }
        Object[] a = Even.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<Character, Integer>) o2).getValue()
                           .compareTo(((Map.Entry<Character, Integer>) o1).getValue());
            }
        });
        for (Object e : a) {
            System.out.print(((Map.Entry<Character, Integer>) e).getKey());
        }
    }
	public static void print(int[] arr) {
		System.out.print("kv");
		for(int i = 0; i < arr.length; i++) {
			System.out.print((char)(arr[i]+97));
		}
	}
	public static void prob1(String s) {
		String str = "";
		for(int i = 1; i < s.length()-1; i++) {
//			System.out.println(str.charAt(i)-1 == str.charAt(i-1) && str.charAt(i)+1 == str.charAt(i+1));
			if(s.charAt(i)-1 == s.charAt(i-1) && s.charAt(i)+1 == s.charAt(i+1)) {
				System.out.print(s.charAt(1));
			}
		}
	}
	private static void mostCommon(String[] words) {
		int[] freqs = new int[40];
		
		for(int i = 0; i < words.length; i++) {
			freqs[words[i].length()] ++;
		}
		int max = freqs[0];
		int maxind = 0;
		for(int i = 1; i < freqs.length; i++) {
			if(freqs[i] > max) {
				max = freqs[i];
				maxind = i;
			}
		}
		System.out.println(maxind);
	}
	
	public static void problem5(String[] words) {
		for(int j = 0; j < 26; j++) {
			for(int i = 0; i < words.length; i++) {
				if(words[i].length() == 7 && words[i].charAt(0) == 'a' + j) {
					System.out.println(words[i]);
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		prob2("37511048612265375838753422854310325851548618404283210255051860706526011781184357102414000067014361273607225081313560326206025804553535852786224748764602642004001627048288441443665372477646228441884533413738221178851754753776405888143021423850156414073633135637147862100234184371875068767518686544564236283514410022542165070677645824778105422501682230147241236084411258530484086236755068644410107364554507058567430762287386177740631248132126333410578873084583852481001017514844203246722255031601467503358725434164225656138804432720864321773320401781342763778353682330210716362211514028707287848617442471821315081560541313370611342415648831243880024303155882353267723685042612266717020542366805448652287153761267430174605617418141742215520455583345466078547218382310616400050164454387634342472353058265887710455316280253374464088112713173787820866652057840745106506606488740548632265862614302655766172034441630045278600725214817265402411205588054754372773060405340011340600082755472043855887758053848435823756157163685173468408710820401310404812232607813047308054673402816554121365285502374733265415585331401715436257724173383468488124500337203467504677304006020028085016037684006571821530622207288782435463267668072707203878627884381384348581168064223262536700085624762214256888282234078054373526427672758684465678574323170136734608050365225374587123541530710365375048585806217405074357065208832000", "6989506129717191687533973955401237940057737494829170755123122917877350958972343647283103966616959826811532709967782171830737731960399122819851037726102087691099047408404987589718937249355783474311157676519228271563557773274413350599677409208741714559115092659386301639545699265680332910014878419685962517047706994739203679707918469484650348210120790268396872243378803237977624523782322223992557964181991461817193930699302089454249882517902383589526189625170444093075952661301084299955466237872913199984400889675789548371157099570159493811307718599627508006296064406096599530251745981471424657341242507717479348960748227564770892735044878512233764916327899301389104924991365913038060863561871353901942019127400999937216352726649011096766033819985832967749090295628225982457932794198073213750965157059139823086533650874552893634050942662316519961914382000");
	}
	
}