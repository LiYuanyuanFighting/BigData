for (ProductWritable p : values) {
    		// user.addScore(p);
    		sum += p.getScore();
    		size++;
    		newProducts.add(new ProductWritable(p));// should add new ProductWritable, otw always be replaced
    	}
