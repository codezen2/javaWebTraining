package com.sapient.service;

public class SimpleSer implements ISer {

	@Override
	public double calcSimple(double p, int n, float r) {

		return p * r * n / 100.0;
	}

}
