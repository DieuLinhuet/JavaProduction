package com.dieulinh.crytography;

import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
	
	private static long modulo(Long p, Long q, Long r) {
		Long x=(long) 1;
		Long power=p%r;
		BigInteger b2=new BigInteger(r.toString());
		String s;
		while (q!=0) {
			BigInteger b=new BigInteger(power.toString());
			if (q%2==1) {
				BigInteger a=new BigInteger(x.toString());
				a=a.multiply(b);
				a=a.mod(b2);
				s=a.toString();
				x=Long.parseLong(s);
			}
			b=b.multiply(b);
			b=b.mod(b2);
			s=b.toString();
			power=Long.parseLong(s);
			q=q/2;
		}
		return x;
		
	}
	
	public static long eclip_extend(long on, long e ) {
		long d=0;
		long m=on;
		long s[]=new long[10000];
		int n=0;
		long tmp;
		long r;
		long q[]=new long[10000];
		while (e!=0) {
			q[n]=on/e;
			r=on%e;
			on=e;
			e=r;
			n++;
		}
		n=n-2;
		s[0]=0;
		s[1]=1;
		for (int i=2;i<=n+2;i++) {
			s[i]=s[i-2]-s[i-1]*q[n-i+2];
		}
		if (s[n+2]<0) s[n+2]+=m;
		return s[n+2];
	}
	
	public static long encrypt(long c,long d,long n) {
		return modulo(c,d,n);
	}
	
	public static long decrypt(long m,long e,long n) {
		return modulo(m,e,n);
	}
	
	public static long pow(long q ) {
		long s=1;
		for (long i=1;i<=q;i++) s=s*26;
		return s;
		
	}

	private static boolean check(long n) {
		boolean ok=true;
		for (int i=2;i<Math.sqrt(n);i++) {
			if (n%i==0) {
				ok=false;
				break;
			}
		}
		return ok;
	}
	
	public static void main(String args[]) {
		long p,q;
		long n;
		long on;
		long d;
		long e;
		long m;
		Scanner in=new Scanner(System.in);
		//p=in.nextLong();
		//q=in.nextLong();
		//e=in.nextLong();
		//n=p*q;
		//on=(p-1)*(q-1);
		p=1000000;
		q =10000000;
		while (!check(p)) {
			p++;
		}
		while (!check(q)) {
			q++;
		}
		e=p*q;
		int ok=100;
		while (!check(e)) {
			e++;
		}
		System.out.println(e);
		n=p*q;
		on=(p-1)*(q-1);
		d=eclip_extend(on, e);
		System.out.println(d);
		long c=7*pow(7)+13*pow(5)+6*pow(4)+10*pow(3)+8*pow(2)+4*26+13;
		System.out.println(c);
		m=modulo(c,d,n);
		System.out.println(m);
		System.out.println(modulo(m, e, n));
	}
}
