package it.polito.bigdata.hadoop.lab;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.Writable;

public class UserWritable implements Writable{

	private String id;
	// private List<Product> products;
	// private Map<String, Integer> proScore;
	private List<ProductWritable> products;
	
	public UserWritable(String id, List<ProductWritable> products) {
	
		this.id = id;
		this.products = products; // ?
	}
	
	
	
	public void addScore(ProductWritable p) {
		products.add(p);
	}

	public List<ProductWritable> getProducts() {
		return products;
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		id = in.readUTF();
		int size = in.readInt();
		products = new ArrayList<ProductWritable>(size);
		for (int i = 0; i < size; i++) {
			ProductWritable p = new ProductWritable();
			p.readFields(in);
			products.add(p);
		}
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(products.size());
		for(ProductWritable p : products)
			p.write(out);
	}
	
	
	
}
