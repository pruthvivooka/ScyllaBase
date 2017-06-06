package com.scyllabase;

import java.nio.ByteBuffer;

public class DateType implements DataType<Long> {

	private Long value;

	DateType(Long value) {
		this.value = value;
	}

	@Override
	public Long getValue() {
		return this.value;
	}

	@Override
	public boolean equal(Object rightValue) {
		return this.value.equals(rightValue);
	}

	@Override
	public boolean notEqual(Object rightValue) {
		return !this.value.equals(rightValue);
	}

	@Override
	public boolean greater(Object rightValue) {
		return rightValue instanceof Long && this.value > (Long) rightValue;
	}

	@Override
	public boolean greaterEquals(Object rightValue) {
		return rightValue instanceof Long && this.value >= (Long) rightValue;
	}

	@Override
	public boolean lesser(Object rightValue) {
		return rightValue instanceof Long && this.value < (Long) rightValue;
	}

	@Override
	public boolean lesserEquals(Object rightValue) {
		return rightValue instanceof Long && this.value <= (Long) rightValue;
	}

	@Override
	public boolean like(Object rightValue) {
		return false;
	}

	@Override
	public byte[] getByteValue() {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putLong(this.value);
		return bb.array();
	}

}