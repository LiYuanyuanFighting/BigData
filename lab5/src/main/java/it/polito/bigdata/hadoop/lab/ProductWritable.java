package it.polito.bigdata.hadoop.lab;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class ProductWritable implements Writable {

	private String id;
	private float score;
	
	public ProductWritable() {
		this.id = new String();
		this.score = 0;
	}
	
	public ProductWritable(String id, float score) {
		this.id = id;
		this.score = score;
	}

	public ProductWritable(ProductWritable other) {
		this.id = new String(other.getId());
		this.score = new Float(other.getScore());
	}
	
	public float getScore() {
		return score;
	}
	
	public String getId() {
		return id;
	}
	
	public void setScore(float score) {
		this.score = score;
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		id = in.readUTF();
		score = in.readFloat();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(id);
		out.writeFloat(score);
	}
	
	public String toString() {
		return new String(id + ":" + score);
	}
}
