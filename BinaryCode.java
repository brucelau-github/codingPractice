public class BinaryCode {
	public String[] decode(String message) {

		String[] Q = message.split("");
		String[] decoded = new String[2];
		boolean isNone = false;
		StringBuffer sb = new StringBuffer();
		int[] P = new int[Q.length + 1];
		
		P[0] = 0;
		P[1] = Integer.parseInt(Q[0])-P[0];
		if(P[1] < 0 || P[1] > 1) {
				decoded[0] = "NONE";
				isNone = true;
		} else {
			sb.append("0"+String.valueOf(P[1]));

			for(int i = 1; i <  Q.length - 1; i++) {
				P[i+1] = Integer.parseInt(Q[i])-P[i-1]-P[i];
				if(P[i+1] < 0 || P[i+1] > 1) {
					decoded[0] = "NONE";
					isNone = true;
					break;
				} else {
					sb.append(String.valueOf(P[i+1]));
				}
			}
		}
		if(!isNone) decoded[0] = sb.toString();

		isNone = false;
		sb.delete(0,sb.length());
		P[0] = 1;
		P[1] = Integer.parseInt(Q[0])-P[0];
		if(P[1] < 0 || P[1] > 1) {
				decoded[1] = "NONE";
				isNone = true;
		} else {
			sb.append("1"+String.valueOf(P[1]));

			for(int i = 1; i <  Q.length - 1; i++) {
				P[i+1] = Integer.parseInt(Q[i])-P[i-1]-P[i];
				if(P[i+1] < 0 || P[i+1] > 1) {
					decoded[1] = "NONE";
					isNone = true;
					break;
				} else {
					sb.append(String.valueOf(P[i+1]));
				}
			}
		}
		if(!isNone) decoded[1] = sb.toString();

		return decoded;
	}
	public static void main(String[] args) {
		BinaryCode b = new BinaryCode();
		//{"011100011","NONE"}
		for(String s :b.decodeComplex("123210122"))
			System.out.println(s);

		//{"01","10"}
		for(String s :b.decode("11"))
			System.out.println(s);

		for(String s :b.decode("3"))
			System.out.println(s);


	}

	public String[] decodeComplex(String message) {
			String[] p = { "0", "1" };
			boolean[] pp = new boolean[2];
			for (int i = 0; i < message.length(); i++) {
				for (int j = 0; j < 2; j++) {
					int sum = 0;
					for (int k : new int[] { -1, 0 }) {
						if (i + k >= 0 && i + k < message.length()) {
							sum += p[j].charAt(i + k) - '0';
						// System.out.println("i:" + i + ", j:" + j + " i+k:"+ (i+k)+" sum:" +sum + " "+ p[j].charAt(i + k));
						}
					}
					int count = (message.charAt(i) - '0') - sum;
					if (!(count == 0 || count == 1)) {
						pp[j] = true;
					}
					if (i + 1 < message.length()) {
						p[j] += count;
					}

				}
			}
			for (int i = 0; i < pp.length; i++) {
				if (pp[i]) {
					p[i] = "NONE";
				}
			}
			return p;
	}
}
/**
*binary string encryption
*
*011100011 encrypt with its sum of its adjacent digits.
*123210122 
*Encryption algorithm
*Q[i] = P[i-1] + P[i] + P[i+1];
*Decryption algorithm
*1.
*Assume P[0] = 0
*P = 0111....
*return P
*2. 
*Assume P[0] = 1
*P=1013
*violate Binary 
*return NONE
*{"01110011100","NONE"}
**/