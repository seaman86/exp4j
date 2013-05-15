package net.objecthunter.exp4j;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ExpressionBuilderTest {
	
	@Test
	public void tesFloatExpression1(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("2+2",Float.class);
		float result = e.build().calculate();
		assertTrue(4f == result);
	}

	@Test
	public void tesFloatExpression2(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("2-2",Float.class);
		float result = e.build().calculate();
		assertTrue(0f == result);
	}
	
	@Test
	public void tesFloatExpression3(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("2/2",Float.class);
		float result = e.build().calculate();
		assertTrue(1f == result);
	}
	
	@Test
	public void tesFloatExpression4(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("2.45-1",Float.class);
		float result = e.build().calculate();
		assertTrue(1.45f == result);
	}

	@Test
	public void tesFloatExpression5(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("2.45-3",Float.class);
		float result = e.build().calculate();
		float expected = 2.45f - 3f;
		assertTrue("exp4j calulated " + result, expected == result);
	}

	@Test(expected=RuntimeException.class)
	public void tesFloatExpression6(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("2.45(-3",Float.class);
		float result = e.build().calculate();
	}

	@Test(expected=RuntimeException.class)
	public void tesFloatExpression7(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("2.45)-3",Float.class);
		float result = e.build().calculate();
	}

	@Test
	public void tesFloatExpression8(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("sin(1.0)",Float.class);
		float result = e.build().calculate();
		float expected = (float) Math.sin(1.0);
		assertTrue("exp4j calulated " + result, expected == result);
	}

	@Test
	public void tesFloatExpression9(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("sin(1.0) * 1 + 1",Float.class);
		float result = e.build().calculate();
		float expected = (float) Math.sin(1.0) * 1 + 1;
		assertTrue("exp4j calulated " + result, expected == result);
	}

	@Test
	public void tesFloatExpression10(){
		ExpressionBuilder<Float> e = new ExpressionBuilder<>("-1",Float.class);
		float result = e.build().calculate();
		assertTrue("exp4j calulated " + result, -1f == result);
	}

	@Test
	public void testExpression1(){
		ExpressionBuilder<Double> e = new ExpressionBuilder<>("2+2",Double.class);
		System.out.println(e.build().calculate());
	}

	@Test
	public void testExpression3(){
		ExpressionBuilder<BigDecimal> e = new ExpressionBuilder<>("2+2",BigDecimal.class);
		System.out.println(e.build().calculate());
	}

	@Test
	public void testExpression4(){
		ExpressionBuilder<ComplexNumber> e = new ExpressionBuilder<>("2+2",ComplexNumber.class);
		System.out.println(e.build().calculate());
	}
}
