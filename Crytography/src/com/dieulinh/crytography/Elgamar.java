package com.dieulinh.crytography;

import java.math.BigInteger;
import java.util.*;
public class Elgamar {
	/**
	 * 
	 * @param p
	 * @param q
	 * @param r
	 * @return p^q modulo n;
	 */

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
	
	private static long encrypt1(long anpha, long k, long p) {
		long result=0;
		result=modulo(anpha,k,p);
		return result;
	}
	
	private static long encrypt2(Long x, Long beta, Long k, Long p) {
		Long result;
		BigInteger b=new BigInteger(x.toString());
		result=modulo(beta,k,p);
		BigInteger b2=new BigInteger(result.toString());
		BigInteger b3=new BigInteger(p.toString());
		b2=b.multiply(b2);
		b2=b2.mod(b3);
		String s=b2.toString();
		result=Long.parseLong(s);
		return result;
	}
	
	private static long eclip_extend(long on, long e) {
		long d=0;
		long s[]=new long[200];
		int n=0;
		long tmp;
		long r;
		long q[]=new long[200];
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
		return s[n+2];
	}
	
	private static long decrypt(Long y1, Long y2, Long a, Long p) {
		Long result;
		result=modulo(y1,a,p);
		result=eclip_extend(p,result);
		BigInteger b=new BigInteger(y2.toString());
		BigInteger b2=new BigInteger(result.toString());
		BigInteger b3=new BigInteger(p.toString());
		b2=b2.multiply(b);
		b2=b2.mod(b3);
		String s=b2.toString();
		result=Long.parseLong(s);
		return result;
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
	
	private static long pow(long q) {
		long s=1;
		for (long i=1;i<=q;i++) s=s*26;
		return s;
		
	}
	
	public static void main(String args[]) {
		long p;
		long anpha;
		long beta;
		long y1;
		long y2;
		long a;
		long k;
		long e;
		long q;
		Scanner in=new Scanner (System.in);
		e=1000000;
		q =10000000;
		while (!check(e)) {
			e++;
		}
		while (!check(q)) {
			q++;
		}
		p=e*q;
		while (!check(p)) {
			p++;
		}
		System.out.println(p);
		anpha=2;
		a=10000019;
		k=1000003;
		beta=modulo(anpha,a,p);
		System.out.println(beta);
		y1=encrypt1(anpha, k, p);
		long x=7*pow(7)+13*pow(5)+6*pow(4)+10*pow(3)+8*pow(2)+4*26+13;
		y2=encrypt2(x, beta, k, p);
		System.out.println(y1+"  "+y2+"  "+x);
		x=decrypt(y1, y2, a, p);
		System.out.println(x);
	}
}
