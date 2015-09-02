package com.sudar.java;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

public class WriteToFileStepHandler implements StepHandler {
	
	ArrayList<String> steps = new ArrayList<String>();
	String filename;

	public WriteToFileStepHandler(String filename) {
		this.filename = filename;
	}

	@Override
	public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
		double t = interpolator.getCurrentTime();
		double[] y = interpolator.getInterpolatedState();
		String onestep = "" + t;
		for (int i = 0; i < y.length; i++) {
			onestep += ", " + y[i];
		}
		steps.add(onestep);
		if (isLast) {
			try {
				PrintWriter writer = new PrintWriter(new File(filename), "UTF-8");
				for (String step : steps) {
					writer.println(step);
				}
				writer.close();
			} catch (Exception e) {
			}
			;
		}
	}

	@Override
	public void init(double t0, double[] y0, double t) {
		// TODO Auto-generated method stub

	}
}
