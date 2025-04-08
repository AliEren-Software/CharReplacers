import java.util.ArrayList;
import java.util.Scanner;

public class replacerv2 {
   private  String banned;
    private  String bannedwords;
    ArrayList<String> list = new ArrayList<>();
    private int bannedlistcounter=0;


    replacerv2(String bannedwords){
    this.bannedwords=bannedwords;
    bannedList();
}
    public String replacer(String a ) {
        if (bannedlistcounter == list.size()) {
            return a;
        }

        banned = list.get(bannedlistcounter);

        if (banned.length() <= a.length()){
        a = a.toLowerCase();
        String a2 = "";
        int count = 0;
        boolean control = false;

            for (int i = 0; i < a.length(); i++) {

                for (int i2 = 0, i3 = i; i2 < banned.length()&&i3<a.length(); i2++, i3++) {
                    if (a.charAt(i3) == banned.charAt(i2)) {
                        count++;
                        control = true;
                    }
                    else {
                        control=false;
                        break;
                    }
                }
                if (count == banned.length()&&control) {  // changes restricted word with '*'
                    for (int i4 = 0; i4 < banned.length(); i4++) {
                        a2 += "*";
                    }
                    i=i+banned.length()-1;
                    count = 0;
                    control =false;
                }
                else{
                    a2+=a.charAt(i);
                    count=0;
                }

            }
            if(bannedlistcounter<list.size()){
                bannedlistcounter++;
            }
            return replacer(a2);
    }
        else {
            return a;
        }

    }

    public void bannedList(){
        Scanner scan = new Scanner(bannedwords);
        while(scan.hasNext()){
            list.add(scan.next());
        }

    }

}

