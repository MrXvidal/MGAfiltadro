package com.RNG;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public strictfp class MersenneTwister extends java.util.Random implements Serializable, Cloneable {

	private static final long serialVersionUID = -4035832775130174188L;
	private static final int N = 624;
	private static final int M = 397;
	private static final int MATRIX_A = 0x9908b0df;
	private static final int UPPER_MASK = 0x80000000;
	private static final int LOWER_MASK = 0x7fffffff;

	private static final int TEMPERING_MASK_B = 0x9d2c5680;
	private static final int TEMPERING_MASK_C = 0xefc60000;

	private int mt[];
	private int mti;
	private int mag01[];

	private double __nextNextGaussian;
	private boolean __haveNextNextGaussian;

	public Object clone() {
		try {
			MersenneTwister f = (MersenneTwister) (super.clone());
			f.mt = (int[]) (mt.clone());
			f.mag01 = (int[]) (mag01.clone());
			return f;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		} // should never happen
	}

	public synchronized boolean stateEquals(MersenneTwister other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		synchronized (other) {
			if (mti != other.mti)
				return false;
			for (int x = 0; x < mag01.length; x++)
				if (mag01[x] != other.mag01[x])
					return false;
			for (int x = 0; x < mt.length; x++)
				if (mt[x] != other.mt[x])
					return false;
			return true;
		}
	}

	public synchronized void readState(DataInputStream stream) throws IOException {
		int len = mt.length;
		for (int x = 0; x < len; x++)
			mt[x] = stream.readInt();

		len = mag01.length;
		for (int x = 0; x < len; x++)
			mag01[x] = stream.readInt();

		mti = stream.readInt();
		__nextNextGaussian = stream.readDouble();
		__haveNextNextGaussian = stream.readBoolean();
	}

	public synchronized void writeState(DataOutputStream stream) throws IOException {
		int len = mt.length;
		for (int x = 0; x < len; x++)
			stream.writeInt(mt[x]);

		len = mag01.length;
		for (int x = 0; x < len; x++)
			stream.writeInt(mag01[x]);

		stream.writeInt(mti);
		stream.writeDouble(__nextNextGaussian);
		stream.writeBoolean(__haveNextNextGaussian);
	}

	public MersenneTwister() {
		this(System.currentTimeMillis());
	}

	public MersenneTwister(long seed) {
		super(seed);
		setSeed(seed);
	}

	public MersenneTwister(int[] array) {
		super(System.currentTimeMillis());
		setSeed(array);
	}

	synchronized public void setSeed(long seed) {

		super.setSeed(seed);

		__haveNextNextGaussian = false;

		mt = new int[N];

		mag01 = new int[2];
		mag01[0] = 0x0;
		mag01[1] = MATRIX_A;

		mt[0] = (int) (seed & 0xffffffff);
		mt[0] = (int) seed;
		for (mti = 1; mti < N; mti++) {
			mt[mti] = (1812433253 * (mt[mti - 1] ^ (mt[mti - 1] >>> 30)) + mti);

		}
	}

	synchronized public void setSeed(int[] array) {
		if (array.length == 0)
			throw new IllegalArgumentException("Array length must be greater than zero");
		int i, j, k;
		setSeed(19650218);
		i = 1;
		j = 0;
		k = (N > array.length ? N : array.length);
		for (; k != 0; k--) {
			mt[i] = (mt[i] ^ ((mt[i - 1] ^ (mt[i - 1] >>> 30)) * 1664525)) + array[j] + j;

			i++;
			j++;
			if (i >= N) {
				mt[0] = mt[N - 1];
				i = 1;
			}
			if (j >= array.length)
				j = 0;
		}
		for (k = N - 1; k != 0; k--) {
			mt[i] = (mt[i] ^ ((mt[i - 1] ^ (mt[i - 1] >>> 30)) * 1566083941)) - i;

			i++;
			if (i >= N) {
				mt[0] = mt[N - 1];
				i = 1;
			}
		}
		mt[0] = 0x80000000;
	}

	synchronized protected int next(int bits) {
		int y;

		if (mti >= N) {
			int kk;
			final int[] mt = this.mt;
			final int[] mag01 = this.mag01;

			for (kk = 0; kk < N - M; kk++) {
				y = (mt[kk] & UPPER_MASK) | (mt[kk + 1] & LOWER_MASK);
				mt[kk] = mt[kk + M] ^ (y >>> 1) ^ mag01[y & 0x1];
			}
			for (; kk < N - 1; kk++) {
				y = (mt[kk] & UPPER_MASK) | (mt[kk + 1] & LOWER_MASK);
				mt[kk] = mt[kk + (M - N)] ^ (y >>> 1) ^ mag01[y & 0x1];
			}
			y = (mt[N - 1] & UPPER_MASK) | (mt[0] & LOWER_MASK);
			mt[N - 1] = mt[M - 1] ^ (y >>> 1) ^ mag01[y & 0x1];

			mti = 0;
		}

		y = mt[mti++];
		y ^= y >>> 11;
		y ^= (y << 7) & TEMPERING_MASK_B;
		y ^= (y << 15) & TEMPERING_MASK_C;
		y ^= (y >>> 18);

		return y >>> (32 - bits);
	}

	private synchronized void writeObject(ObjectOutputStream out) throws IOException {

		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
	}

	public boolean nextBoolean() {
		return next(1) != 0;
	}

	public boolean nextBoolean(float probability) {
		if (probability < 0.0f || probability > 1.0f)
			throw new IllegalArgumentException("probability must be between 0.0 and 1.0 inclusive.");
		if (probability == 0.0f)
			return false;
		else if (probability == 1.0f)
			return true;
		return nextFloat() < probability;
	}

	public boolean nextBoolean(double probability) {
		if (probability < 0.0 || probability > 1.0)
			throw new IllegalArgumentException("probability must be between 0.0 and 1.0 inclusive.");
		if (probability == 0.0)
			return false;
		else if (probability == 1.0)
			return true;
		return nextDouble() < probability;
	}

	public int nextInt(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n must be positive, got: " + n);

		if ((n & -n) == n)
			return (int) ((n * (long) next(31)) >> 31);

		int bits, val;
		do {
			bits = next(31);
			val = bits % n;
		} while (bits - val + (n - 1) < 0);
		return val;
	}

	public long nextLong(long n) {
		if (n <= 0)
			throw new IllegalArgumentException("n must be positive, got: " + n);

		long bits, val;
		do {
			bits = (nextLong() >>> 1);
			val = bits % n;
		} while (bits - val + (n - 1) < 0);
		return val;
	}

	public double nextDouble() {
		return (((long) next(26) << 27) + next(27)) / (double) (1L << 53);
	}

	public double nextDouble(boolean includeZero, boolean includeOne) {
		double d = 0.0;
		do {
			d = nextDouble();
			if (includeOne && nextBoolean())
				d += 1.0;
		} while ((d > 1.0) || (!includeZero && d == 0.0));
		return d;
	}

	public float nextFloat() {
		return next(24) / ((float) (1 << 24));
	}

	public float nextFloat(boolean includeZero, boolean includeOne) {
		float d = 0.0f;
		do {
			d = nextFloat();
			if (includeOne && nextBoolean())
				d += 1.0f;
		} while ((d > 1.0f) || (!includeZero && d == 0.0f));
		return d;
	}

	public void nextBytes(byte[] bytes) {
		for (int x = 0; x < bytes.length; x++)
			bytes[x] = (byte) next(8);
	}

	public char nextChar() {

		return (char) (next(16));
	}

	public short nextShort() {
		return (short) (next(16));
	}

	public byte nextByte() {
		return (byte) (next(8));
	}

	public synchronized void clearGaussian() {
		__haveNextNextGaussian = false;
	}

	synchronized public double nextGaussian() {
		if (__haveNextNextGaussian) {
			__haveNextNextGaussian = false;
			return __nextNextGaussian;
		} else {
			double v1, v2, s;
			do {
				v1 = 2 * nextDouble() - 1;
				v2 = 2 * nextDouble() - 1;
				s = v1 * v1 + v2 * v2;
			} while (s >= 1 || s == 0);
			double multiplier = StrictMath.sqrt(-2 * StrictMath.log(s) / s);
			__nextNextGaussian = v2 * multiplier;
			__haveNextNextGaussian = true;
			return v1 * multiplier;
		}
	}

	public double MersenneTwister() {
		
		return 0;
	}

	

	
}
