import java.io.BufferedReader;//HarunBuyuktepe_150115020
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class HarunBuyuktepe_150115020{
	private static final String FILENAME = "C:\\txt.txt";
	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;
		try {//get the input line by line from adress
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String code;
			br = new BufferedReader(new FileReader(FILENAME));
			while ((code = br.readLine()) != null) {//loop stops when see null value in text
				System.out.println(code);
				for(int i=0;i<code.length();i++){//condition is set to find undefined character
					if(code.charAt(i)==48||code.charAt(i)==49&&code.length()==16){
						
					}
					else{
						System.out.print("\nYour entery is invaliable!!!\nPlease run program again with true code!!");
						break;
					}
				}
				char[] opcode=new char [4];
				String opCode="";
				for(int j=0;j<4;j++){//find opcode in line and collect on character array
					opcode[j]=code.charAt(j);
					opCode+=opcode[j];//concatenate on string to compare to defined string
				}
				System.out.print(""+opCode);
				String add="0001",and="0101",br1="0000",jmp="1100",ld="0010",ldi="1010",ldr="0110",lea="1110",not="1001",st="0011",sti="1011",str="0111",reserved="1101";
				if(opCode.equals(add)){
					System.out.println(" This is add operation.");
					System.out.println(add(code));//get method of add
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(and)){
					System.out.println(" This is and operation.");
					System.out.println(and(code));//get method and
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(br1)){
					System.out.println(" This is branch operation.");
					System.out.println(br1(code));//get method branch
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(jmp)){
					System.out.println(" This is jump operation.");
					System.out.println(jump(code));//get method jump
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(ld)){
					System.out.println(" This is ld operation.");
					System.out.println(ld(code));//get method ld
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(ldi)){
					System.out.println(" This is ldi operation.");
					System.out.println(ldi(code));//get method ldi
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(ldr)){
					System.out.println(" This is ldr operation.");
					System.out.println(ldr(code));//get method ldr
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(lea)){
					System.out.println(" This is lea operation.");
					System.out.println(lea(code));//get method lea
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(not)){
					System.out.println(" This is not operation.");
					System.out.println(not(code));//get method not
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(st)){
					System.out.println(" This is st operation.");
					System.out.println(st(code));//get method st
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(sti)){
					System.out.println(" This is sti operation.");
					System.out.println(sti(code));//get method sti
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(str)){
					System.out.println(" This is str operation.");
					System.out.println(str(code));//get method str
					System.out.println("--------------------------------\n");
				}
				if(opCode.equals(reserved)){
					System.out.println("\nThis is reversed operation.\nNot now...\nComing soon...");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
public static String add(String code){//method has 2 option to give result
	if(code.charAt(10)==48){//is firt option to use condition of if
		char[] DR=new char [3];
		char[] SR=new char [3];
		char[] SR2=new char [3];
		int[] dr=new int[3];
		int[] sr=new int[3];
		int[] sr2=new int[3];
		for(int i=0;i<3;i++){//find Dr SR and SR2
			DR[i]=code.charAt(i+4);
			SR[i]=code.charAt(i+7);
			SR2[i]=code.charAt(i+13);
			if(DR[i]==48){// to convert character to integer
				dr[i]=0;
			}
			else{
				dr[i]=1;
			}
			if(SR[i]==48){
				sr[i]=0;
			}
			else{
				sr[i]=1;
			}
			if(SR2[i]==48){
				sr2[i]=0;
			}
			else{
				sr2[i]=1;
			}
		}
	return "ADD R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+(sr[0]*4+sr[1]*2+sr[2])+" R"+(sr2[0]*4+sr2[1]*2+sr2[2]);//given result to main class
	}
	else{//is second option to use condition of else
		char[] DR=new char [3];
		char[] SR=new char [3];
		char[] SR2=new char [5];
		int[] dr=new int[3];
		int[] sr=new int[3];
		int[] sr2=new int[5];
		for(int i=0;i<3;i++){// to find Dr and SR  and to convert character to integer
			DR[i]=code.charAt(i+4);
			SR[i]=code.charAt(i+7);
			if(DR[i]==48){
				dr[i]=0;
			}
			else{
				dr[i]=1;
			}
			if(SR[i]==48){
				sr[i]=0;
			}
			else{
				sr[i]=1;
			}
		}
		for(int j=0;j<5;j++){// to find Dr and SR  and to convert character to integer
			SR2[j]=code.charAt(j+11);
			if(SR2[j]==48){
				sr2[j]=0;
			}
			else{
				sr2[j]=1;
			}
		}
		if(code.charAt(11)==49){//imm5 is two's complement so we use if condition to find result
			return "ADD R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+(sr[0]*4+sr[1]*2+sr[2])+" #"+"-"+(16-(sr2[1]*8+sr2[2]*4+sr2[3]*2+sr2[4]*1)); //given result to main class
		}
		else{
			return "ADD R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+(sr[0]*4+sr[1]*2+sr[2])+" #"+(sr2[1]*8+sr2[2]*4+sr2[3]*2+sr2[4]*1); //given result to main class
		}	
	}
}
public static String and(String code){//method has 2 option to give result
	if(code.charAt(10)==48&&code.charAt(11)==48&&code.charAt(12)==48){//is firt option to use condition of if
		char[] DR=new char [3];
		char[] SR=new char [3];
		char[] SR2=new char [3];
		int[] dr=new int[3];
		int[] sr=new int[3];
		int[] sr2=new int[3];
		for(int i=0;i<3;i++){// to find variables  and to convert character to integer
			DR[i]=code.charAt(i+4);
			SR[i]=code.charAt(i+7);
			SR2[i]=code.charAt(i+13);
			if(DR[i]==48){
				dr[i]=0;
			}
			else{
				dr[i]=1;
			}
			if(SR[i]==48){
				sr[i]=0;
			}
			else{
				sr[i]=1;
			}
			if(SR2[i]==48){
				sr2[i]=0;
			}
			else{
				sr2[i]=1;
			}
		}
		return "AND R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+(sr[0]*4+sr[1]*2+sr[2])+" R"+(sr2[0]*4+sr2[1]*2+sr2[2]);
	}
	else if(code.charAt(10)==49){
		char[] DR=new char [3];
		char[] SR=new char [3];
		char[] SR2=new char [5];
		int[] dr=new int[3];
		int[] sr=new int[3];
		int[] sr2=new int[5];
		for(int i=0;i<3;i++){// to find variables  and to convert character to integer
			DR[i]=code.charAt(i+4);
			SR[i]=code.charAt(i+7);
			if(DR[i]==48){
				dr[i]=0;
			}
			else{
				dr[i]=1;
			}
			if(SR[i]==48){
				sr[i]=0;
			}
			else{
				sr[i]=1;
			}
		}
		for(int j=0;j<5;j++){// to find variables  and to convert character to integer
			SR2[j]=code.charAt(j+11);
			if(SR2[j]==48){
				sr2[j]=0;
			}
			else{
				sr2[j]=1;
			}
		}
		if(code.charAt(11)==49){
			return "AND R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+(sr[0]*4+sr[1]*2+sr[2])+" #"+"-"+(16-(sr2[1]*8+sr2[2]*4+sr2[3]*2+sr2[4]*1)); 
		}
		else{
			return "AND R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+(sr[0]*4+sr[1]*2+sr[2])+" #"+(sr2[1]*8+sr2[2]*4+sr2[3]*2+sr2[4]*1); 
		}	
	}
	else{//is second option to use condition of else to find invalid value
		return ("\nYour entery is invaliable!!!\nPlease run program again with true code!!");
	}
}
public static String br1(String code){
	String a="",b="";
	char[] hex2=new char [4];
	char[] hex3=new char [4];
	char[] branch=new char [3];
	for(int i=0;i<3;i++){
		branch[i]=code.charAt(i+4);
	}
	if(branch[0]==49){
		a+="n";
	}
	if(branch[1]==49){
		a+="z";
	}
	if(branch[2]==49){
		a+="p";
	}
	if(code.charAt(7)=='1'){
		b+="F";
	}
	else{
		b+="0";
	}
	for(int i=0;i<4;i++){// to find variables  and to convert character to integer
		hex2[i]=code.charAt(i+8);
		hex3[i]=code.charAt(i+12);
	}
	int[] hexa2=new int [4];
	int[] hexa3=new int [4];
	for(int j=0;j<4;j++){
		if(hex2[j]==48){
			hexa2[j]=0;
		}
		else{
			hexa2[j]=1;
		}
		if(hex3[j]==48){
			hexa3[j]=0;
		}
		else{
			hexa3[j]=1;
		}
	}
	String result="";
	int sum2,sum3;
	sum2=hexa2[0]*8+hexa2[1]*4+hexa2[2]*2+hexa2[3];
	sum3=hexa3[0]*8+hexa3[1]*4+hexa3[2]*2+hexa3[3];
	if(sum2<10){
		result="BR"+a+" x"+b+""+(sum2);
	}
	else if(sum2>=10){
		if(sum2==10){
			result="BR"+a+" x"+b+"A";
		}
		else if(sum2==11){
			result="BR"+a+" x"+b+"B";
		}
		else if(sum2==12){
			result="BR"+a+" x"+b+"C";
		}
		else if(sum2==13){
			result="BR"+a+" x"+b+"D";
		}
		else if(sum2==14){
			result="BR"+a+" x"+b+"E";
		}
		else if(sum2==15){
			result="BR"+a+" x"+b+"F";
		}
	}
	if(sum3<10){
		result+=""+sum3;
	}
	else if(sum3>=10){
		if(sum3==10){
			result+="A";
		}
		else if(sum3==11){
			result+="B";
		}
		else if(sum3==12){
			result+="C";
		}
		else if(sum3==13){
			result+="D";
		}
		else if(sum3==14){
			result+="E";
		}
		else if(sum3==15){
			result+="F";
		}
	}
	return result;
}
public static String jump(String code){
	char[] jumpSpace1=new char [3];
	char[] jumpSpace2=new char [6];
	for(int i=0;i<3;i++){
		jumpSpace1[i]=code.charAt(i+4);
		if(jumpSpace1[i]=='1'){
			System.out.println("Your entery is invaliable!!!\nPlease run program again with true code!!");
			break;
		}
	}
	for(int j=0;j<6;j++){
		jumpSpace2[j]=code.charAt(j+10);
		if(jumpSpace2[j]=='1'){
			System.out.println("Your entery is invaliable!!!\nPlease run program again with true code!!");
			break;
		}
	}
	char[] result=new char [3];
	int[] baseR=new int [3];
	for(int k=0;k<3;k++){// to find variables  and to convert character to integer
		result[k]=code.charAt(k+7);
		if(result[k]=='1'){
			baseR[k]=1;
		}
		else{
			baseR[k]=0;
		}
	}
	return "JUMP R"+(baseR[0]*4+baseR[1]*2+baseR[2]);
}
public static String ld(String code){
	char[] DR=new char [3];
	int[] dr=new int[3];
	for(int i=0;i<3;i++){// to find variables  and to convert character to integer
		DR[i]=code.charAt(i+4);
		if(DR[i]==48){
			dr[i]=0;
		}
		else{
			dr[i]=1;
		}
	}
	int[] hexa2=new int [4];
	int[] hexa3=new int [4];
	String b="";
	if(code.charAt(7)=='1'){
		b+="F";
	}
	else{
		b+="0";
	}
	for(int k=0;k<4;k++){// to find variables  and to convert character to integer
		if(code.charAt(8+k)=='1'){
			hexa2[k]=1;
		}
		else{
			hexa2[k]=0;
		}
		if(code.charAt(12+k)=='1'){
			hexa3[k]=1;
		}
		else{
			hexa3[k]=0;
		}
	}
	int sum2,sum3;
	sum2=hexa2[0]*8+hexa2[1]*4+hexa2[2]*2+hexa2[3];
	sum3=hexa3[0]*8+hexa3[1]*4+hexa3[2]*2+hexa3[3];
	if(sum2<10){
		b+=""+(sum2);
	}
	else if(sum2>=10){
		if(sum2==10){
			b+=""+"A";
		}
		else if(sum2==11){
			b+=""+"B";
		}
		else if(sum2==12){
			b+=""+"C";
		}
		else if(sum2==13){
			b+=""+"D";
		}
		else if(sum2==14){
			b+=""+"E";
		}
		else if(sum2==15){
			b+=""+"F";
		}
	}
	if(sum3<10){
		b+=""+(sum3);
	}
	else if(sum3>=10){
		if(sum3==10){
			b+=""+"A";
		}
		else if(sum3==11){
			b+=""+"B";
		}
		else if(sum3==12){
			b+=""+"C";
		}
		else if(sum3==13){
			b+=""+"D";
		}
		else if(sum3==14){
			b+=""+"E";
		}
		else if(sum3==15){
			b+=""+"F";
		}
	}
	return "LD R"+(dr[0]*4+dr[1]*2+dr[2])+" x"+b;
}
public static String ldi(String code){
		char[] DR=new char [3];
		int[] dr=new int[3];
		for(int i=0;i<3;i++){// to find variables  and to convert character to integer
			DR[i]=code.charAt(i+4);
			if(DR[i]==48){
				dr[i]=0;
			}
			else{
				dr[i]=1;
			}
		}
		int[] hexa2=new int [4];
		int[] hexa3=new int [4];
		String b="";
		if(code.charAt(7)=='1'){
			b+="F";
		}
		else{
			b+="0";
		}
		for(int k=0;k<4;k++){// to find variables  and to convert character to integer
			if(code.charAt(8+k)=='1'){
				hexa2[k]=1;
			}
			else{
				hexa2[k]=0;
			}
			if(code.charAt(12+k)=='1'){
				hexa3[k]=1;
			}
			else{
				hexa3[k]=0;
			}
		}
		int sum2,sum3;
		sum2=hexa2[0]*8+hexa2[1]*4+hexa2[2]*2+hexa2[3];
		sum3=hexa3[0]*8+hexa3[1]*4+hexa3[2]*2+hexa3[3];
		if(sum2<10){
			b+=""+(sum2);
		}
		else if(sum2>=10){
			if(sum2==10){
				b+=""+"A";
			}
			else if(sum2==11){
				b+=""+"B";
			}
			else if(sum2==12){
				b+=""+"C";
			}
			else if(sum2==13){
				b+=""+"D";
			}
			else if(sum2==14){
				b+=""+"E";
			}
			else if(sum2==15){
				b+=""+"F";
			}
		}
		if(sum3<10){
			b+=""+(sum3);
		}
		else if(sum3>=10){
			if(sum3==10){
				b+=""+"A";
			}
			else if(sum3==11){
				b+=""+"B";
			}
			else if(sum3==12){
				b+=""+"C";
			}
			else if(sum3==13){
				b+=""+"D";
			}
			else if(sum3==14){
				b+=""+"E";
			}
			else if(sum3==15){
				b+=""+"F";
			}
		}
		return "LDI R"+(dr[0]*4+dr[1]*2+dr[2])+" x"+b;
	}
public static String ldr(String code){
	char[] DR=new char [3];
	char[] SR=new char [3];
	int[] dr=new int[3];
	int[] sr=new int[3];
	for(int i=0;i<3;i++){// to find variables  and to convert character to integer
		DR[i]=code.charAt(i+4);
		SR[i]=code.charAt(i+7);
		if(DR[i]==48){
			dr[i]=0;
		}
		else{
			dr[i]=1;
		}
		if(SR[i]==48){
			sr[i]=0;
		}
		else{
			sr[i]=1;
		}
	}
	char[] SR2=new char [6];
	int[] sr2=new int[6];
	for(int j=0;j<6;j++){// to find variables  and to convert character to integer
		SR2[j]=code.charAt(j+10);
		if(SR2[j]==48){
			sr2[j]=0;
		}
		else{
			sr2[j]=1;
		}
	}
	if(code.charAt(10)=='0'){
		return "LDR R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+((sr[0]*4+sr[1]*2+sr[2]))+" #"+(sr2[1]*16+sr2[2]*8+sr2[3]*4+sr2[4]*2+sr2[5]);
	}
	else{
		return "LDR R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+((sr[0]*4+sr[1]*2+sr[2]))+" #-"+(32-(sr2[1]*16+sr2[2]*8+sr2[3]*4+sr2[4]*2+sr2[5]));
	}
}
public static String lea(String code){
	char[] DR=new char [3];
	for(int i=0;i<3;i++){// to find variables  and to convert character to integer
		DR[i]=code.charAt(i+4);
	}
	int[] dr=new int[3];
	for(int j=0;j<3;j++){// to find variables  and to convert character to integer
		if(DR[j]==48){
			dr[j]=0;
		}
		else{
			dr[j]=1;
		}
	}	
	int[] hexa2=new int [4];
	int[] hexa3=new int [4];
	String b="";
	if(code.charAt(7)=='1'){
		b+="F";
	}
	else{
		b+="0";
	}
	for(int k=0;k<4;k++){// to find variables  and to convert character to integer
		if(code.charAt(8+k)=='1'){
			hexa2[k]=1;
		}
		else{
			hexa2[k]=0;
		}
		if(code.charAt(12+k)=='1'){
			hexa3[k]=1;
		}
		else{
			hexa3[k]=0;
		}
	}
	int sum2,sum3;
	sum2=hexa2[0]*8+hexa2[1]*4+hexa2[2]*2+hexa2[3];
	sum3=hexa3[0]*8+hexa3[1]*4+hexa3[2]*2+hexa3[3];
	if(sum2<10){
		b+=""+(sum2);
	}
	else if(sum2>=10){
		if(sum2==10){
			b+=""+"A";
		}
		else if(sum2==11){
			b+=""+"B";
		}
		else if(sum2==12){
			b+=""+"C";
		}
		else if(sum2==13){
			b+=""+"D";
		}
		else if(sum2==14){
			b+=""+"E";
		}
		else if(sum2==15){
			b+=""+"F";
		}
	}
	if(sum3<10){
		b+=""+(sum3);
	}
	else if(sum3>=10){
		if(sum3==10){
			b+=""+"A";
		}
		else if(sum3==11){
			b+=""+"B";
		}
		else if(sum3==12){
			b+=""+"C";
		}
		else if(sum3==13){
			b+=""+"D";
		}
		else if(sum3==14){
			b+=""+"E";
		}
		else if(sum3==15){
			b+=""+"F";
		}
	}
	return "LEA R"+(dr[0]*4+dr[1]*2+dr[2])+" x"+b;
}
public static String not(String code){
	char[] DR=new char [3];
	char[] SR=new char [3];
	int[] dr=new int[3];
	int[] sr=new int[3];
	for(int i=0;i<3;i++){// to find variables  and to convert character to integer
		DR[i]=code.charAt(i+4);
		SR[i]=code.charAt(i+7);
		if(DR[i]==48){
			dr[i]=0;
		}
		else{
			dr[i]=1;
		}
		if(SR[i]==48){
			sr[i]=0;
		}
		else{
			sr[i]=1;
		}
	}
	return "NOT R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+(sr[0]*4+sr[1]*2+sr[2]);
}
public static String st(String code){
	char[] DR=new char [3];
	int[] dr=new int[3];
	for(int i=0;i<3;i++){// to find variables  and to convert character to integer
		DR[i]=code.charAt(i+4);
		if(DR[i]==48){
			dr[i]=0;
		}
		else{
			dr[i]=1;
		}
	}
	int[] hexa2=new int [4];
	int[] hexa3=new int [4];
	String b="";
	if(code.charAt(7)=='1'){
		b+="F";
	}
	else{
		b+="0";
	}
	for(int k=0;k<4;k++){// to find variables  and to convert character to integer
		if(code.charAt(8+k)=='1'){
			hexa2[k]=1;
		}
		else{
			hexa2[k]=0;
		}
		if(code.charAt(12+k)=='1'){
			hexa3[k]=1;
		}
		else{
			hexa3[k]=0;
		}
	}
	int sum2,sum3;
	sum2=hexa2[0]*8+hexa2[1]*4+hexa2[2]*2+hexa2[3];
	sum3=hexa3[0]*8+hexa3[1]*4+hexa3[2]*2+hexa3[3];
	if(sum2<10){
		b+=""+(sum2);
	}
	else if(sum2>=10){
		if(sum2==10){
			b+=""+"A";
		}
		else if(sum2==11){
			b+=""+"B";
		}
		else if(sum2==12){
			b+=""+"C";
		}
		else if(sum2==13){
			b+=""+"D";
		}
		else if(sum2==14){
			b+=""+"E";
		}
		else if(sum2==15){
			b+=""+"F";
		}
	}
	if(sum3<10){
		b+=""+(sum3);
	}
	else if(sum3>=10){
		if(sum3==10){
			b+=""+"A";
		}
		else if(sum3==11){
			b+=""+"B";
		}
		else if(sum3==12){
			b+=""+"C";
		}
		else if(sum3==13){
			b+=""+"D";
		}
		else if(sum3==14){
			b+=""+"E";
		}
		else if(sum3==15){
			b+=""+"F";
		}
	}
	return "ST R"+(dr[0]*4+dr[1]*2+dr[2])+" x"+b;
}
public static String sti(String code){
	char[] DR=new char [3];
	int[] dr=new int[3];
	for(int i=0;i<3;i++){// to find variables  and to convert character to integer
		DR[i]=code.charAt(i+4);
		if(DR[i]==48){
			dr[i]=0;
		}
		else{
			dr[i]=1;
		}
	}
	int[] hexa2=new int [4];
	int[] hexa3=new int [4];
	String b="";
	if(code.charAt(7)=='1'){
		b+="F";
	}
	else{
		b+="0";
	}
	for(int k=0;k<4;k++){// to find variables  and to convert character to integer
		if(code.charAt(8+k)=='1'){
			hexa2[k]=1;
		}
		else{
			hexa2[k]=0;
		}
		if(code.charAt(12+k)=='1'){
			hexa3[k]=1;
		}
		else{
			hexa3[k]=0;
		}
	}
	int sum2,sum3;
	sum2=hexa2[0]*8+hexa2[1]*4+hexa2[2]*2+hexa2[3];
	sum3=hexa3[0]*8+hexa3[1]*4+hexa3[2]*2+hexa3[3];
	if(sum2<10){
		b+=""+(sum2);
	}
	else if(sum2>=10){
		if(sum2==10){
			b+=""+"A";
		}
		else if(sum2==11){
			b+=""+"B";
		}
		else if(sum2==12){
			b+=""+"C";
		}
		else if(sum2==13){
			b+=""+"D";
		}
		else if(sum2==14){
			b+=""+"E";
		}
		else if(sum2==15){
			b+=""+"F";
		}
	}
	if(sum3<10){
		b+=""+(sum3);
	}
	else if(sum3>=10){
		if(sum3==10){
			b+=""+"A";
		}
		else if(sum3==11){
			b+=""+"B";
		}
		else if(sum3==12){
			b+=""+"C";
		}
		else if(sum3==13){
			b+=""+"D";
		}
		else if(sum3==14){
			b+=""+"E";
		}
		else if(sum3==15){
			b+=""+"F";
		}
	}
	return "STI R"+(dr[0]*4+dr[1]*2+dr[2])+" x"+b;
}
public static String str(String code){
	char[] DR=new char [3];
	char[] SR=new char [3];
	int[] dr=new int[3];
	int[] sr=new int[3];
	for(int i=0;i<3;i++){// to find variables  and to convert character to integer
		DR[i]=code.charAt(i+4);
		SR[i]=code.charAt(i+7);
		if(DR[i]==48){
			dr[i]=0;
		}
		else{
			dr[i]=1;
		}
		if(SR[i]==48){
			sr[i]=0;
		}
		else{
			sr[i]=1;
		}
	}
	char[] SR2=new char [6];
	int[] sr2=new int[6];
	for(int j=0;j<6;j++){// to find variables  and to convert character to integer
		SR2[j]=code.charAt(j+10);
		if(SR2[j]==48){
			sr2[j]=0;
		}
		else{
			sr2[j]=1;
		}
	}
	if(code.charAt(10)=='0'){
		return "STR R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+((sr[0]*4+sr[1]*2+sr[2]))+" #"+(sr2[1]*16+sr2[2]*8+sr2[3]*4+sr2[4]*2+sr2[5]);
	}
	else{
		return "STR R"+(dr[0]*4+dr[1]*2+dr[2])+" R"+((sr[0]*4+sr[1]*2+sr[2]))+" #-"+(32-(sr2[1]*16+sr2[2]*8+sr2[3]*4+sr2[4]*2+sr2[5]));
	}
}
}
